/*
 * Given head of linkedlist remove all nodes that have duplicate values.
 */
package challenges.linkedList;

import java.util.HashSet;

import dataStructures.linkedList.Node;

public class RemoveDups {

	public static void test() {
		Integer[] array = {5,5,8,2,2,2,8,10,10};
		Node<Integer> n = new Node<Integer>(array);
		System.out.print("1(a). removeDups(" + n.toString() + "):");
		removeDups(n);
		System.out.print(' ' + n.toString() + '\n');

		n = new Node<Integer>(array);
		System.out.print("1(b). removeDupsNoBuffer(" + n.toString() + "): ");
		removeDupsNoBuffer(n);
		System.out.println(' ' + n.toString());
	}

	public static <E> void removeDups(Node<E> head) {
		if (head == null || head.next == null)
			return;

		HashSet<E> buffer = new HashSet<E>();
		Node<E> prev = null;

		while (head != null) {
			if (buffer.contains(head.data)) {
				prev.next = head.next;
			} else {
				buffer.add(head.data);
				prev = head;
			}

			head = head.next;
		}

	}

	public static <E> void removeDupsNoBuffer(Node<E> head) {
		if (head == null || head.next == null)
			return;
		
		Node<E> runner;
		while (head != null) {
			runner = head;
			while (runner.next != null) {
				if (runner.next.data == head.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			head = head.next;
		}
	}

}
