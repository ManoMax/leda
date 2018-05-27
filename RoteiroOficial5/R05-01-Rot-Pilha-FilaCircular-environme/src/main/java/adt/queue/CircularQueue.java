package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!(isFull())) {
			if (isEmpty()) this.head++;
			
			if (tail == this.array.length) this.tail = 0;
			else tail++;
			
			array[tail] = element;
			this.elements++;
		} else throw new QueueOverflowException();
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!(isEmpty())) {
			
			T exit = this.array[head];
			this.array[head] = null;
			
			if (this.head == this.array.length-1) this.head = 0;
			else this.head++;
			
			this.elements--;
			return exit;
		} else throw new QueueUnderflowException();
	}

	@Override
	public T head() {
		if (!(isEmpty())) {
			return this.array[head];
		}
		else return null;
	}
	
	@Override
	public boolean isEmpty() {
		return (this.elements == 0);
	}

	@Override
	public boolean isFull() {
		return (this.elements == this.array.length);
	}

}
