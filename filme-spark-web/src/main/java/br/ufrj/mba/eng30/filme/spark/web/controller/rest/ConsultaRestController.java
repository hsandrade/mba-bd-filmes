package br.ufrj.mba.eng30.filme.spark.web.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.ufrj.mba.eng30.filme.spark.web.model.Cliente;
import br.ufrj.mba.eng30.filme.spark.web.model.JobserverResult;

@RestController
public class ConsultaRestController {
	// simular o parse de um String de resposta para um objeto
	private Gson gson = new GsonBuilder().create();
	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value = "/rest/cliente", method = RequestMethod.GET)
	public List<Cliente> getCliente() {

		String strJson = "{\"idcli\":\"1001\",\"cidade\":\"Rio de Janeiro\"}";

		List<Cliente> listResult = new ArrayList<>();
		listResult.add(gson.fromJson(strJson, Cliente.class));
		return listResult;
	}

	@RequestMapping(value = "/rest/cliente-spark")
	public List<Cliente> getClientesJobServer() {
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
