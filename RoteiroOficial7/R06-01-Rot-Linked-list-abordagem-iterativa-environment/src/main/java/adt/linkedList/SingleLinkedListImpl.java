package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		if (this.getHead().isNIL()) return true;
		else return false;
	}

	@Override
	public int size() {
		if (getHead() != null) return this.listSize(this.getHead());
		return -1;
	}
	private int listSize(SingleLinkedListNode<T> item) {
		if (item == null) return 0;
		if (item.isNIL()) return 0;
		else return 1 + listSize(item.getNext());
	}

	@Override
	public T search(T element) {
		if (element == null) return null;
		if (isEmpty()) return null;
		SingleLinkedListNode<T> item = getHead();
		return buscaItem(element, item);		
	}
	private T buscaItem(T element, SingleLinkedListNode<T> item) {
		if (item.isNIL()) return null;
		if (item.getData().equals(element)) return item.getData();
		else return buscaItem(element, item.getNext());
	}
	
	@Override
	public void insert(T element) {
		if (element != null) {
			// Se Tiver Vazia
			if (isEmpty()) {
				// Cria um nova cabeça com elemento na Data e Nil no Next.
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
				// Seta a cabeça vazia como essa nova cabeça.
				this.setHead(newHead);
				
			} else {
				// Se não, pega a atual cabeça.
				SingleLinkedListNode<T> item = getHead();
				// E insere no Local Disponível.
				this.inserirNoNextLivre(element, item);
			}
		}
	}
	private void inserirNoNextLivre(T element, SingleLinkedListNode<T> item) {
		// Confere se o Next dela é Nil.
		if (item.getNext().isNIL()) {
			// Seta o novo elemento no Data do Next dela.
			item.getNext().setData(element);
			// Cria um novo Nil
			SingleLinkedListNode<T> next = new SingleLinkedListNode<T>();
			//Seta o Next dela como Nil.
			item.getNext().setNext(next);
		// Caso não seja, confere disponibilidade para o próximo elemento.
		} else inserirNoNextLivre(element, item.getNext());
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> item = getHead();
		this.buscarERemover(element, item);
	}
	private void buscarERemover(T element, SingleLinkedListNode<T> item) {
		if(item.isNIL()) return;
		if(item.getData().equals(element)) {
			item.setData(null);
			SingleLinkedListNode<T> next = new SingleLinkedListNode<T>();
			item.setNext(next);
		}
		else buscarERemover(element, item.getNext());
	}

	@Override
	public T[] toArray() {
		T[] array = initializeArray();
		SingleLinkedListNode<T> item = getHead();
		return (T[]) listArray(array, item, 0);
	}
	@SuppressWarnings("unchecked")
	private T[] initializeArray() {
		return (T[]) new Object[size()];
	}
	private T[] listArray(T[] array, SingleLinkedListNode<T> item, int position) {
		if (item == null) return array;
		if (item.isNIL()) return array;
		else {
			array[position++] = item.getData();
			return listArray(array, item.getNext(), position);
		}
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
	
}
