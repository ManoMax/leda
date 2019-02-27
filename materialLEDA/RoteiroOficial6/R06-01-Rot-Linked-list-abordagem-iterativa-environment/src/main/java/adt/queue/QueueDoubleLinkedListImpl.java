package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (list.size() < this.size) {
			list.insert(element);
		} else throw new QueueOverflowException();
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T exit = null;
		if (!(list.isEmpty())) {
			exit = (T) ((DoubleLinkedListImpl<T>) list).getHead().getData();
			list.removeFirst();
		} else {
			throw new QueueUnderflowException();
		}
		return exit;
	}

	@Override
	public T head() {
		T exit = null;
		if (!(list.isEmpty())) exit = (T) ((DoubleLinkedListImpl<T>) list).getHead().getData();
		return exit;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return (list.size() >= size);
	}

}
