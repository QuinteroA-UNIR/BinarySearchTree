package binarySearchTree;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author Arnaldo Quintero Segura
 * Class that implements a Binary Search Tree
 */
public class BinarySearchTree {
	
	
	/**
	 * Variable that holds the root of the tree.
	 */
	private Node<Integer> root;

	/**
	 * Constructor of the BST class
	 */
	public BinarySearchTree() { }
	
	/**
	 * Function that prints the list of elements being
	 * traversed in a specified mode.
	 * If no mode is passed, or an invalid value, In-Order is used.
	 * @param mode of the printing
	 */
	public void print(String mode) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		switch (mode) {
		case "pre":
			preOrder(queue,root);
			System.out.println("Pre-Order: " + queue);
			break;
		case "post":
			postOrder(queue,root);
			System.out.println("Post-Order: " + queue);
			break;
		default:
			inOrder(queue,root);
			System.out.println("In-Order: " + queue);
			break;
		}
	}
	
	/**
	 * Function that prints the tree structure itself.
	 */
	public void printTree() {
		print(root,"");
	}
	
	/**
	 * Function that tree nodes recursively as one big structure.
	 */
	private void print(Node<Integer> root, String prefix) {
	    if (root == null) {
	    	if (prefix.equals("")) {
	    		System.out.println("Empty Tree");
	    	}
	    	return;
	    }

	    System.out.println(prefix + "+- " + root.getValue());
	    print(root.getLeft(), prefix + "L  ");
	    print(root.getRight(), prefix + "R  ");
	}
	
	
	/**
	 * Function that inserts a new value into the bst.
	 * @param val to be inserted
	 * @return boolean value, true if successful, false otherwise
	 */
	public boolean insert(int val) {
		boolean result = true;
		try {
			root = this.insert(root,val);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	
	/**
	 * Function that checks if a given element is contained inside of the bst
	 * @param val to be found on the bst
	 * @return true if contained in the tree, false otherwise
	 */
	public boolean contains(int val) {
		return this.find(root, val) != null;
	}
	
	/**
	 * Function that deletes a given element from the bst
	 * @param val to be deleted
	 * @return true if successfully deleted, false otherwise
	 */
	public boolean delete(int val) {
		boolean result = true;
		try {
			this.delete(root,val);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	/**
	 * Function that return a Queue with the result of the 
	 * preOrder traverse of the bst 
	 * @return queue with the preOrder traverse
	 */
	public Queue<Integer> preOrder(){
		Queue<Integer> q = new LinkedList<Integer>();
		preOrder(q,root);
		return q;
	}
	
	/**
	 * Function that return a Queue with the result of the 
	 * inOrder traverse of the bst 
	 * @return queue with the inOrder traverse
	 */
	public Queue<Integer> inOrder(){
		Queue<Integer> q = new LinkedList<Integer>();
		inOrder(q,root);
		return q;
	}
	
	/**
	 * Function that return a Queue with the result of the 
	 * postOrder traverse of the bst 
	 * @return queue with the postOrder traverse
	 */
	public Queue<Integer> postOrder(){
		Queue<Integer> q = new LinkedList<Integer>();
		postOrder(q,root);
		return q;
	}
	
	/**
	 * Function that recursively seeks for a value and deletes it
	 * from the bst.
	 * @param node being looked
	 * @param val to be deleted
	 * @return new node with the deletion done
	 */
	private Node<Integer> delete(Node<Integer> node, int val){
		if (node == null) return node;
		
		if (val > node.getValue()) {
			node.setRight(this.delete(node.getRight(), val));
			return node;
		} else if (val < node.getValue()) {
			node.setLeft(this.delete(node.getLeft(), val));
			return node;
		} else {
			if (node.children() == 0) {
				return null;
			} else if (node.children() == 1) {
				return node.getLeft() != null ? node.getLeft() : node.getRight();
			} else {
				Node<Integer> succesor = this.mostLeftChild(node.getRight());
				int succesorValue = succesor.getValue();
				node.setValue(succesorValue);
				node.setRight(this.delete(node.getRight(),succesorValue));
			}
		}
		return node;
	}
	
	/**
	 * Function that finds the most left child of a given node
	 * @param node to look at
	 * @return the most left child of a node. its sucessor.
	 */
	private Node<Integer> mostLeftChild(Node<Integer> node) {
		if (node.getLeft() == null) {
			return node;
		} else {
			return this.mostLeftChild(node.getLeft());
		}
	}
	
	/**
	 * Function that recursively looks for a given value
	 * @param node looking at
	 * @param val to be searched
	 * @return the node that contains the given value
	 */
	private Node<Integer> find(Node<Integer> node, int val) {
		if (node == null || node.getValue() == val) {
			return node;
		} else if (val > node.getValue()) {
			return this.find(node.getRight(), val);
		} else {
			return this.find(node.getLeft(), val);
		}
	}
	
	/**
	 * Function that inserts a given value into the bst
	 * @param node to start looking where to insert
	 * @param val to be inserted
	 * @return the node with the new value inserted
	 */
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
	
	/**
	 * Function that traverses the bst recursively in a pre-order way
	 * and adds its values into a queue
	 * @param queue of the bst traverse
	 * @param node being traversed
	 */
	private void preOrder(Queue<Integer> queue, Node<Integer> node) {
		
		if (node == null) {
			return;
		} else {
			queue.add(node.getValue());
			this.preOrder(queue, node.getLeft());
			this.preOrder(queue, node.getRight());
		}

	}
	
	/**
	 * Function that traverses the bst recursively in a in-order way
	 * and adds its values into a queue
	 * @param queue of the bst traverse
	 * @param node being traversed
	 */
	private void inOrder(Queue<Integer> queue, Node<Integer> node) {
		
		if (node == null) {
			return;
		} else {
			this.inOrder(queue, node.getLeft());
			queue.add(node.getValue());
			this.inOrder(queue, node.getRight());
		}

	}
	
	/**
	 * Function that traverses the bst recursively in a post-order way
	 * and adds its values into a queue
	 * @param queue of the bst traverse
	 * @param node being traversed
	 */
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
