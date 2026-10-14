package exercicio1;

public class Fila<T> {

    private node<T> inicio;
    private node<T> fim;
    private int tamanho;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void enfileirar(T e) {

        node<T> novoNode = new node<>(e);

        if (inicio == null) {
            inicio = novoNode;
            fim = novoNode;
        } else {
            fim.proximo = novoNode;
            fim = novoNode;
        }

        tamanho++;
    }

    public node<T> desenfileirar() {

        if (tamanho == 0) {
            System.out.println("Fila vazia");
            return null;
        }

        node<T> removido = inicio;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        tamanho--;

        removido.proximo = null;

        return removido;
    }

    public node<T> primeiro() {

        if (tamanho == 0) {
            System.out.println("Fila vazia");
            return null;
        }

        return inicio;
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

