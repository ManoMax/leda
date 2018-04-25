package recursao;

public class GeradorSequencia {
	public void geraSequencia1(int n) {
		if (n == 0) {
			System.out.print(n + " ");
		} else {
			System.out.print(n + " ");
			geraSequencia1(n - 1);
		}
	}

	public void geraSequencia2(int n) {
		if (n == 0) {
			System.out.print(n + " ");
		} else {
			// A ORDEM DOS COMANDOS NA RECURSÃO ESTÁ INVERTIDA
			// VEJA O EFEITO E TENTE ENTENDER O PORQUE DISSO
			geraSequencia2(n - 1);
			System.out.print(n + " ");
		}
	}

	public static void main(String[] args) {
		GeradorSequencia gs = new GeradorSequencia();
		System.out.println("Executando metodo de geracao de sequencia 1");
		gs.geraSequencia1(8);
		System.out.println("\n");
		System.out.println("Executando metodo de geracao de sequencia 2");
		gs.geraSequencia2(8);
	}
}
