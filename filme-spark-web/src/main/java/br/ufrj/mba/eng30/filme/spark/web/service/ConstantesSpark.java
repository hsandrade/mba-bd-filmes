package br.ufrj.mba.eng30.filme.spark.web.service;

public interface ConstantesSpark {

	/**
	 * Template da URL de chamada do Servi&ccedil;o no Spark,
	 * tendo como ponto de altera&ccedil;&atilde;o o nome da classe a 
	 * ser processada.
	 */
	String TEMPLATE_URL_SPARK = "http://54.190.0.205:8090/jobs"
			+ "?appName=servico-filme2"
			+ "&context=mba-context"
			+ "&classPath=br.ufrj.mba.eng30.filme.spark.servico.%s"
			+ "&sync=true"
			+ "&timeout=60";
}
