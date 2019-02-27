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
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento
	 * indexado pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento
	 * indexado pela posicao i no vetor
	 */
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
	private void heapify(int position) {
		if (position >= 0 && position <= index) {
			int left = left(position);
			int right = right(position);
			
			int largest;
			
			if (left < this.size() && comparator.compare(heap[left], heap[position]) > 0)
				largest = left;
			else if (right < this.size() && comparator.compare(heap[right], heap[position]) > 0)
				largest = right;
			else
				largest = position;
			
			if (largest != position) {
				Util.swap(heap, position, largest);
				heapify(largest);
			}
				
			
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
		if (element != null) {
			
			int i = size();
			
			heap[i] = element;
			
			while (i > 0 && comparator.compare(heap[i], heap[parent(i)]) > 0) {
				Util.swap(heap, i, parent(i));
				i = parent(i);
			}
		}
		
		// visualizarArray(index);
	}

	@Override
	public void buildHeap(T[] array) {
		this.heap = array;
		this.index = array.length - 1;
		
		for (int i = parent(index); i >= 0; i--) {
			heapify(i);
		}
		
	}

	@Override
	public T extractRootElement() {
		if (index >= 0) {
			
			// visualizarArray(index);
			
			Util.swap(heap, 0, index);
			T max = heap[index];
			heap[index] = null;
			this.index--;
			
			heapify(0);
			
			// System.out.println(max);
			// visualizarArray(index + 1);
			return max;
		}
		return null;
	}

	@Override
	public T rootElement() {
		if (!isEmpty()) return heap[0];
		return null;
	}
	
	/**
	 * public T[] heapsort(T[] array) {
	 * ArrayList<T> aux = new ArrayList<T>();
		while (rootElement() != null) {
			aux.add(extractRootElement());
		}
		
		ArrayList<T> resp = new ArrayList<T>();
		for (int j = aux.size()-1; j >= 0; j--) {
			resp.add(aux.get(j));
		}
		
		return (T[])resp.toArray(new Comparable[0]);
		}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T[] heapsort(T[] array) {
		buildHeap(array);
		
		for (int i = index; i >= 0 ; i--) {
			
			// visualizarArray(7);
			System.out.println(Arrays.toString(array));
			
			Util.swap(array, i, 0);
			index--;
			heapify(0);
		}
		
		ArrayList<T> aux = new ArrayList<T>();
		for (int i = 0; i <= array.length - 1; i++) {
			aux.add(heap[i]);
			heap[i] = null;
		}
		
		return (T[])aux.toArray(new Comparable[0]);
		
	}
	
	@Override
	public int size() {
		return index + 1;
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
