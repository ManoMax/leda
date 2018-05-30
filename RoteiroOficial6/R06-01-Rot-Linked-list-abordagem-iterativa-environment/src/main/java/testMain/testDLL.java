package testMain;

import java.util.Arrays;

import adt.linkedList.DoubleLinkedListImpl;

public class testDLL {

	public static void main(String[] args) {
        DoubleLinkedListImpl<Integer> k = new DoubleLinkedListImpl<>();
        System.out.println("metodos sll");
        System.out.print(k.isEmpty() ? "." : "F");
        System.out.print(k.size() == 0 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        k.insert(6);
        System.out.print(k.size() == 1 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(6) == 6 ? "." : "F");
        k.insert(25);
        System.out.print(k.size() == 2 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(25) == 25 ? "." : "F");
        k.insert(3);
        k.insert(7);
        k.insert(3);
        System.out.print(k.size() == 5 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(3) == 3 ? "." : "F");
        k.remove(3);
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(3) == 3 ? "." : "F");
        // Integer[] array = k.toArray();
        System.out.print(Arrays.toString(k.toArray()).equals("[6, 25, 7, 3]") ? "." : "F");
        k.insert(null);
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(3) == 3 ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[6, 25, 7, 3]") ? "." : "F");
        k.remove(null);
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[6, 25, 7, 3]") ? "." : "F");
        System.out.print(k.search(null) == null ? "." : "F");
        System.out.println("\nmetodos dll");
        k.insertFirst(9);
        k.insertFirst(17);
        System.out.print(k.size() == 6 ? "." : "F");
        System.out.print(k.search(9) == 9 ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[17, 9, 6, 25, 7, 3]") ? "." : "F");
        //System.out.print(k.search(null) == null ? "." : "F");
        k.removeFirst();
        System.out.print(k.size() == 5 ? "." : "F");
        System.out.print(k.search(17) == null ? "." : "F");
        System.out.print(Arrays.toString(k.toArray()).equals("[9, 6, 25, 7, 3]") ? "." : "F");
        k.removeLast();
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(3) == null ? "." : "F"); //F
        System.out.print(Arrays.toString(k.toArray()).equals("[9, 6, 25, 7]") ? "." : "F"); //.
        k.removeFirst();
        System.out.print(Arrays.toString(k.toArray()).equals("[6, 25, 7]") ? "." : "F"); //.
        k.removeLast();
        System.out.print(Arrays.toString(k.toArray()).equals("[6, 25]") ? "." : "F"); //F
        k.removeFirst();
        System.out.print(Arrays.toString(k.toArray()).equals("[25]") ? "." : "F"); //F
        k.removeLast();
        System.out.print(k.size() == 0 ? "." : "F"); //F
        System.out.print(k.search(25) == null ? "." : "F"); // F
        System.out.print(Arrays.toString(k.toArray()).equals("[]") ? "." : "F"); //F
       
    }
}
