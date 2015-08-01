package com.wlc.ds.tree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	public BinaryTreeNode root;

	private int size(BinaryTreeNode node) {
		if (node == null)
			return 0;
		return size(node.leftChild) + size(node.rightChild) + 1;
	}

	/* 求二叉树的结点个数 */
	public int size() {
		return size(root);
	}

	private int height(BinaryTreeNode node) {
		if (node == null)
			return 0;
		return Math.max(height(node.leftChild), height(node.rightChild)) + 1;
	}

	/* 求二叉树的高度 */
	public int height() {
		return height(root);
	}

	/* 前序遍历 */
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(BinaryTreeNode node) {
		if (node != null) {
			visit(node);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}

	public void visit(BinaryTreeNode node) {
		System.out.print(node.data + " ");
	}

	/*
	 * 层次遍历 采用队列实现，先访问根节点，在将其左孩子和右孩子加入队列
	 */
	public void levelOrder() {
		if (root == null)
			return;
		BinaryTreeNode node = root;
		Queue<BinaryTreeNode> s = new LinkedList<>();
		s.add(node);
		while (!s.isEmpty()) {
			BinaryTreeNode n = s.poll();

			if (n.leftChild != null)
				s.add(n.leftChild);
			if (n.rightChild != null)
				s.add(n.rightChild);

			visit(n);
		}
	}

	/*
	 * 计算二叉树第k层结点的个数 递归实现，求根节点的左右孩子的k-1层结点个数之和
	 */
	public int getNodesNum(int k) {
		return getNodesNum(root, k);
	}

	public int getNodesNum(BinaryTreeNode node, int k) {
		if (node == null || k <= 0)
			return 0;
		if (k == 1) {
			return 1;
		}
		return getNodesNum(node.leftChild, k - 1)
				+ getNodesNum(node.rightChild, k - 1);
	}

	/* 计算二叉树的叶子结点个数 ,递归，等于左右子树的叶子之和 */
	public int getLeafNum() {
		return getLeafNum(root);
	}

	public int getLeafNum(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}
		if (node.leftChild == null && node.rightChild == null)
			return 1;
		return getLeafNum(node.leftChild) + getLeafNum(node.rightChild);
	}

	/* 判断两棵树结构是否相同 */
	public boolean isSameTree(BinaryTreeNode node1, BinaryTreeNode node2) {
		if ((node1 == null && node2 != null)
				|| (node1 != null && node2 == null))
			return false;
		if (node1 == null && node1 == null)
			return true;
		else if (node1 == null || node2 == null)
			return false;
		return isSameTree(node1.leftChild, node2.leftChild)
				&& isSameTree(node1.rightChild, node2.rightChild);
	}

	/* 中序遍历的非递归实现 */
	public void inOrder(BinaryTreeNode node) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		BinaryTreeNode temp = node;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.add(temp);
				temp = temp.leftChild;
			}

			temp = stack.pop();
			visit(temp);
			temp = temp.rightChild;
		}

	}

	/*
	 * 将二叉查找树转变成双向链表 二叉排序树的中序遍历有序
	 */
	public void toDeLinkList(BinaryTreeNode node, BinaryTreeNode first,
			BinaryTreeNode last) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		BinaryTreeNode temp = node;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.add(temp);
				temp = temp.leftChild;
			}

			temp = stack.pop();
			if (first == null)
				first = last = temp;
			else {
				last.rightChild = temp;
				temp.leftChild = last;
				last = temp;
			}
			temp = temp.rightChild;
		}

		while (first != null) {
			visit(first);
			first = first.rightChild;
		}
	}

	/* 判断一个二叉树是不是平衡二叉树 */
	public boolean isAVL(BinaryTreeNode node) {
		if (node == null)
			return true;
		if (Math.abs(height(node.leftChild) - height(node.rightChild)) > 1)
			return false;
		return isAVL(node.leftChild) && isAVL(node.rightChild);
	}

	/*
	 * 返回两个节点的最低公共祖先 解法1：如果一个在左子树，一个在右子树，那么node就是公共结点 如果都在左（右）子树，那么递归到左（右）子树
	 * 解法2：从根节点分别遍历到n1和n2，使用list来保存两条路径，再依次逆序比较两条路径， 第一个相同的结点就是最近的公共结点
	 */
	public BinaryTreeNode getNearestAncestor(BinaryTreeNode node,
			BinaryTreeNode n1, BinaryTreeNode n2) {
		if (node == null || n1 == null || n2 == null)
			return null;
		if (findNode(node.leftChild, n1) && findNode(node.rightChild, n2))
			return node;
		else if (findNode(node.leftChild, n1) && findNode(node.leftChild, n2))
			return getNearestAncestor(node.leftChild, n1, n2);
		else if (findNode(node.rightChild, n1) && findNode(node.rightChild, n2))
			return getNearestAncestor(node.rightChild, n1, n2);
		else
			return null;
	}

	/*
	 * 在node子树中查找toFind结点,找到返回true，否则返回false
	 */
	public boolean findNode(BinaryTreeNode node, BinaryTreeNode toFind) {
		if (node == null || toFind == null) {
			return false;
		}
		if (node == toFind)
			return true;
		boolean isFind = findNode(node.leftChild, toFind);
		if (!isFind) {
			isFind = findNode(node.rightChild, toFind);
		}
		return isFind;
	}

	/* 判断二叉树是不是完全二叉树 */
	public boolean isCompleteTree(BinaryTreeNode node){
		if(node == null)
			return false;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			BinaryTreeNode n = queue.poll();
			if(n.leftChild != null){
				queue.add(n.leftChild);
			}else{
				break;
			}
			if(n.rightChild != null){
				queue.add(n.rightChild);
			}else{
				break;
			}
		}
		while(!queue.isEmpty()){
			BinaryTreeNode n = queue.poll();
			if(n.leftChild != null || n.rightChild == null)
				return false;
		}
		return true;
	}
	
	/* 已知前序中序遍历，重建二叉树 
	 * 采用递归实现
	 * 前序遍历的第一个是根节点，中序遍历根节点左边的是左子树，右边是右子树
	 * */
	public BinaryTreeNode reBuild(int[] pre,int[] in,int nodeNum){
		if(pre == null || in == null || nodeNum <= 0){
			return null;
		}
		BinaryTreeNode node = new BinaryTreeNode();
		node.data = pre[0];
		node.leftChild = node.rightChild = null;
		int position = -1;
		for(int i = 0;i < nodeNum;i++){
			if(in[i] == node.data){
				position = i;
				break;
			}
		}
		
		int nodeNumLeft = position;
		int[] preLeft = Arrays.copyOfRange(pre, 1, nodeNumLeft);
		int[] inLeft = Arrays.copyOf(in, nodeNumLeft);
		node.leftChild = reBuild(preLeft, inLeft, nodeNumLeft);
		
		int nodeNumRight = nodeNum - nodeNumLeft;
		int[] preRight = Arrays.copyOfRange(pre, pre.length-1-nodeNumRight, pre.length-1);
		int[] inRight = Arrays.copyOfRange(in, position+1, in.length-1);
		node.rightChild = reBuild(preRight, inRight, nodeNumRight);
		
		return node;
	}
	
	
	/* 二叉树中路径和为某个值的所有路径 
	 * 用一个临时变量保存current当前的结点和，当current和num相等，并且当前结点是叶子结点的时候，说明
	 * 找到了一条路径，就打印出来
	 * */
	public void getSumPath(BinaryTreeNode node, int current, int num,
			Stack<BinaryTreeNode> s) {
		if (node == null || node.data > num) {
			return;
		}
		current += node.data;
		s.push(node);

		boolean isLeaf = (node.leftChild == null) && (node.rightChild == null);

		if ((current == num) && isLeaf) {
			System.out.println("find a path:");
			for (BinaryTreeNode n : s) {
				System.out.print(n.data + " ");
			}
			System.out.println();
		}

		if (node.leftChild != null) {
			getSumPath(node.leftChild, current, num, s);
		}
		if (node.rightChild != null) {
			getSumPath(node.rightChild, current, num, s);
		}
		current -= node.data;
		s.pop();
	}
}
