package homeworkFall2015;

public class MyList<T> {

	private class Node<T> {
		T data;
		Node<T> next;
	}

	Node<T> first;
	Node<T> last;

	public void add(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = first;
		first = node;
	}

	public void addToTail(T data) {
		Node<T> node = new Node<T>();
		if (first == null) {
			node.data = data;
			node.next = null;
			first = node;
			last = node;
		} else {
			node.data = data;
			last.next = node;
			last = node;
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
	
	public static void main(String[] args) {
		
		MyList<String> list = new MyList<>();
		
		list.addToTail("One");
		list.addToTail("Two");
		list.addToTail("Three");
		
		System.out.println(list);
	}

}
