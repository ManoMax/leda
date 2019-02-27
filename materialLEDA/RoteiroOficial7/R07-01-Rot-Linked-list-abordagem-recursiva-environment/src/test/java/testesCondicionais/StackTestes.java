package testesCondicionais;

import adt.stack.StackOverflowException;
import adt.stack.StackRecursiveDoubleLinkedListImpl;
import adt.stack.StackUnderflowException;

public class StackTestes {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		StackRecursiveDoubleLinkedListImpl<Integer> stack = new StackRecursiveDoubleLinkedListImpl<>(5);
		
		// Removendo de Pilha vazia
		System.out.println("Removendo de Pilha vazia");
		System.out.print(stack.isEmpty() == true ? "." : "F");
		System.out.print(stack.isFull() == false  ? "." : "F");
		System.out.print(stack.top() == null ? "." : "F");
		try{ stack.pop(); } catch (StackUnderflowException e){System.out.print(".");}
		System.out.println("");
		
		// Adicionando Primeiro Elemento
		System.out.println("Adicionando Primeiro Elemento");
		stack.push(2);
		System.out.print(stack.top() == 2 ? "." : "F");
		System.out.print(stack.isFull() == false  ? "." : "F");
		System.out.print(stack.isEmpty() == false ? "." : "F");
		System.out.println("");
		
		// Adicionando Segundo Elemento
		System.out.println("Adicionando Segundo Elemento");
		stack.push(17);
		System.out.print(stack.top() == 17 ? "." : "F");
		System.out.print(stack.isFull() == false  ? "." : "F");
		System.out.print(stack.isEmpty() == false ? "." : "F");
		System.out.println("");
		
		// Adicionando Terceiro Elemento
		System.out.println("Adicionando Terceiro Elemento");
		stack.push(4);
		System.out.print(stack.top() == 4 ? "." : "F");
		System.out.print(stack.isFull() == false  ? "." : "F");
		System.out.print(stack.isEmpty() == false ? "." : "F");
		System.out.println("");
		
		// Adicionando Quarto Elemento
		System.out.println("Adicionando Quarto Elemento");
		stack.push(17);
		System.out.print(stack.top() == 17 ? "." : "F");
		System.out.print(stack.isFull() == false  ? "." : "F");
		System.out.print(stack.isEmpty() == false ? "." : "F");
		System.out.println("");
		
		// Adicionando Quinto Elemento
		System.out.println("Adicionando Quinto Elemento");
		stack.push(42);
		System.out.print(stack.top() == 42 ? "." : "F");
		System.out.print(stack.isFull() == true  ? "." : "F");
		System.out.print(stack.isEmpty() == false ? "." : "F");
		System.out.println("");
		
		// Adicionando Elemento a mais que o Permitido
		System.out.println("Adicionando Elemento a mais que o Permitido");
		System.out.print(stack.isFull() == true ? "." : "F");
		System.out.print(stack.isEmpty() == false ? "." : "F");
		try{ stack.push(12); } catch (StackOverflowException e){System.out.print(".");}
		try{ stack.push(92); } catch (StackOverflowException e){System.out.print(".");}
		System.out.println("");
		
		// Removendo da Pilha
		System.out.println("Removendo da Pilha");
		stack.pop();
		System.out.print(stack.top() == 17 ? "." : "F");
		System.out.print(stack.isFull() == false  ? "." : "F");
		System.out.print(stack.isEmpty() == false ? "." : "F");
		System.out.println("");
		
		stack.pop();
		System.out.print(stack.top() == 4 ? "." : "F");
		System.out.print(stack.isFull() == false  ? "." : "F");
		System.out.print(stack.isEmpty() == false ? "." : "F");
		
		stack.pop();
		System.out.print(stack.top() == 17 ? "." : "F");
		System.out.print(stack.isFull() == false  ? "." : "F");
		System.out.print(stack.isEmpty() == false ? "." : "F");
		
		stack.pop();
		System.out.print(stack.top() == 2 ? "." : "F");
		System.out.print(stack.isFull() == false  ? "." : "F");
		System.out.print(stack.isEmpty() == false ? "." : "F");
		
		stack.pop();
		System.out.print(stack.top() == null ? "." : "F");
		System.out.print(stack.isFull() == false  ? "." : "F");
		System.out.print(stack.isEmpty() == true ? "." : "F");
		try{ stack.pop(); } catch (StackUnderflowException e){System.out.print(".");}
		
	}

}
