package servicos;

import itens.Inventario;
import personagens.Personagem;

public interface ServicoItensInterface {
    void usarItem(Inventario inventario, Personagem jogador, int indice);
}