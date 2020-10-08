package ed.Stack_Pilha;

import java.util.LinkedList;
import java.util.List;

public class Pilha {

    // NOTE: Stack will always add o element beside another, but will only work with the LAST element (LIFO).
    private List<String> nomes = new LinkedList<String>();

    public void insere(String nome) {
        nomes.add(nome);
    }

    // Stack will always remove the last element of the stack
    public String remove() {
        return nomes.remove(nomes.size() - 1);
    }

    public boolean vazia() {
        return nomes.isEmpty();
    }

    @Override
    public String toString() {
        return nomes.toString();
    }
}