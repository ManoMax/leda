package adt.bst.extended;

import java.util.Comparator;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public T[] sort(T[] array) {
		for (int i = 0; i < array.length; i++) {
			this.insert(array[i], this.getRoot());
		}
		return this.order();
	}
		
	@SuppressWarnings("unchecked")
	private void insert(T element, BSTNode<T> node) {
		if (element != null) {

			// Disponivel
			if (node.isEmpty()) {
				node.setData(element);
				node.setLeft(new BSTNode.Builder<T>().parent(node).build());
				node.setRight(new BSTNode.Builder<T>().parent(node).build());

				if (node.getParent() == null) {
					node.setParent(new BSTNode<>());
				}
				//System.out.println(element + " alocado\n");

				// Nao Disponivel
			} else {
				// Elemento menor que Atual node
				if (this.comparator.compare(node.getParent().getData(), element) > 0) {
					//System.out.println(element + " esquerda");
					insert(element, (BSTNode<T>) node.getLeft());

					// Elemento maior que Atual node
				} else if (this.comparator.compare(node.getParent().getData(), element) > 0) {
					//System.out.println(element + " direita");
					insert(element, (BSTNode<T>) node.getRight());
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] reverseOrder() {
		T[] array = (T[]) new Comparable[this.size()];
		if (this.isEmpty()) return array;
		reverseOrder(array, root, 0);
		return array;
	}

	private int reverseOrder(T[] array, BSTNode<T> node, int index) {
		if (!node.getRight().isEmpty()) {
			index = reverseOrder(array, (BSTNode<T>) node.getRight(), index);
		}
		
		array[index++] = node.getData();
		
		if (!node.getLeft().isEmpty()) {
			index = reverseOrder(array, (BSTNode<T>) node.getLeft(), index);
		}
		
		return index;
	}
	
	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}
