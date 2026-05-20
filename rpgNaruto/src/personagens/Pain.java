package personagens;

import itens.Item;

public class Pain extends Inimigo {
    public Pain() {
        super("Pain", 220, 35, 20, 4);

        getInventario().adicionarItem(new Item("Rinnegan", "Olho poderoso", "cura", 1));
        getInventario().adicionarItem(new Item("Explosivo", "Ataque em área", "ataque", 3));
    }

    @Override
    public void atacar(Personagem alvo, int dado) {
        System.out.println(getNome() + " usou Shinra Tensei!");

        int vidaAntes = alvo.getPontosVida();
        int dano = (getAtaque() + dado) + 15 - alvo.getDefesa(); // ataque especial
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
