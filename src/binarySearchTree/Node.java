package binarySearchTree;

/**
 * @author Arnaldo Quintero Segura
 * Class that holds the Nodes for any object
 * with two children, all of the same type T
 * @param <T> Type of the elements of the Node.
 */
public class Node<T> {
	/**
	 * Variable that holds the current value of the Node.
	 */
	private T value;
	/**
	 * Variable that holds the pointer to the left child Node.
	 */
	private Node<T> left;
	/**
	 * Variable that holds the pointer to the right child Node.
	 */
	private Node<T> right;
	
	/**
	 * Initializes the node with the given value
	 * @param value to be set in the new node
	 */
	public Node(T value) {
		this.value = value;
	}
	
	/**
	 * Function that gets the current value of the Node.
	 * @return the value of the Node.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Function that gets the left child Node of the current Node.
	 * @return The left child of the Node
	 */
	public Node<T> getLeft() {
		return left;
	}
	
	/**
	 * Function that gets the right child Node of the current Node.
	 * @return The right child of the Node
	 */
	public Node<T> getRight() {
		return right;
	}
	
	/**
	 * Function that sets the value of the current Node.
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	/**
	 * Function that sets the left child Node of the current Node.
	 */
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	
	/**
	 * Function that sets the right child Node of the current Node.
	 */
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	/**
	 * Function that determines how many children have the Node
	 * @return amount of children, zero one or two
	 */
	public int children() {
		int result = 0;
		if (left != null) result++;
		if (right != null) result++;
		return result;
	};
}
