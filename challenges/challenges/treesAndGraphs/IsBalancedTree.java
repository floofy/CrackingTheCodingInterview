package challenges.treesAndGraphs;

import dataStructures.tree.BST;
import dataStructures.tree.TreeNode;

public class IsBalancedTree {

	public static void test() {
		System.out.println("1. isBalancedTree():");

		int array1[] = {3, 2, 1, 6, 7, 5, 8, 9};
		BST a = new BST(array1);
		BST.levelOrder(a.root);
		boolean balanced = isBalancedTree(a.root);
		System.out.println(balanced);
		
	}
	
	/* ------------------O(nlogn) method------------------------
	 * For every node, their heights has to be calculated by going all the
	 * way to leafs from left and right. Working from the root down means that
	 * the same nodes will be traversed over and over again. 
	 */

	/*
	 * From the root working down, increment a counter until a leaf is reached
	 * then return that height. Return max height of left and right subtree.
	 * Every call we know max of height left and right differ by most 1 because
	 * isBalancedTreeNlogN ensures starting form a leaf, each node is balanced.
	 */
	public static int getHeightNlogN(TreeNode n, int height) {
		if (n.left == null && n.right == null) {
			return height;
		}
		
		int l, r;

		// Pre-order traversal
		if (n.left != null) {
			l = getHeightNlogN(n.left, height+1);
		} else {
			l = height;
		}
		
		if (n.right != null) {
			r = getHeightNlogN(n.right, height+1);
		} else {
			r = height;
		}
		
		return Math.max(l, r);
	}
	
	/*
	 * Traversing in pre-order to leaves and up, return if each node is balanced
	 * by calculating the height for each node's left and right and return bool.
	 */
	public static boolean isBalancedTreeNlogN(TreeNode n) {
		if (n.left == null && n.right == null)
			return false;		// From leaf return height to original node.

		// Pre-order traversal
		boolean balanced;
		if (n.left != null) {
			balanced = isBalancedTreeNlogN(n.left);
			if (!balanced) {
				return false;
			}
		}
		
		if (n.right != null) { 
			balanced = isBalancedTreeNlogN(n.right);
			if (!balanced) {
				return false;
			}
		}
		
		int l = 0;
		int r = 0;
		if (n.left != null) {
			l = getHeightNlogN(n.left, 1);		// Drop a counter to leaf
		}
		
		if (n.right != null) {
			r = getHeightNlogN(n.right, 1);
		}
		
		if (Math.abs(l-r) > 1) {
			return false;
		} 
		
		return true;

	}
	/*
	 * ------------------^O(nlogn) method^------------------------
	 */

	/*
	 * -------------------O(n) method-----------------------------
	 * Instead of finding the heights for all nodes, getHeight will do the
	 * checking if the subtree is balanced (from leaf) and will return
	 * the max height if it is balanced and -1 if it's not.
	 */
	public static int getHeight(TreeNode n, int height) {
		if (n == null) {
			return height;
		}
		
		int l, r;
		l = getHeight(n.left, height+1);
		if (l == -1) {
			return -1;
		}
		
		r = getHeight(n.right, height+1);
		if (r == -1) {
			return -1;
		}

		if (Math.abs(l-r) > 1) {
			return -1;
		}
		
		return Math.max(l, r);
	}

	public static boolean isBalancedTree(TreeNode r) {
		int lHeight, rHeight;
		lHeight = getHeight(r.left, 0);
		rHeight = getHeight(r.right, 0);

		if (lHeight == -1 || rHeight == -1 || Math.abs(lHeight-rHeight) > 1) {
			return false;
		}
		
		return true;
	}
	/*
	 * -------------------^O(n) method^-----------------------------
	 */

}
