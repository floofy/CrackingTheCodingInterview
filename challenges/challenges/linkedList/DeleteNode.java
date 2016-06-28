/*
 * Given access to only the node to delete from a LinkedList, delete it. 
 */

package challenges.linkedList;

import dataStructures.linkedList.Node;

public class DeleteNode {

	public static void test() {
		Integer[] array = {1,2,3,4,5,6,7,8,9};
		Node<Integer> n = new Node<Integer>(array);
		Node<Integer> deleteNode = n.next.next.next.next;
		boolean isDeleted;
	
		System.out.print("3. deleteNode("
						 + n.toString()
						 + "->"
						 + deleteNode.data
						 +"): ");
		
		isDeleted = deleteNode(deleteNode);

		if (isDeleted) {
			System.out.println(n.toString());
		}
		else {
			System.out.println(false);
		}
	}
	
	/*
	 * Given node in list to delete, shift everything to the left until end.
	 */
	public static <E> boolean deleteNode(Node<E> cur) {
		if (cur == null || cur.next == null)
			return false;

		cur.data = cur.next.data;
		cur.next = cur.next.next;
		return true;
	}

}
