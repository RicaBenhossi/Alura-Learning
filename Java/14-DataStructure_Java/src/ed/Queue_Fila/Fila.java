package ed.Queue_Fila;

import java.util.LinkedList;
import java.util.List;

public class Fila {

    // NOTE: Queue is similar to Stack, but it'll always work in the FIRST element of the queue (FIFO)
    private List<String> alunos = new LinkedList<String>();

    public void adiciona(String aluno) {
        alunos.add(aluno);
    }

    @Override
    public String toString() {
        return alunos.toString();
    }

    // Queue will always remove the first element.
    public String remove() {
        return alunos.remove(0);
    }

    public boolean vazia() {
        return alunos.isEmpty();
    }
}
