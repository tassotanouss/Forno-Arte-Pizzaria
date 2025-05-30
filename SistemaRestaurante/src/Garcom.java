package garcom;

import model.PedidoController;
import java.util.Scanner;

public class Garcom {
    private static final PedidoController controller = new PedidoController();

    public static void iniciar() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== ÁREA DO GARÇOM ===");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Listar todos os pedidos");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Descrição do pedido: ");
                    String descricao = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Mesa: ");
                    String mesa = sc.nextLine();
                    controller.adicionarPedido(descricao, qtd, mesa);
                }
                case 2 -> controller.listarPedidos();
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        } while (true);
    }
}
