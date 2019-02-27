package adt.bt;

import adt.bst.BSTNode;

public class Util {

	/**
	* A rotacao a esquerda em node deve subir e retornar seu filho a direita
	* @param node
	* @return
	*/
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		BSTNode<T> right = (BSTNode<T>) node.getRight();
	
		node.setRight(right.getLeft());
		node.getRight().setParent(node);
		right.setParent(node.getParent());
		node.setParent(right);
		right.setLeft(node);
	
		if(parent != null) {
			if(parent.getRight() != null && parent.getRight().equals(node)) {
				parent.setRight(right);
			}else {
				parent.setLeft(right);
			}
		}
		return right;
	}
	
	/**
	* A rotacao a direita em node deve subir e retornar seu filho a esquerda
	* 
	* @param node
	* @return
	*/
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		BSTNode<T> left = (BSTNode<T>) node.getLeft();

		node.setLeft(left.getRight());
		node.getLeft().setParent(node);
		left.setParent(node.getParent());
		node.setParent(left);
		left.setRight(node);

		if(parent != null) {

			if(parent.getRight() != null && parent.getRight().equals(node)) {
				parent.setRight(left);
			}else {
				parent.setLeft(left);
			}
		}
		return left;
	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		T[] array = (T[]) new Comparable[size];
		return array;
	}
	
}
