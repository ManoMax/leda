package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@SuppressWarnings("unused")
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
					} else {
						i++;
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
