package com.wlc.ds.tree;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

	public BinaryTree create() {

		TreeNode[] nodes = new TreeNode[9];

		for (int i = 0; i < 9; i++) {
			nodes[i] = new TreeNode(i);
		}

		BinaryTree tree = new BinaryTree();
		tree.root = nodes[0];
		nodes[0].leftChild = nodes[1];
		nodes[0].rightChild = nodes[2];
		nodes[1].leftChild = nodes[3];
		nodes[1].rightChild = nodes[4];
		nodes[2].leftChild = nodes[5];
		nodes[2].rightChild = nodes[6];
		nodes[5].leftChild = nodes[7];
		nodes[5].rightChild = nodes[8];
		return tree;
		
	}

	public TreeNode creatTree(){
		TreeNode root = new TreeNode(10);
		TreeNode n1 = new TreeNode(15);
		TreeNode n2 = new TreeNode(12);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(7);
		root.leftChild = n1;
		root.rightChild = n2;
		n1.leftChild = n3;
		n1.rightChild = n4;
		return root;
	}
	
	BinaryTree tree = create();

	@Test
	public void testSize() {

		Assert.assertEquals(5, tree.size());
	}

	@Test
	public void testHeight() {
		tree.preOrder();
		tree.levelOrder();
		Assert.assertEquals(3, tree.height());
	}

	@Test
	public void testGetNodesNum() {
		Assert.assertEquals(2, tree.getNodesNum(3));
	}

	@Test
	public void testGetLeafNum() {
		Assert.assertEquals(3, tree.getLeafNum());
	}

	@Test
	public void testInOrder() {
		tree.inOrder(tree.root);
	}

	@Test
	public void testToDeLinkList() {
		TreeNode first = null, last = null;
		tree.toDeLinkList(tree.root, first, last);
	}

	@Test
	public void testIsAVL() {
		Assert.assertTrue(tree.isAVL(tree.root));
	}

	@Test
	public void testgetSumPath() {
		Stack<TreeNode> s = new Stack<>();
		//tree.getSumPath(tree.root, 0, 5, s);
		TreeNode root = creatTree();
		tree.getSumPath(root, 0, 22, s);
	}
	
	@Test
	public void testIsCompleteTree(){
		Assert.assertEquals(true, tree.isCompleteTree(tree.root));
	}
	
	@Test
	public void testCreateMinBST(){
		int[] arr = {1,2,3,4,5,6,7,8,9};
		TreeNode root = BinaryTree.createMinBST(arr);
		tree.inOrder(root);
	}
	
	@Test
	public void testGetTreeWidth(){
		System.out.println(BinaryTree.getTreeWidth(tree.root));
	}
	
}
