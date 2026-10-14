package exercicio1;

public class Pedido {

    String id;
    String descricao;

    public Pedido(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Descrição: " + descricao;
    }
}
