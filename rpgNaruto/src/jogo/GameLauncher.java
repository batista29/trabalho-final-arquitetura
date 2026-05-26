package jogo;

import java.util.Random;
import java.util.Scanner;

import servicos.ServicoBatalha;
import servicos.ServicoItensInterface;
import servicos.ServicoItensImpl;
import servicos.ServicoRecompensa;
import servicos.ServicoDeRecompensa;
import servicos.SistemaDeBatalha;

import ui.ConsoleItemUI;

public class GameLauncher {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        ServicoItensInterface itens = new ServicoItensImpl();
        ServicoRecompensa recompensa = new ServicoDeRecompensa(random);

        ServicoBatalha batalha = new SistemaDeBatalha(
            sc,
            random,
            itens,
            new ConsoleItemUI(sc)
        );

        Jogo jogo = new Jogo(
            batalha,
            itens,
            recompensa,
            sc,
            random
        );

        jogo.iniciar();
    }
}