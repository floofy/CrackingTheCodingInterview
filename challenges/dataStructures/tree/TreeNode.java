package dataStructures.tree;

public class TreeNode{
	public Integer data;
	public boolean visited;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	
	public TreeNode(Integer data) {
		this.data = data;
		left = null;
		right = null;
		parent = null;
	}
	
	public TreeNode() {
		left = null;
		right = null;
		parent = null;
	}

}
