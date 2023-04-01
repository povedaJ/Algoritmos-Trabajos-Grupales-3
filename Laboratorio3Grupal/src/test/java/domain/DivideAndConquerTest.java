package domain;

import org.testng.annotations.Test;
import domain.DivideAndConquer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.testng.Assert.*;

public class DivideAndConquerTest {

    @Test
    public void testBinarySearch() {
        Vector vector= new Vector(50);
        util.Utility.fill(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());

        System.out.println("BINARY SEARCH TEST");
        for (int i = 0; i < 20; i++) {
            int value= util.Utility.random(99);
            //java.util.Arrays
            int indexArrays= java.util.Arrays.binarySearch(vector.getData(),value);

            System.out.println(
                    indexArrays>=0
                            ?"java.util.Arrays.binarySearch the element["+value+"]exist at the position"+indexArrays
                            :"java.util.Arrays.binarySearch the element["+value+"] does not exist in vector"
                    );

        }
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
                            ?"domain.DivideAndConquer.binarySearch (iterative )["+value+"]exist at the position"+indexArrays
                            :"domain.DivideAndConquer.binarySearch (iterative )["+value+"] does not exist in vector"
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
            int indexArrays= domain.DivideAndConquer.binarySearchRecursive(vector.getData(), value,value-3,value+3);

            System.out.println(
                    indexArrays>=0
                            ?"domain.DivideAndConquer.binarySearch (recursive )["+value+"]exist at the position"+indexArrays
                            :"domain.DivideAndConquer.binarySearch (recursive )["+value+"] does not exist in vector"
            );

        }
    }

}