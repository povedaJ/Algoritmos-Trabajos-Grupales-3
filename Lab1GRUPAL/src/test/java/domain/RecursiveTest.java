package domain;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class RecursiveTest {
    private Recursive recursive;
    private final int N=11000;// cantidad del numeros para el arreglo
    private int a[];//arreglo
    private final int m=0;int n=0;// ackerman

    public RecursiveTest() {
        this.recursive= new Recursive();
        this.a= new int[N];
        fill(a);

    }
    private void fill(int[] a) {
        int n = a.length;
        for (int i=0;i<n;i++)
           a[i] = (int) (Math.random()*N);
            //a[i] = util.Utility.random(100);

    }


    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testMcd() {
        Stopwatch timer = new Stopwatch();
        double result = recursive.mcd(3, 5);
        double result2 = recursive.mcd(2, 4);
        double result3 = recursive.mcd(6, 8);
        double result4 = recursive.mcd(3, 6);
        double result5 = recursive.mcd(4, 8);
        double result6 = recursive.mcd(10, 14);

        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println(
                "Test MCD "

                        + "\nmcd(" + 3+","+5+")=="+util.Utility.format(result)
                        + "\nmcd(" + 2+","+4+")=="+util.Utility.format(result2)
                        + "\nmcd(" + 6+","+8+")=="+util.Utility.format(result3)
                        + "\nmcd(" + 3+","+6+")=="+util.Utility.format(result4)
                        + "\nmcd(" + 4+","+8+")=="+util.Utility.format(result5)
                        + "\nmcd(" + 10+","+14+")=="+util.Utility.format(result6)
                        + "\nTn: " + util.Utility.format(time) + " milliseconds"
                        + "\nTn: " + hhmmss + "\n"
        );
    }
    @Test
    public void testAckerman() {
        Stopwatch timer = new Stopwatch();
        int result = recursive.ackerman(0,0);
        int result2 = recursive.ackerman(0,1);
        int result3 = recursive.ackerman(0,2);
        int result4 = recursive.ackerman(0,3);
        int result5 = recursive.ackerman(1,0);
        int result6 = recursive.ackerman(1,1);
        int result7 = recursive.ackerman(1,2);
        int result8 = recursive.ackerman(1,3);
        int result9 = recursive.ackerman(2,0);
        int result10 = recursive.ackerman(2,1);
        int result11= recursive.ackerman(2,2);
        int result12= recursive.ackerman(2,3);
        int result13 = recursive.ackerman(3,0);
        int result14 = recursive.ackerman(3,1);
        int result15 = recursive.ackerman(3,3);
        int result16 = recursive.ackerman(3,3);



        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println(
                " Ackerman Test"
                        + "\nackerman(" + 0+","+0+")=="+util.Utility.format(result)
                        + "\nackerman(" + 0+","+1+")=="+util.Utility.format(result2)
                        + "\nackerman(" + 0+","+2+")=="+util.Utility.format(result3)
                        + "\nackerman(" + 0+","+3+")=="+util.Utility.format(result4)
                        + "\nackerman(" + 1+","+0+")=="+util.Utility.format(result5)
                        + "\nackerman(" + 1+","+1+")=="+util.Utility.format(result6)
                        + "\nackerman(" + 1+","+2+")=="+util.Utility.format(result7)
                        + "\nackerman(" + 1+","+3+")=="+util.Utility.format(result8)
                        + "\nackerman(" + 2+","+0+")=="+util.Utility.format(result9)
                        + "\nackerman(" + 2+","+1+")=="+util.Utility.format(result10)
                        + "\nackerman(" + 2+","+2+")=="+util.Utility.format(result11)
                        + "\nackerman(" + 2+","+3+")=="+util.Utility.format(result12)
                        + "\nackerman(" + 3+","+0+")=="+util.Utility.format(result13)
                        + "\nackerman(" + 3+","+1+")=="+util.Utility.format(result14)
                        + "\nackerman(" + 3+","+2+")=="+util.Utility.format(result15)
                        + "\nackerman(" + 3+","+3+")=="+util.Utility.format(result16)
                        +"\nTn: "+util.Utility.format(time)+" milliseconds\n");

    }


    @Test
    public void testMin() {
        System.out.println(Arrays.toString(a));
        System.out.println(a.length);
        Stopwatch timer = new Stopwatch();
        int result = recursive.min(a,1,a[0]);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println(
                " Min Test"
                        +"\nn: "+util.Utility.format(N)
                        +"\nResult: "+util.Utility.format(result)
                        +"\nTn: "+util.Utility.format(time)+" milliseconds"
                        +"\nTn: "+hhmmss+"\n"
        );
    }
}