package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex <= leftIndex) return;
		
		int i = -1, j = -1;
		
		partition(array, leftIndex, rightIndex, i, j);
		
		sort(array, leftIndex, i);
		sort(array, j, rightIndex);
	}

	private void partition(T[] array, int leftIndex, int rightIndex, int i, int j) {
		
		if (rightIndex - leftIndex <= 1) {
	        if (array[rightIndex].compareTo(array[leftIndex]) < 0) {
	        	Util.swap(array, rightIndex, leftIndex);
	        }
	        return;
		}
		i = leftIndex;
        j = rightIndex;
        
		int mid = leftIndex;
		T pivot = array[rightIndex];
		
		while (mid <= rightIndex) {
			
			//System.out.println(exibirArray(array));
			//System.out.println(array[mid] + " " + pivot);
			
			if (array[mid].compareTo(pivot) < 0) {
				leftIndex++;
				mid++;
				Util.swap(array, leftIndex, mid);
			}
	        else if (array[mid].compareTo(pivot) == 0) mid++;
	        else if (array[mid].compareTo(pivot) > 0) {
	        	rightIndex--;
	        	Util.swap(array, mid, rightIndex);
	        }
		}

		i = leftIndex-1;
		j = mid;
		//System.out.println("I: " + i + "j: " + j + " " + (rightIndex-1));
	}

	private String exibirArray(T[] array) {
		String saida = "";
		for (int i = 0; i < array.length; i++) saida += array[i] + " ";		
		return saida + "\n";
	}
	
	public void particao2(T[] array, int leftIndex, int rightIndex, int i, int j) {
		i = leftIndex-1; j = rightIndex;
		int p = leftIndex-1, q = rightIndex;
		T pivot = array[rightIndex];
		
		System.out.println(exibirArray(array));
		while (true) {
			
			
			while (array[i].compareTo(pivot) > 0 && i < array.length) {
				//System.out.println(array[i] + "pivot: " + pivot);
				i++;
			}
			
			while(array[j].compareTo(pivot) > 0) {
				System.out.println(array[j]+ " " + pivot);
				j--;
				if (j==0) break;
			}
			
			System.out.println("Saida j = " + array[j]);
			if (i >= j) break;
			
			Util.swap(array, i, j);
			
			if (array[i].compareTo(pivot) == 0) {
				p++;
				Util.swap(array, p, i);
			}
			
			if (array[j].compareTo(pivot) == 0) {
				q--;
				Util.swap(array, j, q);
			}
		}
		
		Util.swap(array, i, rightIndex);
		
		j = i-1;
		for (int k = leftIndex; k < p; k++, j--) {
			Util.swap(array, k, j);
	    }
		
		i = i+1;
		for (int k = rightIndex-1; k > q; k--, i++) {
			Util.swap(array, i, k);
		}
	}
}
