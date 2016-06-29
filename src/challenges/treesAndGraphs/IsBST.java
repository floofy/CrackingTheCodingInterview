/*
 * Return True of False if a given tree is a BST.
 */
package challenges.treesAndGraphs;

import dataStructures.tree.BST;
import dataStructures.tree.TreeNode;

public class IsBST {
	public static void test() {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		BST b = CreateMinimalBST.createMinimalBST(array);
			
		System.out.println("5. isBST(");
		BST.levelOrder(b.root, "  \t");
		System.out.print("\t): ");
		System.out.println(isBST(b.root));
		
		test2();
	}

	public static void test2() {
		TreeNode notBST = new TreeNode();
		notBST.data = 12;
		notBST.left = new TreeNode();
		notBST.left.data = 8;
		notBST.left.left = new TreeNode();
		notBST.left.left.data = 5;
		notBST.left.right = new TreeNode();
		notBST.left.right.data = 200;
		notBST.right = new TreeNode();
		notBST.right.data = 15;
		notBST.right.left = new TreeNode();
		notBST.right.left.data = 14;
		System.out.println("5(2). isBST(");
		BST.levelOrder(notBST, "    \t");
		System.out.print("\t): ");
		System.out.println(isBST(notBST));
	}
	
	/*
	 * Recursively checks the left and right subtree's minimum and maximum
	 * values and compares them to the current value. If the left subtree's
	 * maximum is larger or if the right subtree's minimum is less than the
	 * current value then an array with 2 nulls i returned {null, null}.
	 */
	public static Integer[] checkBST(TreeNode n) {
		Integer[] l, r;	 // minimums and maximums of left and right subtrees
		
		if (n.left != null) {
			l = checkBST(n.left);
			if (l[0] == null && l[1] == null) {
				return l;
			}
		} else {	
			l = new Integer[2];		// Leaf node. Min and Max is itself.
			l[0] = n.data;
			l[1] = n.data;
		}
		
		if (n.right != null) {
			r = checkBST(n.right);
			if (r[0] == null && r[1] == null) {
				return r;
			}
		} else {
			r = new Integer[2];
			r[0] = n.data;
			r[1] = n.data;
		}
		
		if (l[1] > n.data) {	// Left's maximum
			Integer[] notBST = {null, null};
			return notBST;
		} 
		if (r[0] < n.data) {	// Right's minimum
			Integer[] notBST = {null, null};
			return notBST;
		} 
		
		// return this node's min and max
		Integer[] minMax ={Math.min(l[0], r[0]), Math.max(l[1], r[1])};
		return minMax;	
	}

	/*
	 * Wrapper for checkBST. Returns false when an array with 2 nulls is
	 * returned. 
	 */
	public static boolean isBST(TreeNode node) {
		if (node == null) {
			return false;
		}
	
		Integer[] minMax = checkBST(node);
		if (minMax[0] == null && minMax[1] == null) {
			return false;
		}
		return true;
	}

}
