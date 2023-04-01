package util;
import domain.Vector;
import domain.VectorE;

import java.text.DecimalFormat;
import java.util.Random;


public class Utility {
    private static Random random;
    private static long seed; //semilla para el random

    //son 25 nombres de paises
    private static String[] paises = {"Argentina", "Colombia", "Costa Rica", "Portugal", "Chile",
                                      "Rusia", "Ecuador", "India", "Bahamas", "Belice",
                                      "Peru", "Cuba", "Alemania", "El Salvador", "Granada",
                                      "Guatemala", "Guyana", "Haití", "Honduras", "Jamaica",
                                      "México", "Nicaragua", "Panamá", "Paraguay", "República Dominicana"};

    //static initializer
    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }
    public static int random(int bound){
        //return 1+(int)Math.floor(Math.random()*bound);
        return 1+random.nextInt(bound);
    }

    public static String format(double value) {
        return new DecimalFormat("###,###,###.##")
                .format(value);
    }

    //llena el objeto con enteros
    public static void fill(Vector vector) {
        int n = vector.getN();
        for (int i = 0; i < n; i++) {
            vector.add(random(99));
        }
    }

    //Llena el objeto con String
    public static void fill2(VectorE<String> vector) {
        int n = vector.getN();
        for (int i = 0; i < n; i++) {
            vector.add(paises[random(25)-1]);
        }
    }


    public static <E> int compare(Object a, Object b) {
        switch (instanceOf(a,b)){
            case"Integer":
                Integer int1= (Integer)a;
                Integer int2= (Integer)b;
                return int1<int2?-1:int1>int2? 1: 0;

            case "String":
                String str1=(String) a;
                String str2=(String) b;
                return str1.compareTo(str2)<0? -1:str1.compareTo(str2)>0? 1:0;
            case "Character":
                Character c1= (Character) a;
                Character c2= (Character) b;
                return c1.compareTo(c2)<0? -1: c1.compareTo(c2)>0? 1:0;

        }
        return 2;
    }

    private static String instanceOf(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) return "Integer";
        if (a instanceof String && b instanceof String) return "String";
        if (a instanceof Character && b instanceof Character) return "Character";
        return "Unknown";


    }
}
