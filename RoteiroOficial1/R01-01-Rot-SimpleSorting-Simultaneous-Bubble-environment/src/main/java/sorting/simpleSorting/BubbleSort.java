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
		
		if (isValid(array, leftIndex, rightIndex)) {
			
			boolean swap = true;
			int contMax = 0;
			
			while (swap) {
				swap = false;
				for (int i = leftIndex; i < (rightIndex - contMax); i++) {
					if (array[i].compareTo(array[i+1]) > 0) {
						Util.swap(array, i, i+1);
						swap = true;
					}
				}
				contMax++;
			}
			
		}
		
	}

	private boolean isValid(T[] array, int leftIndex, int rightIndex) {
		boolean isValid = true;
		
		if (leftIndex >= rightIndex) isValid = false;
		if (leftIndex < 0 || rightIndex > array.length) isValid = false;
		if (array == null || array.length <= 1) isValid = false;
		
		return isValid;
	}
	
	
}
