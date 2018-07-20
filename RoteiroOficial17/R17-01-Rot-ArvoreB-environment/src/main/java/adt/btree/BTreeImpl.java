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
		return height(this.root);
	}

	private int height(BNode<T> node) {
		int result = 0;
		if (!node.isLeaf()) 
			result = 1 + height(node.getChildren().get(0));
		else
			result = 1;
		return result;
	}

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
			
			if (!node.isFull()) {
				node.addElement(element);
			} else {

				node.addElement(element);
				split(node);
				
			}
			
		}
		
	}

	private void split(BNode<T> node) {
		
		int median = node.size()/2;
		T mid = node.getElementAt(median);
		
		BNode<T> left = node.copyLeftChildren(median);
		BNode<T> right = node.copyRightChildren(median);
		
		if (node.getParent() == null) {
			node.setParent(new BNode<T>(node.getOrder()));
			//node.getParent().getChildren().addFirst(node);
			node.getParent().addChild(0, node);
		}
		
		BNode<T> parent = node.getParent();
		System.out.println(parent.getChildren());
		System.out.println("NODE = " + node);
		System.out.println("LEFT: " + left);
		System.out.println("RIGHT: " + right);
		System.out.println("Parent: " + parent);
		
		int index = parent.indexOfChild(node);
		
		parent.removeChild(node);
		
		parent.addChild(index, left);
		parent.addChild(index+1, right);
		
		left.setParent(parent);
		right.setParent(parent);
		
		this.promote(parent);
		
	}

	private void promote(BNode<T> node) {
		if (!node.isFull()) {
			split(node);
		}
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
