package personagens;

public class Inimigo extends Personagem {
    public Inimigo(String nome, int hp, int atk, int def, int nivel) {
        super(nome, hp, atk, def, nivel);
    }

    @Override
    public void atacar(Personagem alvo, int dado) {
        System.out.println(getNome() + " atacou!");

        int vidaAntes = alvo.getPontosVida();
        int dano = (getAtaque() + dado) - alvo.getDefesa();
        if (dano < 0) dano = 0;

        alvo.setPontosVida(alvo.getPontosVida() - dano);

        int vidaDepois = alvo.getPontosVida();
        int danoReal = vidaAntes - vidaDepois;

        exibirResultadoAtaque(alvo, danoReal, vidaDepois);
    }

    protected void exibirResultadoAtaque(Personagem alvo, int danoReal, int vidaDepois) {
        System.out.println(getNome() + " causou " + danoReal + " de dano.");
        System.out.println(alvo.getNome() + " agora tem " + vidaDepois + " de HP.\n");
    }

    //construtor de cópia
    public Inimigo(Inimigo modelo) throws Exception {
        super(modelo);
    }

    //clone
    @Override
    public Object clone() {
        Inimigo retorno = null;
        try {
            return new Inimigo(this); // usa o construtor de cópia
        } catch (Exception e) {
            System.err.println("Erro ao clonar Inimigo: " + e.getMessage());
        }
        return retorno;
    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o);

    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    //CompareTo precisa?

}
