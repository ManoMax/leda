package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int leftHeight = super.height((BSTNode<T>) node.getLeft());
		int rightHeight = super.height((BSTNode<T>) node.getRight());
		
		int balance = leftHeight - rightHeight;
		
		return balance;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);
		
		if (balance > 1) {
			this.rebalanceLeft(node);
		} else if (balance < -1) {
			this.rebalanceRight(node);
		}
	}

	private void rebalanceLeft(BSTNode<T> node) {
		int balanceLeft = this.calculateBalance((BSTNode<T>) node.getLeft());
		
		if (balanceLeft > 0) {
			Util.rightRotation(node);
		} else if (balanceLeft < 0) {
			Util.leftRotation((BSTNode<T>) node.getLeft());
			Util.rightRotation(node);
		}
		
		if (this.getRoot().equals(node)) {
			this.root = (BSTNode<T>) node.getParent();
		}
	}
	
	private void rebalanceRight(BSTNode<T> node) {
		int balanceRight = this.calculateBalance((BSTNode<T>) node.getRight());
		
		if (balanceRight < 0) {
			Util.leftRotation(node);
		} else if (balanceRight > 0) {
			Util.rightRotation((BSTNode<T>) node.getRight());
			Util.leftRotation(node);
		}
		
		if (this.getRoot().equals(node)) {
			this.root = (BSTNode<T>) node.getParent();
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while (parent != null) {
			rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}
	
	
	@Override
	public void insert(T element) {
		if (element != null) {
			insertAux(root, element);
		}
	}

	private void insertAux(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			// Criando um nó novo
			node.setData(element);
			node.setRight(new BSTNode<>());
			node.setLeft(new BSTNode<>());
			if (node.getParent() == null) {
				this.root = node;
			}
			node.getRight().setParent(node);
			node.getLeft().setParent(node);
		} else {
			if (element.compareTo(node.getData()) > 0) {
				insertAux((BSTNode<T>) node.getRight(), element);
			} else if (element.compareTo(node.getData()) < 0) {
				insertAux((BSTNode<T>) node.getLeft(), element);
			}
			rebalance(node);
		}

	}
	
	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty()) {
			return;
		} else {
			// Primerio Caso : node eh uma folha
			if (node.getLeft().isEmpty() && node.getRight().isEmpty()) {
				node.setData(null);
				rebalanceUp(node);
			}
			// Segundo caso : node tem um filho
			else if (node.getLeft().isEmpty() || node.getRight().isEmpty()) {
				if (node.getParent() != null) {
					if (!node.getParent().getLeft().equals(node)) {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					} else {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				} else {
					if (node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getRight();
					} else {
						root = (BSTNode<T>) node.getLeft();
					}
					root.setParent(null);
				}
				rebalanceUp(node);
				// Terceiro caso : node tem dois filhos
			} else {
				T suc = sucessor(node.getData()).getData();
				remove(suc);
				node.setData(suc);

			}
		}

	}
}