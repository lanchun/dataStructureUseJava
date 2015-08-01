package com.wlc.ds.tree;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

	public BinaryTree create() {

		BinaryTreeNode[] nodes = new BinaryTreeNode[5];

		for (int i = 0; i < 5; i++) {
			nodes[i] = new BinaryTreeNode(i);
		}
		BinaryTreeNode nn = new BinaryTreeNode(5);

		BinaryTree tree = new BinaryTree();
		tree.root = nodes[0];
		nodes[0].leftChild = nodes[1];
		nodes[0].rightChild = nodes[2];
		nodes[2].leftChild = nn;
		nodes[1].leftChild = nodes[3];
		nodes[1].rightChild = nodes[4];
		return tree;

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
		BinaryTreeNode first = null, last = null;
		tree.toDeLinkList(tree.root, first, last);
	}

	@Test
	public void testIsAVL() {
		Assert.assertTrue(tree.isAVL(tree.root));
	}

	@Test
	public void testgetSumPath() {
		Stack<BinaryTreeNode> s = new Stack<>();
		tree.getSumPath(tree.root, 0, 5, s);
	}
	
	@Test
	public void testIsCompleteTree(){
		Assert.assertEquals(true, tree.isCompleteTree(tree.root));
	}
}
