package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm applies two bubblesorts simultaneously. In a same iteration, a
 * bubblesort pushes the greatest elements to the right and another bubblesort
 * pushes the smallest elements to the left. At the end of the first iteration,
 * the smallest element is in the first position (index 0) and the greatest
 * element is the last position (index N-1). The next iteration does the same
 * from index 1 to index N-2. And so on. The execution continues until the array
 * is completely ordered.
 */
public class SimultaneousBubblesort<T extends Comparable<T>> extends AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (isValid(array, leftIndex, rightIndex)) {

			boolean swapped = true;
			while (leftIndex <= rightIndex && swapped) {

				swapped = false;
				int i = leftIndex, j = rightIndex;
				while (i < rightIndex && j > leftIndex) {
					
					if (array[i].compareTo(array[i+1]) > 0) 
						Util.swap(array, i, i+1); swapped = true;
					if (array[j].compareTo(array[j-1]) < 0) 
						Util.swap(array, j, j-1); swapped = true;
					i++; j--;
					
				}
				leftIndex++; rightIndex--;
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

