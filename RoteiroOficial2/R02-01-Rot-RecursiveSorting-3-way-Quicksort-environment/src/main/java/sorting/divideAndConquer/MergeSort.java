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
		
		if (leftIndex >= rightIndex) return;
		if (confereArray(array)) return;
		
		if (leftIndex < rightIndex) {
			int m = (leftIndex + rightIndex) / 2;
			
			sort(array, leftIndex, m);
			sort(array, m+1, rightIndex);
			
			merge(array, leftIndex, m, rightIndex);
		}
	}
	
	public void merge(T[] array, int leftIndex, int mid, int rightIndex) {
		
		//System.out.println(exibirArray(array));
		
<<<<<<< HEAD
		T[] leftList = (T[]) new Comparable[tamanho1];
		T[] rightList = (T[]) new Comparable[tamanho2];
		
		for (int i = 0; i < tamanho1; i++) {
			leftList[i] = array[i];
		}
		for (int j = 0; j < tamanho2; j++) {
			rightList[j] = array[j];
		}
=======
		int tamanho1 = mid - leftIndex + 1;
		int tamanho2 = rightIndex - mid;
		
		T[] metade1 = (T[]) new Integer[tamanho1];
		T[] metade2 = (T[]) new Integer[tamanho2];
		
		for (int i = 0; i < tamanho1; i++) metade1[i] = array[leftIndex+i];
		for (int j = 0; j < tamanho2; j++) metade2[j] = array[mid+1+j];
>>>>>>> 637f8408a1b65ebe5c8e22b95555baa98f74d3d1
		
		tamanho1 = 0;
		tamanho2 = 0;
		int tamanho3 = leftIndex;
		
		//System.out.println(exibirArray(metade1));
		//System.out.println(exibirArray(metade2));
		
		while (tamanho1 < metade1.length && tamanho2 < metade2.length) {
			
<<<<<<< HEAD
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
=======
			if (metade1[tamanho1].compareTo(metade2[tamanho2]) <= 0) {
				array[tamanho3] = metade1[tamanho1];
				tamanho1++;
				tamanho3++;
			} else {
				array[tamanho3] = metade2[tamanho2];
				tamanho2++;
				tamanho3++;
			}
		}
		
		while (tamanho1 < metade1.length) {
			array[tamanho3] = metade1[tamanho1];
			tamanho1++;
			tamanho3++;
		}
		
		while (tamanho2 < metade2.length) {
			array[tamanho3] = metade2[tamanho2];
			tamanho2++;
			tamanho3++;
>>>>>>> 637f8408a1b65ebe5c8e22b95555baa98f74d3d1
		}
		
		//System.out.println(exibirArray(array));
	}
	
	public String exibirArray(T[] array) {
		String saida = "";
		
		for (int i = 0; i < array.length; i++) {
			saida += array[i] + " ";
		}
		return saida + "\n";	
	}

	private boolean confereArray(T[] array) {
		return (array == null || array.length == 0);
	}
}
