/*
 * Print out the start of a loop in a LinkedList if there is one. 
 */
package challenges.linkedList;

import java.util.HashSet;

import dataStructures.linkedList.Node;

public class GetLoop {

	// 6 Print beginning of loop
	public static void test() {
		Integer[] array = {5,5,8,2,2,2,8,10,10};
		Node<Integer> n = new Node<Integer>(array);
		Node<Integer> loop = n.next.next.next.next.next.next.next.next; // 5,5,8,2,2,2,8,10,10 <--
		loop.next = n.next.next; 	// Loop at 10 -> 8 (index 2)
		System.out.println("6. getLinkedListLoopNode(5,5,8,2,2,2,8,10,10 -> 8): "
						   + getLinkedListLoopNode(n).data);
		System.out.println("6(2). getLinkedListLoopNodeFastSlow(5,5,8,2,2,2,8,10,10 -> 8): "
						   + getLinkedListLoopNodeFastSlow(n).data);
	}

	/*
	 * Use hashset to store all object references and check if contains one.
	 */
	public static <E> Node<E> getLinkedListLoopNode(Node<E> head) {
		HashSet<Node<E>> set = new HashSet<Node<E>>();
		while (head != null) {
			if (set.contains(head)) {
				return head;
			}
			set.add(head);
			head = head.next;
		}
	
		return null;
	}
	
	/*
	 * Use fast + slow pointers and do math to get loop. 
	 */
	public static <E> Node<E> getLinkedListLoopNodeFastSlow(Node<E> head) {
		Node<E> slow = head;
		Node<E> fast = head;
		
		// Find meeting point somewhere in loop
		while (fast != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				break;
		}
		
		if (fast == null)
			return null;
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}

}
