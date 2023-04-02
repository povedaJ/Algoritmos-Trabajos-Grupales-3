package domain;

import org.testng.annotations.Test;

import java.util.ArrayList;

import java.util.Collections;


import static org.testng.Assert.*;

public class DivideAndConquerTest {


    // test general de BS en arrays, collections, domain
    @Test
    public void testBinarySearch() {

        Vector vector= new Vector(50);
        util.Utility.fill(vector);
        System.out.println(vector.toString()+"\n");
        vector.sort();
        System.out.println("SORTED VECTOR\n"+vector.toString()+"\n");
        //System.out.println("metodo get ...."+vector.get(0));
        System.out.println("BINARY SEARCH TEST\n");
        for (int i = 0; i < 20; i++) {
            int value= util.Utility.random(99);
            //java.util.Arrays
            int indexArrays= java.util.Arrays.binarySearch(vector.getData(),value);

            System.out.println(
                    indexArrays>=0
                            ?"java.util.Arrays class BS... the element ["+value+"] exist at the position "+indexArrays
                            :"java.util.Arrays class BS... the element ["+value+"] does not exist in vector"
                    );


            //java.util.collection
            indexArrays= Collections.binarySearch(getDataList(vector),value);

            System.out.println(
                    indexArrays>=0
                            ?"java.util.collections BS... the element ["+value+"] exist at the position "+indexArrays
                            :"java.util.collections  BS... the element ["+value+"] does not exist in vector"
            );


            indexArrays= domain.DivideAndConquer.binarySearch(vector.getData(), value);

            System.out.println(
                    indexArrays>=0
                            ?"domain.DivideAndConquer.BS (iterative ) ["+value+"] exist at the position "+indexArrays
                            :"domain.DivideAndConquer.BS (iterative ) ["+value+"] does not exist in vector "

            );

             indexArrays= domain.DivideAndConquer.binarySearchRecursive(vector.getData(), value,0,vector.size()-1);

            System.out.println(
                    indexArrays>=0 && indexArrays<50
                            ?"domain.DivideAndConquer.BS (recursive ) ["+value+"] exist at the position "+indexArrays+"\n"
                            :"domain.DivideAndConquer.BS (recursive ) ["+value+"] does not exist in vector\n"
            );

        }//for 20
    }
    public ArrayList<Integer> getDataList(Vector v) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < v.size(); i++) {
            list.add((int) v.get(i)) ;
        }
        return list;
    }

    @Test
    public void testOwnBinarySearch() {
        Vector vector= new Vector(50);
        util.Utility.fill(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());

        System.out.println("BINARY SEARCH TEST");
        for (int i = 0; i < 20; i++) {
            int value= util.Utility.random(99);
            //java.util.Arrays
            int indexArrays= domain.DivideAndConquer.binarySearch(vector.getData(), value);

            System.out.println(
                    indexArrays>=0
                            ?"domain.DivideAndConquer.binarySearch (iterative )["+value+"] exist at the position "+indexArrays
                            :"domain.DivideAndConquer.binarySearch (iterative )["+value+"] does not exist in vector "

            );


        }
    }
    @Test
    public void testOwnBinarySearch2() {
        Vector vector= new Vector(50);
        util.Utility.fill(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());

        System.out.println("BINARY SEARCH TEST");
        for (int i = 0; i < 20; i++) {
            int value= util.Utility.random(99);
            //java.util.Arrays
            int indexArrays= domain.DivideAndConquer.binarySearchRecursive(vector.getData(), value,0,vector.size()-1);

            System.out.println(
                    indexArrays>=0 && indexArrays<50
                            ?"domain.DivideAndConquer.binarySearch (recursive )["+value+"]exist at the position"+indexArrays
                            :"domain.DivideAndConquer.binarySearch (recursive )["+value+"] does not exist in vector"
            );

        }
    }

}