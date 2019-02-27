package solucao.recursao;

/**
 * @author Adalberto
 * @author Campelo
 */
public class MetodosRecursivos {

	public long calcularFatorial(int n) {
		long result = 1;

		if (n == 0) {
			// caso base: nao faz nada
		} else {
			result = n * calcularFatorial(n - 1);
		}
		System.out.println(n + "! = " + result);

		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		if (n == 1 || n == 2) {
			// caso base: nao faz nada
		} else {
			result = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
		}

		return result;
	}

	// embora este metodo naoseja recursivo em si, ele chama um outro metodo que
	// eh recursivo. Assim, a colucao utiliza recursao.
	public int countNotNull(Object[] array) {
		int result = 0;
		result = countNotNull(array, 0);
		return result;
	}

	private int countNotNull(Object[] array, int indexFrom) {
		int result = 0;
		
		if (array[indexFrom] != null) {
			result++;
		}
		
		if (indexFrom != array.length - 1) { // caso base: atingir o ultimo elemento do array
			result = result + countNotNull(array, indexFrom+1);
		}
		return result;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;
		if (expoente == 0) {
			// caso base: nao faz nada. ADMININDO QUE expoente EH UM NATURAL!!!
		} else {
			result = 2 * potenciaDe2(expoente - 1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n == 1) {
			// caso base: nao faz nada
		} else {
			result = progressaoAritmetica(termoInicial, razao, n - 1) + razao;
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n == 1) {
			// caso base: nao faz nada
		} else {
			result = progressaoAritmetica(termoInicial, razao, n - 1) * razao;
		}
		return result;
	}
	
}
