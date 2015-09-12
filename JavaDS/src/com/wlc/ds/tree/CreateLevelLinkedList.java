package com.wlc.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 为一颗深度为k的二叉树创建k个链表，分别存储每一层的结点
 * 采用层次遍历的方法
 * @author lanchun
 *
 */
public class CreateLevelLinkedList {
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
		LinkedList<TreeNode> current = new LinkedList<>();
		if (root == null)
			return null;
		else
			current.add(root);

		while (current.size() > 0) {
			// 下面两句处理上一次的运行结果
			result.add(current);
			LinkedList<TreeNode> parents = current;

			current = new LinkedList<>();
			for (TreeNode node : parents) {
				if (node.leftChild != null) {
					current.add(node.leftChild);
				}
				if (node.rightChild != null) {
					current.add(node.rightChild);
				}
			}
		}

		return result;
	}
}
