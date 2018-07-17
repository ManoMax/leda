package adt.rbtree;

import adt.bst.BSTImpl;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements RBTree<T> {
	
	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}

	protected int blackHeight() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected boolean verifyProperties() {
		boolean resp = verifyNodesColour() && verifyNILNodeColour()
				&& verifyRootColour() && verifyChildrenOfRedNodes()
				&& verifyBlackHeight();

		return resp;
	}

	/**
	 * The colour of each node of a RB tree is black or red. This is guaranteed
	 * by the type Colour.
	 */
	private boolean verifyNodesColour() {
		return true; // already implemented
	}

	/**
	 * The colour of the root must be black.
	 */
	private boolean verifyRootColour() {
		return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
																// implemented
	}

	/**
	 * This is guaranteed by the constructor.
	 */
	private boolean verifyNILNodeColour() {
		return true; // already implemented
	}

	/**
	 * Verifies the property for all RED nodes: the children of a red node must
	 * be BLACK.
	 */
	private boolean verifyChildrenOfRedNodes() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Verifies the black-height property from the root. The method blackHeight
	 * returns an exception if the black heights are different.
	 */
	private boolean verifyBlackHeight() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void insert(T value) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public RBNode<T>[] rbPreOrder() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// FIXUP methods
	protected void fixUpCase1(RBNode<T> node) {
		
		if (node.getParent().isEmpty()) {
			node.setColour(Colour.BLACK);
		} else {
			fixUpCase2(node);
		}
		
	}

	protected void fixUpCase2(RBNode<T> node) {
		
		if (((RBNode<T>) node.getParent()).getColour() == Colour.BLACK) {
			// OK
		} else {
			fixUpCase3(node);
		}
	}

	protected void fixUpCase3(RBNode<T> node) {
		
		RBNode<T> G = (RBNode<T>) node.getParent().getParent();
		RBNode<T> U = (RBNode<T>) G.getRight();
		
		if (U == node.getParent()) {
			U = (RBNode<T>) G.getLeft();
		}
		
		if (U.getColour() == Colour.RED) {
			
		}
		
	}

	protected void fixUpCase4(RBNode<T> node) {
		
		RBNode<T> next = node;
		RBNode<T> pai = (RBNode<T>) node.getParent();
		RBNode<T> avo = (RBNode<T>) pai.getParent();
		
		if (next == pai.getRight() && pai == avo.getLeft()) {
			Util.leftRotation(pai);
			next = (RBNode<T>) node.getLeft();
		}
		else if (next == pai.getLeft() && pai == avo.getRight())  {
			Util.rightRotation(pai);
			next = (RBNode<T>) node.getRight();
		}
		fixUpCase5(next);
		
	}

	protected void fixUpCase5(RBNode<T> node) {
		
		RBNode<T> pai = (RBNode<T>) node.getParent();
		RBNode<T> avo = (RBNode<T>) pai.getParent();
		
		pai.setColour(Colour.BLACK);
		avo.setColour(Colour.RED);
		
		if (node == pai.getLeft()) {
			Util.rightRotation(avo);
		} else {
			Util.leftRotation(avo);
		}
	}
}
