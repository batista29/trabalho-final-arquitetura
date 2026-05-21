package jogo;

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

    public ResultadoBatalha batalhar(
            Personagem jogador,
            Inimigo inimigo) {

        System.out.println(
            "\n--- Batalha Iniciada contra "
            + inimigo.getNome()
            + " ---"
        );

        while (
            jogador.getPontosVida() > 0
            && inimigo.getPontosVida() > 0
        ) {
            executarTurno(jogador, inimigo);
        }

        return avaliarResultado(jogador);
    }

    private void executarTurno(
            Personagem jogador,
            Inimigo inimigo) {

        System.out.println(
            "\nSua Vida: "
            + jogador.getPontosVida()
            + " | Vida do Inimigo: "
            + inimigo.getPontosVida()
        );

        System.out.println(
            "Escolha sua ação: 1- Atacar | 2- Usar Item"
        );

        String opcao = scanner.nextLine();

        if (opcao.equals("1")) {

            int dado = random.nextInt(1, 11);

            jogador.atacar(inimigo, dado);

        } else if (opcao.equals("2")) {

            if (jogador.getInventario().qtdItens() > 0) {

                var item =
                    jogador.getInventario().getItem(0);

                item.usar(jogador);

                jogador.getInventario()
                        .removerItem(item.getNome());

            } else {

                System.out.println(
                    "Seu inventário está vazio!"
                );
            }
        }

        if (inimigo.getPontosVida() > 0) {

            inimigo.atacar(
                jogador,
                random.nextInt(1, 11)
            );
        }
    }

    private ResultadoBatalha avaliarResultado(
            Personagem jogador) {

        if (jogador.getPontosVida() <= 0) {
            return ResultadoBatalha.DERROTA;
        }

        return ResultadoBatalha.VITORIA;
    }
}