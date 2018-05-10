package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (array == null) return;
		
		if (rightIndex > leftIndex) {
			
			int n = (leftIndex + rightIndex)/2;
			
			sort(array, leftIndex, n);
			sort(array, n+1, rightIndex);
			
			merge(array, leftIndex, n, rightIndex);
		}
		
	}

	private void merge(T[] array, int leftIndex, int n, int rightIndex) {
		
		int tamanho1 = n - leftIndex + 1;
		int tamanho2 = rightIndex - n;
		
		T[] leftList = (T[]) new Comparable[tamanho1];
		T[] rightList = (T[]) new Comparable[tamanho2];
		
		for (int i = 0; i < tamanho1; i++) {
			leftList[i] = array[i];
		}
		for (int j = 0; j < tamanho2; j++) {
			rightList[j] = array[j];
		}
		
		int p = 0, q = 0;
		
		int k = leftIndex;
		
		while (p < tamanho1 && q < tamanho2) {
			
			if (leftList[p].compareTo(rightList[q]) <= 0) {
				array[k] = leftList[p];
				p++;
			} else {
				array[k] = rightList[q];
				q++;
			} k++;
		}
		
		while (p < tamanho1) {
			array[k] = leftList[p];
			p++;
			k++;
		}
		
		while (q < tamanho2) {
			array[k] = rightList[q];
			q++;
			k++;
		}
		
	}
}
