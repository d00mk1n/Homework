package homeworkFall2015;

import java.util.Iterator;

public class UseArrayStack {

	public static void main(String[] args) {

		ArrayStack stack = new ArrayStack(100);

		stack.push("one");
		stack.push("two");
		stack.push("three");

		Iterator<String> it0 = stack.iterator();

		System.out.println("--Starting iterating--");

		while (it0.hasNext()) {
			String string = it0.next();
			System.out.println(string);
		}
		System.out.println("--Stopped iterating. Dno--");

		System.out.println(stack.pop());
		System.out.println("Current size = " + stack.size());

		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println("Current size = " + stack.size());

		if (stack.isEmpty()) {
			System.out.println("EMPTY!");
		} else {
			System.out.println("NOT EMPTY");
		}

		System.out.println(stack.pop());
		System.out.println(stack.pop());

		if (stack.isEmpty()) {
			System.out.println("EMPTY!");
		} else {
			System.out.println("NOT EMPTY");
		}
		System.out.println(stack.size());
	}
}
