package sorting.linearSorting;

/**
 * @author Cláudio Campelo
 * 
 * Classe ordena um tipo de array ternário. Este array ternário armazena apenas 3 elementos diferentes,
 * de mesmo tipo, onde cada um deles pode aparecer em qualquer quantidade q, tal que q > 0.
 * 
 * Entrada = {1,0,2,0,0,0,2,0,1} | Saída {0,0,0,0,1,1,2,2}
 * Entrada = {5,5,4,20,20,5,4,4,4} | Saída {4,4,4,4,5,5,5,20,20}
 * 
 * O algoritmo implementado deve seguir as especificações/restricoes abaixo:
 * 
 * 1. Deve ser O(n);
 * 2. Deve ser um algoritmo de ordenacao por comparacao (uso de <, <=, >, >=, ==)
 * 3. Deve ser in-place, ou seja, não pode usar estruturas auxiliares de nenhum tipo ou tamanho;
 * 
 * ATENÇÃO: não é preciso tratar entradas inválidas (não serão testadas).
 *  
 * Uma solução O(n) para este problema seria inspirada no counting sort. Bastaria utilizar 3 variáveis para serem
 * utilizadas como contadores para cada um dos 3 diferentes elementos (essas variáveis seriam atualizadas em uma única passagem
 * pelo array). Para finalizar, bastaria passar novamente pelo array atualizando os elementos com base nos contadores. 
 * Note que esta solução poderia ser dita como in-place apenas porque foram utilizadas 3 variáveis ao invés de um array 
 * auxiliar de tamanho 3. 
 * 
 * No entanto, sua solução *** NÃO PODE SER *** como esta acima (baseada em contadores de frequência). 
 * 
 */

public interface TernaryArraySorting<T extends Comparable<T>> {

	void sort(T[] ternaryArray);

}