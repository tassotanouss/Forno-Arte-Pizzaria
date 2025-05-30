public class PratoController {
    public void cadastrarPrato(String nome, double preco, String categoria){
        Main.cardapio.adicionarPrato(new Prato(nome, preco, categoria));
        System.out.println("✅ Prato cadastrado com sucesso!");
    }

    Prato buscarPratoPorNome(String nome){
        for (Prato p : Main.cardapio.getPratos()){
            if(p.getNome().equalsIgnoreCase(nome)){
                return p;
            }
        }
        return null;
    }

    public void modificarPrato(String nomeAntigo, String nome, double preco, String categoria){
        Prato prato = buscarPratoPorNome(nomeAntigo);
        if (prato != null) {
            prato.setNome(nome);
            prato.setPreco(preco);
            prato.setCategoria(categoria);
            System.out.println("✅ Prato modificado com sucesso!");
        } else {
            System.out.println("❌ Prato não encontrado!");
            return;
        }
    }

    public void excluirPrato(String nome){
        Prato prato = buscarPratoPorNome(nome);
        if (prato != null){
            Main.cardapio.getPratos().remove(prato);
            System.out.println("✅ Prato removido com sucesso!");
        } else {
            System.out.println("❌ Prato não encontrado!");
            return;
        }
    }
}
