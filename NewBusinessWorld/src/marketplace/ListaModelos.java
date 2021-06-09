package marketplace;

public class ListaModelos {
	private class NO {
		PontoVenda dado;
		NO prox;
	}

	private NO lista = null;

	public boolean isEmpty() {
		return lista == null;
	}

	public void add(PontoVenda elem) {
		String novoDado, listaDado, auxDado;
		int x = 0;
		NO novo = new NO();
		novo.dado = elem;
		if (!isEmpty()) {
			novoDado = novo.dado.getBairro();
			listaDado = lista.dado.getBairro();
			x = novoDado.compareTo(listaDado);
			if (x < 0) {
				novo.prox = lista;
				lista = novo;
			} else {
				NO aux = lista;
				boolean achou = false;
				novoDado = novo.dado.getBairro();
				while (aux.prox != null && !achou) {
					auxDado = aux.prox.dado.getBairro();
					x = novoDado.compareTo(auxDado);
					if (x > 0)
						aux = aux.prox;
					else
						achou = true;
				}
				novo.prox = aux.prox;
				aux.prox = novo;

			}
		} else if (isEmpty()) {
			lista = novo;
			novo.prox = null;
		}
		System.out.println("Loja cadastrada com sucesso !!\n");
	}

	public boolean remove(String elem) {
		boolean ok = false;
		if (!isEmpty()) {
			if (elem.equals(lista.dado.getBairro())) {
				lista = lista.prox;
				ok = true;
			} else {
				NO aux = lista;
				while (aux.prox != null && !ok) {
					if (!elem.equals(aux.prox.dado.getBairro()))
						aux = aux.prox;
					else
						ok = true;
				}
				if (ok)
					aux.prox = aux.prox.prox;
			}
		}
		return ok;
	}

	public void venda(String elem, int qtd) {
		boolean ok = false;
		int atualiza;
		if (!isEmpty()) {
			if (elem.equals(lista.dado.getBairro())) {
				if (qtd > lista.dado.getEstoque()) {
					System.out.println("Quantidade indisponivel ! \n Consulte o estoque e tente novamente");
					ok = true;
				} else {
					atualiza = (lista.dado.getEstoque()) - qtd;
					lista.dado.setEstoque(atualiza);
					System.out.println("Venda realizada com sucesso !!!");
					ok = true;
					if (lista.dado.getEstoque() == 0) {
						remove(lista.dado.getBairro());
					}
				}
			} else {
				NO aux = lista;
				while (aux.prox != null && !ok) {

					if (!elem.equals(aux.prox.dado.getBairro()))
						aux = aux.prox;
					else
						ok = true;
				}
				if (ok) {
					atualiza = (aux.prox.dado.getEstoque()) - qtd;
					aux.prox.dado.setEstoque(atualiza);
					System.out.println("Venda realizada com sucesso");
					if (aux.prox.dado.getEstoque() == 0) {
						remove(aux.prox.dado.getBairro());
					}
				} else {
					System.out.println("Nenhuma das lojas atende o bairro do cliente");
				}
			}
		} else {
			System.out.println("Produto não cadastrado na loja \n Venda não realizada\n");
		}
	}

	public void show() {
		NO aux = lista;
		while (aux != null) {
			System.out.println("  " + aux.dado);
			aux = aux.prox;
		}
		System.out.println("\n------------------------------------");
	}

}
