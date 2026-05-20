package jogo;

import personagens.Inimigo;

public class Local {
    private String nome;
    private String descricao;
    private Inimigo inimigo;

    public Local(String nome, String descricao, Inimigo inimigo) {
        this.nome = nome;
        this.descricao = descricao;
        this.inimigo = inimigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Inimigo getInimigo() {
        return inimigo;
    }

    @Override
    public String toString() {
        return nome + " — " + descricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        Local o = (Local) obj;
        if(this.nome == o.nome &&
            this.descricao == o.descricao &&
        this.inimigo.equals(o.inimigo)) return true;
        return false;
    }
    @Override
    public int hashCode() {
        int ret = 1;
        ret  = ret*2+this.nome.hashCode();
        ret  = ret*2+this.descricao.hashCode();
        ret = ret*2+this.inimigo.hashCode();
        return ret;
    }
    //Construtor de cópia
    public Local(Local l) throws Exception{
        if(l == null) throw new Exception("modelo nulo");
        this.nome = l.nome;
        this.descricao = l.descricao;
        this.inimigo = (Inimigo)l.inimigo.clone();
    }

    @Override
    public Object clone() {
        Local copia = null;
        try {
            copia = new Local(this);
        } catch (Exception e) {

        }
        return copia;
    }

    public int  compareTo(Local o) {
        return this.nome.compareTo(o.nome);
    }

}
