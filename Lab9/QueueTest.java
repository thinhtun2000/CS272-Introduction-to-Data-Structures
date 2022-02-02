package lab9;

public class QueueTest {

	public static void main (String[] args) {
		
		// Test the LinkedQueue methods
		System.out.println("This is the results for testing LinkedQueue methods.\n");
		
		// Create a new LinkedQueue object
		LinkedQueue<Integer> a = new LinkedQueue<Integer>();
		
		// Test the isEmpty method
		if (a.isEmpty())
			System.out.println("The queue is empty.\n");
		else
			System.out.println("The queue is not empty.\n");
		
		// Add 5 elements to the queue
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);
		a.enqueue(4);
		a.enqueue(5);
		
		// Test the size method
		System.out.println("There are " + a.size() + " elements in the queue.\n");
		
		// Test the front method
		System.out.println("The element that is at the front of the queue is: " + a.front());
		
		// Test the dequeue method
		a.dequeue();
		System.out.println("\nThere are " + a.size() + " elements in the queue.\n");
		
		// Test the front method
		System.out.println("The element that is at the front of the queue is: " + a.front());
		
		
		
		// Test the ArrayQueue methods
		System.out.println("\nThis is the results for testing ArrayQueue methods.\n");
				
		// Create a new ArrayQueue object
		ArrayQueue<Integer> b = new ArrayQueue<Integer>();
			
		// Test the isEmpty method
		if (b.isEmpty())
			System.out.println("The queue is empty.\n");
		else
			System.out.println("The queue is not empty.\n");
		
		// Add 5 elements to the queue
		b.enqueue(10);
		b.enqueue(20);
		b.enqueue(30);
		b.enqueue(40);
		b.enqueue(50);
		b.enqueue(60);
			
		// Test the size method
		System.out.println("There are " + b.size() + " elements in the queue.\n");
		
		// Test the front method
		System.out.println("The element that is at the front of the queue is: " + b.front());
		
		// Test the dequeue method
		b.dequeue();
		System.out.println("\nThere are " + b.size() + " elements in the queue.\n");
				
		// Test the front method
		System.out.println("The element that is at the front of the queue is: " + b.front());
	}
}
