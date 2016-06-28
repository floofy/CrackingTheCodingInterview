/*
 * Given two numbers represented as LinkedList return the sum of them by a number
 * represented as a LinkedList. Do this for when the first element is the most
 * significant number and least significant. 
 */
package challenges.linkedList;

import dataStructures.linkedList.Node;

public class SumLinkedList {
	
	private static int carry;

	// 5 Add two linked lists in forward and reverse order
	public static void test() {
		Integer[] array1 = {7, 1, 6};
		Integer[] array2 = {5, 9, 2};
		Node<Integer> num1 = new Node<Integer>(array1);
		Node<Integer> num2 = new Node<Integer>(array2);
		System.out.println("5. sumLinkedListedReverse("
						   + num1.toString()
						   + ", "
						   + num2.toString()
						   + "): "
						   + sumReverse(num1, num2).toString());
		System.out.println("5. sumLinkedListedForward("
						   + num1.toString()
						   + ", "
						   + num2.toString()
						   + "): "
						   + sumForward(num1, num2).toString());
	}

	public static <E> int length(Node<E> head) {
		int count = 0;
		while (head != null) {
			++count;
			head = head.next;
		}
		
		return count;
	}
	
	/*
	 * Append 0s to tail of list (most siginificant lists) to align.
	 */
	public static void padReverse(Node<Integer> head, int amount) {
		while (head.next != null) {
			head = head.next;
		}
		
		for (int i=0; i<amount; ++i) {
			head.next = new Node<Integer>();
			head = head.next;
			head.data = 0;
		}
	}
	
	/*
	 * Wrapper to sumReverse with carry argument. The least significant bit is
	 * the head of list where the number is read in reverse. 
	 */
	public static Node<Integer> sumReverse(Node<Integer> l1, Node<Integer> l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		Node<Integer> sum = new Node<Integer>();
		int length1 = length(l1);
		int length2 = length(l2);
		
		if (length1 < length2) {
			padReverse(l1, length2-length1);
		} else if (length2 < length1) {
			padReverse(l2, length1-length2);
		}

		sum = sumReverse(l1, l2, 0);
		return sum;
	}
	
	/*
	 * Return a linkedlist of the sum of two numbers represented by a
	 * linkedlist where the head is the least significant (one's place).
	 */
	private static Node<Integer> sumReverse(Node<Integer> l1,
									 Node<Integer> l2,
									 int carry) {
		if (l1 == null && l2 == null && carry == 0)
			return null; 	// create end of sum's linkedlist
		
		Node<Integer> thisSum = new Node<Integer>();
		int value = 0;
		
		if (l1 != null) {
			value += l1.data;
		}
		
		if (l2 != null) {
			value += l2.data;
		}
		
		value += carry;
		thisSum.data = value%10;
		thisSum.next = sumReverse(l1.next, l2.next, value/10);
		
		return thisSum;
	}
	
	public static Node<Integer> padFoward(Node<Integer> head, int amount) {
		Node<Integer> padNode;
		for (int i=0; i<amount; ++i) {
			padNode = new Node<Integer>();
			padNode.data = 0;
			padNode.next = head;
			head = padNode;
		}

		return head;
	}
	
	public static Node<Integer> sumForward(Node<Integer> l1, Node<Integer> l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		
		Node<Integer> summedList;
		int length1 = length(l1);
		int length2 = length(l2);

		if (length1 < length2) {
			l1 = padFoward(l1, length2 - length1);
		} else if (length2 < length1) {
			l2 = padFoward(l2, length1 - length2);
		}

		carry = 0;
		summedList = sum(l1, l2);
		
		if (carry > 0) {
			Node<Integer> carryOver = new Node<Integer>();
			carryOver.data = carry;
			carryOver.next = summedList;
			summedList = carryOver;
			carry = 0;
		}

		return summedList;
	}
	
	private static Node<Integer> sum(Node<Integer> l1, Node<Integer> l2) {
		if (l1 == null && l2 == null) {
			return null; 	// create tail of linkedlist
		}
		
		Node<Integer> thisSum = new Node<Integer>();
		int value = 0;
		thisSum.next = sum(l1.next, l2.next);
		
		value = l1.data;
		value += l2.data;
		value += carry;
		carry = value/10;
		thisSum.data = value%10;
		return thisSum;
	}
	

}
