package com.wlc.ds.tree;

public class GetNearestAncestor {
	/*
	 * 返回两个节点的最低公共祖先 解法1：如果一个在左子树，一个在右子树，那么node就是公共结点 如果都在左（右）子树，那么递归到左（右）子树
	 * 解法2：从根节点分别遍历到n1和n2，使用list来保存两条路径，再依次逆序比较两条路径， 第一个相同的结点就是最近的公共结点
	 */
	public static TreeNode getNearestAncestorHelper(TreeNode node,
			TreeNode n1, TreeNode n2) {
		if (node == null || n1 == null || n2 == null)
			return null;
		boolean isN1InLeft = findNode(node.leftChild, n1);
		boolean isN2InLeft = findNode(node.leftChild, n2);
		
		if (isN1InLeft != isN2InLeft)
			return node;
		
		TreeNode childSide = isN1InLeft ? node.leftChild:node.rightChild;
		return getNearestAncestorHelper(childSide, n1, n2);
	}

	/*
	 * 在node子树中查找toFind结点,找到返回true，否则返回false
	 */
	public static boolean findNode(TreeNode node, TreeNode toFind) {
		if (node == null || toFind == null) {
			return false;
		}
		if (node == toFind)
			return true;
		return findNode(node.leftChild, toFind) || findNode(node.rightChild, toFind);
	}
	
	public static TreeNode getNearestAncestor(TreeNode root,TreeNode p,TreeNode q){
		if(! findNode(root, p) || !findNode(root, q)){
			return null;
		}
		return getNearestAncestorHelper(root, p, q);
	}
}
