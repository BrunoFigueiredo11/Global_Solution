package marketplace;

public class PontoVenda {
	String loja;
	String bairro;
	int estoque;

	public PontoVenda(String loja, String bairro, int estoque) {
		this.loja = loja;
		this.bairro = bairro;
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "Loja = " + loja + ", Bairro = " + bairro + ", Estoque = " + estoque + "";
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

}
