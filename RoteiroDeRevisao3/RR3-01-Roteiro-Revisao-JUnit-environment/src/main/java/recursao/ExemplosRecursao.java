package recursao;

public class ExemplosRecursao {

	//Calcular o numero de zeros em um array de inteiros
	public int calcularZerosIterativo(int[] array){
		int zeros = 0;
		for (int num : array) {
			if(num == 0){
				zeros = zeros + 1;
			}
		}
		return zeros;
	}
	
	public int calcularZerosComRecursao(int[] array){
		return calcularZerosRecursivo(array, 0);
	}
	private int calcularZerosRecursivo(int[] array, int indice){
		int zeros = 0;
		if(indice == array.length - 1){ //caso base: atingiu o ultimo elemento do array 
			if(array[indice] == 0){
				zeros = 1;
			}
		}else{ //caso recursivo
			if(array[indice] == 0){
				zeros = 1;
			}
			zeros = zeros + calcularZerosRecursivo(array, indice + 1); 
		}
		return zeros;
	}
	
	//calcular o valor minimo de um array de inteiros de forma iterativa
	public int minimum(int[] array){
		int minimum = 0;
		if(array.length > 0){
			minimum = array[0]; //valor base a ser retornado
			for (int num : array) {
				if(num < minimum){
					minimum = num; //atualizacao do valor a ser retornado
				}
			}
		}
		return minimum;
	}
	
	//calcular o valor minimo de um array de forma recursiva
	public int minimumRecursive(int[] array){
		int minimum = 0;
		if(array.length > 0){
			minimum = minimumRecursive(array,0);
		}
		
		return minimum;
		
	}
	private int minimumRecursive(int[] array, int posicao) {
		int minimum = array[0]; //valor base a ser retornado
		if(posicao == array.length-1){ //caso base 
			//nao faz nada porque minimum já guarda o valor a ser retornado
		}else{
			int proxMin = minimumRecursive(array, posicao + 1);
			if(proxMin < minimum){
				minimum = proxMin;
			}
		}

		return minimum;
	}


	//calcular a soma dos k primeiro elementos
	public int somaIterativa(int k){
		int soma = 0; //elemento neutro da soma. valor do caso base a ser retornado
		for (int i = 1; i <= k; i++) {
			soma = soma + k;
		}
		return soma;
	}
	
	//calcular a soma dos k primeiro elementos
	public int somaRecursiva(int k){
		int soma = 0; //elemento neutro da soma
		if( k == 0){ //caso base
			//nao faz nada porque soma ja guarda o valro a ser retornado
		}else{
			soma = k + somaRecursiva(k - 1);
		}
		return soma;
	}

	//verifica se uma sequencia eh um apalindrome sem recursao
	public boolean isPalindrome(String word){
		boolean palindrome = true;
		//varre a string do inicio ate a metade vendo se 
		//caracteres equidistantes sao iguais
		int i = 0;
		while(i < word.length()/2 && palindrome){
			palindrome = word.charAt(i) == word.charAt(word.length() - i);
			i++;
		}
		return palindrome;
	}
	//verifica se uma sequencia eh um apalindrome com recursao
	public boolean isPalindromeRecursive(String word){
		boolean palindrome = true;
		//caso base: se word é vazio ou tem apenas 1 elemento entao eh palindrome
		if(word.equals("") || word.length()==1){
			//nao faz nada porque palindrome ja eh true;
		}else{
		//caso recursivo: verifica a primeira e ultima letras e continua verificando 
		//o restante da string (sem a primeira e a ultima)
			palindrome = word.charAt(0) == word.charAt(word.length()-1)
					&& isPalindromeRecursive(word.substring(1,word.length()-1));
			//note que o codigo acima ainda pode ser otimizado
		}
		return palindrome;
	}
	
	// tail recursion
	/*
	 * Inverter uma string sem usar tail recursion
	 */
	public String reverseString1(String word) {
		if (word == null || word.equals(""))
			return word;
		else
			return reverseString(word.substring(1)) + word.charAt(0);
	}

	// calcular o resto da divisao sem usar o operador % e usando tail recursion
	public int modulus(int val, int divisor) {
		if (val < divisor)
			return val;
		else
			return modulus(val - divisor, divisor);
	}

	/**
	 * Geralmente é possivel converter recursao sem tail recursion em 
	 * recursão usando tail recursion. Isso normalmente requer um metodo
	 * auxiliar. 
	 */
	public String reverseString(String word) {
		if (word == null){
			return word;
		}
		return tailReverse(word, ""); 
	}

	//res vai acumlando a resposta a ser retornada
	public String tailReverse(String word, String res) {
		if (word.equals("")) 
			return res;
		else
			return tailReverse(word.substring(1), word.charAt(0) + res);
	}

	/**
	 * Imprimir a representacao binaria de um numero
	 */
	public void convertBinary(int n) {
		if (n < 2) {
			System.out.print(n);
		} else {
			convertBinary(n / 2);
			System.out.print(n % 2);
		}
	}
	// verificar se é uma palindrome


}
