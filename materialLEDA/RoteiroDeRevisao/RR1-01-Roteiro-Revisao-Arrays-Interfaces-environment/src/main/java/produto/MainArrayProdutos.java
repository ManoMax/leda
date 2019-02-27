package produto;

public class MainArrayProdutos {

	public static void main(String[] args) {
		
		RepositorioProdutoArrayList array = new RepositorioProdutoArrayList(20);
		
		System.out.println(array.existe(5));
		
		Produto produto1 = new Produto(111, "Arroz", 10, "Integral");
		Produto produto2 = new Produto(222, "Feijao", 5, "Preto");
		Produto produto3 = new Produto(333, "Batata", 20, "Frita");
		Produto produto4 = new Produto(444, "Suco", 2, "de Fruta");
		
		
		array.inserir(produto1);
		
		System.out.println(array.toString());
		
		array.inserir(produto2);
		array.inserir(produto3);
		array.inserir(produto4);
		
		System.out.println(array.toString());
		
		System.out.println(array.existe(5));
		
		array.remover(333);
		
		System.out.println(array.toString());
		
		System.out.println(array.existe(111));
		
		array.remover(111);
		
		System.out.println(array.toString());
		
		System.out.println(array.existe(111));
	}

}
