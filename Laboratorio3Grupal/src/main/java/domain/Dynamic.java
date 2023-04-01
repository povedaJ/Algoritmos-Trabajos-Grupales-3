package domain;

public class Dynamic {
    public int Fibonacci(int n){
        int[] numbers = new int[n];
        int counter=0,fibo = 0;
        String result="";
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=counter;
            counter++;

        }
        for (int j = 0; j < numbers.length; j++) {
            result+=numbers[j]+" , ";

        }
        System.out.println(result);
        for (int k = 0; k < numbers.length;k++) {
            numbers[k]=numbers[k-1]+numbers[k+2];
            fibo=numbers[k];
        }
        return fibo;
    }
    public long factorial(long numero) {
        if (numero < 0)
            numero = numero * -1;
        if (numero <= 0)
            return 1;
        long factorial = 1;
        while (numero > 1) {
            factorial = factorial * numero;
            numero--;
        }
        return factorial;
    }
}
