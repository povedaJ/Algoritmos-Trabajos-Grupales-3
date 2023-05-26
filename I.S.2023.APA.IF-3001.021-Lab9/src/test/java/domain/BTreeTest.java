package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTreeTest {

    @Test
    void test() {
        BTree bTree = new BTree();

        SinglyLinkedList singly = new SinglyLinkedList();
        SinglyLinkedList singly2 = new SinglyLinkedList();
        ArrayStack array = new ArrayStack(20);
        LinkedQueue linked = new LinkedQueue();
        BTree bTree2 = new BTree();
        BTree bTree3 = new BTree();


        try {
            for (int i = 0; i < 20; i++) {
                singly.add(util.Utility.random(50));
                singly2.add(util.Utility.random(100));
                array.push(util.Utility.getPerson());
                linked.enQueue(util.Utility.random(50));
                bTree2.add(util.Utility.getAlphabet());
                bTree3.add(util.Utility.getAlphabet());
            }
            bTree.add(singly);
            bTree.add(singly2);
            bTree.add(array);
            bTree.add(linked);
            bTree.add(bTree2);

            System.out.println(bTree.toString());

            System.out.println("\nSize Method");
            System.out.println("The size of the tree is: [" + bTree.size() + "]");

            System.out.println("\nHeight Method");
            System.out.println("The height of the tree is: [" + bTree.height() + "]");

            System.out.println("\nHeight(element) Method");
            System.out.println("The height of the element [singly] is: [" + bTree.height(singly) + "]");
            System.out.println("The height of the element [linked] is: [" + bTree.height(linked) + "]");
            System.out.println("The height of the element [bTree2] is: [" + bTree.height(bTree2) + "]");
            System.out.println("The height of the element [array] is: [" + bTree.height(array) + "]");
            System.out.println("The height of the element [singly2] is: [" + bTree.height(singly2) + "]");

            System.out.println("\nContains Method");

            System.out.println("Is there array in the bTree? " + bTree.contains(array));
            System.out.println("Is there linked in the bTree? " + bTree.contains(linked));
            System.out.println("Is there bTree3 in the bTree? " + bTree.contains(bTree3));


            System.out.println("\nRemove Method");
            System.out.println("Singly2 removed from BTree");
            System.out.println("bTree2 removed from BTree");

            bTree.remove(singly2);
            bTree.remove(bTree2);


            System.out.println(bTree.toString());

            System.out.println("\nHeight(element) Method");
            System.out.println("The height of the element [singly] is: [" + bTree.height(singly) + "]");
            System.out.println("The height of the element [singly2] is: [" + bTree.height(singly2) + "]");
            System.out.println("The height of the element [array] is: [" + bTree.height(array) + "]");
            System.out.println("The height of the element [linked] is: [" + bTree.height(linked) + "]");
            System.out.println("The height of the element [bTree2] is: [" + bTree.height(bTree2) + "]");


        } catch (StackException e) {
            throw new RuntimeException(e);
        } catch (QueueException e) {
            throw new RuntimeException(e);
        } catch (TreeException e) {
            throw new RuntimeException(e);
        }


    }

//    @Test
//    void test() {
//        BTree bTree = new BTree();
//        try {
//            //bTree.add(10);
//            //bTree.add(20);
//            for (int i = 0; i < 10; i++) {
//                bTree.add(util.Utility.random(50));
//            }
//            System.out.println(bTree);
//            System.out.println("BTree size: "+bTree.size());
//            for (int i = 0; i <10 ; i++) {
//                int value = util.Utility.random(50);
//                boolean contains = bTree.contains(value);
//                System.out.println(contains
//                        ?"The value ["+value+"] exists. Height: "+bTree.height(value)
//                        :"The value ["+value+"] does not exist");
//                if(contains){
//                    System.out.println("The value ["+value+"] was removed");
//                    bTree.remove(value);
//                }
//            }
//            System.out.println("Tree height: "+bTree.height());
//            System.out.println(bTree);
//
//
//
//        } catch (TreeException e) {
//            throw new RuntimeException(e);
//        }
//    }

}