package repositorio;

import conta.ContaAbstrata;

public class RepositorioConta {

	private ContaAbstrata[] contas;
	private int indice;

	public RepositorioConta() {
		indice = 0;
		contas = new ContaAbstrata[20];
	}

	private int procurarIndice(ContaAbstrata conta) {
		int i = 0;
		int resp = -1;
		boolean achou = false;

		while ((i < indice) && !achou) {
			if ((contas[i]).equals(conta)) {
				resp = i;
				achou = true;
			}
			i = i + 1;
		}
		return resp;
	}

	public boolean existe(ContaAbstrata conta) {
		boolean resp = false;

		int i = this.procurarIndice(conta);
		if (i != -1) {
			resp = true;
		}

		return resp;
	}

	public void inserir(ContaAbstrata novaConta) {
		contas[indice] = novaConta;
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

	public ContaAbstrata procurar(ContaAbstrata conta) {
		ContaAbstrata resp = null;
		int i = this.procurarIndice(conta);
		if (i != -1) {
			resp = contas[i];
		} else {
			throw new RuntimeException("Cliente nao encontrado");
		}

		return resp;
	}

	public void remover(ContaAbstrata conta) {
		int i = this.procurarIndice(conta);
		if (i != -1) {
			contas[i] = contas[indice - 1];
			contas[indice - 1] = null;
			indice = indice - 1;
		} else {
			throw new RuntimeException("Cliente nao encontrado");
		}
	}
}