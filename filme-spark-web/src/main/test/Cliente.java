import com.google.gson.annotations.SerializedName;

public class Cliente {
	
	@SerializedName("idcli")
	private long idCliente;
	private String sexo;
	private String cidade;
	private int idade;

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", sexo=" + sexo + ", cidade=" + cidade + ", idade=" + idade + "]";
	}

}
