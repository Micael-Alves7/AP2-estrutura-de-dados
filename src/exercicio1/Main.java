package exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pilha<Pedido> cancelados = new Pilha<>();
        Fila<Pedido> pendentes = new Fila<>();

        Scanner scan = new Scanner(System.in);

        int opcao = 0;
        int numeroPedido = 1;

        while(true){
            System.out.println("1 - Criar Pedido");
            System.out.println("2 - Atender Pedido");
            System.out.println("3 - Cancelar Pedido");
            System.out.println("4 - Restaurar Pedido");
            System.out.println("5 - Imprimir Pendentes");
            System.out.println("6 - Imprimir Cancelados");
            System.out.println("0 - Sair");

            opcao = scan.nextInt();
            scan.nextLine();
        switch (opcao){
            case 1:
                System.out.println("Informe a descrição do pedido:");
                String descricao = scan.nextLine();

                String idPedido = String.format("%03d", numeroPedido);
                numeroPedido++;

                Pedido pedido = new Pedido(idPedido, descricao);

                pendentes.enfileirar(pedido);

                System.out.println("Pedido criado");
                break;

            case 2:
                node<Pedido> atendido = pendentes.desenfileirar();

                if (atendido != null) {
                    System.out.println("Pedido atendido: " + atendido.elemento.id);
                }

                break;

            case 3:
                node<Pedido> cancelado = pendentes.desenfileirar();

                if (cancelado != null) {
                    cancelados.empilhar(cancelado.elemento);
                    System.out.println("Pedido cancelado: " + cancelado.elemento.id);
                }

                break;

            case 4:
                node<Pedido> restaurado = cancelados.desempilhar();

                if (restaurado != null) {
                    pendentes.enfileirar(restaurado.elemento);
                    System.out.println("Pedido restaurado: " + restaurado.elemento.id);
                }

                break;

            case 5:
                System.out.println("Pedidos pendentes:");
                pendentes.exibir();
                break;

                case 6:

                    System.out.println("Pedidos cancelados:");
                    cancelados.exibir();
                    break;

            case 0:
                System.out.println("Saindo...");
                scan.close();
                return;
            }
        }
    }
}
