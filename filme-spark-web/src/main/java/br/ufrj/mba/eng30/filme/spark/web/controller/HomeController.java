package br.ufrj.mba.eng30.filme.spark.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

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
	
}
