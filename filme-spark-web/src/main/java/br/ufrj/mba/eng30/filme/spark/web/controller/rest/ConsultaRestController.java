package br.ufrj.mba.eng30.filme.spark.web.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.ufrj.mba.eng30.filme.spark.web.model.Cliente;
import br.ufrj.mba.eng30.filme.spark.web.service.SparkService;

@RestController
public class ConsultaRestController {
	// simular o parse de um String de resposta para um objeto
	private Gson gson = new GsonBuilder().create();
	
	@Autowired
	private SparkService sparkService;

	@RequestMapping(value = "/rest/cliente", method = RequestMethod.GET)
	public List<Cliente> getCliente() {

		String strJson = "{\"idcli\":\"1001\",\"cidade\":\"Rio de Janeiro\"}";

		List<Cliente> listResult = new ArrayList<>();
		listResult.add(gson.fromJson(strJson, Cliente.class));
		return listResult;
	}

	@RequestMapping(value = "/rest/cliente-spark")
	public List<Cliente> getClientesJobServer() {
		return sparkService.getClientesSpark();
	}

}
