package ed.DoubledLinkedList;

public class LinkedList {

    private Celula primeira = null;
    private Celula ultima = null;
    private int totalDeElementos;

    public void adicionaNoComeco(Object elemento) {

        if (this.totalDeElementos == 0) {
            Celula nova = new Celula(elemento);
            // When is the fisrt element, it is the first and the last at the same time.
            this.primeira = nova;
            this.ultima = nova;
        } else {
            // When it is not the fisrt we need to set the actual element as the next of the new element,
            // and the new element as the previous element of the actual element.
            Celula nova = new Celula(elemento, this.primeira);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }

        this.totalDeElementos++;
    }

    public void adiciona(Object elemento) {

        if (this.totalDeElementos == 0) {
            adicionaNoComeco(elemento);
        } else {
            // Now we have to set the prior too.
            Celula nova = new Celula(elemento);
            this.ultima.setProximo(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
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

        if (posicao == 0) {
            adicionaNoComeco(elemento);
        } else if (posicao == totalDeElementos) {
            adiciona(elemento);
        } else {

            // Here we're inserting an element between 2 elements of the list. So we have to:
                // set the new element next to the next element of the previous one.
                // set the new element prior to the prior element
                // set the prior element next to the new element
                // set the next element prior to the new element.
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula nova = new Celula(elemento, anterior.getProximo());
            Celula proxima = anterior.getProximo();

            nova.setProximo(anterior.getProximo());
            nova.setAnterior(anterior);
            anterior.setProximo(nova);
            proxima.setAnterior(nova);

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

        this.primeira = this.primeira.getProximo();
        this.totalDeElementos--;

        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }

    public void remove(int posicao) {
        if (this.totalDeElementos == 1) {
            removeDoComeco();
        } else if (posicao == this.totalDeElementos - 1) {
            removeDofim();
        } else {

            // To remove an element in a certain position we just need to adjust where the prior element next and
            // and the next element prior is pointing
            // Prior element next should pointing to actual element next
            // Next element prior should pointing to actual element prior
            Celula atual = this.pegaCelula(posicao);
            Celula anterior = atual.getAnterior();
            Celula proxima = atual.getProximo();

            anterior.setProximo(atual.getProximo());
            proxima.setAnterior(atual.getAnterior());

            this.totalDeElementos--;
        }

    }

    public void removeDofim() {
        if (this.totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = this.ultima.getAnterior();

            penultima.setProximo(null);
            this.ultima = penultima;

            this.totalDeElementos--;
        }
    }

    public int tamanho() {

        return this.totalDeElementos;
    }

    public boolean contem(Object elemento) {

        Celula atual = this.primeira;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }

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
