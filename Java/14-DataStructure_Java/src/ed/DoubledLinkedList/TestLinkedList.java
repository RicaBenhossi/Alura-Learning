package ed.DoubledLinkedList;

import java.util.List;

public class TestLinkedList {

    public static void main(String[] args) {

        LinkedList lista = new LinkedList();

        System.out.println("Add in the beginning");
        System.out.println(lista);
        lista.adicionaNoComeco("Lola");
        System.out.println(lista);
        lista.adicionaNoComeco("Natalia");
        System.out.println(lista);
        lista.adicionaNoComeco("Ricardo");
        System.out.println(lista);
        lista.adicionaNoComeco("Maria Antonieta");
        System.out.println(lista);

        System.out.println("Add at the end");
        lista.adiciona("Bruce Willians");
        System.out.println(lista);

        System.out.println("Get position 2");
        Object x = lista.pega(2);
        System.out.println(x);

        System.out.println(lista.tamanho());

        System.out.println("Remove from beginning");
        lista.removeDoComeco();
        System.out.println(lista);
        System.out.println(lista.tamanho());

        System.out.println("Remove from the end");
        lista.removeDofim();
        System.out.println(lista);
        System.out.println(lista.tamanho());

        lista.adiciona(3, "Joana D'Arc");
        lista.adiciona(3, "Xuxa");

        System.out.println(lista);
        System.out.println(lista.tamanho());

        System.out.println("Remove position 3");
        lista.remove(3);

        System.out.println(lista);
        System.out.println(lista.tamanho());

        System.out.println("Test contain Natalia");
        System.out.println(lista.contem("Natalia"));

        System.out.println("Test contain José");
        System.out.println(lista.contem("José"));
    }
}
