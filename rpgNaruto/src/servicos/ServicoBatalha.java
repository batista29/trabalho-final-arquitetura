package servicos;

import personagens.Inimigo;
import personagens.Personagem;

public interface ServicoBatalha {
    ResultadoBatalha batalhar(Personagem jogador, Inimigo inimigo);
}
