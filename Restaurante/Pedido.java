public class Pedido {
    private static int contadorId = 1;
    private int id;
    private String descricao;
    private int quantidade;
    private String mesa;

    public Pedido(String descricao, int quantidade, String mesa) {
        this.id = contadorId++;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.mesa = mesa;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " | " + quantidade + "x " + descricao + " | Mesa: " + mesa;
    }
}