package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			
			int i = 0;
			boolean notInsert = true;
			
			while (notInsert) {
				if (hashFunction instanceof HashFunctionOpenAddress) {
					int hash = Math.abs(((HashFunctionOpenAddress<T>) hashFunction).hash(element, i));
					
					
					if (this.table[hash] == null) {
						this.table[hash] = element;
						notInsert = false;
						this.elements++;
						//System.out.println("Posicao: " + hash + " elemento: " + element.toString());
					} else {
						i++;
						this.COLLISIONS++;
					}
				}
				if (i == this.capacity()) {
					notInsert = false;
					throw new HashtableOverflowException();
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			
			int i = 0;
			boolean notRemove = true;
			
			while (notRemove) {
				if (hashFunction instanceof HashFunctionOpenAddress) {
					int hash = Math.abs(((HashFunctionOpenAddress<T>) hashFunction).hash(element, i));
					
					if (this.table[hash] != null && this.table[hash].equals(element)) {
						this.table[hash] = this.deletedElement;
						this.elements--;
						notRemove = false;
					} else {
						i++;
					}
				}
				if (i == this.capacity()) {
					notRemove = false;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T element) {
		T exit = null;
		if (element != null) {
			int i = 0;
			boolean notSearch = true;
			
			while (notSearch) {
				if (hashFunction instanceof HashFunctionOpenAddress) {
					int hash = Math.abs(((HashFunctionOpenAddress<T>) hashFunction).hash(element, i));
					
					if (this.table[hash] != null && this.table[hash].equals(element)) {
						exit = (T) this.table[hash];
						notSearch = false;
					} else {
						i++;
					}
				}
				if (i == this.capacity()) {
					notSearch = false;
				}
			}
		}
		return exit;
	}

	@Override
	public int indexOf(T element) {
		int exit = -1;
		if (element != null) {
			int i = 0;
			boolean notSearch = true;
			
			while (notSearch) {
				if (hashFunction instanceof HashFunctionOpenAddress) {
					int hash = Math.abs(((HashFunctionOpenAddress<T>) hashFunction).hash(element, i));
					
					if (this.table[hash] != null && this.table[hash].equals(element)) {
						exit = hash;
						notSearch = false;
					} else {
						i++;
					}
				}
				if (i == this.capacity()) {
					notSearch = false;
					throw new HashtableOverflowException();
				}
			}
		}
		return exit;
	}
}
