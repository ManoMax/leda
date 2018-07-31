package sorting.linearSorting;

import util.Util;

public class TernaryArraySortingImplJoseAmandio<T extends Comparable<T>> implements TernaryArraySorting<T> {

	/**
	* TernaryArraySortingImpl
	* 
	* @author Jose Amandio, Edit: Gabriel Max
	*/
	public void sort(T[] ternaryArray) {
		T maior = ternaryArray[0];
		T menor = ternaryArray[0];

		for (int i = 0; i < ternaryArray.length; i++) {
			if (maior.compareTo(ternaryArray[i]) < 0 )
				maior = ternaryArray[i];
			if (menor.compareTo(ternaryArray[i]) > 0 )
				menor = ternaryArray[i];
		}
		
		int low = 0, high = ternaryArray.length -1;
		
		for (int i = 0; i <= high;) 
			if (menor.equals(ternaryArray[i]))
				Util.swap(ternaryArray, low++, i++);
			else if (maior.equals(ternaryArray[i]))
				Util.swap(ternaryArray, high--, i);
			else
				i++;
	}

}
