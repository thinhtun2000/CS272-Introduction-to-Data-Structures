package lab8;

import java.util.EmptyStackException;

public class LinkStack<E> implements StackInterface<E> {
	
	// 1 instance variable
	SNode<E> top;
	
	// no argument constructor
	public LinkStack () {
		top = null;
	}
	
	// push method to add a node into the stack
	public void push(E e) {
		top =  new SNode<E>(e, top);
	}
	
	// pop method to remove the node that comes in last
	public E pop() {
		E answer;
		if (top == null) throw new EmptyStackException();
		answer = top.getData();
		top = top.getLink();
		return answer;
	}
	
	// get method returns the node at the top of the stack
	public E get() {
		if (top == null) throw new IllegalStateException("The stack is empty");
		return top.getData();
	}
	
	// size method returns the number of node in the stack
	public int size() {
		if (top == null)
			return 0;
		int n = top.listLength(top);
		return n;
	}
	
	// check if the stack is empty oe not
	public boolean isEmpty() {
		if (top == null) return true;
		else
			return false;
	}
	
	// get method with 1 constructor to return the data at index i
	public E get(int i) {
		SNode<E> cursor = top;
		while (i > 0) {
			cursor = cursor.getLink();
			i--;
		}
		return cursor.data;
	}
	
}
