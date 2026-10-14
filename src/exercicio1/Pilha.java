package exercicio1;

public class Pilha<T> {

    private node<T> inicio;
    private int tamanho;

    public Pilha() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void empilhar(T e) {

        node<T> novoNode = new node<>(e);

        if (inicio == null) {
            inicio = novoNode;
        } else {
            node<T> atual = inicio;

            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = novoNode;
        }

        tamanho++;
    }

    public node<T> desempilhar() {

        if (tamanho == 0) {
            System.out.println("Pilha vazia");
            return null;
        }

        if (tamanho == 1) {
            node<T> removido = inicio;
            inicio = null;
            tamanho--;
            return removido;
        }

        node<T> anterior = null;
        node<T> atual = inicio;

        while (atual.proximo != null) {
            anterior = atual;
            atual = atual.proximo;
        }

        anterior.proximo = null;
        tamanho--;

        return atual;
    }

    public node<T> espiar() {

        if (tamanho == 0) {
            System.out.println("Pilha vazia.");
            return null;
        }

        node<T> atual = inicio;

        while (atual.proximo != null) {
            atual = atual.proximo;
        }

        return atual;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public void exibir() {

        node<T> atual = inicio;

        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = atual.proximo;
        }

        System.out.println();
    }
}
