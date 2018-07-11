package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		
		BSTNode<T> pivot = (BSTNode<T>) node.getRight(); // 20
		BSTNode<T> oposit = (BSTNode<T>) node.getLeft(); // null T1
		BSTNode<T> left = (BSTNode<T>) pivot.getLeft(); // null T2
		BSTNode<T> right = (BSTNode<T>) pivot.getRight(); // 30 T3
		
		swap(pivot, node);
		
		node.setRight(right);
		right.setParent(node);
		
		node.setLeft(pivot);
		pivot.setParent(node);
		
		pivot.setLeft(oposit);
		pivot.setRight(left);
		oposit.setParent(pivot);
		left.setParent(pivot);
		
		return node;
	}
	
	private static <T extends Comparable<T>> BSTNode<T> swap(BSTNode<T> pivot, BSTNode<T> node) {
		
		T aux = node.getData();
		node.setData(pivot.getData());
		pivot.setData(aux);
		
		return null;
	}
	

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
	
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft(); // 20
		BSTNode<T> t1 = (BSTNode<T>) node.getRight(); // null T1
		BSTNode<T> t2 = (BSTNode<T>) pivot.getRight(); // null T2
		BSTNode<T> t3 = (BSTNode<T>) pivot.getLeft(); // 30 T3
		
		swap(pivot, node);
		
		node.setRight(pivot);
		pivot.setParent(node);
		
		node.setLeft(t3);
		t3.setParent(node);
		
		pivot.setRight(t1);
		t1.setParent(pivot);
		
		node.setLeft(t2);
		t2.setParent(node);
		System.out.println(pivot + " " + t1 + t2 + t3);
		return node;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
