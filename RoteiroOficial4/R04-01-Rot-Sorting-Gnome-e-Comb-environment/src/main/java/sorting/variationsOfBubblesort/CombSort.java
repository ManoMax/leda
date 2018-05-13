package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (!verificaEntrada(array, leftIndex, rightIndex)) return;
		
		int n = rightIndex+1;
		int gap = n;
		boolean troca = true;
		
		while (troca || gap != 1) {
			
			gap = novoGap(gap);
			troca = false;
			
			for (int i = leftIndex; i < n-gap; i++) {
				//System.out.println(exibirArray(array) + "Gap: " + gap);
				if (array[i].compareTo(array[i+gap]) > 0) {
					Util.swap(array, i, i+gap);
					troca = true;
				}
			}
		}
		
	}
	
	private int novoGap(int gap) {
		gap = (gap*10)/13;
		if (gap < 1) return 1;
		return gap;
	}
	
	private String exibirArray(T[] array) {
		String saida = "";
		for (int i = 0; i < array.length; i++) saida += array[i] + " ";
		return saida + "\n";
	}
	
	private boolean verificaEntrada(T[] array, int leftIndex, int rightIndex) {
		boolean valida = true;
		if (array == null || array.length <= 1) valida = false;
		if (rightIndex < leftIndex) valida = false;
		if (leftIndex < 0 || rightIndex > array.length) valida = false;
		return valida;
	}
}
