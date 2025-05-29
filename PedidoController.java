import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PedidoController {
    private List<Pedido> pedidos = new ArrayList<>();

    public void adicionarPedido(String descricao, int quantidade, String mesa) {
        Pedido novo = new Pedido(descricao, quantidade, mesa);
        pedidos.add(novo);
        System.out.println("✅ Pedido registrado com sucesso!");
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("📭 Nenhum pedido registrado.");
        } else {
            for (Pedido p : pedidos) {
                System.out.println(p);
            }
        }
    }

    public boolean alterarPedido(int id, String novaDescricao, int novaQuantidade, String novaMesa) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                p.setDescricao(novaDescricao);
                p.setQuantidade(novaQuantidade);
                p.setMesa(novaMesa);
                return true;
            }
        }
        return false;
    }

    public boolean excluirPedido(int id) {
        Iterator<Pedido> it = pedidos.iterator();
        while (it.hasNext()) {
            Pedido p = it.next();
            if (p.getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}