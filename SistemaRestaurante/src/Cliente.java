package cliente;

import model.Cardapio;
import model.PedidoController;
import java.util.Scanner;

public class Cliente {
    private static final PedidoController controller = new PedidoController();
    private static final Cardapio cardapio = new Cardapio();

    static {
        // Itens pré-cadastrados (simulando "banco de dados")
        cardapio.adicionarItem("Pizza Margherita", 45.90);
        cardapio.adicionarItem("Hambúrguer Artesanal", 32.50);
    }

    public static void iniciar() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== ÁREA DO CLIENTE ===");
            System.out.println("1. Visualizar cardápio");
            System.out.println("2. Ver pedidos da mesa");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cardapio.exibirCardapio();
                case 2 -> {
                    System.out.print("Digite o número da mesa: ");
                    String mesa = sc.nextLine();
                    controller.listarPedidosPorMesa(mesa);
                }
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        } while (true);
    }
}