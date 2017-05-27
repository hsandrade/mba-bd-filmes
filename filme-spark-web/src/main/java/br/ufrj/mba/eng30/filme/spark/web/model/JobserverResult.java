package br.ufrj.mba.eng30.filme.spark.web.model;

/**
 * Classe utilizada como resultado do JObserver ao consumir servi&ccedil;o do
 * Spark.
 * 
 * @author henrique
 *
 */
public class JobserverResult {

	private String jobId;
	private String[] result;
	private String error;
	private String message;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String[] getResult() {
		return result;
	}

	public void setResult(String[] result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
