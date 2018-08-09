package sorting.problems;

import sorting.AbstractSorting;
import util.Util;

/**
 * Relembre o algoritmo de insertion sort, onde uma lista ordenada é construida 
 * no proprio array a ser ordenado. O algoritmo varre o array da esquerda para a direita e
 * vai construindo uma lista ordenada na esquerda (in-place). A implementacao padrao 
 * faz uma busca linear na lista ordenada em busca da posicao correta do novo elemento a ser 
 * inseriro. No binary insertion sort, essa busca da posicao se da usando a tecnica de 
 * busca binaria, onde o elemento eh inserido na posicao correta e os demais sao empurrados
 * convenientemente. 
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class BinaryInsertionSortImpl<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * Metodo que ordena o array de leftIndex a rightIndex aplicando a estrategia de busca binaria
	 * em busca da posicao correta para nova insercao na lista ordenada.
	 * 
	 * Restricoes:
	 * - algoritmo deve ser in-place
	 * - algoritmo nao pode usar memoria extra
	 * - algoritmo deve usar o metodo binarySearch;
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		int finalPosition = leftIndex;
		
		while (finalPosition < rightIndex) {
			Util.swap(array, finalPosition, binarySearch(array, leftIndex, finalPosition, array[finalPosition]));
			finalPosition++;
		}


	}
	
	/**
	 * Metodo que usa busca binaria para encontrar a posicao onde, logo apos ela,
	 * deve-se inserir um novo valor num array ordenado. O metodo encontra a posicao 
	 * entre os indices left e right (inclusive).
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private int binarySearch(T[] array, int left, int right, T value) {
		
		int positionOfMin = left;
		T minValue = value;
		
		if (array[getLeft(positionOfMin)] != null) {
			if (minValue.compareTo(array[getLeft(positionOfMin)]) > 0 && positionOfMin > right)
				minValue = array[getLeft(positionOfMin)];
			positionOfMin = binarySearch(array, getLeft(positionOfMin), right, minValue);
		} 
		
		if (array[getRight(positionOfMin)] != null) {
			if (minValue.compareTo(array[getRight(positionOfMin)]) > 0 && positionOfMin > right)
				minValue = array[getRight(positionOfMin)];
			positionOfMin = binarySearch(array, getRight(positionOfMin), right, minValue);
		}

		return positionOfMin;
		
	}

	private int getLeft(int i) {
		return i * 2 + 1;
	}

	private int getRight(int i) {
		return i * 2 + 2;
	}
}
