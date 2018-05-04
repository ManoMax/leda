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

	   for (int i = leftIndex; i < rightIndex; i++) {
		   for(int j = leftIndex; j < rightIndex-i; j++) {
			   if (array[j].compareTo(array[j+1]) > 0) Util.swap(array, j, j+1);
			   if (array[rightIndex-j].compareTo(array[rightIndex-j-1]) < 0) Util.swap(array, rightIndex-j, rightIndex-j-1);
		   }
	   }
   }
   
   private String exibirArray(T[] array) {
		String saida = "";
		
		for (int i = 0; i < array.length; i ++) {
			saida += array[i] + " ";
		}
		return saida + "\n";
		
	}
   
}

