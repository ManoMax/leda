package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		return this.array[0];
	}

	@Override
	public boolean isEmpty() {
		return (tail <= 0);
	}

	@Override
	public boolean isFull() {
		return (tail == this.array.length-1);
	}

	private void shiftLeft() {
		for(int i = 0; i < this.tail; i++) this.array[i] = this.array[i+1];
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!(isFull())) {
			this.tail++;
			this.array[tail] = element;
		} else throw new QueueOverflowException();
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!(isEmpty())) {
			T exit = this.array[0];
			this.array[0] = null;
			shiftLeft();
			this.tail--;
			return exit;
		} else throw new QueueUnderflowException();
	}

}
