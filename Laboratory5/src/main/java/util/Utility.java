/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import domain.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Profesor Lic. Gilberth Chaves Avila
 */
public class Utility {

    private static Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed
    private static SinglyLinkedList studentList;
    private static DoublyLinkedList courseList;
    private static CircularDoublyLinkedList jobPositionList;
    private static CircularLinkedList employeeList;

    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
        studentList = new SinglyLinkedList();
        courseList = new DoublyLinkedList();

        jobPositionList= new CircularDoublyLinkedList();
        employeeList=new CircularLinkedList();
    }

    public static SinglyLinkedList getStudentList() {
        return studentList;
    }

    public static CircularDoublyLinkedList getJobPositionList() {
        return jobPositionList;
    }

    public static void setJobPositionList(CircularDoublyLinkedList jobPositionList) {
        Utility.jobPositionList = jobPositionList;
    }

    public static CircularLinkedList getEmployeeList() {
        return employeeList;
    }

    public static void setEmployeeList(CircularLinkedList employeeList) {
        Utility.employeeList = employeeList;
    }

    public static void setStudentList(SinglyLinkedList studentList) {
        Utility.studentList = studentList;
    }

    public static DoublyLinkedList getCourseList() {
        return courseList;
    }

    public static void setCourseList(DoublyLinkedList courseList) {
        Utility.courseList = courseList;
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


                //? si : no
//            case "Student":
//                Student st1 = (Student)a; Student st2 = (Student)b;
//                return st1.getId().compareTo(st2.getId())<0? -1 :
//                        st1.getId().compareTo(st2.getId())>0? 1 : 0;
//                //less  st1.getId().compareTo(st2.getId())<0? -1
//            //greater  st1.getId().compareTo(st2.getId())>0? 1
//            //igual = 0
//            case "Course":
//                Course course1 = (Course)a; Course course2 = (Course)b;
//                return course1.getId().compareTo(course2.getId())<0? -1 :
//                        course1.getId().compareTo(course2.getId())>0? 1 : 0;
            case "ID":
                Employee a5=(Employee)a; int b5=(int)b;
                return a5.getId()<b5?-1:a5.getId()>b5?1:0;
                
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
//        if(a instanceof Student &&b instanceof Student) return "Student";
//        if(a instanceof Course &&b instanceof Course) return "Course";
        return "Unknown"; //desconocido
    }

    public static String getCountryName(){
        String list[] = {"Argentina", "Australia", "Austria", "Alemania",
                "Belgica", "Bolivia", "Brasil", "Belice",
                "Costa Rica", "Colombia", "Canada", "Chile",
                "Dinamarca", "Ecuador", "Estonia", "El Salvador",
                "Francia", "Finlandia", "Grecia", "Guatemala",
                "Honduras", "Hungria", "India", "Italia",
                "Jamaica", "Japon", "Mexico", "Marruecos",
                "USA", "Nigeria", "Panama", "Portugal",
        };
        //return list[(int) (Math.random() * 31 - 1)];
        return list[random(31)];
    }

    public static char getAlphabet(){
        char alfabeto[] = new char[26] ;
        int cont=0;
        for(char i='a';i<='z';i++)
            alfabeto[cont++] = i;
        return alfabeto[(int) (Math.random() * 25 - 1)];
    }


}
