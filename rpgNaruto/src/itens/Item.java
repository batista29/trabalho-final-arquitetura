package itens;

import personagens.Personagem;

public class Item implements Cloneable {

    private final String nome;
    private final String descricao;
    private final EfeitoDeItem efeito;

    private int quantidade;

    public Item(
        String nome,
        String descricao,
        EfeitoDeItem efeito
    ) {
        this(nome, descricao, efeito, 1);
    }

    public Item(
        String nome,
        String descricao,
        EfeitoDeItem efeito,
        int quantidade
    ) {
        this.nome = nome;
        this.descricao = descricao;
        this.efeito = efeito;
        this.quantidade = quantidade;
    }

    public void usar(Personagem alvo) {
        if (efeito != null) {
            efeito.aplicar(alvo);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public Item clone() {
        try {
            return (Item) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}