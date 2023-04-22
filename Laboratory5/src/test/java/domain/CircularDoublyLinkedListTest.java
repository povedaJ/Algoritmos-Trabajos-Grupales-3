package domain;

import org.testng.annotations.Test;

import java.util.Calendar;

import static org.testng.Assert.*;

public class CircularDoublyLinkedListTest {

    @Test
    public void test() {
        //a
        CircularDoublyLinkedList a = new CircularDoublyLinkedList();
        CircularDoublyLinkedList b = new CircularDoublyLinkedList();
        CircularDoublyLinkedList c = new CircularDoublyLinkedList();
        CircularDoublyLinkedList d = new CircularDoublyLinkedList();
        //b
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, 3, 19);
        list.add(new Employee(1, "Poveda", "Viviana", "Informatica",
                calendar.getTime()));
        calendar.set(2000, 2, 12);
        list.add(new Employee(2, "Ramirez", "Raquel", "Administracion",
                calendar.getTime()));
        calendar.set(1998, 1, 1);
        list.add(new Employee(3, "Aguilar", "Daniel", "Inglés",
                calendar.getTime()));
        calendar.set(1995, 2, 19);
        list.add(new Employee(4, "Solano", "Diego", "Turismo",
                calendar.getTime()));
        calendar.set(1993, 2, 1);
        list.add(new Employee(5, "Vargas", "Randall", "Agronomía",
                calendar.getTime()));
        calendar.set(1989, 3, 1);
        list.add(new Employee(6, "Monge", "Sebastian", "Diseño Publicitario",
                calendar.getTime()));
        calendar.set(1984, 2, 4);
        list.add(new Employee(7, "Alvarado", "Nicole", "Diseño Web",
                calendar.getTime()));
        calendar.set(1981, 2, 15);
        list.add(new Employee(8, "Vasquez", "Ashley", "Asesor",
                calendar.getTime()));
        calendar.set(1979, 4, 1);
        list.add(new Employee(9, "Blanco", "Natalia", "Doctor",
                calendar.getTime()));
        calendar.set(1975, 1, 26);
        list.add(new Employee(10, "Poveda", "Gabriel", "Abogado",
                calendar.getTime()));
        calendar.set(1971, 2, 17);
        list.add(new Employee(11, "Alvarado", "Bertha", "Inglés",
                calendar.getTime()));
        calendar.set(1968, 1, 20);
        list.add(new Employee(12, "Viquez", "Sebastian", "Turismo",
                calendar.getTime()));
        calendar.set(1966, 2, 5);
        list.add(new Employee(13, "Vega", "Emmanuel", "Agronomía",
                calendar.getTime()));
        calendar.set(1963, 1, 1);
        list.add(new Employee(14, "Poveda", "Henry", "Inglés",
                calendar.getTime()));
        calendar.set(1960, 1, 24);
        list.add(new Employee(15, ",Meza", "Kimberly", "Doctor",
                calendar.getTime()));
        calendar.set(1958, 3, 15);
        list.add(new Employee(16, "Calvo", "Eduardo", "Inglés",
                calendar.getTime()));
        System.out.println(list.toString());

        a = rangos(list,a, 18, 25);
        b = rangos(list,b, 26, 40);
        c = rangos(list,c, 41, 55);
        d = rangos(list,d, 56, 150);
        //v
        System.out.println("\nContenido  lista a (entre 18 y 25 años):" + a.toString());
        System.out.println("\nContenido lista b (entre 26 y 40 años):" + b.toString());
        System.out.println("\nContenido lista c (entre 41 y 55 años):" + c.toString() );
        System.out.println("\nContenido lista d (más de 55 años):" + d.toString());

    }

    private CircularDoublyLinkedList rangos(CircularDoublyLinkedList list,CircularDoublyLinkedList newList, int rango1, int rango2) {
        try {
            int n = list.size();
            for (int i = 1; i <= n; i++) {
                Employee employee = (Employee) list.getNode(i).data;
                if (employee.getAge(employee.getBirthday()) >= rango1
                        && employee.getAge(employee.getBirthday()) <= rango2) {
                    newList.add(employee);
                }
            }//
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
        return newList;
    }
}