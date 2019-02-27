package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if (node.isEmpty() || (node.getLeft() == null && node.getRight() == null)) {
			return 0;
		} else {
			return height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		}
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		if (!node.isEmpty()) {
			if (calculateBalance(node) > 1) {

				if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					rightRotation(node);
				} else {
					leftRotation((BSTNode<T>) node.getLeft());
					rightRotation(node);
				}

			}
			if (calculateBalance(node) < -1) {

				if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					leftRotation(node);
				} else {
					rightRotation((BSTNode<T>) node.getRight());
					leftRotation(node);
				}

			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		// TODO Auto-generated method stub
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while (!parent.isEmpty()) {
			rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}

	// AUXILIARY
	protected void leftRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();
		node.setRight(pivot.getLeft());
		pivot.getLeft().setParent(node);

		pivot.setLeft(node);

		pivot.setParent(node.getParent());
		node.setParent(pivot);
		if (node != root) {
			if (pivot.getParent().getLeft() == node) {
				pivot.getParent().setLeft(pivot);
			} else {
				pivot.getParent().setRight(pivot);
			}
		} else {
			root = (BSTNode<T>) pivot;
		}

	}

	// AUXILIARY
	protected void rightRotation(BSTNode<T> node) {
		BTNode<T> pivot = node.getLeft();

		node.setLeft(pivot.getRight());
		pivot.getRight().setParent(node);

		pivot.setRight(node);

		pivot.setParent(node.getParent());
		node.setParent(pivot);

		if (node != root) {
			if (pivot.getParent().getLeft() == node) {
				pivot.getParent().setLeft(pivot);
			} else {
				pivot.getParent().setRight(pivot);
			}
		} else {
			root = (BSTNode<T>) pivot;
		}
	}

	protected void insert(T element, BTNode<T> node) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);

			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);

			if (node.getParent() == null) {
				BSTNode<T> father = new BSTNode<T>();
				node.setParent(father);
			}
		} else {
			if (node.getData().compareTo(element) == -1) {
				insert(element, node.getRight());
			} else {
				insert(element, node.getLeft());
			}
		}
		rebalance((BSTNode<T>) node);
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if (!node.isEmpty()) {
			if (node.getLeft().isEmpty() && node.getRight().isEmpty()) {
				node.setData(null);
				rebalanceUp(node);
			} else if (node.getLeft().isEmpty() || node.getRight().isEmpty()) {
				if (node.equals(root)) {
					if (!node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getLeft();
					} else {
						root = (BSTNode<T>) node.getRight();
					}
					root.setParent(new BSTNode<T>());
				} else if (node.equals(node.getParent().getLeft())) {
					if (!node.getLeft().isEmpty()) {
						node.getParent().setLeft(node.getLeft());
						node.getLeft().setParent(node.getParent());
					} else {
						node.getParent().setLeft(node.getRight());
						node.getRight().setParent(node.getParent());
					}
				} else {
					if (!node.getLeft().isEmpty()) {
						node.getParent().setRight(node.getLeft());
						node.getLeft().setParent(node.getParent());
					} else {
						node.getParent().setRight(node.getRight());
						node.getRight().setParent(node.getParent());
					}
				}
				rebalanceUp(node);
			} else {
				T sucessor = sucessor(element).getData();
				remove(sucessor);
				node.setData(sucessor);
			}
		}
	}

}