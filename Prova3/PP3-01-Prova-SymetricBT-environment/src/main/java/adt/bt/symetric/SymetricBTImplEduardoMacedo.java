package adt.bt.symetric;

import adt.bt.BTNode;

public class SymetricBTImplEduardoMacedo<T> implements SymetricBT<T> {

	protected BTNode<T> root;

	
	public SymetricBTImplEduardoMacedo() {
		root = new BTNode<T>();
	}

	@Override
	public boolean isSymetric() {
		boolean isSymetric = true;
		
		if (getRoot().isEmpty() || getRoot().isLeaf()) {
			isSymetric = true;
		} else {
			isSymetric = isSymetric(root.getRight(), root.getLeft());
		}
		
		return isSymetric;
	}

	private boolean isSymetric(BTNode<T> right, BTNode<T> left) {
		
		if (right != null && left != null && right.equals(left)) {
			
			if (right.isEmpty() && left.isEmpty())
				return true;
			
			return isSymetric(right.getLeft(), left.getRight()) && isSymetric(right.getRight(), left.getLeft());
		}
		return false;
		
	}

	@Override
	public BTNode<T> getRoot() {
		return root;
	}
}
