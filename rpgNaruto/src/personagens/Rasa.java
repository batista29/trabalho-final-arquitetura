package personagens;

import itens.EfeitoCura;
import itens.EfeitoDefesa;
import itens.Item;

public class Rasa extends Inimigo {

    public Rasa() {
        super("Rasa", 150, 25, 10, 3);

        getInventario().adicionarItem(
            new Item(
                "Tempestade de Areia",
                "Protege contra ataques",
                new EfeitoDefesa(3)
            )
        );

        getInventario().adicionarItem(
            new Item(
                "Poção de Cura",
                "Recupera HP",
                new EfeitoCura(50)
            )
        );
    }

    @Override
    public void atacar(Personagem alvo, int dado) {
        System.out.println(getNome() + " usou Tempestade de Areia Dourada!");

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