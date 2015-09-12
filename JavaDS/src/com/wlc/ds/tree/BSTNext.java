package com.wlc.ds.tree;

/**
 * 查找二叉查找树中指定结点的下一个结点
 * 
 * @author lanchun
 *
 */
public class BSTNext {
	public static TreeNode bstNext(TreeNode n) {
		if(n ==null)
			return null;
		if(n.rightChild != null){
			return leftMostChild(n.rightChild);
		}else{
			TreeNode q = n;
			TreeNode x = q.parent;
			while(x!=null&&x.leftChild!=q){
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
}
