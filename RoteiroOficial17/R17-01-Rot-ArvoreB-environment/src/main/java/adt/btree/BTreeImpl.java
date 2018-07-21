package adt.btree;

import javax.lang.model.util.Elements;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

	protected BNode<T> root;
	protected int order;

	public BTreeImpl(int order) {
		this.order = order;
		this.root = new BNode<T>(order);
	}

	@Override
	public BNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
	int result;
	if (getRoot().isEmpty()) {
		result = -1;
	} else {
		result = height(this.root);
	}
	return result;
	}

	private int height(BNode<T> node) {
		int result = 0;
		if (!node.isEmpty() && !node.isLeaf())
			result += 1 + height(node.getChildren().getFirst());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BNode<T>[] depthLeftOrder() {
		
		BNode<T>[] array = new BNode[sizeOfNodes(root)];
		
		depthLeftOrder(root, array);
		
		return array;
	}

	private void depthLeftOrder(BNode<T> node, BNode<T>[] array) {
		
		setNewNode(node, array);
		
		for (BNode<T> nodeAux : node.getChildren()) {
			depthLeftOrder(nodeAux, array);
		}
	}
	
	private void setNewNode(BNode<T> node, BNode<T>[] array) {
		int i = 0;
		
		while (array[i] != null && i < array.length)
			i++;
		
		array[i] = node;
	}

	private int sizeOfNodes(BNode<T> node) {
		
		int result = 1;
		
		for (BNode<T> nodeAux : node.getChildren())
			result += sizeOfNodes(nodeAux);
		
		return result;
	}
	
	@Override
	public int size() {
		return size(this.root);
	}
	
	private int size(BNode<T> node) {
		
		int result = 0;
		
		result += node.getElements().size();
		
		for (BNode<T> nodeAux : node.getChildren()) {
			result += size(nodeAux);
		}
		
		return result;
	}
	
	@Override
	public BNodePosition<T> search(T element) {
		return search(element, root);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private BNodePosition<T> search(T element, BNode<T> node) {
		int i = 0;
		
		while (i < node.getElements().size() && node.getElementAt(i).compareTo(element) < 0) i++;
		
		if (i <= node.getElements().size() && node.getElementAt(i).equals(element))
			return new BNodePosition(node, i);
		
		if (node.isLeaf())
			return new BNodePosition(null, -1);
		
		return search(element, node.getChildren().get(i));
	}
	
	@Override
	public void insert(T element) {
		
		insert(element, getRoot());

	}

	private void insert(T element, BNode<T> node) {
		
		if (!node.isLeaf()) {
			int i = 0;
			while (i < node.size() && node.getElementAt(i).compareTo(element) < 0) i++;
			
			insert(element, node.getChildren().get(i));
		} else {
			node.addElement(element);
		}
		
		if (node.getMaxKeys() < node.size()) {
			split(node);
		}
		
	}

	private void split(BNode<T> node) {
		
		int median = node.size()/2;
		T mid = node.getElementAt(median);
		
		BNode<T> left = node.copyLeftChildren(median);
		BNode<T> right = node.copyRightChildren(median);
		
		if (node == root) {
			BNode<T> newRoot = new BNode<T>(node.getOrder());
			newRoot.addElement(mid);
			node.setParent(newRoot);
			root = newRoot;
			
			for (int i = 0; i < node.getChildren().size(); i++) {
				if (i <= median) {
					left.addChild(i, node.getChildren().get(i));
				} else {
					right.addChild(i - median - 1, node.getChildren().get(i));
				}
			}
			newRoot.addChild(0, left);
			newRoot.addChild(1, right);
			newRoot.getChildren().get(0).setParent(newRoot);
			newRoot.getChildren().get(1).setParent(newRoot);
		} else {
			promote(node);
		}
	}

	private void promote(BNode<T> node) {
		
		BNode<T> parent = node.getParent();
		T mid = node.getElementAt(node.getOrder()/2);
		parent.addElement(mid);
		
		int median = parent.getElements().indexOf(mid);
		parent.removeChild(node);
		
		node.getChildren().get(0).setParent(parent);
		node.getChildren().get(1).setParent(parent);
		
		node.getParent().removeChild(node);
		node.getParent().addChild(median, node.getChildren().get(1));
		node.getParent().addChild(median, node.getChildren().get(0));
	}

	// NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
	@Override
	public BNode<T> maximum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public BNode<T> minimum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public void remove(T element) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

}
