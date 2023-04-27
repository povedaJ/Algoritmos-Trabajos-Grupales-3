package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    @Test
    void test() {
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