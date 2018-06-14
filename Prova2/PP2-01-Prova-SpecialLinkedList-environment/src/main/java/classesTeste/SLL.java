package classesTeste;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.special.SpecialLinkedListImpl;

public class SLL {

	public static void main(String[] args) {
		
		// Instanciando 3 listas
		System.out.println("\nInstanciando 3 listas");
		SingleLinkedListImpl<Integer> list1 = new SingleLinkedListImpl<Integer>();
		SpecialLinkedListImpl<Integer> list2 = new SpecialLinkedListImpl<Integer>();
		
		System.out.println(list1.isEmpty());
		System.out.println(list1.size());
		
		// Inserindo 1 elemento
		System.out.println("\nInserindo 1 elemento");
		list1.insert(1);
		System.out.println(list1.isEmpty());
		System.out.println(list1.size());
		
		// Removendo 1 elemento
		System.out.println("\nRemovendo 1 elemento");
		list1.remove(1);
		System.out.println(list1.isEmpty());
		System.out.println(list1.size());

		// Inserindo varios elementos
		System.out.println("\nInserindo varios elementos");
		list1.insert(1);
		System.out.println(list1.size());
		list1.insert(2);
		System.out.println(list1.size());
		list1.insert(3);
		System.out.println(list1.size());
		
		// K = 1 (Lista 2 Vazia)
		System.out.println("\nK = 1 (Lista 2 Vazia)");
		System.out.println(list2.elementFromTheEnd(1));
		
		// Inserindo varios elementos Lista 2
		System.out.println("\nInserindo varios elementos Lista 2");
		list2.insert(1);
		System.out.println(list2.size());
		list2.insert(2);
		System.out.println(list2.size());
		list2.insert(3);
		System.out.println(list2.size());
		
		System.out.println(list2.toArray());
		
		// SWAP
		System.out.println("\nSWAP");
		list2.swap(1, 3);
		System.out.println(list2.toArray());
		
		// SWAP Inexist Element
		System.out.println("\nSWAP Inexist Element");
		list2.swap(1, 4);
		System.out.println(list2.toArray());
		
		// SWAP Null
		System.out.println("\nSWAP Null");
		list2.swap(1, null);
		System.out.println(list2.toArray());

		// Insert More
		System.out.println("\nInsert More");
		list2.insert(8);
		list2.insert(9);
		
		// K = 1
		System.out.println("\nK = 1");
		System.out.println(list2.elementFromTheEnd(1));
		
		// K = 2
		System.out.println("\nK = 2");
		System.out.println(list2.elementFromTheEnd(2));
		
		// K = 0 (NULL)
		System.out.println("\nK = 0 (NULL)");
		System.out.println(list2.elementFromTheEnd(0));
		
		// K = 5
		System.out.println("\nK = 5");
		System.out.println(list2.elementFromTheEnd(5));
				
		
		// Inserindo elemento invalido
		System.out.println("\nInserindo elemento invalido");
		list1.insert(null);
		System.out.println(list1.size());
		
		System.out.println();
		
		// Removendo elemento invalido
		list1.remove(null);
		System.out.println(list1.size());
		System.out.println(list1.toArray());
		
		
	}

}
