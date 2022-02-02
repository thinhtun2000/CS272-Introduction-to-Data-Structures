package lab5;

public class IntNodeAdvancedTest {
	
	public static void main (String [] args) {
		
		// create some nodes
		IntNode n1 = new IntNode(1);
		n1.addNodeAfterThis(2);
		n1.addNodeAfterThis(3);
		n1.addNodeAfterThis(4);
		n1.addNodeAfterThis(5);
		// Print out the Linked List
		System.out.print("The Linked List: ");
		System.out.println(n1.toString());
		System.out.println();
		
		// Test the add to End method
		n1.addToEnd(6);
		n1.addToEnd(7);
		n1.addToEnd(8);
		n1.addToEnd(9);
		// Print out the Linked List
		System.out.println("The Linked List after adding some more nodes: ");
		System.out.println(n1.toString());
		System.out.println();
		
		// Test the sumLast method
		System.out.println("The sum of all the element of the Linked List: " + IntNode.sumLast(n1, 10));
		System.out.println("The sum of the 3 last elements of the Linked List: " + IntNode.sumLast(n1, 3));
		System.out.println();
		
		// Test the copyOdd method
		System.out.println("The new Linked List with all odd elements: ");
		System.out.println(IntNode.copyOdd(n1).toString());
		System.out.println();
		
		// Test the remove method
		System.out.println("The Linked List after removing all node 3: ");
		System.out.println(IntNode.removeAll(n1, 3).toString());
		System.out.println();
		System.out.println("The Linked List after removing all node 6: ");
		System.out.println(IntNode.removeAll(n1, 6).toString());
		System.out.println();
		
		// Test the reverse method
		System.out.println("The Linked List in reverse order: ");
		System.out.println(IntNode.reverse(n1).toString());
		System.out.println();
		
		// Create a cyclic Linked List
		IntNode n2 = new IntNode(2);
		IntNode n3 = new IntNode(3, n2);
		IntNode n4 = new IntNode(4, n3);
		IntNode n5 = new IntNode(5, n4);
		n2.setLink(n5);
		
		// Test if the Linked List is cyclic or acyclic
		if (IntNode.hasCycle(n1))
			System.out.println("The Linked List is cyclic.");
		else
			System.out.println("The Linked List is acyclic.");
		
		if (IntNode.hasCycle(n5))
			System.out.println("The Linked List is cyclic.");
		else
			System.out.println("The Linked List is acyclic.");
	}
}
