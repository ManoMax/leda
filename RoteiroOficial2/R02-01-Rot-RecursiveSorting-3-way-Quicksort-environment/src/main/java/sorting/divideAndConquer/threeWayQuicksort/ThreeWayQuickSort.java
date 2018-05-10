package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (leftIndex >= rightIndex) return;
		if (confereArray(array)) return;
		
		if (leftIndex < rightIndex) {
			int mid = particion(array, leftIndex, rightIndex);
			sort(array, leftIndex, mid-1);
			T pivot = array[mid];
			
			while (mid < rightIndex && array[mid].compareTo(pivot) == 0) mid++;
				sort(array, mid, rightIndex);
			}
	}

	private int particion(T[] array, int leftIndex, int rightIndex) {
		
		int j = leftIndex;
		int i = leftIndex;
		while (j < rightIndex) {
			
			//System.out.println(array[j] + " " + array[rightIndex]);
			//System.out.println(array[j].compareTo(array[rightIndex]) < 0);
			//System.out.println(exibirArray(array));
			
		if (array[j].compareTo(array[rightIndex]) < 0) {
			Util.swap(array, i, j);
			i++;
			}
			j++;
		}
		Util.swap(array, i, rightIndex);
		return i;
	}

	private String exibirArray(T[] array) {
		String saida = "";
		for (int i = 0; i < array.length; i++) saida += array[i] + " ";		
		return saida + "\n";
	}
	
	private boolean confereArray(T[] array) {
		return (array == null || array.length == 0);
	}
	
}
