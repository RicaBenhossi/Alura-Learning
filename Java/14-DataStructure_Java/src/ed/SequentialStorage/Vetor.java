package ed.SequentialStorage;

import java.util.Arrays;

public class Vetor {
    // NOTE Sequential Storage Vector - ARRAY
    // The idea is to store students side by side.
    private Aluno[] alunos = new Aluno[100];
    private int totalDeAlunos = 0;

    public void adiciona(Aluno aluno){
        this.garanteEspaco();

        // This is not the best way. With an small array it's fine, but if we have only the last position empty,
        // It'll have to iterate aaalll positions to stor the data. So the performance go to hell.

        // ** This is the O(n) problem.The bigger your array, the slowest is to find an empty spot.

        // for (int i = 0; i < alunos.length; i++) {
        //     if (alunos[i] == null) {
        //         alunos[i]= aluno;
        //         break;
        //     }
        // }

        // A better way is to use an algorithm that allways takes the same time to store the data at the position
        // The idea is to cretae a global variable that conut the amount od students and use it as an index of the array.
        // After insert, we increment it to show how many students we have AND the next empty position.
        // In this caso, every position you have to insert takes the same time to do.
        this.alunos[totalDeAlunos] = aluno;
        totalDeAlunos ++;
    }

    public void adiciona(int posicaoAluno, Aluno aluno) {
        this.garanteEspaco();
        // Here we have a position to insert the new aluno. So we have to get all the alunos and move one position right.
        // This is also an O(n) algorithm
        if (!posicaoValida(posicaoAluno)) {
            throw new IllegalArgumentException("Posição inválida.");
        }

        for (int i = totalDeAlunos - 1; i >= posicaoAluno; i--) {
            alunos[i+1] = alunos[i];
        }

        alunos[posicaoAluno] = aluno;
        totalDeAlunos++;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= totalDeAlunos;
    }

    private void garanteEspaco() {
        if (totalDeAlunos == alunos.length) {
            Aluno[] novoArray = new Aluno[alunos.length * 2];
            for (int i = 0; i < alunos.length; i++) {
                novoArray[i] = alunos[i];
            }

            this.alunos = novoArray;
        }
    }

    public Aluno pega(int posicao) {
        // the trick here is that we can't return an position that has null value or that is bigger than the array length. So we have to validate
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição Inválida.");
        }
        return alunos[posicao];
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalDeAlunos;
    }

    public void remove(int posicao) {
        if (!posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posicao inválida.");
        }

        // Here we have to iterate until the totalDeAlunos because if we do totalDeAlunos -1, we won't delete the last position of totalDeAlunos
        // adn we'll have the same data in 2 positions.
        for (int i = posicao; i < this.totalDeAlunos; i++) {
            this.alunos[i] = this.alunos[i+1];
        }

        totalDeAlunos--;
    }

    public Boolean contem(Aluno aluno) {

        // Here the problem is: if aluno hit an index of alunos tha is null, we'll got an "NULL POINTER EXCEPTION"
        // for (int i = 0; i < alunos.length; i++) {
        //     if (aluno.equals(alunos[i])) {
        //         return true;
        //     }
        // }

        // To avoid this we have 2 possibilities:need to threat this
            // Make the equals method return false when the index content is null
            // Iterate alunos not to the end but unitil < totalDeAlunos, that is the total of filled positions.
        // This is O(n) andwe can't scape from it. The bigger is the aray more time we take to iterate and find a match (or not).
        for (int i = 0; i < totalDeAlunos; i++) {
            if (aluno.equals(alunos[i])) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {

        return totalDeAlunos;
    }

    public String toString() {

        return Arrays.toString(alunos);
    }
}
