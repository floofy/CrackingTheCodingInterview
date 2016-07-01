/*
 * Given a node in a tree print the next InOrder (traversal) node. 
 */
package challenges.treesAndGraphs;

import dataStructures.tree.BST;
import dataStructures.tree.TreeNode;

public class NextInOrderNode {
	
	public static void test() {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		BST b = CreateMinimalBST.createMinimalBST(array);
		TreeNode node;
		
		System.out.print("6. nextInOrderNode(");
		node = b.search(8);
		test(b, node, true);
		
		System.out.print("6(2). nextInOrderNode(");
		node = b.search(10);
	    test(b, node, false);
	    
	    System.out.print("6(3). nextInOrderNode(");
	    node = b.search(1);
	    test(b, node, false);
	    
	    System.out.print("6(4). nextInOrderNode(");
	    node = b.search(4);
	    test(b, node, false);
	    
	    System.out.print("6(5). nextInOrderNode(");
	    node = b.search(6);
	    test(b, node, false);
		
	}
	
	public static void test(BST bst, TreeNode node, boolean printTree) {      
        if (printTree) {
            System.out.println("");
            BST.levelOrder(bst.root, "\t\t");
            System.out.print("\t\t");
        }
        System.out.print(", " + node.data + "): ");
        TreeNode nextInOrder = nextInOrderNode(node);
        if (nextInOrder != null) {
            System.out.println(nextInOrder.data);
        } else {
            System.out.println(nextInOrder);
        }
	}

	/*
	 * 			      6
	 * 			4			9
	 * 		2		5	 8		11 
	 * 			   0-7		  10
	 * 
	 * leaf --> parent unless root then right child's left most
	 * 4 --> right child's left most (parent > than)
	 * 5 --> if it has parent that's less than, return its parent parent
	 *
	 * 
	 * 2 --> 4	left < data traverse inorder->right till left == null
	 * 4 --> 0  
	 * 0 --> 5
	 * 5 --> 7
	 * 7 --> 6
	 * 9 --> 10
	 * 10 --> 11
	 * 
	 */	
	
	/*
	 * Return the smallest node (in a BST) at from cur. 
	 */
	public static TreeNode getLeftMostNode(TreeNode cur) {
		while (cur.left != null) {
			cur = cur.left;
		}
		return cur;
	}
	
	/*
	 * Going up left, find next route going up right. 
	 */
	public static TreeNode getNextParentLeftChild(TreeNode cur) {
        while (cur.parent != null) {
            cur = cur.parent;
            if (cur.parent != null && cur.parent.left == cur) {
                return cur.parent;
            }
        }

        return null;
	}
	
	/*
	 * Returns the next InOrder node from cur. 
	 * 
	 * 5 Cases:
	 * 1.Leaf, left child of parent -> return parent
	 * 2.Leaf, right child of parent -> go up tree until we find a node that's a
	 *                                left child of parent and return that
	 *                                parent.
	 * 3.Non-leaf, left child -> Return left most child from node. 
	 * 4.Non-leaf, no left child -> Return right child's left most child
	 * 5.Root -> Return right child's left most child 
	 * 6.Largest leaf -> return null.
	 * 
	 */
	public static TreeNode nextInOrderNode(TreeNode cur) {
		if (cur == null || (cur.parent == null && cur.right == null)) {
			return null;
		}
		
		// leaves
		if (cur.parent == null || cur.left == null && cur.right != null) {
            return getLeftMostNode(cur.right);
		} else if (cur.left != null) {
            return getLeftMostNode(cur);
        } else { // leaf
		    if (cur.parent.left == cur) {
		        return cur.parent;
		    } else {
		        cur = getNextParentLeftChild(cur);
		        return cur;
		    }
		}

	}

}
