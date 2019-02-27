package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		if (this.getHead().isNIL()) return true;
		else return false;
	}

	@Override
	public int size() {
		int size = 0;
		if (getHead() != null) {
			if (!(getHead().isNIL())) {
				SingleLinkedListNode<T> aux = getHead();
				while ((aux != null) && !(aux.isNIL())) {
					size++;
					aux = aux.getNext();
				}
			}
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = getHead();
		while (!(aux.isNIL()) && !(aux.getData().equals(element))) {
			aux = aux.getNext();
		}
		return aux.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = getHead();
		if (getHead().isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, null);
			newHead.setNext(getHead());
			setHead(newHead);
		} else {
			while (!(auxHead.getNext().isNIL())) {
				auxHead = auxHead.getNext();
			}
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, null);
			newNode.setNext(auxHead.getNext());
			auxHead.setNext(newNode);
		}
	}

	@Override
	public void remove(T element) {
		if (getHead().getData().equals(element)) {
			setHead(getHead().getNext());
		} else {
			SingleLinkedListNode<T> aux = getHead();
			SingleLinkedListNode<T> previous = null;
			while ((aux != null) && !(aux.isNIL()) && !(aux.getData().equals(element))) {
				previous = aux;
				aux = aux.getNext();
			}
			if ((aux != null) && !(aux.isNIL())) {
				previous.setNext(aux.getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = initializeArray();
		SingleLinkedListNode<T> aux = getHead();
		int count = 0;
		while ((aux != null) && !(aux.isNIL())) {
			result[count] = aux.getData();
			aux = aux.getNext();
			count++;
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	private T[] initializeArray() {
		return (T[]) new Object[size()];
	}
	
	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
