package domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThreeSum {
    private static int a[];

    public static int[] getA() {
        return a;
    }

    public static int count(int[] a){ // Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(test1());
    }

    public static String test1() {
        String result = "1Mints.txt content..\n";
        a = new int[1000];
//        int a[] = null; //number array
        try {
            Scanner file = new Scanner(new File("src/main/java/text/1Mints.txt"));
            StringBuilder sb = new StringBuilder();
            while(file.hasNext()){
                sb.append(file.nextLine());
            }
            String numberStr[] = sb.toString().split("(\\s+)|(?=-)");
//            a = new int[1000];
            int index=0; int count=0;
            for (int i = 0; i < 1000; i++) {
                if(numberStr[i].compareTo("")!=0){
                    a[index] = Integer.parseInt(numberStr[i]);
                    result+=a[index++]+" ";
                    if(++count==14){
                        result+="\n";
                        count=0;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
        return result+"\ncount(a) result: "+count(a);
    }


}
