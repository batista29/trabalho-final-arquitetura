package jogo;

import java.util.function.Supplier;
import personagens.Personagem;

public class OpcaoDePersonagem {

    private final String codigo;
    private final String nome;
    private final Supplier<Personagem> criador;

    public OpcaoDePersonagem(
            String codigo,
            String nome,
            Supplier<Personagem> criador) {
        this.codigo = codigo;
        this.nome = nome;
        this.criador = criador;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Personagem criarPersonagem() {
        return criador.get();
    }
}
