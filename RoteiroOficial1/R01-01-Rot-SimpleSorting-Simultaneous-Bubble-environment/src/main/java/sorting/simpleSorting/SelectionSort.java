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
		
		for(int i = leftIndex; i < rightIndex; i++) {
			
			T min = array[i];
			int key = i;
			
			for (int j = i+1; j <= rightIndex; j++) {
				if (min.compareTo(array[j]) >= 0) {					
					min = array[j];
					key = j;
				}
				
			}
			Util.swap(array, key, i);
			
			
		}
		
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not Implemented yet!");
	}
	
	private String exibirArray(T[] array) {
		String saida = "";
		
		for (int i = 0; i < array.length; i ++) {
			saida += array[i] + " ";
		}
		return saida + "\n";
		
	}
}
