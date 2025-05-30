import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(String nome, int mesa) {
        Cliente novo = new Cliente(nome, mesa);
        clientes.add(novo);
        System.out.println("✅ Cliente cadastrado com sucesso!");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("❌ Nenhum cliente cadastrado.");
            return;
        } else {
            for (Cliente c : clientes) {
                System.out.println(c.toString());
            }
        }
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public void modificarCliente(String nomeAntigo, String novoNome, int novaMesa) {
        Cliente cliente = buscarClientePorNome(nomeAntigo);
        if (cliente != null) {
            cliente.setNome(novoNome);
            cliente.setMesa(novaMesa);
            System.out.println("✅ Cliente modificado com sucesso!");
        } else {
            System.out.println("❌ Cliente não encontrado!");
            return;
        }
    }

    public boolean excluirCliente(String nome) {
        Cliente cliente = buscarClientePorNome(nome);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }

    public boolean verificarCliente(String nome) {
        return buscarClientePorNome(nome) != null;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
