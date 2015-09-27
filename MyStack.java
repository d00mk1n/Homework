package homeworkFall2015;

public class MyStack<T> extends MyList<T> {
	
	Node<T> top;
	
	@Override
	public void add(T data) {
		super.add(data);
		top = super.first;
	}
	public T pop() {
		if (top == null) {
			return null;
		} else {
			T data = top.data;
			top = top.next;
			return data;
		}	
	}	
	public static void main(String[] args) {
		
		MyStack<String> stack = new MyStack<>();
		
		stack.add("One");
		System.out.println(stack.pop());
		stack.add("Two");
		stack.add("Three");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}