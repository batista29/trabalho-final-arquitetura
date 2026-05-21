package itens;

import personagens.Personagem;

public class EfeitoAtaque implements EfeitoDeItem {

    private final int bonus;

    public EfeitoAtaque(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void aplicar(Personagem personagem) {
        personagem.setAtaque(
            personagem.getAtaque() + bonus
        );
    }
}