package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (isValid(array, leftIndex, rightIndex)) {
			int index;
			T key;
			
			for(int i = leftIndex; i < rightIndex; i++) {
				
				key = array[i+1];
				index = i;
				
				while (index >= leftIndex && array[index].compareTo(key) > 0) {
					array[index + 1] = array[index];
					index--;
				}
				array[index + 1] = key;
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

