package domain;

import java.util.Calendar;

public class TestCircularLinkedList {

    @org.testng.annotations.Test
    public void testEmployee() throws ListException {// test de CircularLinkedList
        CircularLinkedList list = new CircularLinkedList();
        Calendar calendar = Calendar.getInstance();

        //a
        calendar.set(2003, 3, 19);
        list.add(new Employee(1, "Poveda", "Viviana", "Informatica", calendar.getTime()));
        calendar.set(2000, 2, 12);
        list.add(new Employee(2, "Ramirez", "Raquel", "Administracion", calendar.getTime()));
        calendar.set(1998, 1, 1);
        list.add(new Employee(3, "Aguilar", "Daniel", "Inglés", calendar.getTime()));
        calendar.set(1995, 2, 19);
        list.add(new Employee(4, "Solano", "Diego", "Turismo", calendar.getTime()));
        calendar.set(1993, 2, 1);
        list.add(new Employee(5, "Vargas", "Randall", "Agronomía", calendar.getTime()));
        calendar.set(1989, 3, 1);
        list.add(new Employee(6, "Monge", "Sebastian", "Diseño Publicitario", calendar.getTime()));
        calendar.set(1984, 2, 4);
        list.add(new Employee(7, "Alvarado", "Nicole", "Diseño Web", calendar.getTime()));
        calendar.set(1981, 2, 15);
        list.add(new Employee(8, "Vasquez", "Ashley", "Asesor", calendar.getTime()));
        calendar.set(1979, 4, 1);
        list.add(new Employee(9, "Blanco", "Natalia", "Doctor", calendar.getTime()));
        calendar.set(1975, 1, 26);
        list.add(new Employee(10, "Poveda", "Gabriel", "Abogado", calendar.getTime()));
        calendar.set(1971, 2, 17);
        list.add(new Employee(11, "Alvarado", "Bertha", "Inglés", calendar.getTime()));
        calendar.set(1968, 1, 20);
        list.add(new Employee(12, "Viquez", "Sebastian", "Turismo", calendar.getTime()));
        calendar.set(1966, 2, 5);
        list.add(new Employee(13, "Vega", "Emmanuel", "Agronomía", calendar.getTime()));
        calendar.set(1963, 1, 1);
        list.add(new Employee(14, "Poveda", "Henry", "Inglés", calendar.getTime()));
        calendar.set(1960, 1, 24);
        list.add(new Employee(15, ",Meza", "Kimberly", "Doctor", calendar.getTime()));
        calendar.set(1958, 3, 15);
        list.add(new Employee(16, "Calvo", "Eduardo", "Inglés", calendar.getTime()));

        System.out.println(list.toString());
        //b
        System.out.println(rangos(list, 18, 25));
        System.out.println(rangos(list, 26, 40));
        System.out.println(rangos(list, 41, 55));
        System.out.println(rangos(list, 56, 150));

        //c  getTitleList(CircularLinkedList list, String title)

        //d
        String prof = "Administracion";
        SinglyLinkedList l = getTitleList(list, prof);
        System.out.println("\nEmpleados con la profesión de " + prof + ": \n" + l.toString());
        prof = "Inglés";
        l = getTitleList(list, prof);
        System.out.println("\nEmpleados con la profesión de " + prof + ": \n" + l.toString());

    }

    //c
    private SinglyLinkedList getTitleList(CircularLinkedList list, String title) throws ListException {
        SinglyLinkedList L = new SinglyLinkedList();
        int n = list.size();
        for (int i = 1; i <= n; i++) {
            Employee employee = (Employee) list.getNode(i).data;
            if (employee.getTitle().equalsIgnoreCase(title)) {
                L.add(employee);
            }
        }
        return L;
    }

    private String rangos(CircularLinkedList list, int rango1, int rango2) {
        String result;
        try {
            result = "\nEmpleados con rango de edad entre " + rango1 + " y " + rango2 + ":";
            int n = list.size();
            for (int i = 1; i <= n; i++) {
                Employee employee = (Employee) list.getNode(i).data;
                if (employee.getAge(employee.getBirthday()) >= rango1
                        && employee.getAge(employee.getBirthday()) <= rango2) {
                    result += "\n"+employee.toString();
                }
            }//
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @org.testng.annotations.Test
    public void testJobPositions() {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.add(new JobPosition("Informatica", 200));
        System.out.println(list.toString());
    }
}