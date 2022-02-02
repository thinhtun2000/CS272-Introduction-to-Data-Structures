package lab11;

public class search {
	
	public static int binarySearch (int[] A, int e) {
		int index = binarySearch(A, e, 0, A.length - 1);
        return index;	
	}
	
	private static int binarySearch(int[] array, int search, int start, int end) {
        // base case
        if (start > end)
            return -1;
 
        int mid = (start + end) / 2;
        
        // recursive step
        if (array[mid] == search)
        	return mid;
        else if (array[mid] < search) 
            return binarySearch(array, search, mid + 1, end);
        else
            return binarySearch(array, search, start, mid - 1);
    }
	
	public static void main (String[] args) {
		int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int e = 5;
		int k = 15;
		
		System.out.print("The array is: ");
		
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		
		System.out.println();
		
		if (binarySearch(A, e) != -1) 
			System.out.println("\nThe " + e + " element is found at index " + binarySearch(A, e) + ".");
		else
			System.out.println("\nThe " + e + " element is not found.");
		
		if (binarySearch(A, k) != -1) 
			System.out.println("\nThe " + k + " element is found at index " + binarySearch(A, k) + ".");
		else
			System.out.println("\nThe " + k + " element is not found.");
	}
	
}
