package adt.bst;

import java.util.Arrays;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

   protected BSTNode<T> root;

   public BSTImpl() {
      root = new BSTNode<T>();
   }

   public BSTNode<T> getRoot() {
      return this.root;
   }

   @Override
   public boolean isEmpty() {
      return root.isEmpty();
   }

   @Override
   public int height() {
      return height(root);
   }

   protected int height(BSTNode<T> node) {
      int result = -1;

      if (!node.isEmpty()) {
         result = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
      }
      return result;
   }

   @Override
   public BSTNode<T> search(T element) {
      BSTNode<T> aux = root;
      return search(element, aux);
   }

   private BSTNode<T> search(T element, BSTNode<T> node) {
      BSTNode<T> result = new BSTNode<>();
      
      // System.out.println(Arrays.toString(order()));
      
      if (element != null && !node.isEmpty()) {
         if (node.getData().equals(element)) {
            result = node;
            
         } else if (node.getData().compareTo(element) < 0) {
            result = search(element, (BSTNode<T>) node.getRight());
            
         } else {
            result = search(element, (BSTNode<T>) node.getLeft());
         }
      }
      return result;
   }

   @Override
   public void insert(T element) {
      if (element != null) {
         insert(element, root);
      }
   }

   @SuppressWarnings("unchecked")
   private void insert(T element, BSTNode<T> node) {
      if (element != null) {

         // Disponivel
         if (node.isEmpty()) {
            node.setData(element);
            node.setLeft(new BSTNode.Builder<T>().parent(node).build());
            node.setRight(new BSTNode.Builder<T>().parent(node).build());

            if (node.getParent() == null) {
               node.setParent(new BSTNode<>());
            }
            //System.out.println(element + " alocado\n");

         // Nao Disponivel
         } else {
            // Elemento menor que Atual node
            if (node.getData().compareTo(element) > 0) {
               //System.out.println(element + " esquerda");
               insert(element, (BSTNode<T>) node.getLeft());
               
            // Elemento maior que Atual node
            } else if (node.getData().compareTo(element) < 0) {
               //System.out.println(element + " direita");
               insert(element, (BSTNode<T>) node.getRight());
            }
         }
      }
   }

   @Override
   public BSTNode<T> maximum() {
      return maximum(root);
   }

   private BSTNode<T> maximum(BSTNode<T> node) {
      BSTNode<T> result = null;
      if (!node.isEmpty()) {
         if (node.getRight().isEmpty()) {
            result = (BSTNode<T>) node;
         } else {
            result = maximum((BSTNode<T>) node.getRight());
         }
      }
      return result;
   }

   @Override
   public BSTNode<T> minimum() {
      return minimum(root);
   }

   private BSTNode<T> minimum(BSTNode<T> node) {
      BSTNode<T> result = null;
      if (!node.isEmpty()) {
         if (node.getLeft().isEmpty()) {
            result = (BSTNode<T>) node;
         } else {
            result = minimum((BSTNode<T>) node.getLeft());
         }
      }
      return result;
   }

   @Override
   public BSTNode<T> sucessor(T element) {
	  //System.out.println("Sucessor de " + element);
      BSTNode<T> node = search(element);

      if (node.isEmpty())
         return null;

      if (!node.getRight().isEmpty()) {
    	 //System.out.println("é " + minimum((BSTNode<T>) node.getRight())+"\n");
         return minimum((BSTNode<T>) node.getRight());
      } else {
         BSTNode<T> parent = (BSTNode<T>) node.getParent();

         while (!parent.isEmpty() && node.equals(parent.getRight())) {
        	//System.out.println(node.getData() + " " + parent.getData());
            node = parent;
            parent = (BSTNode<T>) node.getParent();
         }
         if (parent.isEmpty())
            return null;
         //System.out.println("é " + parent);
         return parent;
      }
   }

   @Override
   public BSTNode<T> predecessor(T element) {
      BSTNode<T> aux = search(element);

      if (aux.isEmpty())
         return null;

      if (!aux.getLeft().isEmpty()) {
         return maximum((BSTNode<T>) aux.getLeft());
      } else {
         BSTNode<T> parent = (BSTNode<T>) aux.getParent();

         while (!parent.isEmpty() && aux.equals(parent.getLeft())) {
            aux = parent;
            parent = (BSTNode<T>) aux.getParent();
         }
         if (parent.isEmpty())
            return null;
         return parent;
      }
   }

   @Override
   public void remove(T element) {
      if (element != null) {
         BSTNode<T> node = search(element);
         if (node.isEmpty()) return;
         remove(node);
      }
   }

   private void remove(BSTNode<T> node) {
      // Node vazio
      if (node.isEmpty())
         return;

      // Existe Duas filhas
      if (!node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
         BSTNode<T> sucessor = sucessor(node.getData());
         node.setData(sucessor.getData());
         remove(sucessor);
         
      // Uma filha ou Nem uma filha
      } else {
         BSTNode<T> son = (BSTNode<T>) node.getLeft();

         if (son.isEmpty())
            son = (BSTNode<T>) node.getRight();

         node.setData(son.getData());
         node.setRight(son.getRight());
         node.setLeft(son.getLeft());

         if (!node.isEmpty() && node.getRight() != null)
            node.getRight().setParent(node);
         if (!node.isEmpty() && node.getLeft() != null)
            node.getLeft().setParent(node);
      }
   }

   @SuppressWarnings("unchecked")
   @Override
   public T[] preOrder() {
      T[] array = (T[]) new Comparable[this.size()];
      if (this.isEmpty())
         return array;
      preOrder(array, root, 0);
      return array;
   }

   private int preOrder(T[] array, BSTNode<T> node, int index) {
      array[index++] = node.getData();

      if (!node.getLeft().isEmpty())
         index = preOrder(array, (BSTNode<T>) node.getLeft(), index);

      if (!node.getRight().isEmpty())
         index = preOrder(array, (BSTNode<T>) node.getRight(), index);

      return index;
   }

   @SuppressWarnings("unchecked")
   @Override
   public T[] order() {
      T[] array = (T[]) new Comparable[this.size()];
      if (this.isEmpty()) return array;
      order(array, root, 0);
      return array;
   }

   private int order(T[] array, BSTNode<T> node, int index) {
      if (!node.getLeft().isEmpty()) {
         index = order(array, (BSTNode<T>) node.getLeft(), index);
      }

      //System.out.println(index + " node " + node.getData());
      array[index++] = node.getData();
      if (!node.getRight().isEmpty()) {
         index = order(array, (BSTNode<T>) node.getRight(), index);
      }

      return index;
   }

   @SuppressWarnings("unchecked")
   @Override
   public T[] postOrder() {
      T[] array = (T[]) new Comparable[this.size()];
      if (this.isEmpty())
         return array;
      postOrder(array, root, 0);
      return array;
   }

   private int postOrder(T[] array, BSTNode<T> node, int index) {
      if (!node.getLeft().isEmpty())
         index = postOrder(array, (BSTNode<T>) node.getLeft(), index);

      if (!node.getRight().isEmpty())
         index = postOrder(array, (BSTNode<T>) node.getRight(), index);

      array[index++] = node.getData();

      return index;
   }

   /**
    * This method is already implemented using recursion. You must understand
    * how it work and use similar idea with the other methods.
    */
   @Override
   public int size() {
      return size(root);
   }

   private int size(BSTNode<T> node) {
      int result = 0;
      // base case means doing nothing (return 0)
      if (!node.isEmpty()) { // indusctive case
         result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
      }
      return result;
   }
}
