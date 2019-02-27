package adt.rbtree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
	implements RBTree<T> {
	
	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}

	protected int blackHeight() {
		return blackHeight((RBNode<T>) root);
	}

	private int blackHeight(RBNode<T> node) {
		int result = -1;
		
		if (!node.isEmpty() && node.getColour().equals(Colour.BLACK)) {
			result = 1 + Math.max(blackHeight((RBNode<T>) node.getLeft()), blackHeight((RBNode<T>) node.getRight()));
		} else if (!node.isEmpty() && node.getColour().equals(Colour.RED)) {
			result = Math.max(blackHeight((RBNode<T>) node.getLeft()), blackHeight((RBNode<T>) node.getRight()));
		}
      return result;
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
		return verifyChildrenOfRedNodes((RBNode<T>) root, true);
	}

	private boolean verifyChildrenOfRedNodes(RBNode<T> node, boolean verify) {
		boolean result = verify;

		if (!node.isEmpty()) {
			if (((RBNode<T>) node).getColour() == Colour.RED) {
				if (!node.getLeft().isEmpty() && ((RBNode<T>) node.getLeft()).getColour() == Colour.RED) {
					result = false;
				}
				if (!node.getRight().isEmpty() && ((RBNode<T>) node.getRight()).getColour() == Colour.RED) {
					result = false;
				}
			}
			return (verifyChildrenOfRedNodes((RBNode<T>) node.getLeft(), result)
					&& verifyChildrenOfRedNodes((RBNode<T>) node.getRight(), result));
		} else {
			return result;
		}
	}
	
	/**
	 * Verifies the black-height property from the root. The method blackHeight
	 * returns an exception if the black heights are different.
	 */
	private boolean verifyBlackHeight() {
		return verifyBlackHeight((RBNode<T>) root, true);
	}

	private boolean verifyBlackHeight(RBNode<T> node, boolean verify) {
		boolean result = verify;
		
		if (!node.isEmpty()) {
			if (blackHeight((RBNode<T>) node.getLeft()) != blackHeight((RBNode<T>) node.getRight())) {
				result = false;
			}
			return (verifyBlackHeight((RBNode<T>) node.getLeft(), result) 
					&& verifyBlackHeight((RBNode<T>) node.getRight(), result));
		} else {
			return result;
		}
	}

	@Override
	public void insert(T value) {
		if (value != null) {
			insertAux((RBNode<T>) root, value);
		}
	}

	private void insertAux(RBNode<T> node, T value) {
		// Disponivel
		if (node.isEmpty()) {
			node.setData(value);
			node.setLeft(new RBNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new RBNode<T>());
			node.getRight().setParent(node);
			node.setColour(Colour.RED);
			
			if (node.getParent() == null) {
				node.setParent(new BSTNode<>());
			}
			// System.out.println(value + " Alocado");
			fixUpCase1(node);
			
		// Nao Disponivel
		} else {
			if (node.getData().compareTo(value) > 0) {
				// System.out.println(value + " Esquerda");
				insertAux((RBNode<T>) node.getLeft(), value);

			} else if (node.getData().compareTo(value) < 0) {
				// System.out.println(value + " Direita");
				insertAux((RBNode<T>) node.getRight(), value);
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public RBNode<T>[] rbPreOrder() {
		RBNode[] array = new RBNode[this.size()];
	      if (this.isEmpty())
	         return array;
	      preOrder(array, (RBNode<T>) root, 0);
	      return array;
	}
	
	@SuppressWarnings("rawtypes")
	private int preOrder(RBNode[] array, RBNode<T> node, int index) {
		array[index++] = (RBNode) node;

	      if (!node.getLeft().isEmpty())
	         index = preOrder(array, (RBNode<T>) node.getLeft(), index);

	      if (!node.getRight().isEmpty())
	         index = preOrder(array, (RBNode<T>) node.getRight(), index);

	      return index;
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
		RBNode<T> avo = (RBNode<T>) node.getParent().getParent();
		RBNode<T> tio = (RBNode<T>) avo.getRight();
		
		if (tio == node.getParent()) {
			tio = (RBNode<T>) avo.getLeft();
		}
		
		if (tio.getColour() == Colour.RED) {
			((RBNode<T>) node.getParent()).setColour(Colour.BLACK);
			tio.setColour(Colour.BLACK);
			avo.setColour(Colour.RED);
			fixUpCase1(avo);
		} else {
			fixUpCase4(node);
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
