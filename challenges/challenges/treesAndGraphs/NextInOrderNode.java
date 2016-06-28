package challenges.treesAndGraphs;

import dataStructures.tree.BST;
import dataStructures.tree.TreeNode;

public class NextInOrderNode {
	
	public static void test() {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int node = 8;
		BST b = CreateMinimalBST.createMinimalBST(array);
	
		System.out.println("6. nextInOrderNode(");
		BST.levelOrder(b.root, "\t\t");
		
		System.out.println(", + " + node + "\t\t): ");
		TreeNode nextInOrder = nextInOrderNode(b.root, node);
		System.out.print(nextInOrder.data);
	}

	/*
	 * 			      6
	 * 			4			9
	 * 		2		5	8		11
	 * 			  0	  7		  10
	 * 
	 * leaf --> parent unless root then right child's left most
	 * 4 --> right child's left most (parent > than)
	 * 5 --> if it has parent that's less than, return its parent parent
	 *
	 * 
	 * 2 --> 4	left < data traverse inorder->right till left == null
	 * 4 --> 0  
	 * 0 --> 1
	 * 1 --> 5
	 * 5 --> 6
	 * 9 --> 10
	 * 10 --> 11
	 * 
	 */	
	public static TreeNode getLeftMostNode(TreeNode cur) {
		while (cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}
	
	public static TreeNode nextInOrderNode(TreeNode cur, int node) {
		if (cur == null || (cur.parent == null && cur.right == null)) {
			return null;
		}
		
		TreeNode nextNode = null;
		// root
		if (cur.parent == null) {
			return getLeftMostNode(cur.right);
		} else if (cur.left == null && cur.right == null) {
			return cur.parent;
		} else if (cur.right != null) {
			return getLeftMostNode(cur.right);
		} else if (cur.left != null && cur.right == null) {
			return cur.parent.parent;
		}
		
		
		return nextNode;
	}
}
