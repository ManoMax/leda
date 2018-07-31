package adt.linkedList.special;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SpecialLinkedListImplJoaoMarcelo<T> extends SingleLinkedListImpl<T> implements SpecialLinkedList<T> {

	@Override
	public void swap(T elem1, T elem2) {
		SingleLinkedListNode<T> first = null;
		SingleLinkedListNode<T> second = null;
		
		if (elem1 != null && elem2 != null) {
			SingleLinkedListNode<T> node = head;
			
			// Varre e atribui First and Second
			while (!node.isNIL()) {
				if (node.getData().equals(elem1)) {
					first = node;
				} else if (node.getData().equals(elem2)) {
					second = node;
				}
				node = node.getNext();
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
		SingleLinkedListNode<T> exit = this.head;
		SingleLinkedListNode<T> aux = this.head;
		
		int cont = 0, cont2 = k;
		
		while(!aux.isNIL()) {
			if(cont == cont2) {
				exit = exit.getNext();
				cont2++;
			}
			cont++;
			aux = aux.getNext();
		}
		
		T res = null;
		if (cont >= k) res = exit.getData();
		return res;
	}
	
}
