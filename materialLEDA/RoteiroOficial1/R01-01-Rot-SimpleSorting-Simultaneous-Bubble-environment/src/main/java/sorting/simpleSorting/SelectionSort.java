package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (isValid(array, leftIndex, rightIndex)) {
			
			int indexMin;
			for(int i = leftIndex; i <= rightIndex; i++) {
				indexMin = searchMinElement(array, i, rightIndex);
				Util.swap(array, i, indexMin);
			}
			
		}
	}
	
	private int searchMinElement(T[] array, int leftIndex, int rightIndex) {
		int indexMin = leftIndex;
		
		for (int i = leftIndex; i < rightIndex; i++)
			if (array[i].compareTo(array[indexMin]) < 0)
				indexMin = i;
		
		return indexMin;
	}

	private boolean isValid(T[] array, int leftIndex, int rightIndex) {
		boolean isValid = true;
		
		if (leftIndex >= rightIndex) isValid = false;
		if (leftIndex < 0 || rightIndex > array.length) isValid = false;
		if (array == null || array.length <= 1) isValid = false;
		
		return isValid;
	}
}
