package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

public class copiaBubble {

	public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

		@Override
		public void sort(T[] array, int leftIndex, int rightIndex) {
			
			if (rightIndex < leftIndex) return;
			if (array == null) return;
			
			for (int i = leftIndex; i < rightIndex; i++) {
				for(int j = leftIndex; j < rightIndex-i; j++) {
					if (array[j].compareTo(array[j+1]) > 0) Util.swap(array, j, j+1);
					}
				}
			}
	}
}
