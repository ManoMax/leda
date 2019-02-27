package adt.avltree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import adt.bst.BSTNode;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements AVLCountAndFill<T> {

   private int LLcounter;
   private int LRcounter;
   private int RRcounter;
   private int RLcounter;

   public AVLCountAndFillImpl() {

   }

   @Override
   public int LLcount() {
      return LLcounter;
   }

   @Override
   public int LRcount() {
      return LRcounter;
   }

   @Override
   public int RRcount() {
      return RRcounter;
   }

   @Override
   public int RLcount() {
      return RLcounter;
   }

   @Override
   protected void rebalance(BSTNode<T> node) {
      if (!node.isEmpty()) {
         if (calculateBalance(node) > 1) {

            if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
               rightRotation(node);
               LLcounter++;

            } else {
               leftRotation((BSTNode<T>) node.getLeft());
               rightRotation(node);
               LRcounter++;

            }

         }
         if (calculateBalance(node) < -1) {

            if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
               leftRotation(node);
               RRcounter++;

            } else {
               rightRotation((BSTNode<T>) node.getRight());
               leftRotation(node);
               RLcounter++;
            }

         }
      }
   }

   @Override
   public void fillWithoutRebalance(T[] array) {
      if (array != null && array.length != 0) {
         fill(array);
      }
   }

   @SuppressWarnings("unchecked")
   private void fill(T[] array) {
      T[] aux1 = concatenate(array, order());
      Arrays.sort(aux1);
      clean();
      Queue<int[]> queue = new LinkedList<int[]>();
      queue.add(new int[] { 0, aux1.length - 1 });

      while (!queue.isEmpty()) {
         int interval[] = queue.poll();
         int middle = (interval[0] + interval[1]) / 2;

         if (interval[0] <= interval[1]) {
            insert(aux1[middle]);

            queue.add(new int[] { interval[0], middle - 1 });
            queue.add(new int[] { middle + 1, interval[1] });

         }
      }
   }

   private void clean() {
      this.root = new BSTNode<T>();
      this.LLcounter = 0;
      this.RRcounter = 0;
      this.LRcounter = 0;
      this.RLcounter = 0;
   }

   @SuppressWarnings("unchecked")
   private T[] concatenate(T[] array, T[] order) {
      T[] aux1 = (T[]) new Comparable[array.length + order().length];

      int i = 0;

      for (T element : array) {
         aux1[i] = element;
         i++;
      }

      for (T element : order()) {
         aux1[i] = element;
         i++;
      }
      return aux1;
   }

}