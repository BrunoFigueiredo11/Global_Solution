package marketplace;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		int codigo[] = { 6247296, 4548121, 2385203 };
		double preco[] = { 699.99, 1059.00, 765.39 };
		/*
		 * Cria lista encadeada do modelo 6247296 (listaCod1) onde cada elemento
		 * armazena: loja, bairro e estoque. A lista deve ser ordenada em ordem
		 * alfab�tica de bairro.
		 */
		/*
		 * Cria lista encadeada do modelo 4548121 (listaCod2) onde cada elemento
		 * armazena: loja, bairro e estoque. A lista deve ser ordenada em ordem
		 * alfab�tica de bairro.
		 */
		/*
		 * Cria lista encadeada do modelo 2385203 (listaCod3) onde cada elemento
		 * armazena: loja, bairro e estoque. A lista deve ser ordenada em ordem
		 * alfab�tica de bairro.
		 */
		/*
		 * Cria fila de 30 compradores inscritos na pre venda. Cada comprador inserido
		 * na fila: idCliente, modelo, bairro e quantidade desejada.
		 */
		System.out.println("Venda de promo��o iniciada");
		/*
		 * Esvazia a fila de pre venda buscando produto na lista espec�fica do modelo Na
		 * lista � feita a busca por bairro para efetuar a venda. Venda s� ocorre se
		 * alguma loja puder atender no bairro do comprador.
		 */
		char resp;
		do {
			/*
			 * l� informa��es do comprador: idCliente, modelo, bairro e quantidade desejada.
			 * Seleciona a lista do espec�fico modelo e faz procura pelo bairro do
			 * comprador. A venda s� ocorre se alguma loja puder atender no bairro do
			 * comprador.
			 */
			System.out.println("A promo��o ainda est� ativa? (S/N):");
			resp = le.next().charAt(0);
		} while (resp == 'S' || resp == 's');
	}

}
