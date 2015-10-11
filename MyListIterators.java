package homeworkFall2015;

import java.util.Iterator;

public class MyListIterators<T> implements Iterable<T> {
	
		class Node {
		T data;
		Node next;
	}

	
	Node first;
	Node current;
	
	public void add(T data) {
		Node node = new Node();
		node.data = data;
		node.next = first;
		first = node;
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
	public Iterator<T> iterator() { //  анонимный
		
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
			public void remove() {}
			
		};
		
	}
	
	public Iterator<T> localIterator() { //  локальный
		
		class LocalIterator<T> implements Iterator<T> { 
			Node current = first;
			
			@Override
			public boolean hasNext() {
				return current != null;
			}
			
			@Override
			public T next() {
				T data = (T) current.data;
				current = current.next;
				return data;
			}
			
			@Override
			public void remove() {}
			
		};
		
		return new LocalIterator<T>();
	}
	
	class InnerIterator<T> implements Iterator <T>{ // внутренний
		
		Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public T next() {
			T data = (T) current.data;
			current = current.next;
			return data;
		}
		
		@Override
		public void remove() {}
		
		
	}

}