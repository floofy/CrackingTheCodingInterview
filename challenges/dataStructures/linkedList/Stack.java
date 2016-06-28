package dataStructures.linkedList;

public class Stack <E> {
	protected Node<E> top;

	public Stack(E data) {
		top = new Node<E>(data);
	}
	
	public Stack() {
		top = null;
	}

	public void push(E data) {
		Node<E> tmp = new Node<E>(data);
		tmp.next = top;
		top = tmp;
		return;
	}

	public E pop() {
		if (top == null)
			return null;
		E data = top.data;
		top = top.next;
		return data;
	}

	public E peek() {
		if (top == null)
			return null;
		return top.data;
	}
	
	public boolean empty() {
		return top == null ? true : false;
	}
	
	public static void test() {
		System.out.println("Stack Test: ");
		Stack<Integer> B = new Stack<Integer>(10);
		B.push(11);
		B.push(12);
		B.push(13);
		
		Integer b = B.pop();
		while (b != null) {
			System.out.println(b);
			b = B.pop();
		}
	}
}

