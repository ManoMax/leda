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

	@Override
	public void insert(T element) {
		if (element != null) {
			insertRecursive(element, root);
			System.out.println("\n");
		}
	}
	
	@SuppressWarnings("unchecked")
	private void insertRecursive(T element, BSTNode<T> node) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>().parent(node).build());
            node.setRight(new BSTNode.Builder<T>().parent(node).build());
            
            if (node.getParent() == null) {
				this.root = node;
			}
            System.out.println(element + " alocado.");
		} else {
			if (node.getData().compareTo(element) > 0) {
				System.out.println(element + " esquerda");
				insertRecursive(element, (BSTNode<T>) node.getLeft());
			} else if (node.getData().compareTo(element) < 0) {
				System.out.println(element + " direita");
				insertRecursive(element, (BSTNode<T>) node.getRight());
			}
			// Node acima do Elemento alocado
			System.out.println("rebalance com " + node.getData());
			rebalance(node);
		}
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if (node != null) {
			return height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		}
		
		return 0;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		
		printDesseNode(node);
		
		if (balance > 1) {
			System.out.println("Esquerda > Direita\n");
			if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
				
			}
			rebalanceLeft(node);
		}
		
		if (balance < -1) {
			System.out.println("Direita > Esquerda\n");
			rebalanceRight(node);
		}
	}

	private void printDesseNode(BSTNode<T> node) {
		System.out.println("Node: " + node.getData() +
				   ", Left: " + node.getLeft().getData()
				   + ", Right: " + node.getRight().getData()
				   + ", Balance: " + (height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight())));
	}

	private void rebalanceRight(BSTNode<T> node) {
		int balanceRight = calculateBalance(node);
		
		if (balanceRight > 0) {
			Util.leftRotation(node);
		}
		
	}

	private void rebalanceLeft(BSTNode<T> node) {
		int balanceLeft = calculateBalance(node);
		
		if (balanceLeft > 0) {
			Util.rightRotation(node);
		}
		
		// TODO Auto-generated method stub
		
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
