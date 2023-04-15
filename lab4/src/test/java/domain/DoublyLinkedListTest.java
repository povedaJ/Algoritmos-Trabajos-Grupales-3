package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DoublyLinkedListTest {
    @Test
    public void test1() throws ListException {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(new Course("IF-3001","Algoritmos",4));
        list.add(new Course("IF-4001","Sistemas Operativos",4));
        list.add(new Course("IF-2000","Programacion",4));
        list.add(new Course("IF-3000","Programacion 2",4));
        list.add(new Course("IF-4000","Arquitectura",3));
        list.add(new Course("IF-5000","Redes",3));
        list.add(new Course("IF-5100","Bases de datos",4));
        list.add(new Course("IF-4101","Lenguajes app Comerciales",4));
        list.add(new Course("IF-3100","Sistemas de informacion",3));



        System.out.println("¿Existe Informática Aplicada, Id=IF-6201?"+list.contains(new Course(
                "IF-6201","Informática Aplicada",4)));
        System.out.println("¿Existe Algoritmos y Estructuras de Datos, Id=IF-3001?"+list.contains(new Course(
                "IF-3001","Algoritmos",4)));
        System.out.println("¿Existe Sistemas Operativos, Id=IF-4001?"+list.contains(new Course(
                "IF-4001","Sistemas Operativos",4)));
        System.out.println("¿Existe Análisis y Diseño de Sistemas, Id=IF-6100?"+list.contains(new Course(
                "IF-6100","Existe Análisis y Diseño de Sistemas",4)));

        for (int i = 1; i <= list.size(); i++) {
            System.out.println("El elemento en la posicion " +i+" es: "+list.getNode(i).data);
        }


        System.out.println(list.contains( new Course("IF-3001","Algoritmos",4)) ? "El curso Algoritmos y Estructuras de Datos Id=IF-3001 se encuentra en la\n" +
                "posición: " + list.indexOf( new Course("IF-3001","Algoritmos",4)) : "El curso Algoritmos y Estructuras  does not exist in list");

        System.out.println(list.contains( new Course("IF-6100"," Análisis y Diseño de Sistemas ",4)) ? "El curso Algoritmos y Estructuras de Datos Id=IF-3001 se encuentra en la\n" +
                "posición: " + list.indexOf( new Course("IF-6100","Análisis y Diseño de Sistemas ",4)) : "El Análisis y Diseño de Sistemas  does not exist in list");


        list.sort();

    }

}
