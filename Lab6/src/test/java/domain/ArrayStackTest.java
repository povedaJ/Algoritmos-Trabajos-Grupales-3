package domain;

import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    @Test
    public void test() throws StackException {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(new Person(1, "Alana", 18));
        arrayStack.push(new Person(2, "Pablo", 20));
        arrayStack.push(new Person(3, "Ana", 21));
        arrayStack.push(new Person(4, "Maria", 20));
        arrayStack.push(new Person(5, "Victoria", 23));
        arrayStack.push(new Person(6, "Nicole", 19));
        arrayStack.push(new Person(7, "Mateo", 18));
        arrayStack.push(new Person(8, "Nicole", 23));
        arrayStack.push(new Person(9, "Alana", 22));
        arrayStack.push(new Person(10, "Carlos", 19));
        System.out.println(arrayStack.toString()+"\n");
        remove("", 20, arrayStack);
        remove("Nicole", 19, arrayStack);
        remove("Alana", 0, arrayStack);
        System.out.println("Removemos las personas que: \n1.Age = 20\n2.name ='Nicole', age= 19\n3.name='Alana'\n");
        System.out.println(arrayStack.toString());
    }

    private void remove(String name, int age, ArrayStack stack) {
        try {
            int count=1;
            int n=stack.size();
            ArrayStack auxStack = new ArrayStack(stack.size());

            while (!stack.isEmpty()) {
                Person objStack = (Person) stack.peek();
                if (objStack.getAge() == age && objStack.getName().equals(name)) {
                    stack.pop(); count++;
                }
                if (objStack.getAge() == age && name.equals("")) {
                    stack.pop(); count++;
                }
                if ( objStack.getName().equals(name)&& age==0) {
                    stack.pop(); count++;
                }
                if(count<n){
                auxStack.push(stack.pop()); count++;}else{break;}
            }
            //ahora dejamos podemos la pila inicial
            while (!auxStack.isEmpty()) {

                stack.push(auxStack.pop());
            }
        }catch (StackException e) {
            throw new RuntimeException(e);
        }


        //  return result;
    }

    @Test
    public void test1() {
        try {
            ArrayStack arrayStack = new ArrayStack(5);
            arrayStack.push(10);
            arrayStack.push(5);
            arrayStack.push(7);
            arrayStack.push(8);
            arrayStack.push(20);
            //arrayStack.push(30);
            System.out.println(arrayStack.toString());
            //probamos que funciono vaciar y llenar nuevamente la pila
            System.out.println(arrayStack.toString());

        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

}