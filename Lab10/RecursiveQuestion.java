package lab10;

import java.util.Scanner;

public class RecursiveQuestion {
	
	// An algorithm to calculate the k_th Fibonacci number F_k using binary recursion
	public static int FibBinaryRecursive(int k) {
		if (k == 0)
			return 0;
		if (k == 1)
			return 1;
		return FibBinaryRecursive(k - 1) + FibBinaryRecursive(k - 2);
	}
	
	// An algorithm to solve the Hanoi Tower problem
	static void HanoiTower(int n, char pile1, char pile2, char pile3) { 
        if (n == 1) { 
            System.out.println("Move disk 1 from pile " +  pile1 + " to pile " + pile2); 
            return; 
        } 
        HanoiTower(n - 1, pile1, pile3, pile2); 
        System.out.println("Move disk " + n + " from pile " +  pile1 + " to pile " + pile2); 
        HanoiTower(n - 1, pile3, pile2, pile1); 
    } 
	
	// A method that prints all the call levels
	public static String showCallLevel(int L, int curl) {
		String s = "   ";
		if (curl <= L) {
			for (int i = 0; i < curl - 1; i++) {
				System.out.print(s);
			}
			System.out.println("This was written by call number " + curl + "x.");
			showCallLevel(L, curl + 1 );
			for (int i = curl; i > 1; i--) {
				System.out.print(s);
			}
			System.out.println("This was written by call number " + curl + "y.");
		}
		return s;
	}
	
	// A method that convert a decimal number to a binary number
	public static int BinaryConvert (int n) {
		if (n == 0)  
            return 0;     
        else
        	return (n % 2 + 10 * BinaryConvert(n / 2));
	}
	
	// A function that prints the binary number converted from the input
	public static void BinaryPrint (int n) {
		System.out.println(BinaryConvert(n));
	}
	
	// A method that produces the pattern requested
	public static void Pattern(int longest, int indent) {
		if (longest > 0) {
			Pattern(longest / 2, indent);
			for (int i = 0; i < indent; i++) {
				System.out.print(" ");
			}
			for (int i = 0; i < longest; i++) {
				System.out.print("*");
			}
			System.out.println();
			Pattern(longest / 2, indent + longest / 2);	
		}
	}
	
	public static void main(String[] args) {
		
		// Create a scanner object
		Scanner scnr = new Scanner(System.in);
		
		// Test the Fibonacci method
		int n;
		System.out.print("Please enter the n to calculate the n_th Fibonacci sum: ");
		n = scnr.nextInt();
		System.out.println("The " + n + "_th Fibonacci sum is: " + FibBinaryRecursive(n));
		
		// Test the showCallLevel method
		System.out.println("\nThis is the output for showCallLevel method: ");
		showCallLevel(4,1);
		
		// Test the Pattern method
		System.out.println("\nThis is the output for Pattern method: ");
		Pattern(8,0);
		
		// Test the towerOfHanoi method
		int m;
		System.out.print("\nThe Tower of Hanoi problem output\nPlease enter the number of disks: ");
		m = scnr.nextInt();
		System.out.println("\nThe solution: \n");
        HanoiTower(m, 'A', 'C', 'B');
	}
	
	
	
	
	
	
	
}
