
package exercicio2;

public class ListaDupla<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho = 0;
    private No<T> atual;

    public ListaDupla() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
        this.atual = null;
    }

    // METODOS DE INSERIR

    public void adicionarNoFim(T dado) {
        No<T> novoNo = new No<>(dado);

        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }

        if (atual == null) {
            atual = novoNo;
        }

        tamanho++;
    }

    public void adicionarNoInicio(T dado) {
        No<T> novoNo = new No<>(dado);

        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }

        if (atual == null) {
            atual = novoNo;
        }

        tamanho++;
    }

    public void adicionarNaPosicao(T dado, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            return;
        }

        if (posicao == 0) {
            adicionarNoInicio(dado);
            return;
        }

        if (posicao == tamanho) {
            adicionarNoFim(dado);
            return;
        }

        No<T> atual = inicio;
        int i = 0;

        while (i < posicao) {
            atual = atual.proximo;
            i++;
        }

        No<T> novoNo = new No<>(dado);

        novoNo.proximo = atual;
        novoNo.anterior = atual.anterior;

        atual.anterior.proximo = novoNo;
        atual.anterior = novoNo;

        tamanho++;
    }

    // METODOS DE REMOCAO

    public void removerDoInicio() {
        if (inicio == null) {
            return;
        }

        if (this.atual == inicio) {
            this.atual = inicio.proximo;
        }

        if (tamanho == 1) {
            inicio = null;
            fim = null;
            this.atual = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }

        tamanho--;
    }

    public void removerDoFim() {
        if (inicio == null) {
            return;
        }

        if (this.atual == fim) {
            this.atual = fim.anterior;
        }

        if (tamanho == 1) {
            inicio = null;
            fim = null;
            this.atual = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }

        tamanho--;
    }

    public void removerDaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return;
        }

        if (posicao == 0) {
            removerDoInicio();
            return;
        }

        if (posicao == tamanho - 1) {
            removerDoFim();
            return;
        }

        No<T> atual = inicio;
        int i = 0;

        while (i < posicao) {
            atual = atual.proximo;
            i++;
        }

        if (this.atual == atual) {
            this.atual = atual.proximo;
        }

        atual.anterior.proximo = atual.proximo;
        atual.proximo.anterior = atual.anterior;

        tamanho--;
    }

    public void removerPorValor(T dado) {
        No<T> atual = inicio;

        while (atual != null) {
            if (atual.dado.equals(dado)) {
                if (atual == inicio) {
                    removerDoInicio();
                    return;
                }

                if (atual == fim) {
                    removerDoFim();
                    return;
                }

                if (this.atual == atual) {
                    this.atual = atual.proximo;
                }

                atual.anterior.proximo = atual.proximo;
                atual.proximo.anterior = atual.anterior;

                tamanho--;
                return;
            }

            atual = atual.proximo;
        }
    }

    public boolean removerPorTitulo(String titulo) {
        No<T> atual = inicio;

        while (atual != null) {
            Musica musica = (Musica) atual.dado;

            if (musica.titulo.equalsIgnoreCase(titulo)) {
                if (atual == inicio) {
                    removerDoInicio();
                } else if (atual == fim) {
                    removerDoFim();
                } else {
                    if (this.atual == atual) {
                        this.atual = atual.proximo;
                    }

                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;

                    tamanho--;
                }

                return true;
            }

            atual = atual.proximo;
        }

        return false;
    }

    // METODOS DE BUSCA

    public boolean buscarValor(T dado) {
        No<T> atual = inicio;

        while (atual != null) {
            if (atual.dado.equals(dado)) {
                return true;
            }

            atual = atual.proximo;
        }

        return false;
    }

    public T buscarPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        No<T> atual = inicio;
        int i = 0;

        while (i < posicao) {
            atual = atual.proximo;
            i++;
        }

        return atual.dado;
    }

    // METODO DE ATUALIZACAO

    public void atualizar(int posicao, T dado) {
        if (posicao < 0 || posicao >= tamanho) {
            return;
        }

        No<T> atual = inicio;
        int i = 0;

        while (i < posicao) {
            atual = atual.proximo;
            i++;
        }

        atual.dado = dado;
    }

    // METODOS DE NAVEGACAO

    public T musicaAtual() {
        if (atual == null) {
            atual = inicio;
        }

        if (atual == null) {
            return null;
        }

        return atual.dado;
    }

    public T proximaMusica() {
        if (atual == null) {
            atual = inicio;
        } else if (atual.proximo != null) {
            atual = atual.proximo;
        }

        if (atual == null) {
            return null;
        }

        return atual.dado;
    }

    public T musicaAnterior() {
        if (atual == null) {
            atual = inicio;
        } else if (atual.anterior != null) {
            atual = atual.anterior;
        }

        if (atual == null) {
            return null;
        }

        return atual.dado;
    }

    // METODOS DE ORDENACAO

    public void ordenarPorTitulo() {
        No<T> noAtual = inicio;

        while (noAtual != null) {
            No<T> novoNo = noAtual.proximo;

            while (novoNo != null) {
                Musica musica1 = (Musica) noAtual.dado;
                Musica musica2 = (Musica) novoNo.dado;

                if (musica1.titulo.compareTo(musica2.titulo) > 0) {
                    T dado = noAtual.dado;
                    noAtual.dado = novoNo.dado;
                    novoNo.dado = dado;
                }

                novoNo = novoNo.proximo;
            }

            noAtual = noAtual.proximo;
        }
    }

    public void ordenarPorArtista() {
        No<T> noAtual = inicio;

        while (noAtual != null) {
            No<T> novoNo = noAtual.proximo;

            while (novoNo != null) {
                Musica musica1 = (Musica) noAtual.dado;
                Musica musica2 = (Musica) novoNo.dado;

                if (musica1.artista.compareTo(musica2.artista) > 0) {
                    T dado = noAtual.dado;
                    noAtual.dado = novoNo.dado;
                    novoNo.dado = dado;
                }

                novoNo = novoNo.proximo;
            }

            noAtual = noAtual.proximo;
        }
    }

    // METODOS AUXILIARES

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void limpar() {
        inicio = null;
        fim = null;
        atual = null;
        tamanho = 0;
    }

    public void exibir() {
        No<T> atual = inicio;

        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }
}
