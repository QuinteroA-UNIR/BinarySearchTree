package binarySearchTree;

public class MainExample {

	public static void main(String[] args) {
		System.out.println("--------------------------------------------------");
		System.out.println("Casos de pruba de Arbol Binario de Busqueda (ABB):");
		System.out.println("--------------------------------------------------");
		System.out.println();
		
		System.out.println("+- Creación de un ABB vacio:");
		BinarySearchTree bst = new BinarySearchTree();
		bst.printTree();
		System.out.println();
		
		System.out.println("+- Agregacion de elementos:");
		int[] elem = {8,3,10,1,6,4,7,5,14,13};
		for (int x : elem) {
			System.out.println("  - Agregar elemento: " + x);
			bst.insert(x);
		}
		bst.printTree();
		System.out.println();
		
		System.out.println("+- Agregacion de elemento duplicado:");
		System.out.println("  - Agregar elemento: 3");
		bst.printTree();
		System.out.println();
		
		
		boolean res;
		System.out.println("+- Revisar elementos dentro del ABB:");
		res = bst.contains(10);
		System.out.println("  - Buscar elemento 10 => " + res);
		res = bst.contains(13);
		System.out.println("  - Buscar elemento 13 => " + res);
		res = bst.contains(0);
		System.out.println("  - Buscar elemento 0 => " + res);
		res = bst.contains(20);
		System.out.println("  - Buscar elemento 20 => " + res);
		System.out.println();
		
		System.out.println("+- Eliminar elementos del ABB:");
		System.out.println("  - Eliminar con dos hijos: 3");
		bst.delete(3);
		bst.printTree();
		System.out.println("  - Eliminar elemento con un hijo: 14");
		bst.delete(14);
		bst.printTree();
		System.out.println("  - Eliminar elemento sin hijos: 5");
		bst.delete(5);
		bst.printTree();
		System.out.println("  - Eliminar elemento inexistente: 0");
		bst.delete(0);
		bst.printTree();
		System.out.println();
		
		System.out.println("+- Recorridos al arbol:");
		System.out.println("  - Pre-Orden: " + bst.preOrder());
		System.out.println("  - In-Orden: " + bst.inOrder());
		System.out.println("  - Post-Orden: " + bst.postOrder());
		System.out.println();
		
		System.out.println("+- Impresion directa de recorridos al arbol:");
		System.out.print("  - ");
		bst.print("pre");
		System.out.print("  - ");
		bst.print("in");
		System.out.print("  - ");
		bst.print("post");
	}

}
