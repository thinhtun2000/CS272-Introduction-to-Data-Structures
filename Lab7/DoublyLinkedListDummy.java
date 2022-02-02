package lab7;

public class DoublyLinkedListDummy {
	
	// Q1
	// 2 instance variables for the class
	private DIntNode head;
	private DIntNode tail;
	
	// Q2
	// getter, setter methods for head, tail of this doubly linked list
	public DIntNode getHead() {
		return head;
	}
	 
	public DIntNode getTail() {
		return tail;
	}
	 
	public void setHead(DIntNode node) {
		head.setNext(node);
	}
	 
	public void setTail(DIntNode node) {
		tail.setPrev(node);
	}
	
	// Q3
	// The no-argument constructor which creates the dummy head and tail and link them together
	public	DoublyLinkedListDummy(){
		head = new DIntNode();
		tail = new DIntNode();
		head.setNext(tail);
		tail.setPrev(head);
	}
	
	// Q4
	// A method to add an element from the end of the list
	// Let n be the number of nodes in the linked list
	// Time complexity of this method is O(n)
	public void addEnd(int element) {
		DIntNode newNode = new DIntNode(element);
		newNode.setNext(null);
		if (head == null) {
			newNode.setPrev(null);
			head = newNode;
			return;
		}
		DIntNode cursor = head;
		while (cursor.getNext() != null) {
			cursor = cursor.getNext();
		}
		cursor.setNext(newNode);
		newNode.setPrev(cursor);
		tail.setPrev(newNode);
	}
	
	// Q5
	// A method to remove the first actual node
	// Time complexity of this method is O(1)
	public void removeFromHead() {
		head.getNext().getNext().setPrev(head);
		head.setNext(head.getNext().getNext());
	}
	
	// Q6
	//  A method to convert the list to a string
	public String toString() {
		if (head == null) 
			return "The List is empty.";
		DIntNode cursor1 = head.getNext();
		String forward  = "(Forward)  ";
		while (cursor1 != null) {
			forward = forward + "" + cursor1.getData();
			if (cursor1.getNext() != null)
				forward += "<->";
			cursor1 = cursor1.getNext();
		}
		DIntNode cursor2 = head.getNext();
		String backward  = "";
		while (cursor2 != null) {
			backward =  "" + cursor2.getData() + backward;
			if (cursor2.getNext() != null)
				backward = "<->" + backward;
			cursor2 = cursor2.getNext();
		}
		backward = "(Backward) " + backward;
		return forward + "\n" + backward;
	}
	
	// Q7
	// A  method  to  compute  the  number  of  times  that  the  given  value e occurs  in  nodes  in  this linked list.
	// Let n be the number of nodes in the linked list.
	// The time complexity Big-O is O(n)
	public int countOccurrence(int e) {
		int count = 0;
		DIntNode cursor = head;
		while (cursor != null) {
			if (cursor.getData() == e)
				count++;
			cursor = cursor.getNext();
		}
		return count;
	}
	
	// Q8
	// A method to remove all the nodes that contain element e from the list
	// Let n be the number of nodes in the linked list
	// The time complexity Big-O is O(n)
	public boolean removeAll(int e) {
		DIntNode cursor = head;
		while (cursor != null) {
			if (cursor.getData() == e) {
				DIntNode preCursor = cursor.getPrev();
				DIntNode postCursor = cursor.getNext();
				if (preCursor == null)
					this.removeFromHead();
				else if (postCursor == null)
					this.setTail(cursor);
				else {
					preCursor.setNext(postCursor);
					postCursor.setPrev(preCursor);
				}
			}
			cursor = cursor.getNext();
		}
		return false;
	}
	 
	// A method that counts the number of nodes in the linked list from the given node
	public int size() {
		int length = 0;
		if (head == null) 
			return length;
		DIntNode cursor = head;
		while (cursor != null) {
			length++;
			cursor = cursor.getNext();
		}
		return length;
	}
	
	// Q9 
	// A method to extract a sublist of this list
	// Let n be the variable count
	// The time complexity is O(n)
	public DoublyLinkedListDummy subList(int beginIdx, int endIdx) {
		if (beginIdx < 0 || beginIdx > this.size() || beginIdx > endIdx) {
			return null;
		}
		DIntNode cursor = this.head;
		int count = 0;
		while (count <= beginIdx) {
			cursor = cursor.getNext();
			count++;
		}
		DoublyLinkedListDummy list = new DoublyLinkedListDummy();
		while (count <= endIdx) {
			list.addEnd(cursor.getData());
			cursor = cursor.getNext();
			count++;
		}
		list.removeFromHead();
		return list;
	}
	
	// Q10
	// A method to print a summary of the list
	// Let n be the number of the nodes in the linked list
	// The time complexity is O(n)
	public void printStatistics() {
		DoublyLinkedListDummy list = this;
		DIntNode cursor = list.head.getNext();
		System.out.println("number occurence");
 		while (cursor != null) {
 			if (list.countOccurrence(cursor.getData()) == 1) {
 				System.out.printf("%d %10d\n", cursor.getData(), list.countOccurrence(cursor.getData()));
 			}
 			else if (list.countOccurrence(cursor.getData()) != 1) {
 				System.out.printf("%d %10d\n", cursor.getData(), list.countOccurrence(cursor.getData()));
 			}
 			cursor = cursor.getNext();
		}
	}
	 
	public static void main(String[] args) {
		
		DoublyLinkedListDummy list = new DoublyLinkedListDummy();
		
		System.out.println("Test the set methods");
		DIntNode node1 = new DIntNode(9);
		list.setHead(node1);
		list.setTail(node1);
		System.out.println("The linked list after using the set methods is: ");
		System.out.println(list.toString());
		System.out.println();
		
		System.out.println("Test the addEnd method");
		list.addEnd(1);
		list.addEnd(2);
		list.addEnd(3);
		list.addEnd(4);
		list.addEnd(5);
		list.addEnd(6);
		System.out.println("The linked list after the addEnd method is: ");
		System.out.println(list.toString());
		System.out.println();
		
		System.out.println("Test the remove from head method");
		list.removeFromHead();
		System.out.println("The linked list after testing the removeFromHead method is: ");
		System.out.println(list.toString());
		System.out.println();
		
		list.addEnd(7);
		System.out.println("Testing the occurence method: ");
		System.out.println(list.toString());
		System.out.print("The occurence of '1' is: ");
		System.out.println(list.countOccurrence(1));
		System.out.println();
		
		System.out.println("Testing the removeAll method");
		list.removeAll(2);
		System.out.println("The linked list after the removeAll method is: ");
		System.out.println(list.toString());
		System.out.println();
		
		System.out.println("Testing the subList method:");
		System.out.println(list.subList(2, 4).toString());
		System.out.println();
		
		System.out.println("Testing the printStatistics method: ");
		list.addEnd(1);
		System.out.println(list.toString());
		list.printStatistics();
		System.out.println();
	}
}
