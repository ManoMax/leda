package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (!verificaEntrada(array, leftIndex, rightIndex)) return;
		
		int index = leftIndex;
		
		while (index < rightIndex+1) {
			if (index == 0) index++;
			if (array[index].compareTo(array[index-1]) >= 0) index++;
			else {
				Util.swap(array, index, index-1); 
				index--;
			}
		}
	}

	private boolean verificaEntrada(T[] array, int leftIndex, int rightIndex) {
		boolean valida = true;
		if (array == null || array.length <= 1) valida = false;
		if (rightIndex < leftIndex) valida = false;
		if (leftIndex < 0 || rightIndex > array.length) valida = false;
		return valida;
	}
}
