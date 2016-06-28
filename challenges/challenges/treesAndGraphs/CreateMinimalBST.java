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
	
	public static void insertBST(BST bstTree, int[] array) {
		for (int i: array) {
			bstTree.insert(i);
		}
	}

	/*
	 * From sorted set create a BST with minimal height. This is done by
	 * recursively inserting the middle element as the root (by definition of a 
	 * BST this will give it the most balanced tree) and getting left and right
	 * subtrees. 
	 */
	public static BST createMinimalBST(int[] array) {
		BST minBST = new BST();
		if (array == null || array.length == 0) {
			return null;
		} else if (array.length == 1) {
			insertBST(minBST, array);
			return minBST;
		}
		int middle;
		int[] left = null;
		int[] right = null;

		int half = array.length/2;
		middle = array[half];
		left = Arrays.copyOfRange(array, 0, half);
		if (half+1 != array.length) { 
			right = Arrays.copyOfRange(array, half+1, array.length);
		}
		
		BST leftTree = createMinimalBST(left);
		BST rightTree = createMinimalBST(right);
		
		minBST.insert(middle);
		if (leftTree != null) {
			minBST.root.left = leftTree.root;
		}
		if (rightTree != null) {
			minBST.root.right = rightTree.root;
		}
		
		return minBST;
	}
	
}
