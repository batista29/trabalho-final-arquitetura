package jogo;

import itens.FabricaDeItens;
import itens.Inventario;
import java.util.Random;
import java.util.Scanner;
import personagens.Personagem;
import servicos.*;

public class Jogo {

    private final Scanner sc;
    private final Random random;

    private final ServicoBatalha servicoBatalha;
    private final ServicoItensInterface servicoItens;
    private final ServicoRecompensa servicoRecompensa;

    private final GameFlow gameFlow;
    private final JogoActions actions;

    public Jogo(
        ServicoBatalha servicoBatalha,
        ServicoItensInterface servicoItens,
        ServicoRecompensa servicoRecompensa,
        Scanner sc,
        Random random
    ) {
        this.servicoBatalha = servicoBatalha;
        this.servicoItens = servicoItens;
        this.servicoRecompensa = servicoRecompensa;

        this.sc = sc;
        this.random = random;

        this.actions = new JogoActions(servicoBatalha, sc, random);

        Local[] locais = FabricaDeLocais.criarLocais();

        this.gameFlow = new GameFlow(locais, actions);
    }

    public void iniciar() throws Exception {
        System.out.println("=== RPG Naruto: Batalha Shinobi ===");

        Personagem jogador = escolherPersonagem();
        prepararJogador(jogador);

        int cena = 0;

        while (cena != -1) {
            cena = gameFlow.executarCena(cena, jogador);
        }

        System.out.println("Fim da jornada shinobi.");
    }

    private void prepararJogador(Personagem jogador) {
        Inventario inv = jogador.getInventario();

        inv.adicionarItem(FabricaDeItens.criarPocao());
        inv.adicionarItem(FabricaDeItens.criarKunai());
    }

    private Personagem escolherPersonagem() throws Exception {
        System.out.println("Escolha seu personagem:");

        for (OpcaoDePersonagem opcao : new FabricaDePersonagens().listarOpcoes()) {
            System.out.println(opcao.getCodigo() + " - " + opcao.getNome());
        }

        String opcao = sc.nextLine().trim();

        return new FabricaDePersonagens().criarPorCodigo(opcao);
    }
}