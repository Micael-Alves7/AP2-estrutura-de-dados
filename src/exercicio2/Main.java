
package exercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDupla<Musica> playlist = new ListaDupla<>();

        Scanner scan = new Scanner(System.in);

        int opcao = 0;

        while (true) {
            System.out.println("1 - Proxima musica");
            System.out.println("2 - Musica anterior");
            System.out.println("3 - Ordenar playlist");
            System.out.println("4 - Tocar musica");
            System.out.println("5 - Adicionar musica");
            System.out.println("6 - Remover musica");
            System.out.println("7 - Listar musicas");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    Musica musica = playlist.proximaMusica();

                    if (musica != null) {
                        System.out.println(musica);
                    } else {
                        System.out.println("Playlist vazia!");
                    }
                    break;

                case 2:
                    Musica musicaAnterior = playlist.musicaAnterior();

                    if (musicaAnterior != null) {
                        System.out.println(musicaAnterior);
                    } else {
                        System.out.println("Playlist vazia!");
                    }
                    break;

                case 3:
                    System.out.println("1 - Ordenar por titulo");
                    System.out.println("2 - Ordenar por artista");

                    int ordem = scan.nextInt();
                    scan.nextLine();

                    if (ordem == 1) {
                        playlist.ordenarPorTitulo();
                        System.out.println("Playlist ordenada por titulo");
                    }

                    if (ordem == 2) {
                        playlist.ordenarPorArtista();
                        System.out.println("Playlist ordenada por artista");
                    }
                    break;

                case 4:
                    Musica atual = playlist.musicaAtual();

                    if (atual != null) {
                        System.out.println("Tocando musica:");
                        System.out.println(atual);
                    } else {
                        System.out.println("Playlist vazia!");
                    }
                    break;

                case 5:
                    System.out.print("Titulo: ");
                    String titulo = scan.nextLine();

                    System.out.print("Album: ");
                    String album = scan.nextLine();

                    System.out.print("Artista: ");
                    String artista = scan.nextLine();

                    System.out.print("Duracao: ");
                    String duracao = scan.nextLine();

                    Musica novaMusica = new Musica(
                            titulo, album, artista, duracao);

                    System.out.println("1 - Inicio");
                    System.out.println("2 - Fim");
                    System.out.println("3 - Posicao especifica");

                    int local = scan.nextInt();
                    scan.nextLine();

                    if (local == 1) {
                        playlist.adicionarNoInicio(novaMusica);
                        System.out.println("Musica adicionada!");
                    }

                    if (local == 2) {
                        playlist.adicionarNoFim(novaMusica);
                        System.out.println("Musica adicionada!");
                    }

                    if (local == 3) {
                        System.out.print("Posicao: ");
                        int posicao = scan.nextInt();
                        scan.nextLine();

                        if (posicao >= 0 && posicao <= playlist.tamanho()) {
                            playlist.adicionarNaPosicao(novaMusica, posicao);
                            System.out.println("Musica adicionada!");
                        } else {
                            System.out.println("Posicao invalida!");
                        }
                    }
                    break;

                case 6:
                    System.out.println("1 - Remover por posicao");
                    System.out.println("2 - Remover por titulo");

                    int remover = scan.nextInt();
                    scan.nextLine();

                    if (remover == 1) {
                        System.out.print("Posicao: ");
                        int posicao = scan.nextInt();
                        scan.nextLine();

                        if (posicao >= 0 && posicao < playlist.tamanho()) {
                            playlist.removerDaPosicao(posicao);
                            System.out.println("Musica removida!");
                        } else {
                            System.out.println("Posicao invalida!");
                        }
                    }

                    if (remover == 2) {
                        System.out.print("Titulo da musica: ");
                        String nome = scan.nextLine();

                        boolean removida = playlist.removerPorTitulo(nome);

                        if (removida) {
                            System.out.println("Musica removida!");
                        }

                        if (!removida) {
                            System.out.println("Musica nao encontrada!");
                        }
                    }

                case 7:
                    if (playlist.estaVazia()) {
                        System.out.println("Playlist vazia!");
                    } else {
                        playlist.exibir();
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scan.close();
                    return;
            }
        }
    }
}
