package lab9;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements QueueInterface<E> {
	
	// Three instance variables
	private SNode<E> front;
	private SNode<E> rear;
	private int size;
	
	// Constructor
	public LinkedQueue() {
		front = rear = null;
		size = 0;
	}
	
	// A method that adds an element to the queue
	public void enqueue(E e) {
		SNode oldlast = rear;
        rear = new SNode<E>(e);
        rear.data = e;
        rear.link = null;
        if (isEmpty())
        	front = rear;
        else
        	oldlast.link = rear;
        size++;
	}

	// A method that removes an element from the front
	public E dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        E item = front.data;
        front = front.link;
        size--;
        if (isEmpty()) rear = null;
        return item;
	}

	// A method that returns a reference to the front element in the queue
	public E front() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return front.data;
	}

	// A method that returns the number of elements in the queue
	public int size() {
		return size;
	}

	// A method that checks if the queue is empty or not
	public boolean isEmpty() {
		return (size == 0);
	}
	
}
