package adt.hashtable.closed;

import java.util.LinkedList;

import adt.hashtable.hashfunction.HashFunction;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionFactory;
import util.Util;
import adt.hashtable.hashfunction.*;

public class HashtableClosedAddressImpl<T> extends AbstractHashtableClosedAddress<T> {

   /**
    * A hash table with closed address works with a hash function with closed
    * address. Such a function can follow one of these methods: DIVISION or
    * MULTIPLICATION. In the DIVISION method, it is useful to change the size
    * of the table to an integer that is prime. This can be achieved by
    * producing such a prime number that is bigger and close to the desired
    * size.
    * 
    * For doing that, you have auxiliary methods: Util.isPrime and
    * getPrimeAbove as documented bellow.
    * 
    * The length of the internal table must be the immediate prime number
    * greater than the given size (or the given size, if it is already prime). 
    * For example, if size=10 then the length must
    * be 11. If size=20, the length must be 23. You must implement this idea in
    * the auxiliary method getPrimeAbove(int size) and use it.
    * 
    * @param desiredSize
    * @param method
    */

   @SuppressWarnings({ "rawtypes", "unchecked" })
   public HashtableClosedAddressImpl(int desiredSize, HashFunctionClosedAddressMethod method) {
      int realSize = desiredSize;

      if (method == HashFunctionClosedAddressMethod.DIVISION) {
         realSize = this.getPrimeAbove(desiredSize); // real size must the
         // the immediate prime
         // above
      }
      initiateInternalTable(realSize);
      HashFunction<T> function = HashFunctionFactory.createHashFunction(method, realSize);
      this.hashFunction = function;
   }

   // AUXILIARY
   /**
    * It returns the prime number that is closest (and greater) to the given
    * number.
    * If the given number is prime, it is returned. 
    * You can use the method Util.isPrime to check if a number is
    * prime.
    */
   int getPrimeAbove(int number) {
	   while (!Util.isPrime(number)) {
		   number++;
	   };
	   return number;
   }
   
   @Override
   public void insert(T element) {
<<<<<<< HEAD:RoteiroOficial8/RoteiroOficial8/R08-01-Rot-TabelaHash-EndFechado-environment/src/main/java/adt/hashtable/closed/HashtableClosedAddressImpl.java
	   if (element != null) {
		   if (this.search(element) == null) {
			   if (!getLinkedList(element).isEmpty()) {
				   this.COLLISIONS++;
			   }
			   
			   getLinkedList(element).addFirst(element);
			   elements++;
		   }
	   }
   }
   
   @SuppressWarnings("unchecked")
   private LinkedList<T> getLinkedList(T element) {
	   LinkedList<T> exit = new LinkedList<T>();
	   if (hashFunction instanceof HashFunctionClosedAddress) {
		   int hash = Math.abs(((HashFunctionClosedAddress<T>) hashFunction).hash(element));
		   Object list = this.table[hash];
		   
		   if (list instanceof LinkedList) {
			   exit = (LinkedList<T>) list;
		   } else {
			   this.table[hash] = new LinkedList<T>();
			   exit = (LinkedList<T>) list;
		   }
	   }
	   return exit;
=======
	  if (element != null) {
		  if (this.table instanceof LinkedList[]) {
	    	  
	      }
	  }
>>>>>>> 5cb6b74d1d26c6663b2d3dd18bfe53ecec5da853:RoteiroOficial8/R08-01-Rot-TabelaHash-EndFechado-environment/src/main/java/adt/hashtable/closed/HashtableClosedAddressImpl.java
   }

   @Override
   public void remove(T element) {
	   if (element != null) {
		   if (!(getLinkedList(element).isEmpty())) {
			   if (getLinkedList(element).remove(element)) {
				   this.elements--;
			   }
		   }
	   }
   }

   @Override
   public T search(T element) {
	   T exit = null;
	   if (element != null) {
		   // Por algum motivo, sem esse método abaixo não passou nos testes.
		   getLinkedList(element);
		   if (getLinkedList(element).contains(element)) {
			   exit = element;
		   }
	   }
	   return exit;
   }

   @Override
   public int indexOf(T element) {
	   int index = -1;
	   if (element != null) {
		   if (this.search(element) != null) {
			   if (hashFunction instanceof HashFunctionClosedAddress) {
				   index = ((HashFunctionClosedAddress<T>) hashFunction).hash(element);
			   }
		   }
	   }
	   return index;
   }

}
