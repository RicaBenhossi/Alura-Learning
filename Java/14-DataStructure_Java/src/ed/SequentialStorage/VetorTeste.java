package ed.SequentialStorage;

public class VetorTeste {

    public static void main(String[] args) {

        Aluno a1 = new Aluno("Maria");
        Aluno a2 = new Aluno("João");

        Vetor lista = new Vetor();

        System.out.println("----------------------Testa tamanho e adiciona(aluno)----------------------");
        System.out.println(lista.tamanho());
        lista.adiciona(a1);
        System.out.println(lista.tamanho());
        lista.adiciona(a2);
        System.out.println(lista.tamanho());

        System.out.println(lista);

        System.out.println("----------------------Testa contem----------------------");
        System.out.println(lista.contem(a1));

        Aluno a3 = new Aluno("Daniel");
        // here we can have some problems if the student Daniel i not in the list.
        // See contem method notes.
        System.out.println(lista.contem(a3));

        System.out.println("----------------------Testa pega----------------------");
        Aluno y = lista.pega(1);
        System.out.println(y.getNome());

        // Here we have a problem: tour vector is only until 100. So, we'll receive an "Index out of bounds exception".
        // See method to see how we solved this.
        // Aluno x = lista.pega(158);
        // System.out.println(x.getNome());

        System.out.println("----------------------Testa adiciona(posicao, aluno)----------------------");
        lista.adiciona(1, a3);
        System.out.println(lista);

        // lista.adiciona(900, y);

        System.out.println("----------------------Testa remove----------------------");
        lista.remove(1);
        System.out.println(lista);

        System.out.println("----------------------Testa garanteEspaco----------------------");
        for (int i = 0; i < 300; i++) {
            Aluno z = new Aluno("Natalia" + i);
            lista.adiciona(z);
        }
        System.out.println(lista);
        System.out.println(lista.tamanho());
    }

}
