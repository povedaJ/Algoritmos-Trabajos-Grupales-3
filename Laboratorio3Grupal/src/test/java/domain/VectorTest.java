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
        System.out.println("The vector has "+vector.size()+" elements");
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
        System.out.println("The vector has "+vector.size()+" elements");
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
            System.out.println(value+": " + vector.contains(value));
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


//para la clase VectorE
    @Test
    public void testVectorE(){
        System.out.println("\n\nTEST VECTOR E................\n");
        VectorE<String> vector= new VectorE(50);
        util.Utility.fill2(vector); //llena la lista
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());
        System.out.println("The vector has "+vector.size()+" elements");
        System.out.println(vector.isEmpty()
                ?"vector is empty"
                :"vector is not empty");
    }
    @Test
    public void testVectorE2(){
        VectorE<String> vector= new VectorE(50);
        util.Utility.fill2(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());
        System.out.println("The vector has "+vector.size()+" elements");
        vector.add(10,"Canadá");
        vector.add(5,"Francia");
        vector.add(0,"Reino Unido");
        System.out.println("VECTOR with new elements "+vector.toString());
    }
    @Test
    public void testVectorE3(){
        VectorE<String> vector= new VectorE(50);
        util.Utility.fill2(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());
        String value = "España";
        System.out.println(value+": " + vector.contains(value));
        value = "Costa Rica";
        System.out.println(value+": " + vector.contains(value));
    }

    @Test
    public void testVectorE4(){
        VectorE<String> vector= new VectorE(50);
        util.Utility.fill2(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());
        vector.remove(10);
        vector.add(10,"España");
        vector.remove(5);
        vector.add(5,"España");
        vector.remove(0);
        vector.add(0,"España");
        System.out.println("Vector with new values "+vector.toString());
    }

    @Test
    public void testVectorE5(){
        VectorE<String> vector= new VectorE(50);
        util.Utility.fill2(vector);
        System.out.println(vector.toString());
        vector.sort();
        System.out.println("SORTED VECTOR "+vector.toString());
        for (int i = 0; i < 30; i++) {
            int value = util.Utility.random(99);
            vector.remove(value);
        }
        System.out.println(" VECTOR removed values "+vector.toString());
    }

}//fin