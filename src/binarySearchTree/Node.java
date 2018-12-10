package binarySearchTree;

public class Node<T> {
	private T value;
	private Node<T> left;
	private Node<T> right;
	
	public int children() {
		int result = 0;
		if (left != null) result++;
		if (right != null) result++;
		return result;
	};
	
	public Node(T value) {
		this.value = value;
	}

	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}
