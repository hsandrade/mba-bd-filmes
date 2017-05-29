package br.ufrj.mba.eng30.filme.spark.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.ufrj.mba.eng30.filme.spark.web.dao.SparkDAO;
import br.ufrj.mba.eng30.filme.spark.web.model.Ator;
import br.ufrj.mba.eng30.filme.spark.web.model.Cliente;
import br.ufrj.mba.eng30.filme.spark.web.model.Diretor;
import br.ufrj.mba.eng30.filme.spark.web.model.Filme;
import br.ufrj.mba.eng30.filme.spark.web.model.Genero;
import br.ufrj.mba.eng30.filme.spark.web.model.JobserverResult;

/**
 * Classe principal para executar os servi&ccedil;os Spark.
 * @author Henrique
 *
 */
@Service
public class SparkService {
	private RestTemplate restTemplate = new RestTemplate();
	private Gson gson = new GsonBuilder().create();
	
	@Autowired
	private SparkDAO sparkDao;
	
	public List<Cliente> getClientes() {
		JobserverResult jobRes = restTemplate.postForObject(
				String.format(ConstantesSpark.TEMPLATE_URL_SPARK, "TesteObserverSQL"),
				"idCliente = 1001",
				JobserverResult.class);

		return getListResultGeneric(jobRes, Cliente.class);
	}
	
	public List<Filme> getTopFilmesRentaveis(int qtdTop) {
		JobserverResult jobRes = restTemplate.postForObject(
				String.format(ConstantesSpark.TEMPLATE_URL_SPARK, "TopFilmeRentavel"),
				"top=" + qtdTop,
				JobserverResult.class);

		return getListResultGeneric(jobRes, Filme.class);
	}	

	public List<Filme> getTopFilmesAvaliados(int qtdTop) {
		JobserverResult jobRes = restTemplate.postForObject(
				String.format(ConstantesSpark.TEMPLATE_URL_SPARK, "TopFilmeAvaliado"),
				"top=" + qtdTop,
				JobserverResult.class);

		return getListResultGeneric(jobRes, Filme.class);
	}
	
	public List<Ator> getTopAtorRentavel(int qtdTop) {
		JobserverResult jobRes = restTemplate.postForObject(
				String.format(ConstantesSpark.TEMPLATE_URL_SPARK, "TopAtorRentavel"),
				"top=" + qtdTop,
				JobserverResult.class);

		return getListResultGeneric(jobRes, Ator.class);
	}
	
	public List<Genero> getGeneros() {
		JobserverResult jobRes = restTemplate.postForObject(
				String.format(ConstantesSpark.TEMPLATE_URL_SPARK, "NormalizaGenero"),
				"param=abc",
				JobserverResult.class);

		return getListResultGeneric(jobRes, Genero.class);
	}	
	
	public List<Filme> getFilmesGenero(String genero) {
		JobserverResult jobRes = restTemplate.postForObject(
				String.format(ConstantesSpark.TEMPLATE_URL_SPARK, "FilmeGenero"),
				"genero=" + genero,
				JobserverResult.class);

		return getListResultGeneric(jobRes, Filme.class);
	}	
	
	/**
	 * Retorna os dados gerados na tabela pelo Spark em outro servi&ccedil;o.
	 * @return
	 */
	public List<Filme> getFilmesBanco() {
		return sparkDao.getFilmesRentaveis();
	}	
	
	public List<Diretor> getDiretores() {
		JobserverResult jobRes = restTemplate.postForObject(
				String.format(ConstantesSpark.TEMPLATE_URL_SPARK, "TopDiretor"),
				"top=10",
				JobserverResult.class);

		return getListResultGeneric(jobRes, Diretor.class);
	}
	
	public List<Ator> getAtoresDiretor(String diretor, int topAtores) {
		JobserverResult jobRes = restTemplate.postForObject(
				String.format(ConstantesSpark.TEMPLATE_URL_SPARK, "TopDiretorAtor"),
				"params=" + diretor + ";" + topAtores,
				JobserverResult.class);

		return getListResultGeneric(jobRes, Ator.class);
	}	
	
	/**
	 * Retorna uma lista genérica de acordo com o resultado do job.
	 * @param jobRes
	 * @param obj
	 * @return 
	 */
	private <T> List<T> getListResultGeneric(JobserverResult jobRes, Class<T> obj) {
		List<T> listResult = new ArrayList<>();
		if (jobRes.getResult() != null) {
			for (String r : jobRes.getResult()) {
				listResult.add(gson.fromJson(r, obj));
			}
		}		
		return listResult;
	}
	
}
