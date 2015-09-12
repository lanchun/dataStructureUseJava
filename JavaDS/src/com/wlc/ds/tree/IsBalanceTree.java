package com.wlc.ds.tree;

/**
 * 判断一颗树是不是平衡二叉树，即左右子树高度之差不能大于1
 * 在计算高度的时候就可以进行检查，如果发现左右子树高度差大于1，
 * 则立即返回false也就不用再计算了
 * @author lanchun
 *
 */
public class IsBalanceTree {

	private static int checkHeight(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = checkHeight(root.leftChild);
		if (leftHeight == -1)
			return -1;

		int rightHeight = checkHeight(root.rightChild);
		if (rightHeight == -1)
			return -1;

		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return -1;
		} else {
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}

	public static boolean isBalanced(TreeNode root) {
		if (checkHeight(root) == -1)
			return false;
		return true;
	}
}
