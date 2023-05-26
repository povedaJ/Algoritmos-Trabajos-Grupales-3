package util;

import domain.ArrayStack;
import domain.BTree;
import domain.LinkedQueue;
import domain.SinglyLinkedList;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utility {
    private static Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed

    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    public static int random(){
        return 1+(int) Math.floor(Math.random()*99);
    }

    public static int random(int bound){
        //return 1+random.nextInt(bound);
        return 1+(int) Math.floor(Math.random()*bound);
    }

    public static int random(int lowBound, int highBound){
        int value=0;
        do{
            value = lowBound+(int) Math.floor(Math.random()*highBound);
        }while(!isBetween(value, lowBound, highBound));
        return value;
    }

    public static boolean isBetween(int value, int low, int high) {
        return low <= value && value <= high;
    }

    public static String format(double value){
        return new DecimalFormat("###,###,###,###.##")
                .format(value);
    }

    public static String perFormat(double value){
        //#,##0.00 '%'
        return new DecimalFormat("#,##0.00'%'")
                .format(value);
    }

    public static String dateFormat(Date value){
        return new SimpleDateFormat("dd/MM/yyyy")
                .format(value);
    }

    /**
     * a < b return -1
     * a > b return 1
     * a == b return 0
     * @param a
     * @param b
     * @return
     **/
    public static int compare(Object a, Object b) {
        switch(instanceOf(a, b)){
            case "Integer":
                Integer int1 = (Integer)a; Integer int2 = (Integer)b;
                return int1 < int2? -1 :
                        int1 > int2? 1 : 0; //0==equal
            case "String":
                String str1 = (String)a; String str2 = (String)b;
                return str1.compareToIgnoreCase(str2)<0? -1 :
                        str1.compareToIgnoreCase(str2)>0? 1 : 0;
            case "Character":
                Character ch1 = (Character)a; Character ch2 = (Character)b;
                return ch1.compareTo(ch2)<0? -1 :
                        ch1.compareTo(ch2)>0? 1 : 0;
            case "ArrayStack":
                ArrayStack arrS1 = (ArrayStack) a; ArrayStack arrS2 = (ArrayStack) b;
                return !arrS1.equals(arrS2)  ? -1 : 0;
            case "SinglyLinkedList":
                SinglyLinkedList list1 = (SinglyLinkedList) a; SinglyLinkedList list2 = (SinglyLinkedList) b;
                return !list1.equals(list2)  ? -1 : 0;
            case "LinkedQueue":
                LinkedQueue linked1 = (LinkedQueue) a; LinkedQueue linked2 = (LinkedQueue) b;
                return !linked1.equals(linked2)  ? -1 : 0;
            case "BTree":
                BTree btree1 = (BTree) a; BTree btree2 = (BTree) b;
                return !btree1.equals(btree2)  ? -1 : 0;
        }
        return 2; //Unknown
    }

    private static String instanceOf(Object a){
        if(a instanceof Integer) return "Integer";
        if(a instanceof String) return "String";
        if(a instanceof Character) return "Character";
        if(a instanceof ArrayStack) return "ArrayStack";
        if(a instanceof SinglyLinkedList) return "SinglyLinkedList";
        if(a instanceof LinkedQueue) return "LinkedQueue";
        if(a instanceof BTree) return "BTree";
        return "Unknown"; //desconocido
    }

    public static String instanceOf(Object a, Object b){
        if(a instanceof Integer&&b instanceof Integer) return "Integer";
        if(a instanceof String&&b instanceof String) return "String";
        if(a instanceof Character&&b instanceof Character) return "Character";
        if(a instanceof ArrayStack&&b instanceof ArrayStack) return "ArrayStack";
        if(a instanceof SinglyLinkedList &&b instanceof SinglyLinkedList) return "SinglyLinkedList";
        if(a instanceof LinkedQueue &&b instanceof LinkedQueue) return "LinkedQueue";
        if(a instanceof BTree &&b instanceof BTree) return "BTree";
        return "Unknown"; //desconocido
    }

    public static String getPerson() {
        int pnum = random(0, 31);
        String list[] = {"Alana", "Nicole", "Carlos", "Isabella",
                "Valeria", "Ana", "Victoria", "Pablo",
                "Maria", "David", "Mateo", "Cristina",
                "Natalia", "Claudia", "Laura", "Raquel",
                "Fabiana", "Andrea", "Martin", "Daniel",
                "Bertha", "Valentina", "Julia", "Allan",
                "Gabriela", "Rafael", "Alex", "Diana",
                "Marcos", "Alejandro", "Javier", "John",
        };
        return list[pnum];
    }

    public static char getAlphabet() {
        char alfabeto[] = new char[26];
        int cont = 0;
        for (char i = 'a'; i <= 'z'; i++)
            alfabeto[cont++] = i;
        return alfabeto[(int) (Math.random() * 25 - 1)];
    }

}
