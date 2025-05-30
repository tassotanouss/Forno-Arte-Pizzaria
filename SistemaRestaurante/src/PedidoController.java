package model;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {
    private final List<Pedido> pedidos = new ArrayList<>();

    public void adicionarPedido(String descricao, int quantidade, String mesa) {
        Pedido novoPedido = new Pedido(descricao, quantidade, mesa);
        pedidos.add(novoPedido);
        System.out.println("✅ Pedido registrado!");
    }

    public boolean alterarStatusPedido(int id, String novoStatus) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                p.setStatus(novoStatus);
                return true;
            }
        }
        return false;
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("📭 Nenhum pedido registrado.");
        } else {
            pedidos.forEach(System.out::println);
        }
    }

    public void listarPedidosPorMesa(String mesa) {
        pedidos.stream()
                .filter(p -> p.getMesa().equalsIgnoreCase(mesa))
                .forEach(System.out::println);
    }
}

