package sorting.linearSorting;

public class testMain {

	public static void main(String[] args) {
		
		TernaryArraySortingImpl a = new TernaryArraySortingImpl();
	
		
		Integer[] array = new Integer[] {1,0,2,0,0,0,2,0,1};
		
		a.sort(array);
		
		Integer[] array2 = new Integer[] {5,5,4,20,20,5,4,4,4};
		
		a.sort(array2);
		
		Integer[] array3 = new Integer[] {1, 2, 3};
		
		a.sort(array3);
		
		Integer[] array4 = new Integer[] {3, 2, 1};
		
		a.sort(array4);
		
		Integer[] array5 = new Integer[] {1, 1, 1, 1, 2, 3, 3, 3, 3};
		
		a.sort(array5);
		
		Integer[] array6 = new Integer[] {2, 1, 1, 1, 1, 3, 3, 3, 3};
		
		a.sort(array6);
	}
	
}
