package ed.Set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Conjunto {

    // NOTE: Set is a list that contains olny unique members.

    // The idea is to spread the elements inside an minor portion to make the seek of the element easier.
    // For exemple, alphabetic order. We'll have a list that will contains 26 lists, one for each letter.

    // To increae perform, we can store all the LinkedList of letters into an ArrayList
    // The ArrayList is better to navigate using index. So they will be faster on finding the right letter LinkedList
    // LinkedList<LinkedList<String>> tabela = new LinkedList<LinkedList<String>>();
    ArrayList<LinkedList<String>> tabela = new ArrayList<LinkedList<String>>();

    public Conjunto() {
        for (int i = 0; i < 26; i++) {
            tabela.add(new LinkedList<String>());
        }
    }

    public void adiciona(String palavra) {
        if (!contem(palavra)) {
            int indice = calculaIndiceDaTabela(palavra);
            // We use GET all the time, that justifies the use of ArrayList to aggregate the LinkedLists.
            // ArrayLists are more performatic when you need access elements by index
            List<String> lista = tabela.get(indice);
            lista.add(palavra);
        }
    }

    public void remove(String palavra) {
        if (contem(palavra)){
            int index = calculaIndiceDaTabela(palavra);
            List<String> lista = tabela.get(index);
            lista.remove(palavra);
        }
    }

    private boolean contem(String palavra) {
        int indice = calculaIndiceDaTabela(palavra);
        return tabela.get(indice).contains(palavra);
    }

    // This method controls the index of the alphabetic list.
    // So we need to be careful and sure that it will always have the same return when passing the same letter.
    // Otherwise, our set will be messed up.
    private int calculaIndiceDaTabela(String palavra) {
        return palavra.toLowerCase().charAt(0) % 26;
    }

    @Override
    public String toString() {
        return tabela.toString();
    }
}
