package br.ufrj.mba.eng30.filme.spark.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.ufrj.mba.eng30.filme.spark.web.model.Cliente;
import br.ufrj.mba.eng30.filme.spark.web.model.JobserverResult;

/**
 * Classe principal para executar os servi&ccedil;os Spark.
 * @author cassi
 *
 */
@Service
public class SparkService {
	private RestTemplate restTemplate = new RestTemplate();
	private Gson gson = new GsonBuilder().create();
	
	public List<Cliente> getClientesSpark() {
		JobserverResult jobRes = restTemplate.postForObject(
				"http://54.190.0.205:8090/jobs?appName=servico-filme2&context=mba-context&classPath=br.ufrj.mba.eng30.filme.spark.servico.TesteObserverSQL&sync=true&timeout=60",
				"idCliente = 1001",
				JobserverResult.class);

		System.out.println(jobRes.getJobId());
		
		List<Cliente> listResult = new ArrayList<>();
		
		if (jobRes.getResult() != null) {
			for (String r : jobRes.getResult()) {
				listResult.add(gson.fromJson(r, Cliente.class));
			}
		}
		
		return listResult;
	}
	
}
