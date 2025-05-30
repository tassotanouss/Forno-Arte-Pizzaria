public class Cliente {
    private String nome;
    private int mesa;


    public Cliente(String nome, int mesa) {
        this.nome = nome;
        this.mesa = mesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "Cliente:" +
                "\nnome: " + nome+
                "\nmesa: " + mesa;
    }
}