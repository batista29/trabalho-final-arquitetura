package jogo;

import itens.FabricaDeItens;
import java.util.Random;
import java.util.Scanner;
import personagens.Inimigo;
import personagens.Personagem;
import servicos.ResultadoBatalha;
import servicos.ServicoBatalha;

public class JogoActions {

    private final ServicoBatalha servicoBatalha;
    private final Scanner sc;
    private final Random random;

    public JogoActions(ServicoBatalha servicoBatalha, Scanner sc, Random random) {
        this.servicoBatalha = servicoBatalha;
        this.sc = sc;
        this.random = random;
    }

    public ResultadoBatalha enfrentar(Personagem jogador, Inimigo inimigo) {
        return servicoBatalha.batalhar(jogador, inimigo);
    }

    public void pressionarEnter() {
        System.out.println("\n[ENTER para continuar]");
        sc.nextLine();
    }

    public String lerInput() {
        return sc.nextLine().trim();
    }

    public boolean chance50() {
        return random.nextBoolean();
    }

    public void abrirBau(Personagem jogador, Inimigo inimigo) {
        int tesouro = random.nextInt(1, 4);

        switch (tesouro) {
            case 1 -> jogador.getInventario().adicionarItem(FabricaDeItens.criarPocao());
            case 2 -> {
                jogador.setDefesa(jogador.getDefesa() - 2);
                jogador.setPontosVida(jogador.getPontosVida() - 10);
            }
            case 3 -> inimigo.setPontosVida(0);
        }
    }
}