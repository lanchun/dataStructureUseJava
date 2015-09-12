package com.wlc.ds.tree;

class TreeNodeWithDistance {
	int data;
	int leftMaxValue;
	int rightMaxValue;

	TreeNodeWithDistance left;
	TreeNodeWithDistance right;
}

class MaxValue {
	int max;
}

public class MaxTreeDistance {
	public static void getMaxDistance(TreeNodeWithDistance root, MaxValue max) {
		if (root == null)
			return;
		if (root.left == null)
			root.leftMaxValue = 0;
		if (root.right == null)
			root.rightMaxValue = 0;

		if (root.left != null) {
			getMaxDistance(root.left, max);
		}
		if (root.right != null) {
			getMaxDistance(root.right, max);
		}

		if (root.left != null) {
			root.leftMaxValue = 1 + root.left.leftMaxValue > root.left.rightMaxValue ? root.leftMaxValue
					: root.rightMaxValue;
		}
		if (root.right != null) {
			root.rightMaxValue = 1 + root.right.leftMaxValue > root.right.rightMaxValue ? root.leftMaxValue
					: root.rightMaxValue;
		}

		if (root.leftMaxValue + root.rightMaxValue > max.max)
			max.max = root.leftMaxValue + root.rightMaxValue;
	}
	
}
