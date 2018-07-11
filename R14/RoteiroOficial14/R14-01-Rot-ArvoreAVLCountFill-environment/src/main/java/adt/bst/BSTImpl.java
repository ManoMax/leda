package adt.bst;

import java.util.ArrayList;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<>();

	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);

	}

	protected int height(BSTNode<T> node) {
		int height = -1;
		if (!node.isEmpty()) {
			int heightLeft = height((BSTNode<T>) node.getLeft());
			int heightRight = height((BSTNode<T>) node.getRight());
			height = 1 + Math.max(heightLeft, heightRight);
		}
		return height;

	}

	@Override
	public BSTNode<T> search(T element) {
		return search(root, element);
	}

	private BSTNode<T> search(BTNode<T> node, T element) {

		if (node.isEmpty()) {
			return (BSTNode<T>) node;
		} else if (node.getData().equals(element)) {
			return (BSTNode<T>) node;
		} else {
			if (element.compareTo(node.getData()) <= 0) {
				return search(node.getLeft(), element);
			} else {
				return search(node.getRight(), element);
			}
		}
	}

	@Override
	public void insert(T element) {
		insert(element, root);
	}

	protected void insert(T element, BTNode<T> node) {

		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent((BTNode<T>) node);
			node.getRight().setParent((BTNode<T>) node);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				insert(element, node.getLeft());
			} else {
				insert(element, node.getRight());
			}

		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(root);
	}

	private BSTNode<T> maximum(BTNode<T> node) {
		if (node.isEmpty()) {
			return null;
		} else if (node.getRight().isEmpty()) {
			return (BSTNode<T>) node;
		} else {
			return maximum(node.getRight());
		}

	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(root);
	}

	private BSTNode<T> minimum(BTNode<T> node) {
		if (node.isEmpty()) {
			return null;
		} else if (node.getLeft().isEmpty()) {
			return (BSTNode<T>) node;
		} else {

			return minimum(node.getLeft());
		}

	}

	@Override
	public BSTNode<T> sucessor(T element) {
		return (BSTNode<T>) sucessor(root, element);
	}

	private BTNode<T> sucessor(BTNode<T> no, T element) {
		BTNode<T> result = null;
		BTNode<T> auxNode = search(element);

		if (auxNode.isEmpty()) {
			return null;
		}
		if (!auxNode.getRight().isEmpty()) {
			result = minimum(auxNode.getRight());
		} else {
			result = auxNode.getParent();
			while (result != null && auxNode.equals(result.getRight())) {
				auxNode = result;
				result = result.getParent();
			}
		}
		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		return (BSTNode<T>) predecessor(root, element);
	}

	private BTNode<T> predecessor(BTNode<T> no, T element) {
		BTNode<T> result = null;
		BTNode<T> auxNode = search(element);

		if (auxNode.isEmpty()) {
			return null;
		}
		if (!auxNode.getLeft().isEmpty()) {
			result = maximum(auxNode.getLeft());
		} else {
			result = auxNode.getParent();
			while (result != null && auxNode.equals(result.getLeft())) {
				auxNode = result;
				result = result.getParent();
			}
		}

		return result;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> no = search(element);
		if (!no.isEmpty())
			remove(no);
	}

	private void remove(BSTNode<T> node) {
		if (node.getRight().isEmpty() && node.getLeft().isEmpty()) {
			node.setData(null);
		} else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) {
			if (node.equals(root)) {
				if (!node.getRight().isEmpty()) {
					root = (BSTNode<T>) node.getRight();
				} else {
					root = (BSTNode<T>) node.getLeft();
				}
				root.setParent(new BSTNode<T>());
			} else {
				if (node.equals(node.getParent().getLeft())) {
					if (!node.getRight().isEmpty()) {
						node.getParent().setLeft(node.getRight());
						node.getRight().setParent(node.getParent());
					} else {
						node.getParent().setLeft(node.getLeft());
						node.getLeft().setParent(node.getParent());
					}
				} else {
					if (!node.getRight().isEmpty()) {
						node.getParent().setRight(node.getRight());
						node.getRight().setParent(node.getParent());
					} else {
						node.getParent().setRight(node.getLeft());
						node.getLeft().setParent(node.getParent());
					}
				}
			}
		} else {
			BSTNode<T> sucessor = sucessor(node.getData());
			T elementoSucessor = sucessor.getData();
			remove(sucessor);
			node.setData(elementoSucessor);

		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<T>();
		preOrder(this.root, list);
		T[] array = (T[]) new Comparable[size()];
		return list.toArray(array);
	}

	public void preOrder(BSTNode<T> no, ArrayList<T> array) {
		if (!no.isEmpty()) {
			array.add(no.getData());
			preOrder((BSTNode<T>) no.getLeft(), array);
			preOrder((BSTNode<T>) no.getRight(), array);
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<T>();
		order(this.root, list);
		T[] array = (T[]) new Comparable[size()];
		return list.toArray(array);
	}

	private void order(BSTNode<T> no, ArrayList<T> array) {
		if (!no.isEmpty()) {
			order((BSTNode<T>) no.getLeft(), array);
			array.add(no.getData());
			order((BSTNode<T>) no.getRight(), array);
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<T>();
		postOrder(this.root, list);
		T[] array = (T[]) new Comparable[size()];
		return list.toArray(array);
	}

	private void postOrder(BSTNode<T> no, ArrayList<T> array) {
		if (!no.isEmpty()) {
			postOrder((BSTNode<T>) no.getLeft(), array);
			postOrder((BSTNode<T>) no.getRight(), array);
			array.add(no.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
		}
		return result;
	}
}