/*
 * Return true or false if a linkedlist is a palindrome
 */
package challenges.linkedList;

import java.util.Stack;
import dataStructures.linkedList.Node;

public class IsPalindrome {

	public static void test() {
		Integer[] palindrome = {1 ,2 ,3 ,4 ,3 ,2 ,1};
		Node<Integer> n = new Node<Integer>(palindrome);
		System.out.println("7. isLinkedListPalindrome("
						   + n.toString() + "): "
						   +  isPalindrome(n));
	}

	/*
	 * Use fast and slow pointer adding first half of list to a stack, then
	 * comparing it consecutively when the slow pointers moves from half to end.
	 */
	public static <E> boolean isPalindrome(Node<E> head) {
		if (head == null)
			return false;
		else if (head.next == null)
			return true;

		Node<E> fast = head;
		Node<E> slow = head;
		Stack<E> buffer = new Stack<E>();

		while (fast != null && fast.next != null) {
			buffer.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		// Odd length, skip middle element
		if (fast.next == null) {
			slow = slow.next;
		}
		
		while (slow != null) {
			if (slow.data != buffer.pop()) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

}
