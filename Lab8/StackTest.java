package lab8;

public class StackTest {
	
	public static void main (String[] args) {
		
		// Test the LinkStack<E>
		System.out.println("Testing the LinkStack<E>\n\n");
		
		// Create a new LinkStack object of type Integer
		LinkStack<Integer> stack = new LinkStack<Integer>();
		System.out.println("Test results for stack:");
		
		// Testing the push method my adding 5 number to it
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		// Test the size method
		System.out.println("The size of the Link Stack is: " + stack.size());
		
		// Test the get top method
		System.out.println("The element at the top of the stack is: " + stack.get());
		
		// Test the pop method
		stack.pop();
		System.out.println("The element at the top of the stack now is: " + stack.get());
		
		// Test the isEmpty method
		if (stack.isEmpty())
			System.out.println("The stack is empty.");
		else
			System.out.println("The stack is not empty.");
		
		// Create a new LinkStack object of type Integer
		LinkStack<Integer> stack1 = new LinkStack<Integer>();
		System.out.println("\nTest results for stack1:");
		
		// Test the isEmpty method
		if (stack1.isEmpty())
			System.out.println("The Stack is empty.");
		else
			System.out.println("The Stack is not empty.");
		
		// Testing the push method
		stack1.push(11);
		
		// Test the get top method
		System.out.println("The element at the top of the stack after adding is: " + stack1.get());
		
		// Test the isEmpty method
		if (stack1.isEmpty())
			System.out.println("The Stack is empty.");
		else
			System.out.println("The Stack is not empty.");
		
		// Test the pop method
		// Please use the 2 lines below to test the special case
		// stack1.pop();
		// System.out.println("The element at the top of the stack now is: " + stack1.get());
		
		// Test the ArraylistStack<E>
		System.out.println("\n\nTesting the ArraylistStack<E>\n\n");
		
		// Create a new LinkStack object of type Integer
		ArraylistStack<Integer> list = new ArraylistStack<Integer>();
		System.out.println("Test results for list:");
		
		// Testing the push method my adding 5 number to it
		list.push(15);
		list.push(25);
		list.push(35);
		list.push(45);
		list.push(55);
		
		// Test the size method
		System.out.println("The size of the Array list Stack is: " + list.size());
		
		// Test the get top method
		System.out.println("The element at the top of the Array list Stack is: " + list.get());
				
		// Test the pop method
		list.pop();
		System.out.println("The element at the top of the Array list Stack now is: " + list.get());
		
		// Test the isEmpty method
		if (list.isEmpty())
			System.out.println("The Array list Stack is empty.");
		else
			System.out.println("The Array list Stack is not empty.");
				
		// Create a new ArraylistStack object of type Integer
		LinkStack<Integer> list1 = new LinkStack<Integer>();
		System.out.println("\nTest results for list1:");
		
		// Test the isEmpty method
		if (list1.isEmpty())
			System.out.println("The Array list Stack is empty.");
		else
			System.out.println("The Array list Stack is not empty.");
		
		// Testing the push method
		list1.push(19);
		
		// Test the get top method
		System.out.println("The element at the top of the Array list Stack after adding is: " + list1.get());
		
		// Test the isEmpty method
		if (list1.isEmpty())
			System.out.println("The Array list Stack is empty.");
		else
			System.out.println("The Array list Stack is not empty.");
				
		// Test the pop method
		// Please use the 2 lines below to test the special case
		// list1.pop();
		// System.out.println("The element at the top of the Array list Stack now is: " + list1.get());
		
	}
	
}
