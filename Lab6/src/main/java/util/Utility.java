/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import domain.LinkedStack;
import domain.StackException;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Profesor Lic. Gilberth Chaves Avila
 */
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
        }
        return 2; //Unknown
    }

    private static String instanceOf(Object a){
        if(a instanceof Integer) return "Integer";
        if(a instanceof String) return "String";
        if(a instanceof Character) return "Character";
        return "Unknown"; //desconocido
    }

    public static String instanceOf(Object a, Object b){
        if(a instanceof Integer&&b instanceof Integer) return "Integer";
        if(a instanceof String&&b instanceof String) return "String";
        if(a instanceof Character&&b instanceof Character) return "Character";
        return "Unknown"; //desconocido
    }

    public static String postfixToInfixConverter(String postFixExp) throws StackException {
        LinkedStack s = new LinkedStack();
        postFixExp= postFixExp.replaceAll("\\s","");
        int n= postFixExp.length();
        for (int i = 0; i < n; i++) {
            if(Character.isLetterOrDigit(postFixExp.charAt(i))){
                s.push(""+postFixExp.charAt(i));
            }else if(isOperator(postFixExp.charAt(i))){
                String op2=(String) s.pop();// extraigo el 1 elemento de la pila
                String op1=(String) s.pop();// extraigo el 2 elemento de la pila
                //satisfago la operacion: operando operador operando
                s.push("("+op1+postFixExp.charAt(i)+op2+")");
            }
        }
        return (String)s.peek();
    }

    private static boolean isOperator(char value) {
        switch (value){
            case '+': case'-': case '*': case '/': case '^':
                return true;
        }
        return false;
    }

    public static boolean isNumberExp(String str) {
        str =str.replaceAll("\\s","");
        int n= str.length();
        for (int i = 0; i < n; i++) {
            if(!Character.isDigit(str.charAt(i))&&!isOperator(str.charAt(i))){
                return false;}

        }
        return true;
    }

    public static boolean isPreviousNumber(String str) {  //Cuenta el "("
        str =str.replaceAll("\\s","");
        int n= str.length()-1;
        if(!Character.isDigit(str.charAt(n)) && isOperator(str.charAt(n))){
            return false;
        }if (str.charAt(n)=='('){
            return false;
        }
        return true;
    }

    public static String deleteLastDigit(String str) {
        str =str.replaceAll("\\s","");
        int n= str.length()-1;
        String result="";
        for (int i = 0; i < n; i++) {
            result= result+str.charAt(i);
        }
        return result;
    }

    public static String postFixExpResult(String postFix) throws StackException {
        LinkedStack s= new LinkedStack();
       postFix =postFix.replaceAll("\\s","");
        int n= postFix.length();
        int op2=0,op1=0;
        for (int i = 0; i <n ; i++) {

            if(Character.isLetterOrDigit(postFix.charAt(i))){
                s.push(postFix.charAt(i));
            }else if (isOperator(postFix.charAt(i))){
                 op2=(int) s.pop();// extraigo el 1 elemento de la pila
                 op1=(int) s.pop();// extraigo el 2 elemento de la pila
            }
            char operador= postFix.charAt(i);
            switch (operador) {
                case '+':
                   s.push( op1 + op2);
                case '-':
                    s.push( op1 -op2);
                case '*':
                    s.push( op1 * op2);
                case '/':
                    s.push( op1 / op2);
            }
        }
        return !s.isEmpty()?(String) s.peek():"";
    }
    public static String infixToPostfixConverter(String infixExpression) throws StackException {
        LinkedStack s= new LinkedStack();
        StringBuilder postfixExpression = new StringBuilder();

        for (int i = 0; i < infixExpression.length(); i++) {
            char currentChar = infixExpression.charAt(i);
            if (Character.isLetterOrDigit(currentChar)) {
                postfixExpression.append(currentChar);
            } else if (currentChar == '(') {
                s.push(currentChar);
            } else if (currentChar == ')') {
                while (!s.isEmpty() && !s.peek().equals('(') ) {
                    postfixExpression.append(s.pop());
                }
                s.pop(); // remove '('
            } else {
                while (!s.isEmpty() && precedence(currentChar) <= precedence((Character) s.peek())) {
                    postfixExpression.append(s.pop());
                }
                s.push(currentChar);
            }
        }

        while (!s.isEmpty()) {
            if (s.peek()=="(") {
                return "Invalid expression";
            }
            postfixExpression.append(s.pop());
        }

        return postfixExpression.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }
}
