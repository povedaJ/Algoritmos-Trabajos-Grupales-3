package util;

import java.text.DecimalFormat;
import java.util.Random;

public class Utility {
    private static Random random;
    private static long seed; //semilla para el random
    //static initializer
    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }
    public static int random(int bound){
        //return 1+(int)Math.floor(Math.random()*bound);
        return 1+random.nextInt()*bound;
    }

    public static String format(double value) {
        return new DecimalFormat("###,###,###.##")
                .format(value);
    }

    public static void fill(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = random(99);
        }
    }
    public static void fill2(int[] a) {
        int n = a.length;
        for (int i=0;i<n;i++)
            a[i] = (int) (Math.random()*100);
        //a[i] = util.Utility.random(100);

    }
}
