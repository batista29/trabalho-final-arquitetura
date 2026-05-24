package personagens;

public class Sasuke extends Personagem {
    public Sasuke() {
        super("Sasuke", 180, 35, 10, 1);
    }

    @Override
    public void atacar(Personagem inimigo, int dado) {
        System.out.println(getNome() + " usou Chidori!");

        int vidaAntes = inimigo.getPontosVida();
        int dano = (getAtaque() + dado) - inimigo.getDefesa();
        if (dano < 0) dano = 0;

        inimigo.setPontosVida(inimigo.getPontosVida() - dano);

        int vidaDepois = inimigo.getPontosVida();
        int danoReal = vidaAntes - vidaDepois;

        System.out.println(getNome() + " causou " + danoReal + " de dano.");
        System.out.println(inimigo.getNome() + " agora tem " + vidaDepois + " de HP.\n");

        if (inimigo.getPontosVida() <= 0) {
            System.out.println(inimigo.getNome() + " foi derrotado!");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    //construtor de cópia
    public Sasuke(Sasuke modelo) throws Exception {
        super(modelo);
    }

    //clone
    @Override
    public Sasuke clone() {
        Sasuke retorno = null;
        try {
            return new Sasuke(this); // usa o construtor de cópia
        } catch (Exception e) {
            System.err.println("Erro ao clonar Naruto: " + e.getMessage());
        }
        return retorno;
    }

}

