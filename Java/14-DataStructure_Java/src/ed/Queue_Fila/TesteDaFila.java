package ed.Queue_Fila;

import java.util.LinkedList;
import java.util.Queue;


public class TesteDaFila {

    public static void main(String[] args) {

        Fila fila = new Fila();

        System.out.println("Is fila empty?");
        System.out.println(fila.vazia());

        fila.adiciona("Maria Bonita");
        fila.adiciona("Marie Curie");
        fila .adiciona("Maya Angelou");
        System.out.println(fila);

        System.out.println("Is fila empty?");
        System.out.println(fila.vazia());

        System.out.println("Remove element.");
        String name1 = fila.remove();
        System.out.println(name1);
        System.out.println(fila);

        System.out.println("################################ JAVA QUEUE ################################");

        // In java, Queue is an interface and the LinkedList its self is an implementation of queue.
        Queue<String> filaDoJava = new LinkedList<String>();

        filaDoJava.add("Rosa Parks");
        filaDoJava.add("Michelle Obama");
        filaDoJava.add("Amelia Earhart");
        System.out.println(filaDoJava);

        // Poll is the method that removes the first element.
        System.out.println("Poll");
        String name2 = filaDoJava.poll();
        System.out.println(name2);
        System.out.println(filaDoJava);

        System.out.println("Peek");
        String name3 = filaDoJava.peek();
        System.out.println(name3);
        System.out.println(filaDoJava);


    }
}
