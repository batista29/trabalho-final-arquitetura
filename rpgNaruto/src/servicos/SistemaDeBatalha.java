package servicos;

import java.util.Random;
import java.util.Scanner;
import personagens.Inimigo;
import personagens.Personagem;

public class SistemaDeBatalha {

    private final Scanner scanner;
    private final Random random = new Random();

    public SistemaDeBatalha(Scanner scanner) {
        this.scanner = scanner;
    }

    public ResultadoBatalha batalhar(Personagem jogador, Inimigo inimigo) {
        System.out.println("\n--- Batalha iniciada contra " + inimigo.getNome() + " ---");

        while (jogador.getPontosVida() > 0 && inimigo.getPontosVida() > 0) {
            ResultadoBatalha resultadoTurno = executarTurno(jogador, inimigo);

            if (resultadoTurno == ResultadoBatalha.FUGA) {
                return ResultadoBatalha.FUGA;
            }
        }

        return avaliarResultado(jogador);
    }

    private ResultadoBatalha executarTurno(Personagem jogador, Inimigo inimigo) {
        System.out.println(
            "\nSua vida: " + jogador.getPontosVida()
            + " | Vida do inimigo: " + inimigo.getPontosVida()
        );

        System.out.println("Escolha sua acao: 1- Atacar | 2- Usar item | 3- Fugir");

        String opcao = scanner.nextLine().trim();

        if (opcao.equals("1")) {
            int dado = random.nextInt(1, 11);
            jogador.atacar(inimigo, dado);
        } else if (opcao.equals("2")) {
            ServicoDeItens.escolherEUsarItem(
                jogador.getInventario(),
                jogador,
                scanner
            );
        } else if (opcao.equals("3")) {
            if (random.nextBoolean()) {
                System.out.println("Voce conseguiu fugir!");
                return ResultadoBatalha.FUGA;
            }

            System.out.println("Falhou em fugir! O inimigo contra-ataca!");
        } else {
            System.out.println("Opcao invalida. Voce perdeu o turno.");
        }

        if (inimigo.getPontosVida() > 0) {
            inimigo.atacar(jogador, random.nextInt(1, 11));
        }

        return avaliarResultado(jogador);
    }

    private ResultadoBatalha avaliarResultado(Personagem jogador) {
        if (jogador.getPontosVida() <= 0) {
            return ResultadoBatalha.DERROTA;
        }

        return ResultadoBatalha.VITORIA;
    }
}
