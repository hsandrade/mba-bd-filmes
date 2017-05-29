package br.ufrj.mba.eng30.filme.spark.web.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrj.mba.eng30.filme.spark.web.model.Ator;
import br.ufrj.mba.eng30.filme.spark.web.model.Diretor;
import br.ufrj.mba.eng30.filme.spark.web.model.Filme;
import br.ufrj.mba.eng30.filme.spark.web.model.Genero;
import br.ufrj.mba.eng30.filme.spark.web.service.SparkService;

@RestController
public class ConsultaRestController {
	
	@Autowired
	private SparkService sparkService;

	@RequestMapping(value = "/rest/filmes/rentaveis")
	public List<Filme> getTopFilmeRentaveis() {
		return sparkService.getTopFilmesRentaveis(10);
	}
	
	@RequestMapping(value = "/rest/filmes/rentaveis/{qtdTop}")
	public List<Filme> getTopFilmeRentaveis(@PathVariable("qtdTop") int qtdTop) {
		return sparkService.getTopFilmesRentaveis(qtdTop);
	}	
	
	@RequestMapping(value = "/rest/filmes/avaliados")
	public List<Filme> getTopFilmeAvaliados() {
		return sparkService.getTopFilmesAvaliados(10);
	}
	
	@RequestMapping(value = "/rest/filmes/avaliados/{qtdTop}")
	public List<Filme> getTopFilmeAvaliados(@PathVariable("qtdTop") int qtdTop) {
		return sparkService.getTopFilmesAvaliados(qtdTop);
	}
	
	@RequestMapping(value = "/rest/filmes/ator")
	public List<Ator> getTopAtorRentavel() {
		return sparkService.getTopAtorRentavel(10);
	}
	
	@RequestMapping(value = "/rest/filmes/ator/{qtdTop}")
	public List<Ator> getTopAtorRentavel(@PathVariable("qtdTop") int qtdTop) {
		return sparkService.getTopAtorRentavel(qtdTop);
	}
	
	@RequestMapping(value = "/rest/generos")
	public List<Genero> getGeneros() {
		return sparkService.getGeneros();
	}
	
	@RequestMapping(value = "/rest/filmes/genero/{genero}")
	public List<Filme> getFilmesGenero(@PathVariable("genero") String genero) {
		return sparkService.getFilmesGenero(genero);
	}	
	
	@RequestMapping(value = "/rest/diretores")
	public List<Diretor> getDiretores() {
		return sparkService.getDiretores();
	}	
	
	@RequestMapping(value = "/rest/filmes/diretor/{diretor}/{qtdAtor}")
	public List<Ator> getAtoresDiretor(@PathVariable("diretor") String diretor,
			@PathVariable("qtdAtor") int qtdAtor) {
		return sparkService.getAtoresDiretor(diretor, qtdAtor);
	}	
	
}
