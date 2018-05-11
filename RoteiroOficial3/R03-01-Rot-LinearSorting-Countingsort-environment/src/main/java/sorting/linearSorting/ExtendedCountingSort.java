package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (rightIndex < leftIndex) return;
		if (confereArray(array)) return;
		
		int maiorNumero = identicaMaiorNumero(array, leftIndex, rightIndex);
		int menorNumero = identicaMenorNumero(array, leftIndex, rightIndex);
		
		//System.out.println(exibirArray(array));
		
		Integer[] arrayContador = criaArrayContado(array, maiorNumero, menorNumero);
		//System.out.println(exibirArray(arrayContador) + "Tamanho: " + arrayContador.length);
		
		arrayContador = somaDePrefixos(arrayContador);
		//System.out.println(exibirArray(arrayContador));
		
		arrayContador = ordenaArray(array, arrayContador, leftIndex, rightIndex);
		//System.out.println(exibirArray(arrayContador));
		
		modificarArray(array, arrayContador, leftIndex, rightIndex);
		//System.out.println(exibirArray(array));
		
	}

	private int identicaMenorNumero(Integer[] array, int leftIndex, int rightIndex) {
		int menor = array[0];
		for (int i = leftIndex; i <= rightIndex; i++) if (array[i] < menor) menor = array[i];
		return menor;
	}

	private int identicaMaiorNumero(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[0];
		for (int i = leftIndex; i <= rightIndex; i++) if (array[i] > maior) maior = array[i];
		return maior;
	}
	
	private Integer[] criaArrayContado(Integer[] array, int maiorNumero, int menorNumero) {
		
		Integer[] arrayContador = new Integer[maiorNumero-menorNumero+1];
		
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
