package itens;

import personagens.Personagem;

public class EfeitoCura implements EfeitoDeItem {
    private final int valorCura;

    public EfeitoCura(int valorCura) {
        this.valorCura = valorCura;
    }

    @Override
    public void aplicar(Personagem alvo) {
        alvo.setPontosVida(alvo.getPontosVida() + valorCura);
        System.out.println(alvo.getNome() + " recuperou " + valorCura + " de Vida!");
    }
}