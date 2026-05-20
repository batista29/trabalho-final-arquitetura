package personagens;

import itens.Item;

public class Zabuza extends Inimigo {
    public Zabuza() {
        super("Zabuza", 150, 25, 10, 2);

        getInventario().adicionarItem(new Item("Kunai", "Aumenta o ataque temporariamente", "ataque", 3));
        getInventario().adicionarItem(new Item("Poção de Cura", "Recupera 50 de HP", "cura", 2));
    }

    @Override
    public void atacar(Personagem alvo, int dado) {
        System.out.println(getNome() + " usou Decapitação Silenciosa!");

        int vidaAntes = alvo.getPontosVida();
        int dano = (getAtaque() + dado) + 5 - alvo.getDefesa();
        if (dano < 0) dano = 0;

        alvo.setPontosVida(alvo.getPontosVida() - dano);

        int vidaDepois = alvo.getPontosVida();
        int danoReal = vidaAntes - vidaDepois;

        exibirResultadoAtaque(alvo, danoReal, vidaDepois);
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}
