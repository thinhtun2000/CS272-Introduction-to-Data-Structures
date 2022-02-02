package lab10;

public class Permutation {

	// A recursive method that prints the permutations of the integers in this array
	public static void printRecursive(int n, int[] array) {
		if(n == 1)
			printArray(array);
		else {
			for(int i = 0; i < n-1; i++) {
				printRecursive(n - 1, array);
				if(n % 2 == 0)
					swap(array, i, n-1);
				else
					swap(array, 0, n-1);
			}
			printRecursive(n - 1, array);
		}
	}
	
	// A method that swaps the elements of the array
	private static void swap(int[] array, int a, int b) {
	    int tmp = array[a];
	    array[a] = array[b];
	    array[b] = tmp;
	}
	
	// A method that prints out the permutations of the array
	private static void printArray(int[] array) {
	    for(int i = 0; i < array.length; i++) {
	        System.out.print(array[i]);
	    }
	    System.out.print(" ");
	}
	
	public static void main(String[] args) {
		
		// Create 4 int arrays
		int[] array1 = { 1 };
		int[] array2 = {1, 2};
		int[] array3 = {1, 2, 3, 4, 5};
		int[] array4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		
		// Test the method
		System.out.println("Permutations: \n");
		printRecursive( 1, array1 );
		System.out.println("\n");
		printRecursive( 2, array2 );
		System.out.println("\n");
		printRecursive( 5, array3 );
		System.out.println("\n");
		printRecursive( 5, array4 );
		
	}

}
