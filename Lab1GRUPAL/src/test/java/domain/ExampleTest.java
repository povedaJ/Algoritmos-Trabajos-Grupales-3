package domain;

import static org.testng.Assert.*;

public class ExampleTest {
    private final int N=10000000; //example1, example2, example4
    private final int M=100000; //example3
    private final int P=2000; //example5
    private final int Q=3000; //example5
    private int a[];
    private int b[];
    private int c[];
    private int d[];
    private Example example;

    //Constructor
    public ExampleTest() {
        this.example = new Example();
        this.a = new int[N];
        this.b = new int[M];
        this.c = new int[P];
        this.d = new int[Q];
        fill(a); fill(b); fill(c); fill(d);
    }

    private void fill(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = util.Utility.random(99);
        }
    }

    @org.testng.annotations.BeforeMethod
    public void setUp() {
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() {
    }

    @org.testng.annotations.Test
    public void testExample1() {
        Stopwatch timer = new Stopwatch();
        int result = example.example1(a);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println(
                "Test Example 1"
                +"\nn: "+util.Utility.format(N)
                +"\nResult: "+util.Utility.format(result)
                +"\nTn: "+util.Utility.format(time)+" milliseconds"
                +"\nTn: "+hhmmss+"\n"
        );
    }

    @org.testng.annotations.Test
    public void testExample2() {
        Stopwatch timer = new Stopwatch();
        int result = example.example2(a);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println(
                "Test Example 2"
                        +"\nn: "+util.Utility.format(N)
                        +"\nResult: "+util.Utility.format(result)
                        +"\nTn: "+util.Utility.format(time)+" milliseconds"
                        +"\nTn: "+hhmmss+"\n"
        );
    }

    @org.testng.annotations.Test
    public void testExample3() {
        Stopwatch timer = new Stopwatch();
        int result = example.example3(b);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println(
                "Test Example 3"
                        +"\nn: "+util.Utility.format(M)
                        +"\nResult: "+util.Utility.format(result)
                        +"\nTn: "+util.Utility.format(time)+" milliseconds"
                        +"\nTn: "+hhmmss+"\n"
        );
    }

    @org.testng.annotations.Test
    public void testExample4() {
        Stopwatch timer = new Stopwatch();
        int result = example.example4(a);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println("Test Example 4"
                +"\nn: "+util.Utility.format(N)
                +"\nResult: "+ util.Utility.format(result)
                +"\nTn: "+ util.Utility.format(time) +" milliseconds"
                +"\nTn: "+ hhmmss+"\n"
        );
    }

    @org.testng.annotations.Test
    public void testExample5() {
        Stopwatch timer = new Stopwatch();
        int result = example.example5(c, d);
        double time = timer.elapsedTime();
        String hhmmss = timer.elapsedTimeHMS();
        System.out.println("Test Example 5"
                +"\nn: "+util.Utility.format(P)
                +"\nm: "+util.Utility.format(Q)
                +"\nResult: "+ util.Utility.format(result)
                +"\nTn: "+ util.Utility.format(time) +" milliseconds"
                +"\nTn: "+ hhmmss+"\n"
        );
    }
}