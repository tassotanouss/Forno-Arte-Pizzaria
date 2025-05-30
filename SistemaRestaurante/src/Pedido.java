package model;

public class Pedido {
    private static int contadorId = 1;
    private int id;
    private String descricao;
    private int quantidade;
    private String mesa;
    private String status; // PENDENTE, PREPARO, ENTREGUE

    public Pedido(String descricao, int quantidade, String mesa) {
        this.id = contadorId++;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.mesa = mesa;
        this.status = "PENDENTE";
    }

    // Getters e Setters (métodos abaixo)
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public String getMesa() { return mesa; }
    public void setMesa(String mesa) { this.mesa = mesa; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format(
                "Pedido #%d | %dx %s | Mesa: %s | Status: %s",
                id, quantidade, descricao, mesa, status
        );
    }
}
