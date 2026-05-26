package jogo;

import java.util.Random;
import java.util.Scanner;
import servicos.ServicoBatalha;
import servicos.ServicoDeRecompensa;
import servicos.ServicoItensImpl;
import servicos.ServicoItensInterface;
import servicos.ServicoRecompensa;
import servicos.SistemaDeBatalha;
import ui.ConsoleItemUI;

public class GameFactory {

    public static Jogo criar() {
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

        return new Jogo(batalha, itens, recompensa, sc, random);
    }
}