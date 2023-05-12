package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementaryTest {

    @Test
    void test() {
        int a[]= new int [10000];
        util.Utility.fill(a,5000);
        System.out.println("Arrray content\n "+util.Utility.show(a,200));
        Elementary elementary = new Elementary();
        System.out.println("Esta ordenado: "+ isSorted(a));
        if(!isSorted(a)){
            elementary.improvedBubbleSort(a);
            System.out.println("\nArrray content Improve Bubble Sort\n "+util.Utility.show(a,200));
        }
        System.out.println("Esta ordenado: "+ isSorted(a));


    }

    private boolean isSorted(int[] a) {
        int i= a.length;
        for (int j = 0; j < i-1; j++) {
            if (util.Utility.compare(a[j],a[j+1])>0){ return false;}
            }
            return true;

    }
}