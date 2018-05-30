package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (top.size() <= size) top.insert(element);
	}

	@Override
	public T pop() throws StackUnderflowException {
		T exit = null;
		if (!(top.isEmpty())) {
			exit = ((DoubleLinkedListImpl<T>) top).getLast().getData();
			top.removeLast();
		}
		return exit;
	}

	@Override
	public T top() {
		T exit = null;
		if (!(top.isEmpty())) exit = ((DoubleLinkedListImpl<T>) top).getLast().getData();
		return exit;
	}

	@Override
	public boolean isEmpty() {
		return (top.isEmpty());
	}

	@Override
	public boolean isFull() {
		return (top.size() == size);
	}

}
