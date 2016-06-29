package dataStructures.linkedList;

public class Queue<E> {
	Node<E> front;
	Node<E> back;

	public Queue(E data) {
		front = new Node<E>(data);
		back = front;
	}

	/*
	 * Add new node after back. If queue is empty set front = back to new node.
	 */
	public void enqueue(E data) {
		if (front == null) {
			front = new Node<E>(data);
			back = front;
		} else {
			Node<E> tmp = new Node<E>(data);
			back.next = tmp;
			back = tmp;
		}
	}

	public E dequeue() {
		if (front == null) {
			return null;
		} else {
			E data = front.data;
			front = front.next;
			if (front == null)
				back = null;
			return data;
		}
	}
	
	public static void test() {
		System.out.println("Queue test: ");
		Queue<Integer> A = new Queue<Integer>(5);	
		A.enqueue(6);
		A.enqueue(7);
		A.enqueue(8);
		
		Integer a = A.dequeue();
		while (a != null) {
			System.out.println(a);
			a = A.dequeue();
		}
	}

}