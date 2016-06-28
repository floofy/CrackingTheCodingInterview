package challenges.linkedList;

import dataStructures.linkedList.Node;

public class DeleteNode {

	public static void test() {
		Integer[] array = {1,2,3,4,5,6,7,8,9};
		Node<Integer> n = new Node<Integer>(array);
		System.out.print("3. deleteNode(" + n.toString() + "): ");
		deleteNode(n.next.next.next.next);
		System.out.println(n.toString());
	}
	
	/*
	 * Given node in list to delete, shift everything to the left until end.
	 */
	public static <E> void deleteNode(Node<E> head) {
		if (head == null || head.next == null)
			return;
		
		while (true) {
			head.data = head.next.data;
			if (head.next.next == null) {
				head.next = null;
				break;
			}
			head = head.next;
		}
	}

}
