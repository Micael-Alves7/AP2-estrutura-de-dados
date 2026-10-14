package exercicio2;

public class Musica {
    String titulo;
    String album;
    String artista;
    String duracao;

    public Musica(String titulo, String album, String artista, String duracao) {
        this.titulo = titulo;
        this.album = album;
        this.artista = artista;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo
                + " | Artista: " + artista
                + " | Album: " + album
                + " | Duracao: " + duracao;
    }

}
