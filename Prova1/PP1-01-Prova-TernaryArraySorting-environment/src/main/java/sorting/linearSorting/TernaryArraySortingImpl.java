package sorting.linearSorting;

import util.Util;

/**
 * Código mais FEIO da minha vida!
 * Por favor, olhe o exemplo de meu amigo José Amandio
 * Esse cara é fod*, parabéns Amandinho!
 * 
 * @author USUARIO
 *
 * @param <T>
 */
public class TernaryArraySortingImpl<T extends Comparable<T>> implements TernaryArraySorting<T> {

   /**
    * TernaryArraySortingImpl
    * 
    * @author Gabriel Max
    */
   public void sort(T[] ternaryArray) {
	   
	   System.out.println(exibirArray(ternaryArray));
	   
	   T maior = ternaryArray[0];
	   T menor = ternaryArray[0];
	   
	   for (int i = 0; i < ternaryArray.length; i++) {
		   if (ternaryArray[i].compareTo(maior) > 0) maior = ternaryArray[i];
		   if (ternaryArray[i].compareTo(menor) < 0) menor = ternaryArray[i];
	   }
	   
	   int i = 0; int j = ternaryArray.length-1;
	   while (i <= j) {
		   if (!ternaryArray[i].equals(menor)) {
			   if (ternaryArray[j].equals(menor)) Util.swap(ternaryArray, i, j);
			   else j--;
		   } else i++;
	   }
	   
	   i = 0; j = ternaryArray.length-1;
	   while (i <= j) {
		   if (!ternaryArray[j].equals(maior)) {
			   if (ternaryArray[i].equals(maior)) Util.swap(ternaryArray, i, j);
			   else i++;
		   } else j--;
	   }
	   
	   System.out.println(exibirArray(ternaryArray));
	   
   }
   
   private String exibirArray(T[] ternaryArray) {
	   	String saida = "";
	   	for (int i = 0; i < ternaryArray.length; i++) saida += ternaryArray[i] + " ";
	   	return saida + "\n";
	   }
   
   public void sortAntigo(T[] ternaryArray) {

	      //System.out.println(exibirArray(ternaryArray));

	      T elementoA = ternaryArray[0];
	      T elementoB = defineElementoB(ternaryArray, elementoA);
	      T elementoC = defineElementoC(ternaryArray, elementoA, elementoB);

	      if (elementoA.compareTo(elementoB) > 0) {
	         T aux = elementoA;
	         elementoA = elementoB;
	         elementoB = aux;
	      }

	      if (elementoB.compareTo(elementoC) > 0) {
	         T aux = elementoB;
	         elementoB = elementoC;
	         elementoC = aux;
	      }

	      if (elementoA.compareTo(elementoB) > 0) {
	         T aux = elementoA;
	         elementoA = elementoB;
	         elementoB = aux;
	      }

	      int cont1 = 0;
	      int cont2 = 0;
	      int cont3 = 0;
	      int cont4 = 0;

	      for (int i = 0; i < ternaryArray.length; i++) {
	         if (ternaryArray[i].equals(elementoA))
	            cont1++;
	         else if (ternaryArray[i].equals(elementoB))
	            cont2++;
	         else if (ternaryArray[i].equals(elementoC))
	            cont3++;
	      }

	      while (cont1 > 0) {
	         ternaryArray[cont4] = elementoA;
	         cont4++;
	         cont1--;
	      }
	      while (cont2 > 0) {
	         ternaryArray[cont4] = elementoB;
	         cont4++;
	         cont2--;
	      }
	      while (cont3 > 0) {
	         ternaryArray[cont4] = elementoC;
	         cont4++;
	         cont3--;
	      }

	      //System.out.println(exibirArray(ternaryArray));

	   }

   private T defineElementoB(T[] ternaryArray, T elementoA) {

      for (int i = 1; i < ternaryArray.length; i++) {
         if (!(ternaryArray[i].compareTo(elementoA) == 0)) {
            return ternaryArray[i];
         }
      }
      return null;
   }

   private T defineElementoC(T[] ternaryArray, T elementoA, T elementoB) {

      for (int j = 2; j < ternaryArray.length; j++) {
         if (!(ternaryArray[j].compareTo(elementoA) == 0) && !(ternaryArray[j].compareTo(elementoB) == 0)) {
            return ternaryArray[j];
         }
      }
      return null;
   }
}
