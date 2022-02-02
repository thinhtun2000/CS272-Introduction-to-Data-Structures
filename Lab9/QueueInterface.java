package lab9;

public interface QueueInterface<E> {
	public void enqueue(E e);
	public E dequeue();
	public E front();
	public int size();
	public boolean isEmpty();
}
