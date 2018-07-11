package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> rightNode = (BSTNode<T>) node.getRight();
		rightNode.setParent(node.getParent());
		
		if (node.getParent() != null) {
			if (node.getParent().getLeft().equals(node)) {
				node.getParent().setLeft(rightNode);
			} else {
				node.getParent().setRight(rightNode);
			}
		}
		
		node.setParent(rightNode);
		node.setRight(rightNode.getLeft());
		
		if (rightNode.getLeft() != null) {
			rightNode.getLeft().setParent(node);
		}
		
		rightNode.setLeft(node);
		
		return rightNode;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> leftNode = (BSTNode<T>) node.getLeft();
		leftNode.setParent(node.getParent());
		
		if (node.getParent() != null) {
			if (node.getParent().getLeft().equals(node)) {
				node.getParent().setLeft(leftNode);
			} else {
				node.getParent().setRight(leftNode);
			}
		}
		
		node.setParent(leftNode);
		node.setLeft(leftNode.getRight());
		
		if (leftNode.getRight() != null) {
			leftNode.getRight().setParent(node);
		}
		
		leftNode.setRight(node);
		
		return leftNode;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}