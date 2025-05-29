import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PedidoController controller = new PedidoController();

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE PEDIDOS - GARÇOM ===");
            System.out.println("1. Registrar novo pedido");
            System.out.println("2. Listar pedidos");
            System.out.println("3. Alterar pedido");
            System.out.println("4. Excluir pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Descrição do pedido: ");
                    String desc = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Mesa: ");
                    String mesa = sc.nextLine();
                    controller.adicionarPedido(desc, qtd, mesa);
                    break;
                case 2:
                    controller.listarPedidos();
                    break;
                case 3:
                    System.out.print("ID do pedido a alterar: ");
                    int idAlt = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nova descrição: ");
                    String novaDesc = sc.nextLine();
                    System.out.print("Nova quantidade: ");
                    int novaQtd = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nova mesa: ");
                    String novaMesa = sc.nextLine();
                    if (controller.alterarPedido(idAlt, novaDesc, novaQtd, novaMesa)) {
                        System.out.println("✅ Pedido alterado com sucesso.");
                    } else {
                        System.out.println("❌ Pedido não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID do pedido a excluir: ");
                    int idExc = sc.nextInt();
                    if (controller.excluirPedido(idExc)) {
                        System.out.println("✅ Pedido excluído.");
                    } else {
                        System.out.println("❌ Pedido não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("❗ Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
