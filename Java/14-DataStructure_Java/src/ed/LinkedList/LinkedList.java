package ed.LinkedList;

public class LinkedList {

    // Store the first item of the lista
    private Celula primeira = null;
    // Store the last item of the list
    private Celula ultima = null;
    private int totalDeElementos;

    public void adicionaNoComeco(Object elemento) {

        // NOTE Add items in the begining of the list
        // When adding on the beginning we must set the primeiro as the new celula we're
        // adding.
        Celula nova = new Celula(elemento, primeira);
        this.primeira = nova;

        // If this new celula is the first it's also the first (primeiro) and last
        // (ultimo) item on the list.
        if (this.totalDeElementos == 0) {
            this.ultima = this.primeira;
        }

        this.totalDeElementos++;
    }

    public void adiciona(Object elemento) {

        // NOTE Add items in the end of the list
        // If it is the first element just add on the beginning
        if (this.totalDeElementos == 0) {
            adicionaNoComeco(elemento);
        } else {
            // Here we create a new cell with proximo is null because, when adding at the
            // end, there is no next.
            Celula nova = new Celula(elemento, null);
            // Now we set this new element as the next element of the prior one, which was
            // the last before adding this new
            this.ultima.setProximo(nova);
            // And here we set the new element as the last element of the list.
            this.ultima = nova;
        }

        this.totalDeElementos++;

    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

    private Celula pegaCelula(int posicao) {

        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida.");
        }

        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual;
    }

    public void adiciona(int posicao, Object elemento) {

        // NOTE Inserting an element in the middle of the list
        if (posicao == 0) {
            adicionaNoComeco(elemento);
        } else if (posicao == totalDeElementos) {
            adiciona(elemento);
        } else {
            // The logic here is: take the prior element of the position you want to add
            Celula anterior = this.pegaCelula(posicao - 1);
            // Create the new celula setting the next (proximo) as the same next of the
            // prior element
            Celula nova = new Celula(elemento, anterior.getProximo());
            // Set the next (proximo) element of the prior element as the new element.
            anterior.setProximo(nova);

            this.totalDeElementos++;
        }
    }

    public Object pega(int posicao) {

        return this.pegaCelula(posicao).getElemento();
    }

    public void removeDoComeco() {

        if (this.totalDeElementos == 0) {
            throw new IllegalArgumentException("Lista vazia.");
        }

        // To remove an element on the beginning is just rearrange the reference to first element as the next (proximo)
        // This way, the second element is now the first.
        this.primeira = this.primeira.getProximo();
        this.totalDeElementos--;

        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }

    public void remove(int posicao) {

        // Celula anterior = pegaCelula(posicao - 1);
        // Celula atual = pegaCelula(posicao);
        // anterior.setProximo(atual.getProximo());

        // totalDeElementos--;

    }

    public int tamanho() {

        return this.totalDeElementos;
    }

    public boolean contem(Object obj) {

        return false;
    }

    @Override
    public String toString() {

        if (this.totalDeElementos == 0) {
            return "[]";
        }

        Celula atual = primeira;

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalDeElementos; i++) {

            if (i > 0 && i < totalDeElementos) {
                builder.append(",");
            }
            builder.append(atual.getElemento());

            atual = atual.getProximo();
        }
        builder.append("]");

        return builder.toString();
    }
}
