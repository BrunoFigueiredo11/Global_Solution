package marketplace;

public class Cliente {
	int idCliente;
	String modelo;
	String bairro;
	int quantidade;

	public Cliente(int idCliente, String modelo, String bairro, int quantidade) {
		this.idCliente = idCliente;
		this.modelo = modelo;
		this.bairro = bairro;
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", modelo=" + modelo + ", bairro=" + bairro + ", quantidade="
				+ quantidade + "]";
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
