package lab8;

// Generic class for the node in Singly linked lists

public class SNode<E> {
	
	// 2 instance variables
	E data;
	SNode<E> link;
	
	// constructor
	public SNode (E e) {
		data = e;
		link = null;
	}
	
	// 2 arguments constructor
	public SNode(E e, SNode<E> top) {
		data = e;
		link = top;
	}

	public E getData() {
		return data;
	}
	
	public SNode<E> getLink() {
		return link;
	}
	
	public void setData( E newData ) {
		data = newData;
	}
	
	public void setLink( SNode<E> newLink ) {
		link = newLink;
	}
	
	public int listLength( SNode<E> head ) {
		int count = 0;
		if (head == null) return count;
		SNode<E> cursor = head;
		while ( cursor != null ) {
			count++;
			cursor = cursor.link;
		}
		return count;
	}
}
