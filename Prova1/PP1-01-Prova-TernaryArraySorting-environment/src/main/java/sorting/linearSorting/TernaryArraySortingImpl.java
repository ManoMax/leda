package sorting.linearSorting;

public class TernaryArraySortingImpl<T extends Comparable<T>> implements TernaryArraySorting<T> {

   /**
    * TernaryArraySortingImpl
    * 
    * @author Gabriel Max
    */
   public void sort(T[] ternaryArray) {

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

   // Método Utilizado para visualização do Array.
   /**
   private String exibirArray(T[] ternaryArray) {
   	String saida = "";
   	for (int i = 0; i < ternaryArray.length; i++) {
   		saida += ternaryArray[i] + " ";
   	}
   	return saida + "\n";
   }
    **/

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
