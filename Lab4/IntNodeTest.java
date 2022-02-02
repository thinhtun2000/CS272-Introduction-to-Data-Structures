package lab4;

public class IntNodeTest {

	public static void main(String[] args) {
		// Test 2 constructors
		IntNode n1 = new IntNode();
		IntNode n2 = new IntNode(5, n1);
		
		// Test the set method
		n1.setData(2);
		// Test the get method
		System.out.println("The node n1 value is: " + n1.getData());
		System.out.println("The node n2 value is: " + n2.getData());
		
		// Test the toString method
		System.out.print("The Linked List is: ");
		System.out.println(n2.toString());

		// Test addNodeAfterThis method
		n1.addNodeAfterThis(6);
		n2.addNodeAfterThis(10);
		
		System.out.print("The Linked List after adding 2 nodes is: ");
		System.out.println(n2.toString());
		
		// Test the listLength method
		System.out.print("There are(is) ");
		System.out.print(IntNode.listLength(n2));
		System.out.println(" nodes in the Linked List.");
		
		// Test the search method
		int n = 3;
		if (IntNode.search(n2, n))
			System.out.println(n + " is in the Linked List.");
		else
			System.out.println(n + " is not in the Linked List.");
		
		n = 2;
		if (IntNode.search(n2, n))
			System.out.println(n + " is in the Linked List.");
		else
			System.out.println(n + " is not in the Linked List.");
		
		// Test the remove method
		n2.removeNodeAfterThis();
		System.out.print("The Linked List after removing a node: ");
		System.out.println(n2.toString());
		
		System.out.print("The Linked List after removing a node: ");
		n1.removeNodeAfterThis();
		System.out.println(n2.toString());
	}
}
