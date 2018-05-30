package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}
	
	@Override
	public T search(T element) {
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) getHead();
		DoubleLinkedListNode<T> auxLast = getLast();
		
		while((auxHead != null) && (auxLast != null) && auxHead != auxLast && auxHead.next != auxLast
			&& auxHead.data!= element && auxLast.data != element) {
			
			auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			auxLast = auxLast.getPrevious();
			}
		
		if ((auxHead != null) && auxHead.data == element) return auxHead.getData();
		if ((auxHead != null) && auxLast.data == element) return auxLast.getData();
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, null, null);
			newLast.setPrevious(getLast());
			newLast.setNext(new DoubleLinkedListNode<T>());
			
			getLast().setNext(newLast);
			
			if (getLast().isNIL()) setHead(newLast);
			setLast(newLast);
		}
	}
	
	@Override
	public void remove(T element) {
		if (getHead().getData().equals(element)) {
			removeFirst();
		} else {
			DoubleLinkedListNode<T> aux = getHead();
			while ((aux != null) && !(aux.isNIL()) && !(aux.getData().equals(element))) {
				aux = (DoubleLinkedListNode<T>) aux.getNext();
			}
			if (!(aux.isNIL())) {
				aux.getPrevious().setNext(aux.getNext());
				((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
			}
		}
	}
	
	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, null, null);
			newHead.setNext(this.getHead());
			newHead.setPrevious(new DoubleLinkedListNode<T>());
			
			if (getHead() instanceof DoubleLinkedListNode) {
				((DoubleLinkedListNode<T>) getHead()).setPrevious(newHead);}
			
			if (getHead().isNIL()) setLast(newHead);
			setHead(newHead);
		}
	}

	@Override
	public void removeFirst() {
		if (!(this.getHead().isNIL())) {
			this.setHead(getHead().getNext());
		} else {
			this.setLast((DoubleLinkedListNode<T>) this.getHead());
		}
		((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<T>());
	}

	@Override
	public void removeLast() {
		if(!(getLast().isNIL())) {
			setLast(getLast().getPrevious());
			if (getLast().isNIL()) {
				setHead((DoubleLinkedListNode<T>) getLast());
			}
			((DoubleLinkedListNode<T>) getLast()).setNext(new DoubleLinkedListNode<T>());
		}
	}

	@Override
	public DoubleLinkedListNode<T> getHead() {
		return (DoubleLinkedListNode<T>) this.head;
	}
	
	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
