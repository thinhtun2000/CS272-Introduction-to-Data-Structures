package lab8;

// Generic interface for stack

public interface StackInterface<E> {
	public void push (E e);
	public E pop();
	public E get();
	public int size();
	public boolean isEmpty();
}
