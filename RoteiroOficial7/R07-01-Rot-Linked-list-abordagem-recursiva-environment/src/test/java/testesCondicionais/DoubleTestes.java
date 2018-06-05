package testesCondicionais;

import java.util.Arrays;

import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class DoubleTestes {

	public static void main(String[] args) {
		RecursiveDoubleLinkedListImpl<Integer> list = new RecursiveDoubleLinkedListImpl<>();
		
		// Testes DoubleLinkedList
		System.out.println("Testes DoubleLinkedList");
		
		// Lista Vazia
		System.out.println("Lista Vazia");
		System.out.print(list.size() == 0 ? "." : "F");
		System.out.print(list.search(9) == null ? "." : "F");
		System.out.print(Arrays.toString(list.toArray()).equals("[]") ? "." : "F");
		System.out.println("");
		list.removeFirst();
		list.removeLast();
		list.remove(34);
		
		// Acrescentando 1º Elemento na Primeira Posicao
		System.out.println("Acrescentando 1º Elemento na Primeira Posicao");
		list.insertFirst(9);
		System.out.print(list.size() == 1 ? "." : "F");
		System.out.print(list.search(9) == 9 ? "." : "F");
		System.out.print(Arrays.toString(list.toArray()).equals("[9]") ? "." : "F");
		System.out.print(list.getFirst().equals(9) ? "." : "F");
		System.out.println("");
		
		// Acrescentando 2º Elemento na Primeira Posicao
		System.out.println("Acrescentando 2º Elemento na Primeira Posicao");
		list.insertFirst(17);
		System.out.print(list.size() == 2 ? "." : "F");
		System.out.print(list.search(9) == 9 ? "." : "F");
		System.out.print(Arrays.toString(list.toArray()).equals("[17, 9]") ? "." : "F");
		System.out.print(list.getFirst().equals(17) ? "." : "F");
		System.out.println("");
		
		// Acrescentando 3º Elemento na Primeira Posicao
		System.out.println("Acrescentando 3º Elemento na Primeira Posicao");
		list.insertFirst(12);
		System.out.print(list.size() == 3 ? "." : "F");
		System.out.print(list.search(12) == 12 ? "." : "F");
		System.out.print(Arrays.toString(list.toArray()).equals("[12, 17, 9]") ? "." : "F");
		System.out.print(list.getFirst().equals(12) ? "." : "F");
		System.out.println("");
		
		// Removendo Primeira Posicao
		System.out.println("Removendo Primeira Posicao");
		list.removeFirst();
		System.out.print(list.size() == 2 ? "." : "F");
		System.out.print(list.search(12) == null ? "." : "F");
		System.out.print(Arrays.toString(list.toArray()).equals("[17, 9]") ? "." : "F");
		System.out.println("");
		
		// Removendo Ultima Posicao
		System.out.println("Removendo Ultima Posicao");
		list.removeLast();
		System.out.print(list.size() == 1 ? "." : "F");
		System.out.print(list.search(9) == null ? "." : "F");
		System.out.print(Arrays.toString(list.toArray()).equals("[17]") ? "." : "F");
		System.out.println("");
		
		// Removendo Elemento Especifico
		System.out.println("Removendo Elemento Especifico");
		list.remove(17);
		System.out.print(list.size() == 0 ? "." : "F");
		System.out.print(list.search(17) == null ? "." : "F");
		System.out.print(Arrays.toString(list.toArray()).equals("[]") ? "." : "F");
		System.out.println("");
		
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
