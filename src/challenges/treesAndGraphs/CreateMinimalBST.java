/*
 * Given sorted list of numbers create a BST with minimal height.
 */
package challenges.treesAndGraphs;

import java.util.Arrays;
import dataStructures.tree.BST;

public class CreateMinimalBST {
	public static void test() {
		int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println("3. createMinimalBST(" + Arrays.toString(array2) + ": ");
		BST b = createMinimalBST(array2);
		BST.levelOrder(b.root);
	}
	
	/*
	 * Insert elements in array into a BST data structure consecutively.
	 */
	public static void insertBST(BST bstTree, int[] array) {
		for (int i: array) {
			bstTree.insert(i);
		}
	}

	/*
	 * From sorted set create a BST with minimal height. This is done by
	 * recursively inserting the middle element as the root (by definition of a 
	 * BST this will give it the most balanced tree) recursing the left and
	 * right subtrees.
	 */
	public static BST createMinimalBST(int[] array) {
		BST minBST = new BST();

		if (array == null || array.length == 0) {
			return null;
		} else if (array.length == 2) {
			insertBST(minBST, array);
			return minBST;
		}

		int half = array.length/2;
		int middle = array[half];
		int[] leftArray = null;
		int[] rightArray = null;

		leftArray = Arrays.copyOfRange(array, 0, half);
		rightArray = Arrays.copyOfRange(array, half+1, array.length);
		
		BST leftTree = createMinimalBST(leftArray);
		BST rightTree = createMinimalBST(rightArray);
		
		minBST.insert(middle);
		if (leftTree != null) {
		    BST.addLeft(minBST.root, leftTree.root);
		}
		if (rightTree != null) {
		    BST.addRight(minBST.root, rightTree.root);
		}
		
		return minBST;
	}
	
}
