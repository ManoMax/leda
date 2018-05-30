package adt.linkedList;

import java.util.Arrays;

public class MainSLL {

	public static void main(String[] args) {
        SingleLinkedListImpl<Integer> k = new SingleLinkedListImpl<>();
        System.out.print(k.isEmpty() ? "." : "F");
        System.out.print(k.size() == 0  ? "." : "F");
        System.out.print(k.search(5) == null  ? "." : "F");
        k.insert(6);
        System.out.print(k.size() == 1  ? "." : "F");
        System.out.print(k.search(5) == null  ? "." : "F");
        System.out.print(k.search(6) == 6  ? "." : "F");
        k.insert(25);
        System.out.print(k.size() == 2  ? "." : "F");
        System.out.print(k.search(5) == null  ? "." : "F");
        System.out.print(k.search(25) == 25  ? "." : "F");
        k.insert(3);
        k.insert(7);
        k.insert(3);
        System.out.print(k.size() == 5  ? "." : "F");
        System.out.print(k.search(5) == null  ? "." : "F");
        System.out.print(k.search(3) == 3  ? "." : "F");
        k.remove(3);
        System.out.print(k.size() == 4 ? "." : "F");
        System.out.print(k.search(5) == null ? "." : "F");
        System.out.print(k.search(3) == 3 ? "." : "F");
        //Integer[] array = k.toArray();
        System.out.println(Arrays.toString(k.toArray()).equals("[6, 25, 7, 3]") ? "." : "F");
        System.out.println("");
    }

}
