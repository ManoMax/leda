package solucao.vetor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import vetor.Aluno;

public class TesteVetor {
	private Vetor<Aluno> vetorNaoVazio;
	private Vetor<Aluno> vetorVazio;

	@Before
	public void setUp() throws Exception {
		vetorNaoVazio = new Vetor<Aluno>(10);
		vetorVazio = new Vetor<Aluno>(1);
		ComparadorMaximo compMax = new ComparadorMaximo();
		vetorNaoVazio.setComparadorMaximo(compMax);
		vetorVazio.setComparadorMaximo(compMax);
		ComparadorMinimo compMin = new ComparadorMinimo();
		vetorNaoVazio.setComparadorMinimo(compMin);
		vetorVazio.setComparadorMinimo(compMin);
	}

	@Test
	public void testInserir() {
		assertTrue(vetorNaoVazio.isVazio());
		vetorNaoVazio.inserir(new Aluno("Joao Epifanio", 5.0));
		assertFalse(vetorNaoVazio.isVazio());

	}

	@Test
	public void testRemover() {
		Aluno novoAluno = new Aluno("Joao Epifanio", 5.0);
		vetorNaoVazio.inserir(novoAluno);
		assertFalse(vetorNaoVazio.isVazio());
		vetorNaoVazio.remover(novoAluno);
		assertTrue(vetorNaoVazio.isVazio());
	}

	@Test
	public void testProcurar() {
		Aluno novoAluno = new Aluno("Joao Epifanio", 5.0);
		vetorNaoVazio.inserir(novoAluno);

		Aluno procurado = vetorNaoVazio.procurar(novoAluno);
		assertEquals(novoAluno, procurado);
		procurado = vetorNaoVazio.procurar(new Aluno("Ze", 6.0));
		assertNull(procurado);
	}

	@Test
	public void testIsVazio() {
		assertTrue(vetorVazio.isVazio());
	}

	@Test
	public void testIsCheio() {
		for (int i = 0; i < 10; i++) {
			Aluno novoAluno = new Aluno("Joao Epifanio", 5.0);
			vetorNaoVazio.inserir(novoAluno);
		}
		assertTrue(vetorNaoVazio.isCheio());
	}

	@Test
	public void testMaximo() {
		Aluno novoAluno1 = new Aluno("Joao Epifanio", 5.0);
		Aluno novoAluno2 = new Aluno("Jose Laurentino", 6.0);
		vetorNaoVazio.inserir(novoAluno1);
		vetorNaoVazio.inserir(novoAluno2);
		Aluno maximo = vetorNaoVazio.maximo();
		assertEquals(novoAluno2, maximo);
	}

	@Test
	public void testMinimo() {
		Aluno novoAluno1 = new Aluno("Joao Epifanio", 5.0);
		Aluno novoAluno2 = new Aluno("Jose Laurentino", 6.0);
		vetorNaoVazio.inserir(novoAluno1);
		vetorNaoVazio.inserir(novoAluno2);
		Aluno minimo = vetorNaoVazio.minimo();
		assertEquals(novoAluno1, minimo);
	}

}
