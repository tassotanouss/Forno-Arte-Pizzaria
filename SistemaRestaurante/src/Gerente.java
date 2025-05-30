package gerente;

import model.PedidoController;
import java.util.Scanner;

public class Gerente {
    private static final PedidoController controller = new PedidoController();

    public static void iniciar() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== ÁREA DO GERENTE ===");
            System.out.println("1. Relatório de pedidos");
            System.out.println("2. Alterar status de pedido");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> gerarRelatorio();
                case 2 -> alterarStatusPedido(sc);
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        } while (true);
    }

    private static void gerarRelatorio() {
        System.out.println("\n📊 RELATÓRIO DE PEDIDOS 📊");
        controller.listarPedidos();  // Usa o mesmo método do Garçom
    }

    private static void alterarStatusPedido(Scanner sc) {
        System.out.print("ID do pedido: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Novo status (PENDENTE/PREPARO/ENTREGUE): ");
        String status = sc.nextLine();

        if (controller.alterarStatusPedido(id, status)) {
            System.out.println("✅ Status atualizado!");
        } else {
            System.out.println("❌ Pedido não encontrado!");
        }
    }
}
