package adt.bst;

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

   private int height(BSTNode<T> aux) {
      int result = -1;

      if (!aux.isEmpty()) {
         result = 1 + Math.max(height((BSTNode<T>) aux.getLeft()), height((BSTNode<T>) aux.getRight()));
      }
      return result;
   }

   @Override
   public BSTNode<T> search(T element) {
      BSTNode<T> aux = root;
      return search(element, aux);
   }

   private BSTNode<T> search(T element, BSTNode<T> aux) {
      BSTNode<T> result = new BSTNode<>();
      if (element != null && !aux.isEmpty()) {
         if (aux.getData().equals(element)) {
            result = aux;
         } else if (aux.getData().compareTo(element) < 0) {
            result = search(element, (BSTNode<T>) aux.getRight());
         } else {
            result = search(element, (BSTNode<T>) aux.getLeft());
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

   private void insert(T element, BSTNode<T> aux) {
      if (element != null) {
         // Nó disponível
         if (aux.isEmpty()) {
            aux.setData(element);
            aux.setLeft(new BSTNode<T>());
            aux.setRight(new BSTNode<T>());

            if (aux.getParent() == null) {
               aux.setParent(new BSTNode<>());
            }

            aux.getLeft().setParent(aux);
            aux.getRight().setParent(aux);
            //System.out.println(element + " alocado\n");

            // Nó ocupado
         } else {
            // Elemento é menor que Atual nó
            if (aux.getData().compareTo(element) > 0) {
               //System.out.println(element + " esquerda");
               insert(element, (BSTNode<T>) aux.getLeft());
               // Elemento é maior que Atual nó
            } else if (aux.getData().compareTo(element) < 0) {
               //System.out.println(element + " direita");
               insert(element, (BSTNode<T>) aux.getRight());
            }
         }
      }
   }

   @Override
   public BSTNode<T> maximum() {
      return maximum(root);
   }

   private BSTNode<T> maximum(BSTNode<T> aux) {
      BSTNode<T> result = null;
      if (!aux.isEmpty()) {
         if (aux.getRight().isEmpty()) {
            result = (BSTNode<T>) aux;
         } else {
            result = maximum((BSTNode<T>) aux.getRight());
         }
      }
      return result;
   }

   @Override
   public BSTNode<T> minimum() {
      return minimum(root);
   }

   private BSTNode<T> minimum(BSTNode<T> aux) {
      BSTNode<T> result = null;
      if (!aux.isEmpty()) {
         if (aux.getLeft().isEmpty()) {
            result = (BSTNode<T>) aux;
         } else {
            result = minimum((BSTNode<T>) aux.getLeft());
         }
      }
      return result;
   }

   @Override
   public BSTNode<T> sucessor(T element) {
      BSTNode<T> aux = search(element);

      if (aux.isEmpty())
         return null;

      if (!aux.getRight().isEmpty()) {
         return minimum((BSTNode<T>) aux.getRight());
      } else {
         BSTNode<T> parent = (BSTNode<T>) aux.getParent();

         while (!parent.isEmpty() && aux.equals(parent.getRight())) {
            aux = parent;
            parent = (BSTNode<T>) aux.getParent();
         }
         if (parent.isEmpty())
            return null;
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
         BSTNode<T> aux = search(element);
         if (aux.isEmpty())
            return;
         remove(aux);
      }
   }

   private void remove(BSTNode<T> aux) {
      // Nem direita nem Esquerda tem Elemento
      if (aux.isEmpty())
         return;

      // Existe Duas filhas
      if (!aux.getLeft().isEmpty() && !aux.getRight().isEmpty()) {
         BSTNode<T> sucessor = sucessor(aux.getData());
         aux.setData(sucessor.getData());
         remove(sucessor);
         // Uma filha ou Nem uma filha
      } else {
         BSTNode<T> sucessor = (BSTNode<T>) aux.getLeft();

         if (sucessor.isEmpty())
            sucessor = (BSTNode<T>) aux.getRight();

         aux.setData(sucessor.getData());
         aux.setRight(sucessor.getRight());
         aux.setLeft(sucessor.getLeft());

         if (!aux.isEmpty() && aux.getRight() != null)
            aux.getRight().setParent(aux);
         if (!aux.isEmpty() && aux.getLeft() != null)
            aux.getLeft().setParent(aux);
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

   @SuppressWarnings({ "rawtypes", "unchecked" })
   private int preOrder(T[] array, BSTNode<T> node, int index) {
      array[index++] = node.getData();

      if (!node.getLeft().isEmpty())
         index = preOrder(array, (BSTNode) node.getLeft(), index);

      if (!node.getRight().isEmpty())
         index = preOrder(array, (BSTNode) node.getRight(), index);

      return index;
   }

   @SuppressWarnings("unchecked")
   @Override
   public T[] order() {
      T[] array = (T[]) new Comparable[this.size()];
      if (this.isEmpty())
         return array;
      order(array, root, 0);
      return array;
   }

   @SuppressWarnings({ "rawtypes", "unchecked" })
   private int order(T[] array, BSTNode<T> node, int index) {
      if (!node.getLeft().isEmpty()) {
         index = order(array, (BSTNode) node.getLeft(), index);
      }

      array[index++] = node.getData();
      if (!node.getRight().isEmpty()) {
         index = order(array, (BSTNode) node.getRight(), index);
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

   @SuppressWarnings({ "rawtypes", "unchecked" })
   private int postOrder(T[] array, BSTNode<T> node, int index) {
      if (!node.getLeft().isEmpty())
         index = postOrder(array, (BSTNode) node.getLeft(), index);

      if (!node.getRight().isEmpty())
         index = postOrder(array, (BSTNode) node.getRight(), index);

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
