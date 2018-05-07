package repositorio;

import conta.ContaAbstrata;

public class RepositorioConta {

	private ContaAbstrata[] contas;
	private int indice;

	public RepositorioConta() {
		indice = 0;
		contas = new ContaAbstrata[20];
	}

<<<<<<< HEAD
	private int procurarIndice(ContaAbstrata cliente) {
=======
	private int procurarIndice(ContaAbstrata conta) {
>>>>>>> 98e87768c1cbec382073741311da90b4af5b6aae
		int i = 0;
		int resp = -1;
		boolean achou = false;

		while ((i < indice) && !achou) {
<<<<<<< HEAD
			if ((contas[i]).equals(cliente)) {
=======
			if ((contas[i]).equals(conta)) {
>>>>>>> 98e87768c1cbec382073741311da90b4af5b6aae
				resp = i;
				achou = true;
			}
			i = i + 1;
		}
		return resp;
	}

<<<<<<< HEAD
	public boolean existe(ContaAbstrata cliente) {
		boolean resp = false;

		int i = this.procurarIndice(cliente);
=======
	public boolean existe(ContaAbstrata conta) {
		boolean resp = false;

		int i = this.procurarIndice(conta);
>>>>>>> 98e87768c1cbec382073741311da90b4af5b6aae
		if (i != -1) {
			resp = true;
		}

		return resp;
	}

<<<<<<< HEAD
	public void inserir(ContaAbstrata novoCliente) {
		contas[indice] = novoCliente;
=======
	public void inserir(ContaAbstrata novaConta) {
		contas[indice] = novaConta;
>>>>>>> 98e87768c1cbec382073741311da90b4af5b6aae
		this.indice++;
	}

	public void atualizar(ContaAbstrata conta) {
		int i = procurarIndice(conta);
		if (i != -1) {
			contas[i] = conta;
		} else {
			throw new RuntimeException("Conta nao encontrada");
		}
	}

<<<<<<< HEAD
	public ContaAbstrata procurar(ContaAbstrata cliente) {
		ContaAbstrata resp = null;
		int i = this.procurarIndice(cliente);
=======
	public ContaAbstrata procurar(ContaAbstrata conta) {
		ContaAbstrata resp = null;
		int i = this.procurarIndice(conta);
>>>>>>> 98e87768c1cbec382073741311da90b4af5b6aae
		if (i != -1) {
			resp = contas[i];
		} else {
			throw new RuntimeException("Cliente nao encontrado");
		}

		return resp;
	}

<<<<<<< HEAD
	public void remover(ContaAbstrata cliente) {
		int i = this.procurarIndice(cliente);
=======
	public void remover(ContaAbstrata conta) {
		int i = this.procurarIndice(conta);
>>>>>>> 98e87768c1cbec382073741311da90b4af5b6aae
		if (i != -1) {
			contas[i] = contas[indice - 1];
			contas[indice - 1] = null;
			indice = indice - 1;
		} else {
			throw new RuntimeException("Cliente nao encontrado");
		}
	}
}