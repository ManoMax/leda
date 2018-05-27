package adt.stack;

/**
 * 
 * @author GabrielMax
 * @git: ManoMax
 *
 * @param <T>
 */
public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		if (!(isEmpty())) return this.array[this.top];
		else return null;
	}

	@Override
	public boolean isEmpty() {
		return (this.top == -1);
	}

	@Override
	public boolean isFull() {
		return (this.top == this.array.length);
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!(isFull())) {
			this.top++;	this.array[top] = element;
		} else throw new StackOverflowException();
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!(isEmpty())) {
			T exit = this.array[top];
			this.array[top] = null;
			this.top--;
			return exit;
		} else throw new StackUnderflowException();
	}

}
