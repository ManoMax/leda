package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex < leftIndex) return;
		if (array == null) return;
		
		
		if (rightIndex < leftIndex) return;
		if (array == null) return;
		
		boolean troca = true;
		
		while (troca) {
			troca = false;
			for (int i = 0; i < array.length-1; i++) {
				if (array[i].compareTo(array[i+1]) > 0) {
					Util.swap(array, i, i+1);
					troca = true;
				}
			}
		}
	}
}
