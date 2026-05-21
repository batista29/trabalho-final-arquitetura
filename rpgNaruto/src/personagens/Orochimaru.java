package personagens;

import itens.EfeitoAtaque;
import itens.Item;

public class Orochimaru extends Inimigo {
     public Orochimaru() {
        super("Orochimaru", 180, 30, 15, 3);
    
        getInventario().adicionarItem(
            new Item(
                "Veneno Mortal",
                "Diminui HP gradualmente",
                new EfeitoAtaque(6)
            )
        );
    
        getInventario().adicionarItem(
            new Item(
                "Pergaminho Secreto",
                "Habilidade ninja",
                new EfeitoAtaque(5)
            )
        );
    }

    @Override
    public void atacar(Personagem alvo, int dado) {
        System.out.println(getNome() + " invocou serpentes!");

        int vidaAntes = alvo.getPontosVida();
        int dano = (getAtaque() + dado) + 10 - alvo.getDefesa();
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
