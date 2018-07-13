package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;

	protected int maxHeight;

	protected double PROBABILITY = 0.5;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SkipListImpl(int maxHeight) {
		this.maxHeight = maxHeight;
		root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
	 * metodo deve conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxHeight; i++) {
			root.forward[i] = NIL;
		}
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void insert(int key, T newValue, int height) {
		
		SkipListNode<T> node1 = root;
		SkipListNode[] update = new SkipListNode[maxHeight];
		
		for (int i = maxHeight-1; i >= 0; i--) {
			while (node1.getForward(i) != null && node1.getForward(i).getKey() < key) {
				node1 = node1.getForward(i);
			}
			update[i] = node1;
		}
		
		node1 = node1.getForward(0);
		
		if (node1.getKey() == key) {
			node1.setValue(newValue);
			
		} else if (node1 != null || node1.getKey() != key) {
			
			SkipListNode<T> node3 = new SkipListNode<T>(key, height, newValue);
			
			for (int i = 0; i < height; i++) {
				node3.forward[i] = update[i].getForward(i);
				update[i].forward[i] = node3;
			}
		}
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void remove(int key) {
		
		SkipListNode<T> node1 = root;
		SkipListNode[] update = new SkipListNode[maxHeight];
		
		for (int i = maxHeight-1; i >= 0; i--) {
			while (node1.getForward(i) != null && node1.getForward(i).getKey() < key) {
				node1 = node1.getForward(i);
			}
			update[i] = node1;
		}
		
		node1 = node1.getForward(0);
		
		if (node1.getKey() == key) {
			for (int i = 0; i < size(); i++) {
				if (update[i].forward[i] != node1) {
					break;
				}
				update[i].forward[i] = node1.forward[i];
			}
		}
	}

	@Override
	public int height() {
		SkipListNode<T> node1 = this.root;
		
		for (int i = maxHeight -1; i >= 0; i--) 
			if (node1.getForward(i) != NIL) 
				return i+1;
		return 0;
	}

	@SuppressWarnings("unused")
	@Override
	public SkipListNode<T> search(int key) {
		
		SkipListNode<T> node1 = root;
		SkipListNode<T> node2 = null;
		
		for (int i = maxHeight -1; i >= 0; i--) {
			while (node1.getForward(i) != NIL && node1.getForward(i).getKey() < key) {
				node1 = node1.getForward(i);
			}
			node2 = node1;
		}
		
		node1 = node1.getForward(0);
		
		if (node1.getKey() == key) {
			return node1;
		} else {
			return null;
		}
	}

	@Override
	public int size() {
		
		int cont = 0;
		
		SkipListNode<T> node1 = root.getForward(0);
		while (node1 != NIL) {
			node1 = node1.getForward(0);
			cont++;
		}
		return cont;
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SkipListNode<T>[] toArray() {
		
		SkipListNode[] update = new SkipListNode[size()+2];
		SkipListNode<T> node1 = root;
		int i = 0;
		while(node1 != NIL) {
			update[i] = node1;
			node1 = node1.getForward(0);
			i++;
		}
		update[i] = node1;
		
		return update;
	}

}
