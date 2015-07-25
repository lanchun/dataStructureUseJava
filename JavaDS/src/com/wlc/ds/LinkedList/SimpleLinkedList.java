package com.wlc.ds.linkedList;

import java.util.HashSet;
import java.util.Set;

import com.wlc.ds.Node;

/**
 * 简单链表实现
 * 
 * @author lanchun
 * 
 * @param <T>
 */
class SimpleLinkedList<T> {
	public Node<T> first = null;

	public int size = 0;

	// 插入元素，头插法
	public void insert(Node<T> node) {
		if(node == null)
			return;
		
		node.next = first;
		first = node;
		++size;
	}

	// 是否存在指定元素
	public boolean contains(T t) {
		Node<T> n = first;
		while (n.item != t && n.next != null) {
			n = n.next;
		}
		if (n.item == t)
			return true;
		return false;
	}

	//将链表反转
	public void reverse(){
		Node<T> node = first;
		Node<T> newNode = new Node<T>(first.item, null);
		
		while(node.next != null){
			node = node.next;
			Node<T> newFirst = new Node<T>(node.item, newNode);
			newNode = newFirst;
		}
		first = newNode;
	}
	/** 
	 * 删除重复元素
	 * 遍历链表，从第一个结点开始，将其与后面的结点比较，有相同的就删除第一个结点
	 */
	public void deleteDups() {
		Node<T> node = first;
		Node<T> pre = first;

		while (node != null) {
			Node<T> node2 = node.next;
			while (node2 != null && node.item != node2.item) {
				node2 = node2.next;
			}

			if (node2 == null) {
				// 没有重复的元素
				pre = node;
				node = node.next;
			} else {
				/**
				 * 找到重复元素,删除第一个
				 */

				if (node == pre) {
					// 如果是第一个元素
					node = node.next;
					pre = node;
					first = pre;
				} else {
					pre.next = node.next;
					node.next = null;
					node = pre.next;
				}
				size--;
			}
		}
	}

	/**
	 * 判断链表是否有环
	 * 使用一个集合来保存已经访问过的结点，遍历链表，判断该结点是否在集合中，如果不在，将其加入，在则说明有环
	 */
	
	public boolean existLoop(){
		if(first == null)
			return false;
		Node<T> node = first;
		Set<Node<T>> visited = new HashSet<>();
		visited.add(node);
		while(node.next != null){
			node = node.next;
			if(visited.contains(node)){
				return true;
			}else{
				visited.add(node);
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> node = first;
		while (node != null) {
			sb.append(node.item);
			sb.append("->");
			node = node.next;
		}
		sb.delete(sb.length()-2,sb.length());
		return sb.toString();
	}

}
