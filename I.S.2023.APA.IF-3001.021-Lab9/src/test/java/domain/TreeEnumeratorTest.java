package domain;

import org.junit.jupiter.api.Test;

public class TreeEnumeratorTest {
    @Test
    public void test1 (){
        // Crear un árbol binario de ejemplo
        BTree binaryTree = new BTree();
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(8);
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(9);
        binaryTree.add(10);

        // Crear una instancia de TreeEnumerator
        TreeEnumerator enumerator = new TreeEnumerator();

        // Probar el recorrido PreOrder
        System.out.println("PreOrder Enumeration:");
        String preOrderEnumeration = enumerator.enumeratePreOrder(binaryTree.getRoot());
        System.out.println(preOrderEnumeration);

        // Probar el recorrido InOrder
        System.out.println("InOrder Enumeration:");
        String inOrderEnumeration = enumerator.enumerateInOrder(binaryTree.getRoot());
        System.out.println(inOrderEnumeration);

        // Probar el recorrido PostOrder
        System.out.println("PostOrder Enumeration:");
        String postOrderEnumeration = enumerator.enumeratePostOrder(binaryTree.getRoot());
        System.out.println(postOrderEnumeration);
    }
}