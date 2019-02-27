package test.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import adt.stack.Stack;
import adt.stack.StackRecursiveDoubleLinkedListImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackRecursiveDoubleLinkedListImpl<Integer>(4);
		stack2 = new StackRecursiveDoubleLinkedListImpl<Integer>(10);
		stack3 = new StackRecursiveDoubleLinkedListImpl<Integer>(5);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack1.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}

	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack1.push(7);
		stack1.push(new Integer(5));
	}

	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(new Integer(3), stack3.pop()); 
	}
}