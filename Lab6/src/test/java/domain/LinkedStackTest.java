package domain;

import org.junit.jupiter.api.Test;

class LinkedStackTest {
    @Test
    void test() {
        try {
            LinkedStack linkedStack = new LinkedStack();
            for (int i = 0; i < 10; i++) {
                linkedStack.push(util.Utility.random(10, 50));
            }

            //System.out.println(linkedStack.toString());
            //ArrayStack llenado
            ArrayStack as1 = new ArrayStack(20);
            as1.push(new Person(1, "Alana", 18));
            as1.push(new Person(2, "Pablo", 20));
            as1.push(new Person(3, "Ana", 21));
            as1.push(new Person(4, "Maria", 20));
            as1.push(new Person(5, "Victoria", 23));
            as1.push(new Person(6, "Nicole", 19));
            as1.push(new Person(7, "Mateo", 18));
            as1.push(new Person(8, "Nicole", 23));
            as1.push(new Person(9, "Alana", 22));
            as1.push(new Person(10, "Carlos", 19));
            as1.push(new Person(11, "Viviana", 18));
            as1.push(new Person(12, "Raquel", 20));
            as1.push(new Person(13, "Diego", 21));
            as1.push(new Person(14, "Bertha", 20));
            as1.push(new Person(15, "Diego", 23));
            as1.push(new Person(16, "Sebastian", 19));
            as1.push(new Person(17, "Tiago", 18));
            as1.push(new Person(18, "Henry", 23));
            as1.push(new Person(19, "Randall", 22));
            as1.push(new Person(20, "Daniel", 19));
            ArrayStack as2 = new ArrayStack(10);
            as2.push("Costa Rica");
            as2.push("España");
            as2.push("USA");
            as2.push("Colombia");
            as2.push("Alemania");
            as2.push("Mexico");
            as2.push("Corea");
            as2.push("China");
            as2.push("Ecuador");
            as2.push("Argentina");
            linkedStack.push(as1);
            linkedStack.push(as2);
            linkedStack.push("Santorini");
            linkedStack.push("Islas Fiyi");
            linkedStack.push("Islas Maldivas");
            linkedStack.push("Bahamas");
            linkedStack.push("Isla de Bora Bora");
            linkedStack.push(new Carro("Audi","Negro","Cl5678"));
            linkedStack.push(new Carro("BMW","Rojo","CV6899"));
            linkedStack.push(new Carro("Lexus","Gris","Cl5788"));

            System.out.println("The list has : " + linkedStack.size() + " elements\n");
            System.out.println(linkedStack.toString());
            System.out.println("\nRemoving the last 10 elements:\n");
            int count = 10;
            while (count != 0) {
                System.out.println("Removing: " + linkedStack.pop());
                count--;
            }
            System.out.println("\nTop element in list: " + linkedStack.peek());
            System.out.println("The list has : " + linkedStack.size() + " elements\n");
            System.out.println(linkedStack.toString());

        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test1() {
        try {
            LinkedStack linkedStack = new LinkedStack();
            linkedStack.push(10);
            linkedStack.push(5);
            linkedStack.push(7);
            linkedStack.push(8);
            linkedStack.push(20);
            linkedStack.push(30);
            System.out.println(linkedStack.toString());
            //probamos que funciono vaciar y llenar nuevamente la pila
            System.out.println(linkedStack.toString());

        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }
}