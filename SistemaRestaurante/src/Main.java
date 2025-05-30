package main;

import cliente.Cliente;
import garcom.Garcom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SISTEMA RESTAURANTE ===");
            System.out.println("1. Área do Cliente");
            System.out.println("2. Área do Garçom");
            System.out.println("3. Área do Gerente");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            

            int escolha = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (escolha) {
                case 1 -> Cliente.iniciar();
                case 2 -> Garcom.iniciar();
                case 3 -> gerente.Gerente.iniciar();
                case 0 -> {
                    System.out.println("Encerrando...");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}