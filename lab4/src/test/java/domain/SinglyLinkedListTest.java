package domain;

import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.testng.Assert.*;

public class SinglyLinkedListTest {

    @Test
    public void test1() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(new Student("1", "Maria", 20, "Cartago"));
        list.add(new Student("2", "Carlos", 22, "San Jose"));
        list.add(new Student("3", "Laura", 20, "Paraíso"));
        list.add(new Student("4", "Paula", 18, "Turrialba"));
        list.add(new Student("5", "Carlos", 21, "Limón"));
        list.add(new Student("6", "Fabiana", 19, "Paraíso"));
        list.add(new Student("7", "Maria", 23, "Guanacaste"));
        list.add(new Student("8", "Carlos", 25, "San Carlos"));
        list.add(new Student("9", "Laura", 20, "Turrialba"));
        list.add(new Student("10", "Pedro", 24, "Heredia"));

//        System.out.println(list.toString());
        try {
            //b
            // i.
            System.out.println("Existe Pedro, Id = 20? " + list.contains(new Student("20", "Pedro", 12, "Cartago")));
            System.out.println("Existe Paula, Id = 4? " + list.contains(new Student("4", "Paula", 30, "Turrialba")));
            System.out.println("Existe Carlos, Id = 5 ? " + list.contains(new Student("5", "Carlos", 25, "Limón")));
            System.out.println("Existe Carlos, Id = 8 ? " + list.contains(new Student("8", "Carlos", 20, "Heredia")));
            System.out.println("\n");

            //ii.
            for (int i = 1; i <= list.size(); i++) {

                System.out.println("El elemento en la posición " + i + " es: " + list.getNode(i).data);
            }
            System.out.println("\n");

            //iii.
            System.out.println("El estudiante Carlos con Id=8 se encuentra en la posicion: "+list.indexOf(new Student("8", "Carlos", 25, "San Carlos")));
            System.out.println("El estudiante Carlos con Id=100 se encuentra en la posicion: "+list.indexOf(new Student("100", "Carlos", 25, "San Carlos")));
            System.out.println("\n");

            //iv.   //Ordenar con metodo sort
            list.sort();

            //v.
            list.remove(new Student("1", "Maria", 20, "Cartago"));

            list.remove(new Student("3", "Laura", 20, "Paraíso"));

            list.remove(new Student("5", "Carlos", 21, "Limón"));

            for (int i = 1; i <= list.size(); i++) {
                System.out.println(list.getNode(i).data);
            }
            System.out.println("\n");


        } catch (ListException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void test2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(20);
        list.add(10);
        list.add(15);
        list.add(3);
        list.add(17);
        System.out.println(list.toString());
        try {
            System.out.println("List size: " + list.size());
            System.out.println(list.contains(50) ? "El 50 existe" : "El 50 no existe");
            System.out.println(list.contains(3) ? "El 3 existe" : "El 3 no existe");

            System.out.println("Deleting 20...");
            list.remove(20);
            System.out.println("Deleting 3...");
            list.remove(3);
            for (int i = 0; i < 10; i++) {
                list.add(util.Utility.random(50));
            }
            System.out.println(list.toString());
            for (int i = 0; i < 10; i++) {
                int value = util.Utility.random(50);
                System.out.println(list.contains(value) ? "Element " + value + " exists at pos: " + list.indexOf(value) : "Element " + value + " does not exist in list");
            }
            int n = list.size();
            for (int i = 1; i <= n; i++) {
                System.out.println("Element at position: " + i + ": " + list.getNode(i).data);
            }

        } catch (ListException e) {
            throw new RuntimeException(e);
        }
    }


}