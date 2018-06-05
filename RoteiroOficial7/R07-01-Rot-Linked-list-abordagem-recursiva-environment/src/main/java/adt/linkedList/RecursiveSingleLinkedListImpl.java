package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		setData(data);
		setNext(next);
	}

	@Override
	public boolean isEmpty() {
		return (getData() == null);
	}

	@Override
	public int size() {
		if (isEmpty()) return 0;
		else return 1 + next.size();
	}

	@Override
	public T search(T element) {
		if (!(element == null)) {
			if (isEmpty()) return null;
			else {
				if (data == element) return getData();
				else return next.search(element);
			}
		} return null;
	}

	@Override
	public void insert(T element) {
		if (!(element == null)) {
			if (isEmpty()) {
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<T>());
			} else next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (isEmpty()) {
				//Não há o que remover
			} else {
				if (getData() == element) {
					setData(next.getData());
					setNext(next.getNext());
				} else next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = initializeArray();
		toArray(array, this, 0);
		return array;
	}
	
	public T[] toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int position) {
		if (node == null) return array;
		if (node.isEmpty()) return array;
		else {
			array[position++] = node.getData();
			return toArray(array, node.getNext(), position);
		}
	}
	
	@SuppressWarnings("unchecked")
	private T[] initializeArray() {
		return (T[]) new Object[size()];
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
