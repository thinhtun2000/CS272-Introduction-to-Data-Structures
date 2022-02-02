package lab8;

import java.util.ArrayList;

public class ArraylistStack<E> implements StackInterface<E> {
	
	ArrayList<E> data;
	
	public ArraylistStack () {
		data = new ArrayList<E> ();
	}
	
	public void push(E e) {
		data.add(e);
	}

	public E pop() {
		if (data.size() == 0)
			throw new IllegalStateException("Stack is empty");
		return data.remove(data.size()-1);
	}

	public E get() {
		return data.get(data.size()-1);
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		if (data == null) return true;
		else
			return false;
	}

	public int get(int i) {
		int idx;
		int[] array = new int[16];
		for (idx = 0; idx < data.size(); idx++) {
			array[idx] = (int) data.get(idx);
		}
		return array[i];
	}
	
}
