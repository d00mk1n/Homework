package homeworkFall2015;

import java.util.Iterator;

public class ArrayStack<T> implements Iterable {

	ArrayStack(int length) {
		stack = (T[]) new String[length];
	}

	T[] stack;

	void push(T el) {
		for (int i = stack.length - 1; i >= 0; i--) {
			if (stack[i] != null) {
				stack[i + 1] = stack[i];
			}
		}
		stack[0] = el;
	}

	T pop() {
		T tos = stack[0];
		if (tos != null) {
			if (stack[1] != null) {
				for (int i = 1; i < stack.length; i++) {
					if (stack[i] != null) {
						stack[i - 1] = stack[i];
						stack[i] = null;
					}
				}
				return tos;
			} else {
				stack[0] = null;
			}
			return tos;
		} else {
			return null;
		}
	}

	T top() {
		return stack[0];
	}

	public int size() {
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] == null) {
				return i;
			}
		}
		return 0;
	}

	public boolean isEmpty() {
		for (T t : stack) {
			if (t != null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {
			T cur = stack[0];
			int curIndex = 0;

			@Override
			public boolean hasNext() {
				return cur != null;
			}

			@Override
			public T next() {
				T string = cur;
				cur = stack[++curIndex];
				return string;
			}

			@Override
			public void remove() {
			}
		};
	}
}
