package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		
		BSTNode<T> pivot = (BSTNode<T>) node.getRight(); // 30
		BSTNode<T> root = (BSTNode<T>) node.getParent();
		
		
		pivot.setLeft(node); // 20 < 30
		
		node.getParent().setRight(pivot); 
		
		return (BSTNode<T>) node.getRight();
	}
	
	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
	
		BSTNode<T> pivot = (BSTNode<T>) node; // -10
		BSTNode<T> root = (BSTNode<T>) node.getRight(); // 20
		
		
		
		
		return null;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
