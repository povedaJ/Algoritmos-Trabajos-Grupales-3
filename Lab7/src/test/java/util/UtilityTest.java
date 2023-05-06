package util;

import domain.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void compare() {
        Person p1= new Person("ana","Sad");
        Person p2= new Person("Viviana","Sad");

        int i= p1.getName().compareTo(p2.getName())==
                p1.getMood().compareTo(p2.getMood()) ? 0 :-1;
//                p1.getName().compareTo(p2.getName())>0
//                       &&
//                        p1.getMood().compareTo(p2.getMood())>0
//                        ? 1 : 0
                ;
        System.out.println("Numero: "+i);

        System.out.println( util.Utility.instanceOf(p1,p2));

        if(util.Utility.compare(p1, p2)==0){
            System.out.println("true");
        } else {System.out.println("False");}

        System.out.println("\nNumeros");
        System.out.println( util.Utility.instanceOf(p1,"Sad"));
        if(util.Utility.compare(p1, "Sad")==0){
            System.out.println("true");
        } else {System.out.println("False");}



    }
}