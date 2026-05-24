package servicos;

import personagens.Inimigo;
import personagens.Personagem;

public interface ServicoRecompensa {
    void aplicarVitoria(Personagem jogador, Inimigo inimigo);
}
