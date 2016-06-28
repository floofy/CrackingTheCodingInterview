package dataStructures.linkedList;

import java.util.ArrayList;

public class Node<E> {
	public Node<E> next = null;
	public E data = null;
	public int size = 0;

	public Node(E d) {
		data = d;
	}

	public Node() {
	}

	public Node(E[] array) {
		Node<E> n = this;
		n.data = array[0];
		for (int i=1; i<array.length; ++i) {
			n.next = new Node<E>(array[i]);
			n = n.next;
		}
	}

	public void appendToTail(E d) {
		if (this.data == null) {
			this.data = d;
			return;
		}

		Node<E> end = new Node<E>(d);
		Node<E> nextNode = this;

		while (nextNode.next != null) {
			nextNode = nextNode.next;
		}
		nextNode.next = end;
	}

	public String toString() {
		String string = "";
		ArrayList<E> elements = new ArrayList<E>();
		Node<E> n = this;
		while (n != null) {
			elements.add(n.data);
			n = n.next;
		}
		for (int i=0; i<elements.size(); ++i) {
			string += elements.get(i);
			if (i != elements.size()-1)
				string += ' ';
		}
		return string;
	}

	public void test() {
		System.out.println("---[Testing Node (LinkedList)]---");
		Node<Integer> a = new Node<Integer>();
		for (int i=0; i<10; ++i) 
			a.appendToTail(i);
		a.appendToTail(1123235434);
		
		Node<Integer> next = a.next;
		while (next != null) {
			System.out.println(next.data);
			next = next.next;
		}
	}

}
