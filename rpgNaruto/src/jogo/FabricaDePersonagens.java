package jogo;

import java.util.List;
import personagens.Naruto;
import personagens.Personagem;
import personagens.Sakura;
import personagens.Sasuke;

public class FabricaDePersonagens {

    private final List<OpcaoDePersonagem> opcoes;

    public FabricaDePersonagens() {
        this.opcoes = List.of(
            new OpcaoDePersonagem("1", "Naruto", Naruto::new),
            new OpcaoDePersonagem("2", "Sasuke", Sasuke::new),
            new OpcaoDePersonagem("3", "Sakura", Sakura::new)
        );
    }

    public List<OpcaoDePersonagem> listarOpcoes() {
        return opcoes;
    }

    public Personagem criarPorCodigo(String codigo) {
        for (OpcaoDePersonagem opcao : opcoes) {
            if (opcao.getCodigo().equals(codigo)) {
                return opcao.criarPersonagem();
            }
        }

        System.out.println("Opcao invalida, sera escolhido o Naruto por padrao.");
        return opcoes.get(0).criarPersonagem();
    }
}
