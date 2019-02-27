package adt.linkedList.special;

import adt.linkedList.LinkedList;

public interface SpecialLinkedList<T> extends LinkedList<T>{
	/**
	 * Faz o swap entre dois elementos existentes em uma lista. Se pelo menos um 
	 * dos elementos nao esta na lista nenhuma modificacao sera feita pelo metodo.
	 * 
	 * Restricoes:
	 * - voce pode assumir que a lista nao possui elementos duplicados
	 * - voce nao pode usar estruturas auxiliares de colecao (arrays, outras listas, etc)
	 * - o uso dos metodos size, insert, search e remove da lista esta proibido
	 * - sua implementacao DEVE resolver o problema varrendo a lista apenas uma vez 
	 *   (nao necessariamente em um só laço) e nao pode ter lacos aninhados.
	 * @param elem1
	 * @param elem2
	 */
	public void swap(T elem1, T elem2);
	
	/**
	 * Retorna o k-esimo elemento a partir do fim. Por exemplo, se k=1, retorna 
	 * o ultimo elemento da lista. Se k = 2, retorna o penultimo e assim por diante.
	 * 
	 * Restricoes:
	 * - Voce nao pode usar estrutura auxiliar para copiar os elementos da lista
	 * - O uso dos metodos size, insert, search e remove da lista esta proibido
	 * - sua implementacao DEVE resolver o problema varrendo o array apenas uma vez 
	 *   (nao necessariamente em um só laço) e nao pode ter lacos aninhados.
	 * 
	 * @param k o indice do elemento a ser retornado (a partir do fim)
	 * @return o k-esimo elemento procurando a partir do fim da lista. Caso a lista nao 
	 * tenha k-esimo elemento (a partir do fim), deve retornar null.
	 */
	public T elementFromTheEnd(int k);
	
}
