package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KnapsackTest {

    @Test
    public void testSolve() {
        Item items[] = new Item[12];
        items[0] = new Item("Smart TV 65", 1000, 20);
        items[1] = new Item("PS5", 600, 2);
        items[2] = new Item("Libro java", 20, 1);
        items[3] = new Item("Samsung Galaxy", 700, 0.5);
        items[4] = new Item("Huawei", 400, 0.5);
        items[5] = new Item("Libro C++", 25, 0.5);
        items[6] = new Item("Xbox One", 500, 2.2);
        items[7] = new Item("Drone", 500, 3);
        items[8] = new Item("Proyector", 200, 3);
        items[9] = new Item("Laptop", 800, 3);
        items[10] = new Item("Impresora 3D", 800, 4);
        items[11] = new Item("iPhone", 800, 0.5);

        System.out.println("\nKNAPSACK PROBLEM SOLUTION");
        System.out.println(show(items));


        Knapsack knapsack1 = new Knapsack(items, 14.5);
        System.out.println(knapsack1.toString());

        Knapsack knapsack2 = new Knapsack(items, 24.5);
        System.out.println(knapsack2.toString());

        Knapsack knapsack3 = new Knapsack(items, 35);
        System.out.println(knapsack3.toString());

        Knapsack knapsack4 = new Knapsack(items, 12);
        System.out.println(knapsack4.toString());

        Knapsack knapsack5 = new Knapsack(items, 4.5);
        System.out.println(knapsack5.toString());
    }

    private String show(Item[] a) {
        String result="";
        int n = a.length;
        for (Item item: a) {
            result += "\n"+item.toString();
        }
        return result;
    }
}