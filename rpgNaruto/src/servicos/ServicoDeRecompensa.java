package servicos;

import itens.FabricaDeItens;
import java.util.Random;
import personagens.Inimigo;
import personagens.Personagem;

public class ServicoDeRecompensa {

    private static final Random random = new Random();

    private ServicoDeRecompensa() {
    }

    public static void aplicarVitoria(Personagem jogador, Inimigo inimigo) {
        jogador.receberItensDoInimigo(inimigo);
        subirNivel(jogador);
        sortearItem(jogador);

        if (inimigo.getNome().equalsIgnoreCase("Pain")) {
            System.out.println("Sua vitoria foi convertida em premios!");
            System.out.println("Voce ganhou +35 HP e +10 de defesa.");
            jogador.setPontosVida(jogador.getPontosVida() + 35);
            jogador.setDefesa(jogador.getDefesa() + 10);
        }

        System.out.println("\nParabens, voce subiu de nivel!");
        System.out.println("Nivel atual: " + jogador.getNivel());
        System.out.println("Ataque: " + jogador.getAtaque());
        System.out.println("Defesa: " + jogador.getDefesa());
        System.out.println(jogador);
    }

    private static void subirNivel(Personagem jogador) {
        jogador.setNivel(jogador.getNivel() + 1);
        jogador.setAtaque(jogador.getAtaque() + 10);
        jogador.setDefesa(jogador.getDefesa() + 3);
        jogador.setPontosVida(jogador.getPontosVida() + 50);
    }

    private static void sortearItem(Personagem jogador) {
        int sorte = random.nextInt(4);

        switch (sorte) {
            case 0 -> jogador.getInventario().adicionarItem(FabricaDeItens.criarKunai());
            case 1 -> jogador.getInventario().adicionarItem(FabricaDeItens.criarPocao());
            case 2 -> jogador.getInventario().adicionarItem(FabricaDeItens.criarRinnegan());
            default -> {
            }
        }
    }
}
