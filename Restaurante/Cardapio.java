import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Prato> pratos;

    public Cardapio(){
        this.pratos = new ArrayList<>();
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    @Override
    public String toString() {
        StringBuilder cardapio = new StringBuilder();
        cardapio.append("-------------------------------\n");
        cardapio.append("            Cardápio\n");
        cardapio.append("-------------------------------\n");

        for (Prato prato : pratos) {
            cardapio.append("\nNome: ").append(prato.getNome())
                    .append("\nCategoria: ").append(prato.getCategoria())
                    .append("\nPreço: R$").append(String.format("%.2f", prato.getPreco()))
                    .append("\n");
        }

        return cardapio.toString();
    }
}
