package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementaryTest {
    int a[]= new int [10000];
    int b[]= new int [10000];
    int c[]= new int [10000];
    int d[]= new int [10000];
    int e[]= new int [10000];
    int f[]= new int [10000];

    @Test
    void test() {

        util.Utility.fill(a,5000);
        util.Utility.fill(b,5000);
        util.Utility.fill(c,5000);
        util.Utility.fill(d,5000);
        util.Utility.fill(e,5000);
        util.Utility.fill(f,5000);
        System.out.println("Arrray A content\n "+util.Utility.show(a,200));
        System.out.println("Arrray B content\n "+util.Utility.show(b,200));
        System.out.println("Arrray C content\n "+util.Utility.show(c,200));
        System.out.println("Arrray D content\n "+util.Utility.show(d,200));
        System.out.println("Arrray E content\n "+util.Utility.show(e,200));
        System.out.println("Arrray F content\n "+util.Utility.show(f,200));

        Elementary elementary = new Elementary();
        System.out.println("Esta ordenado: "+ isSorted(a));
        if(!isSorted(a)){
            elementary.improvedBubbleSort(a);
            System.out.println("\nArrray content Improve Bubble Sort\n "+util.Utility.show(a,200));
        }
        System.out.println("Esta ordenado: "+ isSorted(a));
        System.out.println("Esta ordenado: "+ isSorted(b));
        if(!isSorted(b)){
            elementary.bubbleSort(b);
            System.out.println("\nArrray content Improve Bubble Sort\n "+util.Utility.show(b,200));
        }
        System.out.println("Esta ordenado: "+ isSorted(b));
        System.out.println("Esta ordenado: "+ isSorted(c));
        if(!isSorted(c)){
            elementary.selectionSort(c);
            System.out.println("\nArrray content Improve Bubble Sort\n "+util.Utility.show(c,200));
        }
        System.out.println("Esta ordenado: "+ isSorted(c));
        System.out.println("Esta ordenado: "+ isSorted(d));
        if(!isSorted(d)){
            elementary.improvedBubbleSort(d);
            System.out.println("\nArrray content Improve Bubble Sort\n "+util.Utility.show(d,200));
        }
        System.out.println("Esta ordenado: "+ isSorted(d));
        System.out.println("Esta ordenado: "+ isSorted(e));
        if(!isSorted(e)){
            elementary.improvedBubbleSort(e);
            System.out.println("\nArrray content Improve Bubble Sort\n "+util.Utility.show(e,200));
        }
        System.out.println("Esta ordenado: "+ isSorted(e));
        System.out.println("Esta ordenado: "+ isSorted(f));
        if(!isSorted(f)){
            elementary.improvedBubbleSort(f);
            System.out.println("\nArrray content Improve Bubble Sort\n "+util.Utility.show(f,200));
        }
        System.out.println("Esta ordenado: "+ isSorted(f));

        Search search = new Search();
        for (int i = 0; i < 30; i++) {
            int value= util.Utility.random(5000);
            if (search.binarySearch(a,value)==-1){
                System.out.println("the value "+value+" not exist");

            }else {
                System.out.println("the value "+value+" exist in position "+search.linearSearch(f,value));

            }
            if (search.binarySearch(b,value)==-1){
                System.out.println("the value "+value+" not exist");

            }else {
                System.out.println("the value "+value+" exist in position "+search.linearSearch(f,value));

            }
            if (search.binarySearch(c,value)==-1){
                System.out.println("the value "+value+" not exist");

            }else {
                System.out.println("the value "+value+" exist in position "+search.linearSearch(f,value));

            }
            if (search.binarySearch(d,value)==-1){
                System.out.println("the value "+value+" not exist ");

            }else {
                System.out.println("the value "+value+" exist in position "+search.linearSearch(f,value));

            }
            if (search.binarySearch(e,value)==-1){
                System.out.println("the value "+value+" not exist ");

            }else {
                System.out.println("the value "+value+" exist in position "+search.linearSearch(f,value));

            }
            if (search.binarySearch(f,value)==-1){
                System.out.println("the value "+value+" not exist ");

            }else {
                System.out.println("the value "+value+" exist in position "+search.linearSearch(f,value));

            }


        }


    }

    private boolean isSorted(int[] a) {
        int i= a.length;
        for (int j = 0; j < i-1; j++) {
            if (util.Utility.compare(a[j],a[j+1])>0){ return false;}
        }
        return true;

    }

//    @Test
//    void testClase() {
//        int a[]= new int [10000];
//        util.Utility.fill(a,5000);
//        System.out.println("Arrray content\n "+util.Utility.show(a,200));
//        Elementary elementary = new Elementary();
//        System.out.println("Esta ordenado: "+ isSorted(a));
//        if(!isSorted(a)){
//            elementary.improvedBubbleSort(a);
//            System.out.println("\nArrray content Improve Bubble Sort\n "+util.Utility.show(a,200));
//        }
//        System.out.println("Esta ordenado: "+ isSorted(a));
//
//
//    }


}