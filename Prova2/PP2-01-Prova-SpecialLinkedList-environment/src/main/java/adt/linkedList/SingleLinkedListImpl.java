package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return (this.head.isNIL());
	}

	@Override
	public int size() {
		
		SingleLinkedListNode<T> aux = head;
		int size = 0;
		while (!aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T search = null;
		if (element != null) {
			SingleLinkedListNode<T> aux = head;
			
			while (!aux.isNIL()) {
				if (aux.getData().equals(element)) {
					search = element;
				} else {
					aux = aux.getNext();
				}
			}
		}
		return search;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> aux = head;
			boolean notInsert = true;
			
			while (notInsert) {
				if (aux.isNIL()) {
					aux.setNext(new SingleLinkedListNode<T>());
					aux.setData(element);
					notInsert = false;
				} else {
					aux = aux.getNext();
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			SingleLinkedListNode<T> aux = head;
			SingleLinkedListNode<T> nextAux = head.getNext();
			
			boolean notRemove = true;
			
			if (aux.getData().equals(element)) {
				aux.setData(nextAux.getData());
				aux.setNext(nextAux.getNext());
			}
			
			while (!(nextAux.isNIL()) && notRemove) {
				if (nextAux.getData().equals(element)) {
					aux.setNext(nextAux.getNext());
					notRemove = false;
				} else {
					aux = aux.getNext();
					nextAux = nextAux.getNext();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[size()];
		SingleLinkedListNode<T> aux = getHead();
		int count = 0;
		//String saida = "";
		
		while ((aux != null) && !(aux.isNIL())) {
			//saida += aux.getData() + " ";
			result[count] = aux.getData();
			aux = aux.getNext();
			count++;
		}
		//System.out.println(saida);
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
