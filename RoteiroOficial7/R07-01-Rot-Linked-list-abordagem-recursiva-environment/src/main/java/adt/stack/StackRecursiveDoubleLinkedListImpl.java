package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (top.size() < size)	top.insertFirst(element);
		else throw new StackOverflowException();
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!(top.isEmpty())) {
			T firstElement = ((RecursiveDoubleLinkedListImpl<T>) top).getFirst();
			top.removeFirst();
			return firstElement;
		}
		else throw new StackUnderflowException();
	}

	@Override
	public T top() {
		return ((RecursiveDoubleLinkedListImpl<T>) top).getFirst();
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return (top.size() == size);
	}

}
