package itens;

public class Item implements Comparable<Item>, Cloneable {
    private String nome;
    private String descricao;
    private String efeito;
    private int quantidade;

    public Item(String nome, String descricao, String efeito, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.efeito = efeito;
        this.quantidade = quantidade;
    }

    public Item(Item outro) {
        this.nome = outro.nome;
        this.descricao = outro.descricao;
        this.efeito = outro.efeito;
        this.quantidade = outro.quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEfeito() {
        return efeito;
    }

    public int getQuantidade() {
        return quantidade;

    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void usar() {
        if (quantidade > 0) {
            quantidade--;
            System.out.println("Usou " + nome + ". Restam " + quantidade + " unidade(s).");
        } else {
            System.out.println("Você não tem mais " + nome + "!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;

        Item outro = (Item) obj;

        if(outro.descricao != this.descricao || outro.nome != this.nome) return false;

        return true;
    }

    @Override
    public int compareTo(Item outro) {
        return this.nome.compareTo(outro.nome);
    }

    @Override
    public Item clone() {
        Item ret = null;

        try {
            ret = new Item(this);
        } catch (Exception erro) {}
        return ret;
    }

    @Override
    public String toString() {
        return this.nome + " (" + this.descricao + ") x" + this.quantidade;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        ret = ret*2 + this.nome.hashCode();
        ret = ret*2 + this.descricao.hashCode();
        ret = ret*2 + this.efeito.hashCode();
        ret = ret*2 + this.quantidade;

        if (ret<0) ret=-ret;
        return ret;
    }
}
