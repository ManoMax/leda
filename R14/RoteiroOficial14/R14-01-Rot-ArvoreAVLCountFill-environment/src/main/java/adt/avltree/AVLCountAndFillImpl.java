package adt.avltree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adt.bst.BSTNode;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	protected void rebalance(BSTNode<T> node) {
		if (!node.isEmpty()) {
			if (calculateBalance(node) > 1) {

				if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					rightRotation(node);
					LLcounter++;

				} else {
					leftRotation((BSTNode<T>) node.getLeft());
					rightRotation(node);
					LRcounter++;

				}

			}
			if (calculateBalance(node) < -1) {

				if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					leftRotation(node);
					RRcounter++;

				} else {
					rightRotation((BSTNode<T>) node.getRight());
					leftRotation(node);
					RLcounter++;
				}

			}
		}
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		List<T[]> list = new ArrayList<T[]>();
		Arrays.sort(array);
		list.add(array);
		int i = 0;
		while (i < list.size()) {
			T[] arrayAux = list.get(i);
			int middle = arrayAux.length / 2;
			T[] arrayAux1 = Arrays.copyOfRange(arrayAux, 0, middle);
			T[] arrayAux2 = Arrays.copyOfRange(arrayAux, middle + 1, arrayAux.length);
			if (arrayAux.length > 1) {
				list.add(arrayAux1);
				list.add(arrayAux2);
			}
			insert(arrayAux[middle]);
			i++;
		}

	}

}