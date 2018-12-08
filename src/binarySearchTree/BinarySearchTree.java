package binarySearchTree;

import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {
	
	private Node<Integer> root;

	public BinarySearchTree() {
		
	}
	
	public void insert(int val) {
		root = this.insert(root,val);
	}
	
	public void print(int val) {
		Queue<Integer> queue = new LinkedList<Integer>();
		switch (val) {
		case -1:
			preOrder(queue,root);
			System.out.println(queue);
			return;
		case 0:
			inOrder(queue,root);
			System.out.println(queue);
			return;
		case 1:
			postOrder(queue,root);
			System.out.println(queue);
			return;
		default:
			System.out.println("Invalid");
		}
	}
	
	private Node<Integer> insert(Node<Integer> node, int val) {
		
		if (node == null) {
			return new Node<Integer>(val);
		}
		
		if (val < node.getValue()) {
			node.setLeft(this.insert(node.getLeft(), val));
		} else if (val > node.getValue()) {
			node.setRight(this.insert(node.getRight(), val));
		}
		return node;
		
	}
	
	private void preOrder(Queue<Integer> queue, Node<Integer> node) {
		
		if (node == null) {
			return;
		} else {
			queue.add(node.getValue());
			this.preOrder(queue, node.getLeft());
			this.preOrder(queue, node.getRight());
		}

	}
	
	private void inOrder(Queue<Integer> queue, Node<Integer> node) {
		
		if (node == null) {
			return;
		} else {
			this.inOrder(queue, node.getLeft());
			queue.add(node.getValue());
			this.inOrder(queue, node.getRight());
		}

	}
	
	private void postOrder(Queue<Integer> queue, Node<Integer> node) {
		
		if (node == null) {
			return;
		} else {
			this.postOrder(queue, node.getLeft());
			this.postOrder(queue, node.getRight());
			queue.add(node.getValue());
		}

	}
}
