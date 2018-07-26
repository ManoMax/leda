package adt.bt.symetric;

import adt.bt.BTNode;

public class SymetricBTImpl<T> implements SymetricBT<T>{

	protected BTNode<T> root;

	
	public SymetricBTImpl() {
		root = new BTNode<T>();
	}

	@Override
	public boolean isSymetric() {
		if (!root.isEmpty()) {
			return isSymetric(root.getRight(), root.getLeft(), true);
		} else {
			return true;
		}
	}

	private boolean isSymetric(BTNode<T> right, BTNode<T> left, boolean result) {
		
		boolean exit = result;
		BTNode<T> r = right;
		BTNode<T> l = left;
			
		// Fechando vazio
		if (r.isEmpty() && !l.isEmpty()) {
			exit = false;
			
		// Abrindo vazio
		} else if (!r.isEmpty() && l.isEmpty()) {
			exit = false;
		
		// Fechando nao vazio
		} else if (!r.isEmpty() && !l.isEmpty()) {	
			if (!r.getData().equals(l.getData())) exit = false;
			if (r.getData() != l.getData()) exit = false;
			exit = isSymetric(r.getLeft(), l.getRight(), result);
				
		// Abrindo nao vazio
		} else if (!r.isEmpty() && !l.isEmpty()) {
			if (!r.getData().equals(l.getData())) exit = false;
			if (r.getData() != l.getData()) exit = false;
			exit = isSymetric(r.getRight(), l.getLeft(), result);
		
		}
		
		return exit;
	}

	@Override
	public BTNode<T> getRoot() {
		return root;
	}

}
