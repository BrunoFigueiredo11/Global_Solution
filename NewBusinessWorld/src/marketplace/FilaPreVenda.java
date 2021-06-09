package marketplace;

public class FilaPreVenda {
	public final int N=30;
	Cliente dados[] = new Cliente[N];
	int ini, fim, cont;
	
	public void init() {
		ini = fim = cont = 0;
	}
	
	public boolean isEmpty() {
		return cont == 0;
	}
	
	public boolean isFull() {
		return cont == N;
	}
	
	public void enqueue(Cliente valor) {
		if (isFull())
			System.out.println("Fila de pré venda cheia");
		else {
			dados[fim] = valor;
			cont++;
			fim = (fim + 1) % N;
			System.out.println("Cliente cadastrado com sucesso !!");
		}
	}
	
	public Cliente dequeue() {
		Cliente valor = dados[ini];
		ini = (ini + 1) % N;
		cont--;
		return valor;
	}
	
	public Cliente first() {
		return dados[ini];
	}

	
	public int getN() {
		return N;
	}

	public int getCont() {
		return cont;
	}
}
