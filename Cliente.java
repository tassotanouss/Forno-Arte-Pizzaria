import java.util.Scanner;


// CLASSE CLIENTE (Fazendo atalhos para as outras classes)
public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PedidoController controller = new PedidoController();
        Cardapio cardapio = new Cardapio();

        // Adicionando alguns itens ao cardápio (Faltou um banco de dados aqui kkkkk)
        cardapio.adicionarItem("Pizza Margherita", 45.90);
        cardapio.adicionarItem("Hambúrguer Artesanal", 32.50);
        cardapio.adicionarItem("Salada Caesar", 25.00);
        cardapio.adicionarItem("Sushi Variado", 58.90);
        cardapio.adicionarItem("Refrigerante", 8.50);
        cardapio.adicionarItem("Suco Natural", 12.00);
        cardapio.adicionarItem("Água Mineral", 5.00);

        int opcao;
        // Criando um visual para o clente
        do {
            System.out.println("\n=== SISTEMA DE PEDIDOS - CLIENTE ===");
            System.out.println("1. Visualizar cardápio");
            System.out.println("2. Ver status dos pedidos da mesa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            // Para limpar buffer
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    cardapio.exibirCardapio();
                    break;
                case 2:
                    System.out.print("Digite o número da mesa: ");
                    String mesa = sc.nextLine();
                    verificarPedidosMesa(controller, mesa);
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

    private static void verificarPedidosMesa(PedidoController controller, String mesa) {
        boolean encontrou = false;

        System.out.println("\n📋 Pedidos para a Mesa " + mesa + ":");
        for (Pedido p : controller.getPedidos()) {
            if (p.getMesa().equalsIgnoreCase(mesa)) {
                System.out.println("ID: " + p.getId() +
                        " | Item: " + p.getDescricao() +
                        " | Qtd: " + p.getQuantidade() +
                        " | Status: " + p.getStatus());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum pedido encontrado para esta mesa.");
        }
    }
}

// CLASSE CARDAPIO PARA O CLIENTE PODER ESCOLHER
class Cardapio {
    private List<ItemCardapio> itens = new ArrayList<>();

    public void adicionarItem(String nome, double preco) {
        itens.add(new ItemCardapio(nome, preco));
    }

    public void exibirCardapio() {
        System.out.println("\n🍽️  CARDÁPIO  🍽️");
        System.out.println("======================");
        for (ItemCardapio item : itens) {
            System.out.printf("%-20s R$ %.2f%n", item.getNome(), item.getPreco());
        }
        System.out.println("======================");
    }
}

// CLASSE ITEM CARDAPIO PARA O CLIENTE VÊ OS NOMES E PREÇOS DOS ITENS
class ItemCardapio {
    private String nome;
    private double preco;

    public ItemCardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}