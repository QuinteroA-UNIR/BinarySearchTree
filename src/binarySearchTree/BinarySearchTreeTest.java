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
		System.out.println(t.contains(6));
		System.out.println(t.contains(2));
		System.out.println(t.contains(7));
		System.out.println(t.contains(-1));
		System.out.println(t.contains(0));
		
		
		
		BinarySearchTree s = new BinarySearchTree();
		int[] x = {8,3,10,1,6,4,7,5,14,13};
		for (int i : x) {
			s.insert(i);
		}
		s.print(0);
		System.out.println(t.contains(3));
		s.delete(3);
		s.print(0);
		System.out.println(t.contains(3));
		s.delete(10);
		s.print(1);
		System.out.println(t.contains(10));
	}

}
