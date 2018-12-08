package binarySearchTree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	@Test
	void test() {
		BinarySearchTree t = new BinarySearchTree();
		t.print(-1);
		t.insert(6);
		t.print(-1);
		t.insert(2);
		t.insert(7);
		t.insert(1);
		t.insert(4);
		t.insert(3);
		t.insert(5);
		t.insert(9);
		t.insert(8);
		t.print(-1);
		t.print(0);
		t.print(1);
	}

}
