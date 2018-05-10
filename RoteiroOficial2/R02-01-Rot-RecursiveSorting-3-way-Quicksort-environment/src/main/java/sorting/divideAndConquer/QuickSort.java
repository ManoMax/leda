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
		if (confereArray(array)) return;
		
		int mid = particao(array, leftIndex, rightIndex);
		
		sort(array, leftIndex, mid-1);
		sort(array, mid+1, rightIndex);
	}
	
	private int particao(T[] array,int leftIndex,int rightIndex) {
		
		T pivot = array[leftIndex];
		
		int i = leftIndex+1;
		int j = rightIndex;
		
		while (i <= j) {
			if (array[i].compareTo(pivot) <= 0) i++;
			else if (array[j].compareTo(pivot) > 0) j--;
			else {
				Util.swap(array, i, j);
			}
		}
		
		Util.swap(array, leftIndex, j);
		
		return j;
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
