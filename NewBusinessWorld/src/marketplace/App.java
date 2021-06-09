package marketplace;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int idCliente, quantidade, estoque, modelo = 0;
		String loja, bairro = null;
		Scanner le = new Scanner(System.in);
		int codigo[] = { 6247296, 4548121, 2385203 };
		double preco[] = { 699.99, 1059.00, 765.39 };
		/*
		 * Cria lista encadeada do modelo 6247296 (listaCod1) onde cada elemento
		 * armazena: loja, bairro e estoque. A lista deve ser ordenada em ordem
		 * alfabética de bairro.
		 */
		/*
		 * Cria lista encadeada do modelo 4548121 (listaCod2) onde cada elemento
		 * armazena: loja, bairro e estoque. A lista deve ser ordenada em ordem
		 * alfabética de bairro.
		 */
		/*
		 * Cria lista encadeada do modelo 2385203 (listaCod3) onde cada elemento
		 * armazena: loja, bairro e estoque. A lista deve ser ordenada em ordem
		 * alfabética de bairro.
		 */

		ListaModelos listaCod1 = new ListaModelos();
		ListaModelos listaCod2 = new ListaModelos();
		ListaModelos listaCod3 = new ListaModelos();
		FilaPreVenda filaPreVenda = new FilaPreVenda();

		int op;
		do {
			System.out.printf(menu());
			op = le.nextInt();

			switch (op) {
			case 1:
				System.out.println("Escolha o modelo a ser cadastrado: ");
				for (int i = 0; i < codigo.length; i++) {
					System.out.println((i + 1) + " - " + codigo[i]);
				}
				System.out.println("Digite uma opção: ");
				modelo = le.nextInt();
				System.out.println("");
				if (modelo == 1) {
					System.out.println("Digite o nome da Loja:  ");
					le.nextLine();
					loja = le.nextLine();
					System.out.println("Digite o bairro: ");
					bairro = le.nextLine();
					System.out.println("Informe a quantidade: ");
					estoque = le.nextInt();
					PontoVenda pontoVenda = new PontoVenda(loja, bairro, estoque);
					listaCod1.add(pontoVenda);

				} else if (modelo == 2) {
					System.out.println("Digite o nome da Loja:  ");
					le.nextLine();
					loja = le.nextLine();
					System.out.println("Digite o bairro: ");
					bairro = le.nextLine();
					System.out.println("Informe a quantidade: ");
					estoque = le.nextInt();
					PontoVenda pontoVenda = new PontoVenda(loja, bairro, estoque);
					listaCod2.add(pontoVenda);
				} else if (modelo == 3) {
					System.out.println("Digite o nome da Loja:  ");
					le.nextLine();
					loja = le.nextLine();
					System.out.println("Digite o bairro: ");
					bairro = le.nextLine();
					System.out.println("Informe a quantidade: ");
					estoque = le.nextInt();
					PontoVenda pontoVenda = new PontoVenda(loja, bairro, estoque);
					listaCod3.add(pontoVenda);
				} else
					System.out.println("Modelo Inválido! \nTente novamente\n");
				break;
			case 2:
				System.out.println("\nModelo 6247296 ");
				listaCod1.show();
				System.out.println("Modelo 4548121 ");
				listaCod2.show();
				System.out.println("Modelo 2385203 ");
				listaCod3.show();
				break;
			case 3:
				/*
				 * Cria fila de 30 compradores inscritos na pre venda. Cada comprador inserido
				 * na fila: idCliente, modelo, bairro e quantidade desejada.
				 */
				System.out.println("Informe o id do Cliente: ");
				idCliente = le.nextInt();
				System.out.println("Informe o modelo desejado: ");
				for (int i = 0; i < codigo.length; i++) {
					System.out.print((i + 1) + "-" + codigo[i] + "  ");
				}
				System.out.println("\nDigite uma opção");
				modelo = le.nextInt();
				if (modelo >= 1 && modelo <= 3) {
					System.out.println("Quantidade maxima permitida 3 ");
					System.out.println("Informe a quantidade desejada: ");
					quantidade = le.nextInt();
					if (quantidade > 3) {
						System.out.println("Quantidade excedida, tente novamente!");
						break;
					}
					System.out.println("Informe o bairro de entrega: ");
					le.nextLine();
					bairro = le.nextLine();
					if (modelo == 1) {
						modelo = 6247296;
					} else if (modelo == 2) {
						modelo = 4548121;
					} else if (modelo == 3) {
						modelo = 2385203;
					}
					Cliente cliente = new Cliente(idCliente, modelo, bairro, quantidade);
					filaPreVenda.enqueue(cliente);
				} else {
					System.out.println("Modelo Inválido! \nTente novamente\n");
					break;
				}
				break;
			case 4:

				/*
				 * Esvazia a fila de pre venda buscando produto na lista específica do modelo Na
				 * lista é feita a busca por bairro para efetuar a venda. Venda só ocorre se
				 * alguma loja puder atender no bairro do comprador.
				 */
				for (int i = filaPreVenda.ini; i < filaPreVenda.dados.length; i++) {
					if (filaPreVenda.dados[i] != null) {
						bairro = filaPreVenda.dados[i].getBairro();
						quantidade = filaPreVenda.dados[i].getQuantidade();
						modelo = filaPreVenda.dados[i].getModelo();
						if (modelo == 6247296) {
							listaCod1.venda(bairro, quantidade);
							System.out.println(filaPreVenda.dequeue());
						} else if (modelo == 4548121) {
							listaCod2.venda(bairro, quantidade);
							System.out.println(filaPreVenda.dequeue());
						} else if (modelo == 2385203) {
							listaCod3.venda(bairro, quantidade);
							System.out.println(filaPreVenda.dequeue());
						}

					}
				}

				break;
			case 5:
				char resp;
				do {
					/*
					 * lê informações do comprador: idCliente, modelo, bairro e quantidade desejada.
					 * Seleciona a lista do específico modelo e faz procura pelo bairro do
					 * comprador. A venda só ocorre se alguma loja puder atender no bairro do
					 * comprador.
					 */

					System.out.println("Informe o id do Cliente: ");
					idCliente = le.nextInt();
					System.out.println("Informe o modelo desejado: ");
					for (int i = 0; i < codigo.length; i++) {
						System.out.print((i + 1) + "-" + codigo[i] + "  ");
					}
					System.out.println("\nDigite uma opção");
					modelo = le.nextInt();
					if (modelo >= 1 && modelo <= 3) {
						System.out.println("Quantidade maxima permitida 3 ");
						System.out.println("Informe a quantidade desejada: ");
						quantidade = le.nextInt();
						if (quantidade > 3) {
							System.out.println("Quantidade excedida, tente novamente!");
							break;
						}
						System.out.println("Informe o bairro de entrega: ");
						le.nextLine();
						bairro = le.nextLine();
						if (modelo == 1) {
							listaCod1.venda(bairro, quantidade);
						} else if (modelo == 2) {
							listaCod2.venda(bairro, quantidade);
						} else if (modelo == 3) {
							listaCod3.venda(bairro, quantidade);
						}

					} else {
						System.out.println("Modelo Inválido! \nTente novamente\n");
						break;
					}

					System.out.println("Deseja realizar outra venda? (S/N):");
					resp = le.next().charAt(0);
				} while (resp == 'S' || resp == 's');
				break;

			default:
				break;
			}
		} while (op != 0);

	}

	private static String menu() {
		String menu = "";
		menu += "0 - Sair.\n";
		menu += "1 - Cadastrar Lojas e Produtos.\n";
		menu += "2 - Exibir Lojas e Produtos.\n";
		menu += "3 - Cadastrar Clientes na pré-venda.\n";
		menu += "4 - Atender Clientes da pré-venda.\n";
		menu += "5 - Realizar Vendas.\n";
		menu += "\nDigite uma opção --> ";

		return menu;
	}

}
