package jogo;

import personagens.Maligno;
import personagens.Orochimaru;
import personagens.Pain;
import personagens.Rasa;
import personagens.Zabuza;

public class FabricaDeLocais {

    private FabricaDeLocais() {
    }

    public static Local[] criarLocais() {

        return new Local[] {

            new Local(
                "Névoa Oculta",
                "Uma vila cercada por neblina e mistérios.",
                new Zabuza()
            ),

            new Local(
                "Floresta da Morte",
                "Lar de perigos e serpentes gigantes.",
                new Orochimaru()
            ),

            new Local(
                "Vila Oculta da Areia",
                "Clima árido e desértico... cuidado com as tempestades de areia!",
                new Rasa()
            ),

            new Local(
                "Estrada Shinobi",
                "Área livre de inimigos. Um bom lugar para descansar.",
                null
            ),

            new Local(
                "Vila da Chuva",
                "Chove constantemente... e Pain observa.",
                new Pain()
            ),

            new Local(
                "Oráculo do Triunfo",
                "É um local de poder ancestral indescritível, erguido por uma civilização anterior à fundação das Vilas Ocultas",
                new Maligno()
            )
        };
    }
}