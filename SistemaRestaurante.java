import java.util.*;
import java.util.stream.Collectors;

public class SistemaRestaurante {

    // Classe que representa um prato do cardápio, com nome e categoria
    static class Prato {
        String nome;
        String categoria;

        Prato(String nome, String categoria) {
            this.nome = nome;
            this.categoria = categoria;
        }
    }

    // Classe que representa um pedido feito por um cliente
    static class Pedido {
        String cliente;
        String status;
        Prato prato;

        Pedido(String cliente, String status, Prato prato) {
            this.cliente = cliente;
            this.status = status;
            this.prato = prato;
        }
    }

    // Lista simulada com pratos cadastrados no sistema
    static List<Prato> pratos = Arrays.asList(
        new Prato("Prato A", "Categoria 1"),
        new Prato("Prato B", "Categoria 2"),
        new Prato("Prato C", "Categoria 3")
    );

    // Lista simulada com pedidos realizados
    static List<Pedido> pedidos = Arrays.asList(
        new Pedido("Cliente 1", "Status 1", pratos.get(0)),
        new Pedido("Cliente 2", "Status 2", pratos.get(1)),
        new Pedido("Cliente 1", "Status 2", pratos.get(2))
    );

    // Função que permite ao gerente filtrar os pedidos com base em categoria, status e cliente
    public static void consultar(String filtroCategoria, String filtroStatus, String filtroCliente) {
        // Aplica os filtros de forma dinâmica, considerando os campos preenchidos
        List<Pedido> resultados = pedidos.stream()
            .filter(p -> (filtroCategoria == null || p.prato.categoria.equalsIgnoreCase(filtroCategoria)))
            .filter(p -> (filtroStatus == null || p.status.equalsIgnoreCase(filtroStatus)))
            .filter(p -> (filtroCliente == null || p.cliente.equalsIgnoreCase(filtroCliente)))
            .collect(Collectors.toList());

        // Exibe os resultados filtrados ou informa que nada foi encontrado
        if (resultados.isEmpty()) {
            System.out.println("Nenhum pedido encontrado com os filtros aplicados.");
        } else {
            for (Pedido p : resultados) {
                System.out.println("Cliente: " + p.cliente + " | Prato: " + p.prato.nome + 
                                   " (" + p.prato.categoria + ") | Status: " + p.status);
            }
        }
    }

    // Função principal que interage com o usuário e chama a consulta
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Filtrar por categoria (ou Enter para ignorar):");
        String categoria = sc.nextLine();
        categoria = categoria.isEmpty() ? null : categoria;

        System.out.println("Filtrar por status (ou Enter para ignorar):");
        String status = sc.nextLine();
        status = status.isEmpty() ? null : status;

        System.out.println("Filtrar por cliente (ou Enter para ignorar):");
        String cliente = sc.nextLine();
        cliente = cliente.isEmpty() ? null : cliente;

        // Chama a função de consulta com os filtros escolhidos
        System.out.println("\nResultados encontrados:");
        consultar(categoria, status, cliente);
    }
}
