package itens;

import personagens.Personagem;

public class EfeitoDefesa implements EfeitoDeItem {

    private final int bonus;

    public EfeitoDefesa(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void aplicar(Personagem alvo) {
        alvo.setDefesa(alvo.getDefesa() + bonus);

        System.out.println(
            alvo.getNome()
            + " recebeu +"
            + bonus
            + " de defesa!"
        );
    }
}