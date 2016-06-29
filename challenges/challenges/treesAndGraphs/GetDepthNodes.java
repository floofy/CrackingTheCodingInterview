/*
 * Print out all nodes on the same level of the tree. 
 */
package challenges.treesAndGraphs;

import java.util.LinkedList;
import dataStructures.tree.BST;
import dataStructures.tree.TreeNode;

public class GetDepthNodes {

	public static void test() {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		BST b = CreateMinimalBST.createMinimalBST(array);

		LinkedList<LinkedList<TreeNode>> levels = new LinkedList<LinkedList<TreeNode>>();
		System.out.println("4. getDepthNodes( ");
		BST.levelOrder(b.root, "\t\t ");
		System.out.println("\t\t): " );
		getDepthNodes(b, levels);
		
		int count = 0;
		for (LinkedList<TreeNode> level : levels) {
			System.out.print(count + ": ");
			for (TreeNode node : level) {
				System.out.print(node.data + " ");
			}
			System.out.println("");
			++count;
		}
	}
	
	/*
	 * Naive solution. Wrapper to getDepthNodes with a printLevel argument. 
	 */
	public static void getDepthNodes(BST root,
									 LinkedList<LinkedList<TreeNode>> levels) {
		if (root == null) {
			return;
		}

		LinkedList<TreeNode> level;
		level = getDepthNodes(root.root, 0, 0);
		int depth = 0;
		while (level.size() != 0) {
			levels.add(level);
			level = getDepthNodes(root.root, 0, ++depth);
		}
		return;
	}
	
	/*
	 * Passed down a counter and prints all nodes when it equals it. For every
	 * level, a node that was calculated has to pass down a counter again. 
	 */
	public static LinkedList<TreeNode> getDepthNodes(TreeNode root, int level, int printLevel) {
		LinkedList<TreeNode> levelNodes = new LinkedList<TreeNode>();
		if (root == null) {
			return null;
		} else if (level == printLevel) {
			levelNodes.add(root);
			return levelNodes;
		}
		
		LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
		tmp = getDepthNodes(root.left, level+1, printLevel);
		if (tmp != null) {
			levelNodes.addAll(tmp);
		}
		
		tmp = getDepthNodes(root.right, level+1, printLevel);
		if (tmp != null) {
			levelNodes.addAll(tmp);
		}
		return levelNodes;
	}

}
