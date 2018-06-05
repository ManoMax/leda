package testesCondicionais;

import java.util.Arrays;

import adt.linkedList.RecursiveSingleLinkedListImpl;

public class SingleTestes {

	public static void main(String[] args) {
		RecursiveSingleLinkedListImpl<Integer> list = new RecursiveSingleLinkedListImpl<>();
		
		// Lista Vazia
		System.out.println("Lista Vazia");
		System.out.print(list.isEmpty() ? "." : "F");
		System.out.print(list.size() == 0  ? "." : "F");
		System.out.print(list.search(5) == null  ? "." : "F");
		System.out.println(Arrays.toString(list.toArray()).equals("[]") ? "." : "F");
		
		// 1 Elemento
		System.out.println("1 Elemento");
		list.insert(1);
		System.out.print(list.size() == 1  ? "." : "F");
		System.out.print(list.search(5) == null  ? "." : "F");
		System.out.print(list.search(1) == 1  ? "." : "F");
		System.out.println(Arrays.toString(list.toArray()).equals("[1]") ? "." : "F");
		
		// 2 Elementos
		System.out.println("2 Elementos");
		list.insert(2);
		System.out.print(list.size() == 2  ? "." : "F");
		System.out.print(list.search(5) == null  ? "." : "F");
		System.out.print(list.search(2) == 2  ? "." : "F");
		System.out.println(Arrays.toString(list.toArray()).equals("[1, 2]") ? "." : "F");
		
		// 5 Elementos
		System.out.println("5 Elementos");
		list.insert(3);
		list.insert(7);
		list.insert(3);
		System.out.print(list.size() == 5  ? "." : "F");
		System.out.print(list.search(5) == null  ? "." : "F");
		System.out.print(list.search(3) == 3  ? "." : "F");
		System.out.println(Arrays.toString(list.toArray()).equals("[1, 2, 3, 7, 3]") ? "." : "F");
		
		// Menos Elemento especifico
		System.out.println("Menos Elemento especifico");
		list.remove(2);
		System.out.print(list.size() == 4  ? "." : "F");
		System.out.print(list.search(2) == null ? "." : "F");
		System.out.print(list.search(3) == 3 ? "." : "F");
		//Integer[] array = k.toArray();
		System.out.println(Arrays.toString(list.toArray()).equals("[1, 3, 7, 3]") ? "." : "F");
		
		// Menos 1º Elemento especifico
		System.out.println("Menos 1º Elemento especifico");
		list.remove(3);
		System.out.print(list.size() == 3 ? "." : "F");
		System.out.print(list.search(5) == null ? "." : "F");
		System.out.print(list.search(3) == 3 ? "." : "F");
		//Integer[] array = k.toArray();
		System.out.println(Arrays.toString(list.toArray()).equals("[1, 7, 3]") ? "." : "F");
		
		// Removendo todos os Elementos
		System.out.println("Removendo todos os Elementos");
		list.remove(1);
		System.out.println(Arrays.toString(list.toArray()).equals("[7, 3]") ? "." : "F");
		list.remove(7);
		System.out.println(Arrays.toString(list.toArray()).equals("[3]") ? "." : "F");
		list.remove(3);
		System.out.println(Arrays.toString(list.toArray()).equals("[]") ? "." : "F");
		list.remove(9);
		System.out.println(Arrays.toString(list.toArray()).equals("[]") ? "." : "F");

		// Inserindo e Pesquisando Elemento Null
		System.out.println("Inserindo e Pesquisando Elemento Null");
		list.insert(null);
		System.out.print(list.size() == 0 ? "." : "F");
		System.out.print(list.search(5) == null ? "." : "F");
		System.out.print(list.search(3) == null ? "." : "F");
		System.out.print(Arrays.toString(list.toArray()).equals("[]") ? "." : "F");
		System.out.print(list.search(null) == null ? "." : "F");
		System.out.println("");
		
		// Removendo e Pesquisando Elemento Null
		System.out.println("Removendo e Pesquisando Elemento Null");
		list.remove(null);
		System.out.print(list.size() == 0 ? "." : "F");
		System.out.print(list.search(5) == null ? "." : "F");
		System.out.print(Arrays.toString(list.toArray()).equals("[]") ? "." : "F");
		System.out.print(list.search(null) == null ? "." : "F");
		
	}

}
