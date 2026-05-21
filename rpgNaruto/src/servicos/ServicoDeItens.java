package servicos;

import itens.Inventario;
import itens.Item;
import java.util.Scanner;
import personagens.Personagem;

public class ServicoDeItens {

    private ServicoDeItens() {
    }

    public static void escolherEUsarItem(
            Inventario inventario,
            Personagem jogador,
            Scanner scanner) {

        inventario.listarItens();

        if (inventario.qtdItens() == 0) {
            return;
        }

        System.out.println("0 - sair");
        System.out.println("Digite o numero do item que deseja usar: ");

        int indice;

        try {
            indice = Integer.parseInt(scanner.nextLine().trim());

            if (indice == 0) {
                return;
            }

            indice--;

            if (indice < 0 || indice >= inventario.qtdItens()) {
                System.out.println("Valor invalido.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida!");
            return;
        }

        usarItem(inventario, jogador, indice);
    }

    public static void usarItem(
            Inventario inventario,
            Personagem jogador,
            int indice) {

        Item item = inventario.getItem(indice);

        if (item == null) {
            System.out.println("Item invalido!");
            return;
        }

        item.usar(jogador);
        inventario.removerItem(item.getNome());
    }
}
