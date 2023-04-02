package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DynamicTest {

    @Test
    public void testDynamic() {
        Dynamic dynamic = new Dynamic();
        System.out.println("Fibonacci of "+4+" = "+dynamic.fibonacci2(4));
        System.out.println("Fibonacci of "+7+" = "+dynamic.fibonacci2(7));
        System.out.println("Fibonacci of "+10+" = "+dynamic.fibonacci2(10));
        System.out.println("Fibonacci of "+12+" = "+dynamic.fibonacci2(12));

        System.out.println("\nFactorial of "+4+" = "+dynamic.factorial(4));
        System.out.println("Factorial of "+7+" = "+dynamic.factorial(7));
        System.out.println("Factorial of "+10+" = "+dynamic.factorial(10));
        System.out.println("Factorial of "+12+" = "+dynamic.factorial(12));


    }


}