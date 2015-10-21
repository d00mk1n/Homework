package homeworkFall2015;

import java.util.Iterator;

public class MyBoundedList<T> implements Iterable<T> {

	private int boundary;
	int size = 0;

	MyBoundedList(int bound) {
		this.boundary = bound;
	}

	private class Node {
		T data;
		Node next;
	}

	Node first;
	Node current;

	public void add(T data) throws ListFullException {
		if (size < boundary) {
			size++;
			Node node = new Node();
			node.data = data;
			node.next = first;
			first = node;
		} else {
			throw new ListFullException();
		}
	}

	public void remove() throws ListEmptyException {
		if (size > 1) {
			size--;
			first = first.next;
		}
		if (size == 1) {
			first = null;
		} else {
			throw new ListEmptyException();
		}
	}

	@Override
	public String toString() {

		String s = "[";

		Node temp = first;

		while (temp != null) {
			s += temp.data;
			s += ", ";
			temp = temp.next;
		}

		return s + "]";
	}

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {
			Node current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				T data = current.data;
				current = current.next;
				return data;
			}

			@Override
			public void remove() {
			}

		};

	}

	public static void main(String[] args) {
		MyBoundedList<String> mlb = new MyBoundedList<>(4);
		System.out.println("new list created");

		try {
			mlb.add("one");
			System.out.println(mlb);
			mlb.add("two");
			System.out.println(mlb);
			mlb.add("three");
			System.out.println(mlb);
			mlb.add("four");
			System.out.println(mlb);
			mlb.add("five");
			System.out.println(mlb);
			mlb.add("five");
			System.out.println(mlb);

		} catch (ListFullException e) {
			System.out.println(e.message);
		}
		try {

			mlb.remove();
			mlb.remove();
			mlb.remove();
			mlb.remove();
			mlb.remove();

		} catch (ListEmptyException e) {
			System.out.println(e.message);
		}
	}

}