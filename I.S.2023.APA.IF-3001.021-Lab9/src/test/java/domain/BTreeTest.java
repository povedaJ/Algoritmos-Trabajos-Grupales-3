package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTreeTest {

    @Test
    void test() {
        BTree bTree = new BTree();
        try {
            //bTree.add(10);
            //bTree.add(20);
            for (int i = 0; i < 10; i++) {
                bTree.add(util.Utility.random(50));
            }
            System.out.println(bTree);
            System.out.println("BTree size: "+bTree.size());
            for (int i = 0; i <10 ; i++) {
                int value = util.Utility.random(50);
                boolean contains = bTree.contains(value);
                System.out.println(contains
                        ?"The value ["+value+"] exists. Height: "+bTree.height(value)
                        :"The value ["+value+"] does not exist");
                if(contains){
                    System.out.println("The value ["+value+"] was removed");
                    bTree.remove(value);
                }
            }
            System.out.println("Tree height: "+bTree.height());
            System.out.println(bTree);


        } catch (TreeException e) {
            throw new RuntimeException(e);
        }
    }
}