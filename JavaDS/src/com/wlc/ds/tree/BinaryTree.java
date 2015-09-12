package com.wlc.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	public TreeNode root;

	private int size(TreeNode node) {
		if (node == null)
			return 0;
		return size(node.leftChild) + size(node.rightChild) + 1;
	}

	/* 求二叉树的结点个数 */
	public int size() {
		return size(root);
	}

	private int height(TreeNode node) {
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

	private void preOrder(TreeNode node) {
		if (node != null) {
			visit(node);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}

	public void visit(TreeNode node) {
		System.out.print(node.data + " ");
	}

	/*
	 * 层次遍历 采用队列实现，先访问根节点，在将其左孩子和右孩子加入队列
	 */
	public void levelOrder() {
		if (root == null)
			return;
		TreeNode node = root;
		Queue<TreeNode> s = new LinkedList<>();
		s.add(node);
		while (!s.isEmpty()) {
			TreeNode n = s.poll();

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

	public int getNodesNum(TreeNode node, int k) {
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

	public int getLeafNum(TreeNode node) {
		if (node == null) {
			return 0;
		}
		if (node.leftChild == null && node.rightChild == null)
			return 1;
		return getLeafNum(node.leftChild) + getLeafNum(node.rightChild);
	}

	/* 判断两棵树结构是否相同 */
	public boolean isSameTree(TreeNode node1, TreeNode node2) {
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
	public void inOrder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = node;
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
	public void toDeLinkList(TreeNode node, TreeNode first,
			TreeNode last) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = node;
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
	public boolean isAVL(TreeNode node) {
		if (node == null)
			return true;
		if (Math.abs(height(node.leftChild) - height(node.rightChild)) > 1)
			return false;
		return isAVL(node.leftChild) && isAVL(node.rightChild);
	}

	

	/* 判断二叉树是不是完全二叉树 */
	public boolean isCompleteTree(TreeNode node){
		if(node == null)
			return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			TreeNode n = queue.poll();
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
			TreeNode n = queue.poll();
			if(n.leftChild != null || n.rightChild == null)
				return false;
		}
		return true;
	}
	
	/* 已知前序中序遍历，重建二叉树 
	 * 采用递归实现
	 * 前序遍历的第一个是根节点，中序遍历根节点左边的是左子树，右边是右子树
	 * */
	public TreeNode reBuild(int[] pre,int[] in,int nodeNum){
		if(pre == null || in == null || nodeNum <= 0){
			return null;
		}
		TreeNode node = new TreeNode();
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
	
	
	/* 打印二叉树中路径和为某个值的所有路径 
	 * 用一个临时变量保存current当前的结点和，当current和num相等，并且当前结点是叶子结点的时候，说明
	 * 找到了一条路径，就打印出来
	 * */
	public void getSumPath(TreeNode node, int current, int num,
			Stack<TreeNode> s) {
		if (node == null || node.data > num) {
			return;
		}
		current += node.data;
		s.push(node);

		boolean isLeaf = (node.leftChild == null) && (node.rightChild == null);

		if ((current == num) && isLeaf) {
			System.out.println("find a path:");
			for (TreeNode n : s) {
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
	
	/**
	 * 将有序数组转换为一个高度最小的二叉查找树
	 * 每次取数组的中间值作为根节点
	 */
	static TreeNode createMinBST(int[] arr,int start,int end){
		if(start <= end){
			int mid = (start+end)>>>1;
		System.out.println(mid);
			TreeNode root = new TreeNode(arr[mid]);
			root.leftChild = createMinBST(arr, start, mid-1);
			root.rightChild = createMinBST(arr, mid+1, end);
			return root;
		}
		return null;
	}
	
	static TreeNode createMinBST(int[] arr){
		return createMinBST(arr, 0, arr.length-1);
	}
	
	/**
	 * 求二叉树的宽度
	 * 对二叉树进行层次遍历，使用temp保存每一层的结点数
	 * num保存下一层的结点数，levelNodesNum为上一层的结点数，每出队列一个结点，levelNodesNum减1，
	 * 直到为0，num累加停止，num即为下一层的结点数，存到temp中
	 * 最后返回temp中最大的即为树的宽度
	 */
	public static int getTreeWidth(TreeNode root){
		if(root == null)
			return 0;
		List<Integer> temp = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		temp.add(1);
		int levelNodesNum = 1;
		int num = 0;
		
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			if(levelNodesNum > 0){
				levelNodesNum--;
			}else{
				levelNodesNum = num;
				num = 0;
				temp.add(levelNodesNum);
			}
			
			if(node.leftChild != null){
				num++;
				q.offer(node.leftChild);
			}
			if(node.rightChild != null){
				num++;
				q.offer(node.rightChild);
			}
		}
		
		return Collections.max(temp);
	}
	
	
}
