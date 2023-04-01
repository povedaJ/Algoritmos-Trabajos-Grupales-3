package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VectorTest {
    @Test
    public void testVector(){
        Vector vector= new Vector(50);
        util.Utility.fill(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());
        System.out.println("The vector has"+vector.size()+" elements");
        System.out.println(vector.isEmpty()
                ?"vector is empty"
                :"vector is not empty");



    }
    @Test
    public void testVector2(){
        Vector vector= new Vector(50);
        util.Utility.fill(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());
        System.out.println("The vector has"+vector.size()+" elements");
        vector.add(10,10);
        vector.add(5,5);
        vector.add(0,0);
        System.out.println("VECTOR with new elements "+vector.toString());
    }
    @Test
    public void testVector3(){
        Vector vector= new Vector(50);
        util.Utility.fill(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());
        for (int i = 0; i < 30; i++) {
            int value = util.Utility.random(99);
            vector.contains(value);

        }

    }
    @Test
    public void testVector4(){
        Vector vector= new Vector(50);
        util.Utility.fill(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());
        vector.remove(10);
        vector.add(10,81);
        vector.remove(5);
        vector.add(5,40);
        vector.remove(0);
        vector.add(0,70);
        System.out.println("Vector with new values "+vector.toString());


    }
    @Test
    public void testVector5(){
        Vector vector= new Vector(50);
        util.Utility.fill(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());

        for (int i = 0; i < 30; i++) {
            int value = util.Utility.random(99);
            vector.remove(value);
        }
        System.out.println(" VECTOR removed values "+vector.toString());

    }

}