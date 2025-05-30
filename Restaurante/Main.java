import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static Prato prato;
    public static Cardapio cardapio = new Cardapio();
    public static PedidoController pedidoController = new PedidoController();
    public static PratoController pratoController = new PratoController();
    public static ClienteController clienteController = new ClienteController();

    public static void main(String[] args) {
        // FUNCIONARIOS TESTE
        funcionarios.add(new Funcionario("adm", "123", "gerente"));
        funcionarios.add(new Funcionario("garcom", "123", "garcom"));

        menuPrincipal();
    }

    // Tela Principal
    public static void menuPrincipal(){
        int opcao;
        do {
            System.out.println("===      FORNO ARTE PIZZARIA    ===");

            System.out.println("1. Cliente");
            System.out.println("2. Funcionário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1:
                    menuCliente();
                    break;
                case 2:
                    loginFuncionario();
                    break;
                case 0:
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção invalida, digite novamente!");
            }
        } while (opcao != 0);

    }

    // Menu Cliente
    public static void menuCliente() {
        limparTerminal();
        System.out.println("===         MENU CLIENTE        ===");

        System.out.println("1. Ver Cardápio");
        System.out.println("2. Status do pedido");
        System.out.println("0. Voltar ao menu");
        System.out.print("Escolha uma opção: ");

        int opcao;
        do {
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    mostrarCardapio();
                    break;
                case 2:

                    break;
                case 0:
                    limparTerminal();
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção invalida, digite novamente!");
                    continue;
            }
            break;
        } while (opcao != 0);
    }

    public static void mostrarCardapio(){
        limparTerminal();
        System.out.println(cardapio);
        System.out.println("Pressione ENTER para voltar ao menu!");
        sc.nextLine();
        menuCliente();
    }

    // Menu Gerente
    public static void menuGerente() {
        limparTerminal();
        System.out.println("===         MENU GERENTE        ===");

        System.out.println("1. Gerenciar pratos");
        System.out.println("2. Gerenciar clientes");
        System.out.println("0. Voltar ao menu");
        System.out.print("Escolha uma opção: ");

        int opcao;
        do {
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    gerenciarPratos();
                    break;
                case 2:
                    gerenciarCliente();
                    break;
                case 0:
                    limparTerminal();
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção invalida, digite novamente!");
            }
        } while (opcao != 0);
    }

    //Gerenciamento de pratos
    public static void gerenciarPratos(){
        limparTerminal();
        System.out.println("===       GERENCIAR PRATOS      ===");

        System.out.println("1. Cadastrar novo prato");
        System.out.println("2. Modificar prato");
        System.out.println("3. Excluir prato");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");

        int opcao;
        do {
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPrato();
                    break;
                case 2:
                    modificarPrato();
                    break;
                case 3:
                    excluirPrato();
                    break;
                case 0:
                    menuGerente();
                    break;
                default:
                    System.out.println("Opção invalida, digite novamente!");
            }
        } while (opcao != 0);
    }

    // Cadastrar novo prato
    public static void cadastrarPrato(){
        limparTerminal();
        System.out.println("===       CADASTRO DE PRATO     ===");

        System.out.print("Nome do prato: ");
        String nome = sc.nextLine();
        System.out.print("Preço: R$");
        double preco = sc.nextDouble();
        sc.nextLine();
        System.out.print("Categoria: ");
        String categoria = sc.nextLine();

        pratoController.cadastrarPrato(nome, preco, categoria);

        gerenciarPratos();
    }
    
    // Modificar prato
    public static void modificarPrato() {
        limparTerminal();
        System.out.println("===        MODIFICAR PRATO      ===");

        for (Prato p : cardapio.getPratos()) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Preço: R$" + p.getPreco());
            System.out.println("Categoria: " + p.getCategoria());
            System.out.println();
        }

        System.out.print("Digite o nome do prato que deseja modificar: ");
        String nomeAntigo = sc.nextLine();

        Prato prato = pratoController.buscarPratoPorNome(nomeAntigo);
        if (prato == null) {
            System.out.println("❌ Prato não encontrado!");
            return;
        }

        System.out.println("Prato encontrado! Insira os novos dados:");
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Novo preço: R$");
        double preco = sc.nextDouble();
        sc.nextLine(); // limpar buffer
        System.out.print("Nova categoria: ");
        String categoria = sc.nextLine();

        pratoController.modificarPrato(nomeAntigo, nome, preco, categoria);

        gerenciarPratos();
    }

    public static void excluirPrato(){
        limparTerminal();
        System.out.println("===         EXCLUIR PRATO       ===");

        for (Prato p1 : cardapio.getPratos()){
            System.out.println("Nome: " + p1.getNome());
            System.out.println("Preço: " + p1.getPreco());
            System.out.println("Categoria: " + p1.getCategoria());
        }

        System.out.print("Digite o nome do prato que deseja excluir: ");
        String nome = sc.nextLine();
        
        pratoController.excluirPrato(nome);
        
        gerenciarPratos();
    }

    public static void gerenciarCliente(){
        limparTerminal();
        System.out.println("===       GERENCIAR CLIENTE     ===");

        System.out.println("Cadatrar novo cliente - 1");
        System.out.println("Modificar cliente - 2");
        System.out.println("Excluir cliente - 3");
        System.out.println("Voltar - 4");
        System.out.print("Escolha uma opção: ");

        int opcao;
        do {
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    modificarCliente();
                    break;
                case 3:
                    excluirCliente();
                    break;
                case 4:
                    menuGerente();
                    break;
                default:
                    System.out.println("Opção invalida, digite novamente!");
            }
        } while (opcao != 4);
    }

    // Registar Cliente
    public static void cadastrarCliente(){
        limparTerminal();
        System.out.println("===       REGISTRAR CLIENTE     ===");

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Numero da mesa: ");
        int mesa = sc.nextInt();
        sc.nextLine();
        
        clienteController.adicionarCliente(nome, mesa);
        
        gerenciarCliente();
    }

    public static void modificarCliente() {
        limparTerminal();
        System.out.println("===       MODIFICAR CLIENTE     ===");

        clienteController.listarClientes();

        System.out.print("Digite o nome do cliente que deseja modificar: ");
        String nomeAntigo = sc.nextLine();

        Cliente cliente = clienteController.buscarClientePorNome(nomeAntigo);

        if (cliente == null) {
            System.out.println("❌ Cliente não encontrado!");
            return;
        }

        System.out.println("Cliente encontrado! Insira os novos dados:");

        System.out.print("Novo nome: ");
        String novoNome = sc.nextLine();

        System.out.print("Nova mesa: ");
        int novaMesa = sc.nextInt();
        sc.nextLine();

        clienteController.modificarCliente(nomeAntigo, novoNome, novaMesa);

        gerenciarCliente(); // Volta ao menu de clientes
    }

    public static void excluirCliente(){
        limparTerminal();
        System.out.println("===        EXCLUIR CLIENTE      ===");

        System.out.print("Digite o nome do cliente que deseja excluir: ");
        String nome = sc.nextLine();

        clienteController.excluirCliente(nome);

        gerenciarCliente();
    }

    // Menu Garçom
    public static void menuGarcom() {
        limparTerminal();
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE PEDIDOS - GARÇOM ===");
            System.out.println("1. Registrar novo pedido");
            System.out.println("2. Listar pedidos");
            System.out.println("3. Alterar pedido");
            System.out.println("4. Excluir pedido");
            System.out.println("0. Voltar ao menu");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    pedidoController.listarPedidos();
                    sc.nextLine();
                    break;
                case 3:
                    alterarPedido();
                    break;
                case 4:
                    excluirPedido();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("❗ Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void registrarPedido(){
        System.out.print("Descrição do pedido: ");
        String desc = sc.nextLine();
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();
        sc.nextLine();
        System.out.print("Mesa: ");
        String mesa = sc.nextLine();
        pedidoController.adicionarPedido(desc, qtd, mesa);
    }

    public static void alterarPedido(){
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
        if (pedidoController.alterarPedido(idAlt, novaDesc, novaQtd, novaMesa)) {
            System.out.println("✅ Pedido alterado com sucesso.");
        } else {
            System.out.println("❌ Pedido não encontrado.");
        }
    }

    public static void excluirPedido() {
        System.out.print("ID do pedido a excluir: ");
        int idExc = sc.nextInt();
        if (pedidoController.excluirPedido(idExc)) {
            System.out.println("✅ Pedido excluído.");
        } else {
            System.out.println("❌ Pedido não encontrado.");
        }
    }

    // Login Funcionario
    public static void loginFuncionario() {
        limparTerminal();
        System.out.println("===       LOGIN FUNCIONARIO     ===");


        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.next();
        sc.nextLine();

        for (Funcionario f : funcionarios) {
            if (f.getNome().equals(nome) && f.getSenha().equals(senha)) {
                if (f.getCargo().equalsIgnoreCase("Gerente")){
                    menuGerente();
                    return;
                } else {
                    menuGarcom();
                    return;
                }
            }
        }
        System.out.println("Usuario ou senha invalidos");
    }

    public static void limparTerminal() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

}
