package repositorio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import conta.Conta;

public class TesteRepositorioGenericoTest {

	private RepositorioCliente repClientes;
	private RepositorioConta repContas;
	private RepositorioGenerico rep;
	
	@Before
	public void setUp() {
		this.repClientes = new RepositorioCliente();
		this.repContas = new RepositorioConta();
		this.rep = new RepositorioGenerico();
	}
	
	
	@Test
	public void test() {
		Cliente cli1 = new Cliente("1","Jose");
		Cliente cli2 = new Cliente("2","Joao");
		repClientes.inserir(cli1);
		repClientes.inserir(cli2);
		//repClientes.inserir(new Conta("3",100.0,cli1));
	}

}
