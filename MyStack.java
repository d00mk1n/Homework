package homeworkFall2015;

// Учимся использовать наследование и не писать лишний код,
// поэтому я наследую от MyList и использую его класс Node 
// (пришлось изменить видимость) и метод add.
// Стоит так делать или лучше было написать свой Node?

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