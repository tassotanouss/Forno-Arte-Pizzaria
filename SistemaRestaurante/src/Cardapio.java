package model;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private final List<ItemCardapio> itens = new ArrayList<>();

    public void adicionarItem(String nome, double preco) {
        itens.add(new ItemCardapio(nome, preco));
    }

    public void exibirCardapio() {
        System.out.println("\n🍽️  CARDÁPIO  🍽️");
        System.out.println("======================");
        itens.forEach(item ->
                System.out.printf("%-20s R$ %.2f%n", item.getNome(), item.getPreco())
        );
        System.out.println("======================");
    }
}