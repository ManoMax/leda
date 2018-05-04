package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		for(int i = leftIndex; i < rightIndex; i++) {
			//System.out.println(this.exibirArray(array));
			//System.out.println(i + "L: " + leftIndex + " R: " + rightIndex);
			
			int j = i;
			int key = i+1;
			
			//System.out.println("J: " + j + " Key: " + key);
			//System.out.println(j >= 0 && array[key].compareTo(o) < 0);
			
			while (j >= 0 && array[key].compareTo(array[j]) < 0) {
				//System.out.println(this.exibirArray(array));
				//System.out.println("Mudou " + j + " " + key);
				
				Util.swap(array, key, j);
				j--;
				if (j >= 0) {
					key = j+1;
					//System.out.println("J: " + j + " Key: " + key);
				}
				
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
		
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not Implemented yet!");
	}

