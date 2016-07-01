package dataStructures.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class BST {
	private int size;
	public TreeNode root = null;

	public BST(Integer data) {
		root = new TreeNode(data);
	}

	public BST() {
	}

	public BST(int[] array) {
		if (array.length == 0)
			return;

		for (int i : array) {
			this.insert(i);
		}
		return;
	}

	public int size() {
		return this.size;
	}

	public static boolean addLeft(TreeNode cur, TreeNode insert) {
	    if (cur == null || insert.data > cur.data) {
	        return false;
	    }
	    cur.left = insert;
	    insert.parent = cur;
	    return true;
	}
	
    public static boolean addRight(TreeNode cur, TreeNode insert) {
        if (cur == null
           || insert.data < cur.data
           || (cur.left != null && cur.right != null)) {
            return false;
        }
        cur.right = insert;
        insert.parent = cur;
        return true;
    }
   
	public void insert(Integer n) {
		if (this.root == null) {
			this.root = new TreeNode(n);
			return;
		}

		TreeNode cur = root;
		while (true) {
			if (n <= cur.data) {
				if (cur.left != null) {
					cur = cur.left;
				} else {
					cur.left = new TreeNode(n);
					cur.left.parent = cur;
					break;
				}
			} else if (n > cur.data) {
			    if (cur.right != null) {
			        cur = cur.right;
				} else {
					cur.right = new TreeNode(n);
					cur.right.parent = cur; 
					break;
				}
			}
		}

	}

	public TreeNode search(int data) {
	    TreeNode cur = root;
	    while (cur != null) {
	        if (data == cur.data) {
	            return cur;
	        } else if (data < cur.data) {
	            cur = cur.left;
	        } else {
	            cur = cur.right;
	        }
	    }

	    return null;
	}
	
	public int deleteLeftBiggest(TreeNode cur) {
		TreeNode prev = cur;
		TreeNode next = cur.left;
		while (next.right != null) {
			prev = next;
			next = next.right;
		}

		// Subtree has no right branches. Move left subtree up.
		if (prev == cur) {
			prev.left = next.left;
		}
		// Move the rightmost node's left subtree up one
		else {
			prev.right = next.left;
		}
		return next.data;
	}

	public int deleteRightSmallest(TreeNode cur) {
		TreeNode prev = cur;
		TreeNode next = cur;
		next = next.right;
		while (next.left != null) {
			prev = next;
			next = next.left;
		}

		// Subtree has no right branches. Move left subtree up.
		if (prev == cur) {
			prev.right = next.right;
		}
		// Move the leftmost node's right subtree up one
		else {
			prev.left = next.right;
		}
		return cur.data;
	}

	public boolean delete(Integer n) {
		TreeNode cur = this.root;
		TreeNode prev = this.root;

		while (cur != null) {
			if (n < cur.data) {
				prev = cur;
				cur = cur.left;
			} else if (n > cur.data) {
				prev = cur;
				cur = cur.right;
			} else {
				if (cur.left == null && cur.right == null) {
					if (prev.left == cur) {
						prev.left = null;
					} else if (prev.right == cur) {
						prev.right = null;
					} else {
						this.root = null;
					}

				} else {
					int tmp;

					if (cur.left != null) {
						tmp = deleteLeftBiggest(cur);
						cur.data = tmp;
					} else if (cur.right != null) {
						tmp = deleteRightSmallest(cur);
						cur.data = tmp;
					} else {
						if (cur == this.root) {
							this.root = null;
						}
					}
				}
				return true;
			}
		}

		return false;
	}

	public static void preOrder(TreeNode cur) {
		if (cur == null)
			return;

		System.out.print(cur.data + " ");
		preOrder(cur.left);
		preOrder(cur.right);
		return;
	}

	public static void inOrder(TreeNode cur) {
		if (cur == null)
			return;

		inOrder(cur.left);
		System.out.print(cur.data + " ");
		inOrder(cur.right);
		return;
	}

	public static void postOrder(TreeNode cur) {
		if (cur == null)
			return;

		postOrder(cur.left);
		postOrder(cur.right);
		System.out.print(cur.data + " ");
	}

	public static void levelOrder(TreeNode cur) {
		if (cur == null) {
			return;
		}

		ArrayList<Integer> nodes = new ArrayList<Integer>();
		nodes.add(cur.data);
		int printLevel = 0;
		while (nodes.size() > 0) {
			nodes.clear();
			nodes.addAll(levelOrder(cur, 0, printLevel));
			if (nodes.size() > 0) {
				System.out.println(nodes);
			}
			++printLevel;
		}

		return;
	}
	
	public static void levelOrder(TreeNode cur, String prefix) {
		if (cur == null) {
			return;
		}

		ArrayList<Integer> nodes = new ArrayList<Integer>();
		nodes.add(cur.data);
		int printLevel = 0;
		while (nodes.size() > 0) {
			nodes.clear();
			nodes.addAll(levelOrder(cur, 0, printLevel));
			if (nodes.size() > 0) {
				System.out.println(prefix + nodes);
			}
			++printLevel;
		}

		return;
	}

	public static ArrayList<Integer> levelOrder(TreeNode cur,
												int cur_level,
												int printLevel) {
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		if (cur_level == printLevel) {
			nodes.add(cur.data);
			return nodes;
		}

		if (cur.left != null) {
			nodes.addAll(levelOrder(cur.left, cur_level + 1, printLevel));
		}

		if (cur.right != null) {
			nodes.addAll(levelOrder(cur.right, cur_level + 1, printLevel));
		}

		return nodes;
	}

	public static void testTreeTraversals(BST bst) {
		System.out.print("preOrder: ");
		preOrder(bst.root);
		System.out.print("\ninOrder: ");
		inOrder(bst.root);
		System.out.print("\npostOrder: ");
		postOrder(bst.root);
		System.out.println("\nlevelOrder: ");
		levelOrder(bst.root);
	}

	public static void test() {
		int array[] = { 10, 8, 6, 7, 9, 15, 18, 12, 11, 5 };
		System.out.println("Inserting " + Arrays.toString(array) + "\n");
		BST a = new BST(array);

		testTreeTraversals(a);
		
		System.out.println("\nTesting parents (going all the way down right then up to root");
		TreeNode cur = a.root;
        while (cur.right != null) {
            System.out.println(cur.data);
            cur = cur.right;
        }
        System.out.println(cur.data);
        System.out.println("---");
        while (cur.parent != null) {
            System.out.println(cur.data);
            cur = cur.parent;
        }

		System.out.println("\nDeleting all from bst");
		for (int i : array) {
			if (!a.delete(i))
				System.out.println(i + " does not exist in BST!");
		}
		System.out.println("levelOrder: ");
		levelOrder(a.root);

	}

}
