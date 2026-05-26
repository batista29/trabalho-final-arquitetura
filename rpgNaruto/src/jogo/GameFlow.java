package jogo;

import itens.FabricaDeItens;
import personagens.Personagem;
import servicos.ResultadoBatalha;

public class GameFlow {

    private final Local[] locais;
    private final JogoActions actions;

    public GameFlow(Local[] locais, JogoActions actions) {
        this.locais = locais;
        this.actions = actions;
    }

    public int executarCena(int cena, Personagem jogador) throws Exception {

        return switch (cena) {

            case 0 -> cena0();
            case 1 -> cena1(jogador);
            case 2 -> cena2(jogador);
            case 3 -> cena3(jogador);
            case 4 -> cena4(jogador);
            case 5 -> cena5(jogador);
            case 6 -> cena6(jogador);
            case 7 -> cena7(jogador);

            default -> -1;
        };
    }

    private int cena0() throws Exception {
        System.out.println("\n[Konoha – Gabinete da Hokage]");
        actions.pressionarEnter();
        return 1;
    }

    private int cena1(Personagem jogador) throws Exception {
        Local alvo = locais[0];

        var resultado = actions.enfrentar(jogador, alvo.getInimigo());

        if (resultado == ResultadoBatalha.FUGA) return 3;

        String op = actions.lerInput();

        if (op.equals("2")) return 3;
        return 2;
    }

    private int cena2(Personagem jogador) throws Exception {
        Local alvo = locais[1];

        var resultado = actions.enfrentar(jogador, alvo.getInimigo());

        if (resultado == ResultadoBatalha.FUGA) return 3;

        actions.pressionarEnter();
        return 4;
    }

    private int cena3(Personagem jogador) {
        if (actions.chance50()) {
            jogador.getInventario().adicionarItem(FabricaDeItens.criarPocao());
        }

        actions.pressionarEnter();
        return 2;
    }

    private int cena4(Personagem jogador) throws Exception {
        Local alvo = locais[2];

        if (actions.lerInput().equals("1")) {
            actions.abrirBau(jogador, alvo.getInimigo());
        }

        var resultado = actions.enfrentar(jogador, alvo.getInimigo());

        if (resultado == ResultadoBatalha.FUGA) return 3;

        actions.pressionarEnter();
        return 5;
    }

    private int cena5(Personagem jogador) throws Exception {
        Local alvo = locais[4];

        var resultado = actions.enfrentar(jogador, alvo.getInimigo());

        if (resultado == ResultadoBatalha.FUGA) return 3;

        actions.pressionarEnter();
        return 6;
    }

    private int cena6(Personagem jogador) throws Exception {
        Local alvo = locais[5];

        var resultado = actions.enfrentar(jogador, alvo.getInimigo());

        if (resultado == ResultadoBatalha.FUGA) return 3;

        return 7;
    }

    private int cena7(Personagem jogador) throws Exception {
        Local alvo = locais[5];

        actions.enfrentar(jogador, alvo.getInimigo());

        return -1;
    }
}