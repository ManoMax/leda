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
            
		} else {
			
			if (node.getData().compareTo(element) > 0) {
				insertRecursive(element, (BSTNode<T>) node.getLeft());
				
			} else if (node.getData().compareTo(element) < 0) {
				insertRecursive(element, (BSTNode<T>) node.getRight());
			}
			
			rebalance(node);
		}
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			return height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		} else {
			return 0;
		}
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		if (!node.isEmpty()) {
			int rootBalance = calculateBalance(node);		
			int leftBalance = calculateBalance((BSTNode<T>) node.getLeft());
			int rightBalance = calculateBalance((BSTNode<T>) node.getRight());
			
			// L L
			if (rootBalance > 1 && leftBalance >= 0) {
				Util.rightRotation(node);
			}
			
			// R R
			else if (rootBalance < -1 && rightBalance >= 0) {
				Util.leftRotation(node);		
				}
			
			// R L
			else if (rootBalance < -1 && leftBalance < 0) {
				Util.rightRotation((BSTNode<T>) node.getLeft());
				Util.leftRotation(node);
			}		

			// L R
			else if (rootBalance > 1 && rightBalance < 0) {
				Util.leftRotation((BSTNode<T>) node.getRight());
				Util.rightRotation(node);
			}

		}		
		
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
