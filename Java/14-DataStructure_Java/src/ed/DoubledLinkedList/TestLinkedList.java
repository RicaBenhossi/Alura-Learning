package ed.DoubledLinkedList;

public class TestLinkedList {

    public static void main(String[] args) {

        LinkedList lista = new LinkedList();

        System.out.println(lista);
        lista.adicionaNoComeco("Lola");
        System.out.println(lista);
        lista.adicionaNoComeco("Natalia");
        System.out.println(lista);
        lista.adicionaNoComeco("Ricardo");
        System.out.println(lista);

        lista.adiciona("João");
        System.out.println(lista);

        Object x = lista.pega(2);
        System.out.println(x);

        System.out.println(lista.tamanho());

        lista.removeDoComeco();
        System.out.println(lista);

        System.out.println(lista.tamanho());
    }
}
