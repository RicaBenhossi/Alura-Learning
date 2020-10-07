package ed.DoubledLinkedList;

public class Celula {

    private Object elemento;
    // NOTE: Doubled linked List means every elements has 2 arrows:
    // one pointting to previous element and another pointing to the next element.
    // Fisrt element has anterior = null // Last element has proximo = null.
    private Celula anterior;
    private Celula proximo;

    public Celula(Object elemento) {
        this(elemento, null);
    }

    public Celula(Object elemento, Celula proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public Object getElemento() {
        return elemento;
    }

    public Celula getProximo() {
        return proximo;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }
}
