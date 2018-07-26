package adt.bt.symetric;

import adt.bt.BTNode;

/**
 * Extensao de arvore binaria que possui um método especifico.
 * 
 * @author adalbertocajueiro
 *
 */
public interface SymetricBT<T>{
	/**
	 * Diz se a BT e simetrica ou nao. 
	 * Uma BT e simetrica na raiz quando as sub-arvores da raiz sao imagens espelhadas.
	 * Ou seja, a sub-arvore a direita eh uma imagem no espelho da sub-arvore a direita.
	 * 
	 * Restricoes:
	 * - voce nao pode gerar nenhum caminhamento na arvore e compara-los para ver a simetria
	 * - voce nao podee usar memoria extra (qualquer colecao para armazenar objetos)
	 * - voce deve usar recursao. 
	 * 
	 * @return
	 */
	public boolean isSymetric();
	
	/**
	 * Metodo para retornar a raiz da arvore
	 * @return
	 */
	public BTNode<T> getRoot();
}
