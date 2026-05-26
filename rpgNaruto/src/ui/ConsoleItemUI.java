package ui;

import java.util.Scanner;
import itens.Inventario;

public class ConsoleItemUI {

    private final Scanner scanner;

    public ConsoleItemUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public int escolherItem(Inventario inventario) {

        inventario.listarItens();

        if (inventario.qtdItens() == 0) {
            System.out.println("Inventário vazio!");
            return -1;
        }

        System.out.println("\n0 - Sair");
        System.out.println("Escolha o número do item:");

        try {
            int escolha = Integer.parseInt(scanner.nextLine().trim());

            if (escolha == 0) {
                return -1;
            }

            int indice = escolha - 1;

            if (indice < 0 || indice >= inventario.qtdItens()) {
                System.out.println("Item inválido!");
                return -1;
            }

            return indice;

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida!");
            return -1;
        }
    }
}