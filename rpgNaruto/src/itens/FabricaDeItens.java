package itens;

public class FabricaDeItens {

    public static Item criarPocao() {
        return new Item(
            "Poção de Cura",
            "Recupera 50 HP",
            new EfeitoCura(50)
        );
    }

    public static Item criarKunai() {
        return new Item(
            "Kunai",
            "Aumenta o ataque",
            new EfeitoAtaque(5)
        );
    }

    public static Item criarRinnegan() {
        return new Item(
            "Rinnegan",
            "Recupera 60 HP",
            new EfeitoCura(60)
        );
    }
}