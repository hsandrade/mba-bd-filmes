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
		return "filme-top-rentavel";
	}
	
	@RequestMapping(value="/filme-top-rentavel", method=RequestMethod.GET)
	public String filmeTopRentavel(ModelMap model) {
		return "filme-top-rentavel";
	}
	
	@RequestMapping(value="/filme-top-avaliados", method=RequestMethod.GET)
	public String filmeTopAvaliados(ModelMap model) {
		return "filme-top-avaliados";
	}	
	
	@RequestMapping(value="/filme-top-ator-rentavel", method=RequestMethod.GET)
	public String filmeTopAtorRentavel(ModelMap model) {
		return "filme-top-ator-rentavel";
	}	
	
	@RequestMapping(value="/filme-genero", method=RequestMethod.GET)
	public String filmeGenero(ModelMap model) {
		return "filme-genero";
	}	
	
	@RequestMapping(value="/diretor-ator", method=RequestMethod.GET)
	public String diretorAtor(ModelMap model) {
		return "diretor-ator";
	}	
}
