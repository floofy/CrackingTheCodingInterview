package challenges.linkedList;

import dataStructures.linkedList.Node;

public class SumLinkedList {

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
						   + sumLinkedListedReverse(num1, num2));
		System.out.println("5. sumLinkedListedForward("
						   + num1.toString()
						   + ", "
						   + num2.toString()
						   + "): "
						   + sumLinkedListForward(num1, num2));
	}

	/*
	 * Return 10^(length of list)
	 */
	public static int getPower(Node<Integer> head) {
		Node<Integer> tmp = head;
		int power = 1;
		while (tmp.next != null) {
			power *= 10;
			tmp = tmp.next;
		}
		return power;
	}
	
	/*
	 * Last number in list is Most Significant s.t 7->1->6 = 617
	 */
	public static int sumLinkedListedReverse(Node<Integer> head1, Node<Integer> head2) {
		int num1 = 0;
		int num2 = 0;
		int power1 = getPower(head1);
		int power2 = getPower(head2);
		Node<Integer> tmp;
		
		tmp = head1;
		for (int i=1; i<=power1; i *= 10) {
			num1 += tmp.data*i;
			tmp = tmp.next;
		}
		
		tmp = head2;
		for (int i=1; i<=power2; i *= 10) {
			num2 += tmp.data*i;
			tmp = tmp.next;
		}
		
		return num1 + num2;
	}

	/*
	 * First number in list is Most Significant s.t 7->1->6 = 716
	 */
	public static int sumLinkedListForward(Node<Integer> head1, Node<Integer> head2) {
		int power1 = 1;
		int power2 = 1;
		int num1 = 0;
		int num2 = 0;

		power1 = getPower(head1);
		power2 = getPower(head2);
	
		Node<Integer> tmp = head1;
		while (power1 != 0) {
			num1 += tmp.data * power1;
			power1 /= 10;
			tmp = tmp.next;
		}

		tmp = head2;
		while (power2 != 0) {
			num2 += tmp.data * power2;
			power2 /= 10;
			tmp = tmp.next;
		}

		return num1 + num2;
	}

}
