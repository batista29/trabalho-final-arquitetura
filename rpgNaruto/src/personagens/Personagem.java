package personagens;

import itens.Inventario;

public abstract class Personagem implements Cloneable {
    String nome;
    private int pontosVida;
    private int ataque;
    private int defesa;
    private int nivel;
    private Inventario inventario;

    public Personagem(String nome, int pontosVida, int ataque, int defesa, int nivel) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.nivel = nivel;
        this.inventario = new Inventario();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getNivel() {
        return nivel;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Personagem(Personagem modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo de personagem nulo");
        this.nome = modelo.nome;
        this.pontosVida = modelo.pontosVida;
        this.ataque = modelo.ataque;
        this.defesa = modelo.defesa;
        this.nivel = modelo.nivel;
        this.inventario = (modelo.inventario != null) ? modelo.inventario.clone() : new Inventario();
    }

    @Override
    public String toString() {
        return nome + " [HP: " + pontosVida + ", Atk: " + ataque + ", Def: " + defesa + "]";
    }

    // metodo abstrato
    public abstract void atacar(Personagem inimigo, int dado);


    public void receberItensDoInimigo(Personagem inimigo) {
        if (inimigo == null || inimigo.getInventario() == null)
            return;

        // transfere os itens
        this.inventario.transferirItens(inimigo.getInventario());

        System.out.println("\n" + this.getNome() + " saqueou o inventário de " + inimigo.getNome() + ":");
        System.out.println(inimigo.getInventario().toString());
        inimigo.getInventario().limparInventario();
    }
    @Override
    public boolean equals(Object o) {
        if(o == null)return false;
        if(o == this)return true;
        if(o.getClass() != this.getClass())return false;
        Personagem p = (Personagem)o;
        if(this.nome == p.nome &&
        this.pontosVida == p.pontosVida &&
        this.ataque == p.ataque &&
        this.defesa == p.defesa &&
        this.nivel == p.nivel &&
        this.inventario.equals(p.inventario)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        ret  = ret*2 + this.nome.hashCode();
        ret  = ret*2 + ((Integer)this.pontosVida).hashCode();
        ret  = ret*2 + ((Integer)this.ataque).hashCode();
        ret  = ret*2 + ((Integer)this.defesa).hashCode();
        ret  = ret*2 + ((Integer)this.nivel).hashCode();
        ret = ret*2+ this.inventario.hashCode();
        if(ret<0) ret =-ret;
        return ret;
    }



    //COmpareTo precisa?
}
