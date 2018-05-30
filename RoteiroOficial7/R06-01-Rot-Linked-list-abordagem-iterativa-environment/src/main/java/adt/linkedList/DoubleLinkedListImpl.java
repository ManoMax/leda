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
		
		while(auxHead != auxLast && auxHead.next != auxLast
			&& auxHead.data!= element && auxLast.data != element) {
			
			auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			auxLast = auxLast.getPrevious();
			}
		
		if (auxHead.data == element) return auxHead.getData();
		if (auxLast.data == element) return auxLast.getData();
		return null;
	}
	
	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), null);
			newHead.setNext(this.getHead());
			
			if (getHead() instanceof DoubleLinkedListNode) {
				((DoubleLinkedListNode<T>) getHead()).setPrevious(newHead);}
			
			if (getHead().isNIL()) setLast(newHead);
			setHead(newHead);
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, null, new DoubleLinkedListNode<T>());
			newLast.setPrevious(getLast());
			
			getLast().setNext(newLast);
			
			if (getLast().isNIL()) setHead(newLast);
			setLast(newLast);
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
		if(!(this.getLast().isNIL())) {
			this.setLast(getLast().getPrevious());
		} else {
			this.setHead((DoubleLinkedListNode<T>) this.getLast());
		}
		((DoubleLinkedListNode<T>) this.getLast()).setNext(new DoubleLinkedListNode<T>());
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
