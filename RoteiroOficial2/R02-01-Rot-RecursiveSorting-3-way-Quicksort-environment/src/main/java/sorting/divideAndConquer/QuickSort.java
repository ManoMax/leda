package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (leftIndex >= rightIndex) return; 
		
		int m = particao(array, leftIndex, rightIndex);
		
		sort(array, leftIndex, m-1);
		sort(array, m+1, rightIndex);
	}
	
	private int particao(T[] array,int l,int r) {
		
		int pivot = (int) array[l];
		
		int i = l;
		
		for (int j = l+1; j < array.length; j++) {
			
			if ((int) array[j] <= pivot) {
				
				i++;
				Util.swap(array, i, j);
			}
			Util.swap(array, l, i);
		}
		
		return i;
	}
	
	
}
