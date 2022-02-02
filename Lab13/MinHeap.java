package lab11;

import java.util.ArrayList;

public class MinHeap {

	private ArrayList<Integer> array;
	
	public MinHeap() {
		array = new ArrayList<Integer>();
	}
	
	private static int parent(int pos) {
		return (pos - 1) / 2;
    }
	
	// Return the index of the left child of node i.
		private static int leftChild(int pos) {
			return 2 * pos + 1;
		}

	// Return the index of the right child of node i.
	private static int rightChild(int pos) {
		return 2 * pos + 2;
	}
	
	// Add a new element e into the heap
	public void add(int e) {
		 array.add(e);
	     int pos = array.size() - 1;
	     int parentPos = parent(pos);

	     while (pos > 0 && array.get(pos).compareTo(array.get(parentPos)) < 0) {
	         swap(array, pos, parentPos);
	         pos = parentPos;
	     }
	}
	
	// the swap method
	private static <E> void swap(ArrayList<E> a, int i, int j) {
		E t = a.get(i);
		a.set(i, a.get(j));
		a.set(j, t);
	}
	
	// Get and remove the top element of the heap
	public int remove() {
		if (array.size() <= 0)
			return 0;
		else {
			int top = array.get(0);
			array.set(0, array.get(array.size()-1));
			array.remove(array.size() - 1);
			reheapDownward(array, 0);
			return top;
		}
	}
	
	// reheapDownward method
	public void reheapDownward(ArrayList<Integer> array, int pos) {
		int left = leftChild(pos);    
		int right = rightChild(pos);  
		int smallest;
		
		if (left <= array.size() - 1 && array.get(left).compareTo(array.get(pos)) < 0)
			smallest = left;
		else
			smallest = pos;
		
		if (right <= array.size() - 1 && array.get(right).compareTo(array.get(smallest)) < 0)
			smallest = right;
		
		if (smallest != pos) {
			swap(array, pos, smallest);
			reheapDownward(array, smallest);
		}
		
	}
	
	// Get the top element of the heap
	public int top() {
		if (array.size() <= 0)
			return 0;
		else 
			return array.get(0);
	}
	
	// Main method to test the other methods
	public static void main (String[] args) {
		
		System.out.println("Create a heap!");
		MinHeap array = new MinHeap();
		
		System.out.println();
		// Check the top method when there is no element
		if (array.top() != 0) 
			System.out.println("The element at the top is: " + array.top());
		else
			System.out.println("There is no element in the heap.");
		
		// Check the add method
		array.add(40);
		array.add(20);
		array.add(10);
		array.add(50);
		array.add(30);
		
		// Test the top method
		System.out.println("\nThe top element after adding 5 elements is: " + array.top());
		
		// Test the remove method
		int k = array.remove();
		while (k != 0) {
			System.out.println("\nThe top element after removing the current top: " + array.top());
			k = array.remove();
			// Test the remove method when there is no element in the heap
			if (k == 0)
				System.out.println("\nThere is no element in the heap.");
		}
	}
}
