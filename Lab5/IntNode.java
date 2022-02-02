package lab5;

public class IntNode {
	
	// two instance variables
	private int data;
	private IntNode link;
	
	// The no-argument constructor which sets the node value to be 0 and the link to be null reference
	public IntNode() {
		data = 0;
		link = null;
	}
	
	// A constructor with the given node value and the link
	public IntNode( int _data, IntNode _node ) {
		data = _data;
		link = _node;
	}
	
	// Get and set methods to get the node value and node link
	public	int	getData() {
		return data;
	}
	
	public IntNode getLink() {
		return link;
	}
	
	public void setData( int newData ) {
		data = newData;
	}
	
	public void setLink( IntNode newLink ) {
		link = newLink;
	}
	
	// toString method
	public String toString() {
		IntNode cursor = this.link;
		String sToPrint = "";
		sToPrint += String.valueOf(this.data);
		sToPrint += "->";
		while (cursor != null && cursor.data != 0) {
			sToPrint += String.valueOf(cursor.getData());
			sToPrint += "->";
			cursor = cursor.link;
		}
		return sToPrint.substring(0, sToPrint.length() - 2);
	}
	
	// A method to add a node after the current node
	public void addNodeAfterThis( int newdata ) {
		link = new IntNode (newdata, link);
	}
	
	// A method to remove the node after the current node
	public void removeNodeAfterThis() {
		this.link = link.getLink();
	}
	
	// A method to get the number of nodes in the list starting from a given node head
	public static int listLength( IntNode head ) {
		int count = 0;
		IntNode cursor = head;
		while ( cursor != null ) {
			count++;
			cursor = cursor.link;
		}
		return count;
	}
	
	// A method to search whether a linked list starting with head contains a given value data
	/* @precondition
	 * head is not null
	 */
	public static boolean search( IntNode head, int data ) {
		IntNode cursor = head;
		while ( cursor != null ) {
			if( cursor.getData() == data )
				return true;
			cursor = cursor.getLink();
		}
		return false;
	}
	
	// METHOD ADD FOR LAB 5
	
	// A constructor with just 1 parameter
	public IntNode(int _data) {
		data = _data;
		link = null;
	}
	
	// A method to calculate the number of even elements in the linked list staring from the given head. When head is null,return 0.
	public static int listEvenNumber( IntNode head ) {
		int cnt = 0;
		IntNode cursor = head;
		if (head == null)
			return cnt;
		while (cursor != null) {
			if (cursor.getData() % 2 == 0)
				cnt++;
			cursor = cursor.getLink();
		}
		return cnt;
	}
	
	// A method to add the given new data to the end of the linked list that starts from the current node.
	public void addToEnd( int newdata ) {
		IntNode cursor = this.link;
		while (cursor.link != null) {
			cursor = cursor.getLink();
		}
		cursor.addNodeAfterThis(newdata);
	}
	
	// A method that counts the number of nodes from the given head
	public static int numNode( IntNode head ) {
		int cnt = 0;
		IntNode cursor = head;
		while (cursor != null) {
			cnt++;
			cursor = cursor.getLink();
		}
		return cnt;
	}
	
	/*
	 * @ Precondition
	 * num > 0
	 */
	// The following method to calculate the summation of elements in the last num nodes in a given linked list.
	public static int sumLast( IntNode head, int num ) {
		int sum = 0;
		IntNode cursor = head;
		if (num < 0)
			return 0;
		if (num >= numNode(head)) {
			while (cursor != null) {
				sum += cursor.getData();
				cursor = cursor.getLink();
			}
		}
		else {
			while (numNode(cursor) > num)
				cursor = cursor.getLink();
			while (cursor != null) {
				sum += cursor.getData();
				cursor = cursor.getLink();
			}
		}
		return sum;
	}
	
	// Copy part of a given linked list.
	public static IntNode copyOdd ( IntNode head ) {
		if (head == null)
			return null;
		else {
			IntNode cursor1 = head;
			while(cursor1.getData() % 2 == 0 ) {
				cursor1 = cursor1.getLink();
			}
			IntNode newhead = new IntNode(cursor1.getData());
			IntNode cursor2 = newhead;
			cursor1 = cursor1.getLink();
			while(cursor1 != null) {
				if (cursor1.getData() % 2 == 1) {
					cursor2.addNodeAfterThis(cursor1.getData());
					cursor2 = cursor2.getLink();
				}
				cursor1 = cursor1.getLink();
			}
		return newhead;
		}
	}
	
	// A  method  to  remove  ALL  the  nodes  that  have  the  data  value e from  the  linked  list starting from the given head.
	public static IntNode removeAll(IntNode head, int e) {
		if (head == null)
			return null;
		else {
			IntNode cursor1 = head;
			IntNode newhead = new IntNode(cursor1.getData());
			IntNode cursor2 = newhead;
			cursor1 = cursor1.getLink();
			while(cursor1 != null) {
				if (cursor1.getData() != e) {
					cursor2.addNodeAfterThis(cursor1.getData());
					cursor2 = cursor2.getLink();
				}
				cursor1 = cursor1.getLink();
			}
		return newhead;
		}
	}
	
	// A method to reverse a linked list
	public static IntNode reverse (IntNode head) {
		IntNode cursor = head;
		IntNode newhead = new IntNode(head.getData());
		while (cursor != null) {
			newhead.addNodeAfterThis(cursor.getData());
			cursor = cursor.getLink();
		}
		newhead = newhead.getLink();
		return newhead;
	}
	
	// A method to test whether a linked list starting from the given head is cyclic or acyclic
	public static boolean hasCycle(IntNode head) {
		IntNode fastCursor = head;
		IntNode slowCursor = head;
		if (head == null) 
			return false;
		for (int i = 0; ; i++) {
			fastCursor = fastCursor.getLink();
			if( i % 2 == 1 )
				slowCursor = slowCursor.getLink();
			if (fastCursor == null)
				return false;
			if (fastCursor == slowCursor)
				return true;
		}
	}
	
}

