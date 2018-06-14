package adt.linkedList.special;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SpecialLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SpecialLinkedList<T> {

	@Override
	public void swap(T elem1, T elem2) {
		SingleLinkedListNode<T> first = null;
		SingleLinkedListNode<T> second = null;
		
		if (elem1 != null && elem2 != null) {
			SingleLinkedListNode<T> varredor = head;
			
			// Recebe First and Second
			while (!varredor.isNIL()) {
				if (varredor.getData().equals(elem1)) {
					first = varredor;
				} else if (varredor.getData().equals(elem2)) {
					second = varredor;
				}
				varredor = varredor.getNext();
			}
			
			//SWAP
			if (first != null && second != null) {
				T aux = first.getData();
				first.setData(second.getData());
				second.setData(aux);
			}
		}
	}

	@Override
	public T elementFromTheEnd(int k) {
		
		SingleLinkedListNode<T> aux1 = head;
		
		if (head.isNIL()) return null;
	
		int cont = 0;
		while (!aux1.isNIL()) {
			cont++;
			aux1 = aux1.getNext();
		}
		
		int newCont = 0;
		aux1 = head;
		while (newCont < cont - k) {
			aux1 = aux1.getNext();
			newCont++;
		}
	
		return aux1.getData();

	}

}
