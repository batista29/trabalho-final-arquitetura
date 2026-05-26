package servicos;

import itens.Inventario;
import itens.Item;
import personagens.Personagem;

public class ServicoItensImpl implements ServicoItensInterface {

    @Override
    public void usarItem(
            Inventario inventario,
            Personagem jogador,
            int indice) {

        if (indice < 0 || indice >= inventario.qtdItens()) {
            System.out.println("Item inválido!");
            return;
        }

        Item item = inventario.getItem(indice);

        if (item == null) {
            System.out.println("Item inválido!");
            return;
        }

        item.usar(jogador);
        inventario.removerItem(item.getNome());
    }
}