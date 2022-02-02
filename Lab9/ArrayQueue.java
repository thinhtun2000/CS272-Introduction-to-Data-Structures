package lab9;

import java.io.InvalidObjectException;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueInterface<E> {
	
	// 4 instance variables
	int front, rear;
	E[] data;
	int size;
	
	// Constructor
	public ArrayQueue() {
		data = (E[]) new Object[5];
		front = rear = size = 0;
	}
	
	// A method that adds another element to the queue
	public void enqueue(E e) {
		E[] bigdata = (E[]) new Object[data.length*2];
		if (size == data.length) {
			int i;
			for (i = front; i < data.length; i++)
				bigdata[i-front] = data[i];
			int startingIdx = data.length - front;
			for (i=0; i < rear; i++)
				bigdata[startingIdx++] = data[i];
			front = 0;
			rear = data.length;
			data = bigdata;		
		}
		data[rear] = e;
		rear = (++rear) % data.length;
		size++;
	}

	// A method to remove an element
	public E dequeue() {
		if (size > 0) {
			E ans = data[front];
			front = (++front) % data.length;
			size--;
			if (size == 0)
				front = rear = 0;
			return ans;
		}
		else
			throw new NoSuchElementException("Queue underflow");
	}

	// A method that return the front element of the queue
	public E front() {
		if (size > 0) {
			return data[front];
		}
		else
			throw new NoSuchElementException("Queue underflow");
	}

	// A method that return the number of elements in the queue
	public int size() {
		return size;
	}

	// A method that check if the queue is empty or not
	public boolean isEmpty() {
		return (size == 0);
	}
	
}
