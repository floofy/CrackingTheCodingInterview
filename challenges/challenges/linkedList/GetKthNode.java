/*
 * Return the kth to last Node in a linked list give the head. 
 */
package challenges.linkedList;

import dataStructures.linkedList.Node;

public class GetKthNode {

	public static void test() {
		Integer[] array = {1,2,3,4,5,6,7,8,9};
		Node<Integer> n = new Node<Integer>(array);
		int k = 3;
		System.out.print("2. getKthNode(" + n.toString() + ", " + k + "): ");
		System.out.println(getKthNode(n, k).data);
	}

	/*
	 * Where k=1 is the last element. Works by having two pointers in list k
	 * distance apart so we get the kth element when later pointer reaches null.
	 */
	public static <E> Node<E> getKthNode(Node<E> head, int k) {
		if (head == null)
			return null;

		Node<E> prev = head;
		Node<E> end = head;
		int distance = 0;
		while (end.next != null) {
			if (distance == k-1) {
				prev = prev.next;
			} else {
				++distance;
			}
			end = end.next;
		}
		if (distance != k-1) {
			return null;
		}
		return prev;
	}

}
