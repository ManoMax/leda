package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (rightIndex < leftIndex) return;
		if (confereArray(array)) return;
		
		int maiorNumero = identicaMaiorNumero(array, leftIndex, rightIndex);
		//System.out.println(exibirArray(array));
		
		Integer[] arrayContador = criaArrayContado(array, maiorNumero);
		//System.out.println(exibirArray(arrayContador) + "Tamanho: " + arrayContador.length);
		
		arrayContador = somaDePrefixos(arrayContador);
		//System.out.println(exibirArray(arrayContador));
		
		arrayContador = ordenaArray(array, arrayContador, leftIndex, rightIndex);
		//System.out.println(exibirArray(arrayContador));
		
		modificarArray(array, arrayContador, leftIndex, rightIndex);
		//System.out.println(exibirArray(array));
		
	}

	private int identicaMaiorNumero(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[0];
		for (int i = leftIndex; i <= rightIndex; i++) if (array[i] > maior) maior = array[i];
		return maior;
	}
	
	private Integer[] criaArrayContado(Integer[] array, int maiorNumero) {
		
		Integer[] arrayContador = new Integer[maiorNumero+1];
		
		for (int i = 0; i < arrayContador.length; i++) arrayContador[i] = 0;
		
		for (int i = 0; i < array.length; i++) arrayContador[array[i]]++;
		
		return arrayContador;
	}
	
	private Integer[] somaDePrefixos(Integer[] arrayContador) {
		for (int i = 0; i < arrayContador.length-1; i++) arrayContador[i+1] += arrayContador[i];
		return arrayContador;
	}
	
	private Integer[] ordenaArray(Integer[] array, Integer[] arrayContador, int leftIndex, int rightIndex) {
		
		Integer[] aux = new Integer[array.length];
		
		for (int i = 0; i < aux.length; i++) aux[i] = 0;
		
		for (int i = array.length-1; i >= 0 ; i--) {
			int valorDaArrayOriginal = array[i];
			
			arrayContador[array[i]]--;
			//System.out.println("Valor Original: " + array[i]);
			//System.out.println("Contador: " + exibirArray(arrayContador));
			
			int posicaoContador = arrayContador[valorDaArrayOriginal];
			//System.out.println("Posicao Cont: " + arrayContador[valorDaArrayOriginal]);
			
			aux[posicaoContador] = array[i];
			//System.out.println(exibirArray(aux));
		}
		return aux;
	}

	private void modificarArray(Integer[] array, Integer[] arrayContador, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) array[i] = arrayContador[i];
	}

	private boolean confereArray(Integer[] array) {
		return (array == null || array.length <= 1);
	}

	private String exibirArray(Integer[] array) {
		String saida = "";
		
		for (int i = 0; i < array.length; i ++) {
			saida += array[i] + " ";
		}
		return saida + "\n";
	}

}
