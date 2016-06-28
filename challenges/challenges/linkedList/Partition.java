/*
 * Partition a linkedlist where all numbers < x are before x it. 
 */
package challenges.linkedList;

import dataStructures.linkedList.Node;

public class Partition {

	// 4 partition nodes before and after x
	public static void test() {
		Integer[] array = {10, 9, 100, 2, 1, 0, 5, 4, 3, 16, 20};
		Node<Integer> n = new Node<Integer>(array);
		int value = 5;
		System.out.print("4. partitionLinkedList("
						 + n.toString()
						 + ", "
						 + value
						 + "): ");
		Node<Integer> partitioned = partition(n, value);
		System.out.println(partitioned.toString());
	}
	
	/*
	 * Create a less and large linkedlist then join the linked lists with value.
	 */
	public static Node<Integer> partition(Node<Integer> head, Integer value) {
		if (head == null || head.next == null)
			return null;
		
		Node<Integer> less = new Node<Integer>();
		Node<Integer> large = new Node<Integer>();
	
		while (head != null) {
			if  (head.data < value) {
				less.appendToTail(head.data);
			} else if (head.data > value) {
				large.appendToTail(head.data);
			}
			head = head.next;
		}
		
		Node<Integer> partitioned = less;
		less.appendToTail(value);
		while (less.next != null) {
			less = less.next;
		}
		less.next = large;
	return partitioned;
	}


}
