package servicos;

import itens.Inventario;
import java.util.Scanner;
import personagens.Personagem;

public interface ServicoItens {
    void escolherEUsarItem(Inventario inventario, Personagem jogador, Scanner scanner);
}
