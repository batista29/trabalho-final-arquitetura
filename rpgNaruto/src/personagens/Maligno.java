package personagens;

public class Maligno extends Inimigo {
    public Maligno() {
        super("Maligno", 666, 666, 666, 666);
    }

    public void ataqueMortal(Personagem alvo) {
        alvo.setPontosVida(0);
//        Após vencer todos os desafios, você finalmente encontra Maligno.
        finalizar();
    }

    public void finalizar() {
        System.out.println("Ele observa em silêncio, com um olhar calmo e satisfeito.");
        System.out.println("\t - Então... você chegou até o fim. Exatamente como eu planejei.");
        System.out.println("Suas forças começam a fraquejar. Uma dor ardente toma conta do seu corpo. Maligno dá um leve sorriso.");
        System.out.println("\t - O veneno corre em você desde o início da jornada. Cada vitória... aproximou você do seu fim.");
        System.out.println("Você cai de joelhos. O mundo escurece. Maligno se afasta, desaparecendo na névoa.");
        System.out.println("\t - Seu destino... sempre foi morrer por minhas mãos.");
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

    @Override
    public Object clone() {
        return super.clone();
    }

}
