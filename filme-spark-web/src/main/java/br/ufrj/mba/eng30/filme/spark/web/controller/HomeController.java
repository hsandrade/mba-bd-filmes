package br.ufrj.mba.eng30.filme.spark.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufrj.mba.eng30.filme.spark.web.service.SparkService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private SparkService sparkService;
	
	@RequestMapping
	public String index(ModelMap model) {
		model.addAttribute("boasVindas", "Chegou no index");
		return "index";
	}
	
	@RequestMapping(value="/outra-pagina", method=RequestMethod.GET)
	public String outraPagina(ModelMap model) {
		model.addAttribute("atributo", "atributo");
		return "outra-pagina";
	}
	
	@RequestMapping(value="/teste-rest-spark", method=RequestMethod.GET)
	public String testeRestSpark(ModelMap model) {
		model.addAttribute("resultRest", sparkService.getClientesSpark());
		return "teste-rest-spark";
	}		
	
}
