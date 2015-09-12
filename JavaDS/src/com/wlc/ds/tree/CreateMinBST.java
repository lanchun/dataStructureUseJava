package com.wlc.ds.tree;

public class CreateMinBST {
	/**
	 * 将有序数组转换为一个高度最小的二叉查找树 每次取数组的中间值作为根节点
	 */
	private static TreeNode createMinBST(int[] arr, int start, int end) {
		if (start <= end) {
			int mid = (start + end) >>> 1;
			System.out.println(mid);
			TreeNode root = new TreeNode(arr[mid]);
			root.leftChild = createMinBST(arr, start, mid - 1);
			root.rightChild = createMinBST(arr, mid + 1, end);
			return root;
		}
		return null;
	}

	public static TreeNode createMinBST(int[] arr) {
		return createMinBST(arr, 0, arr.length - 1);
	}
}
