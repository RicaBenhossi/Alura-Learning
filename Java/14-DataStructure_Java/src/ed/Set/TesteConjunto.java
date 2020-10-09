package ed.Set;

import java.util.HashSet;
import java.util.Set;

public class TesteConjunto {

    public static void main(String[] args) {

        // The problem here is that we have to iterate all the LinkedList to check if the name already exist. It costs performance.
        // if (!conjunto.contains("Maria Bonita")) {
        //     conjunto.add("Maria Bonita");
        // }
        Conjunto conjunto = new Conjunto();
        conjunto.adiciona("Maya Angelou");
        System.out.println(conjunto);
        conjunto.adiciona("Elizabeth II");
        System.out.println(conjunto);
        conjunto.adiciona("Marie Curie");
        System.out.println(conjunto);

        conjunto.remove("Marie Curie");
        System.out.println(conjunto);

        System.out.println("################################ JAVA SET ################################");

        Set<String> conjuntoJava = new HashSet<String>();

        conjuntoJava.add("Maya Anglou");
        conjuntoJava.add("Elizabeth II");
        conjuntoJava.add("Marie Curie");

        System.out.println(conjuntoJava);

        String name1 = "Elizabeth II";
        System.out.println(name1.hashCode());
        System.out.println("Elizabeth II".hashCode());
    }
}
