package com.wlc.ds.tree;

/**
 * 检查一颗二叉树是否是二叉查找树 二叉查找树的定义为对于每一个结点， 它的左边的结点必须小于等于它，右边的结点必须大于它
 * 自上而下传递一个区间，如果某个值不在区间里，则说明不是
 * @author lanchun
 *
 */
public class IsBST {
	private static boolean checkBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;

		if (root.data >= max || root.data < min) {
			return false;
		}

		if (!checkBST(root.leftChild, min, root.data) || !checkBST(root.rightChild, root.data, max)) {
			return false;
		}
		return true;
	}

	public static boolean checkBST(TreeNode root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}
