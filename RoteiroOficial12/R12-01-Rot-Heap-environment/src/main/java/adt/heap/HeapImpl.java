package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import util.Util;

/**
 * O comportamento de qualquer heap eh definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o maior sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 3 > 2),
 * essa heap deixa os elementos maiores no topo. Essa comparacao nao eh feita 
 * diretamente com os elementos armazenados, mas sim usando um comparator. 
 * Dessa forma, dependendo do comparator, a heap pode funcionar como uma max-heap 
 * ou min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador eh utilizado para fazer as comparacoes da heap. O ideal eh
	 * mudar apenas o comparator e mandar reordenar a heap usando esse
	 * comparator. Assim os metodos da heap nao precisam saber se vai funcionar
	 * como max-heap ou min-heap.
	 */
	// LEMBRAR DE USAR
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma
	 * min-heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	@SuppressWarnings("unused")
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento
	 * indexado pela posicao i no vetor
	 */
	@SuppressWarnings("unused")
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento
	 * indexado pela posicao i no vetor
	 */
	@SuppressWarnings("unused")
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (T elem : this.heap) {
			if (elem != null) {
				resp.add(elem);
			}
		}
		return (T[])resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode
	 * ser a raiz da heap ou de uma sub-heap. O heapify deve colocar os maiores
	 * (comparados usando o comparator) elementos na parte de cima da heap.
	 */
	@SuppressWarnings("unused")
	private void heapify(int position) {
		T left = heap[left(position)];
		T right = heap[right(position)];
		
		int largest = position;
		//System.out.println(left + " " + position + " " + size());
		if (left != null && (int) left <= size() && left.compareTo(heap[position]) > 0) {
			largest = left(position);
		} if (right != null && (int) right <= size() && right.compareTo(heap[position]) > 0) {
			largest = right(position);
		}
		if (largest != position) {
			Util.swap(heap, largest, position);
			heapify(largest);
		}
	}

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		// /////////////////////////////////////////////////////////////////
		// Implemente a insercao na heap aqui.
		this.index++;
		int position = size();
		
		while(position > 0 && heap[parent(position)].compareTo(element) < 0) {
			heap[position] = heap[parent(position)];
			position = parent(position);
		}
		heap[position] = element;
	}

	@Override
	public void buildHeap(T[] array) {
		while (rootElement() != null) {
			extractRootElement();
		}
		
		this.index = array.length;
		for (T element : array) {
			insert(element);
		}
		
		for (int i = size()/2; i > 1; i--) {
			heapify(i);
		}
		
	}

	@Override
	public T extractRootElement() {
		if (!isEmpty()) {
			T max = heap[0];
			heap[0] = heap[size()];
			this.index--;
			heapify(0);
			return max;
		}
		return null;
	}

	@Override
	public T rootElement() {
		if (!isEmpty()) return heap[0];
		return null;
	}

	@Override
	public T[] heapsort(T[] array) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public int size() {
		int size = 0;
		int i = 0;
		while (heap[i] != null) {
			size++;
			i++;
		}
		return size;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}

}
