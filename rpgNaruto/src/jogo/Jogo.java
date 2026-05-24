package jogo;

import itens.FabricaDeItens;
import itens.Inventario;
import java.util.Random;
import java.util.Scanner;
import personagens.Inimigo;
import personagens.Personagem;
import servicos.ResultadoBatalha;
import servicos.ServicoBatalha;
import servicos.ServicoDeItens;
import servicos.ServicoDeRecompensa;
import servicos.ServicoItens;
import servicos.ServicoRecompensa;
import servicos.SistemaDeBatalha;

// Clone sendo utilizado para saquear inventário de inimigos e para restaurar vida do jogador

public class Jogo {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();
    private static final ServicoItens servicoItens = new ServicoDeItens();
    private static final ServicoBatalha servicoBatalha =
            new SistemaDeBatalha(sc, random, servicoItens);
    private static final ServicoRecompensa servicoRecompensa =
            new ServicoDeRecompensa(random);
    private static final FabricaDePersonagens fabricaDePersonagens =
            new FabricaDePersonagens();

    private static Inventario savePoint;
    private static int revivesRestantes = 2;

    public static void main(String[] args) throws Exception {
        System.out.println("=== RPG Naruto: Batalha Shinobi ===");
        System.out.println("\uD83C\uDF38 Bem-vindo ao Mundo Shinobi! \uD83C\uDF38\n" +
                "Você acaba de entrar num universo ninja onde coragem,\n" +
                "estratégia e determinação definem o seu destino.\n" +
                "\n" +
                "Aqui você vai poder assumir personagens lendários de Naruto,\n" +
                "explorar vilas, enfrentar inimigos e provar que merece o título\n" +
                "de verdadeiro shinobi.\n" +
                "\n" +
                "Prepare-se para treinar, lutar e tomar decisões que mudam o rumo\n" +
                "da história.\n" +
                "\nA aventura começa agora!\n");
        Personagem jogador = escolherPersonagem();
        Inventario inventario = jogador.getInventario();

        inventario.adicionarItem(FabricaDeItens.criarPocao());
        inventario.adicionarItem(FabricaDeItens.criarKunai());

        savePoint = inventario.clone();

        System.out.println("----------------------------------------------\n");
        System.out.println("\nVocê escolheu: " + jogador.getClass().getSimpleName());
        System.out.println(jogador);

        Local[] locais = FabricaDeLocais.criarLocais();

        int cenaAtual = 0;
        while (cenaAtual != -1) {
            cenaAtual = executarCena(cenaAtual, jogador, locais);
        }

        System.out.println("\nFim da jornada shinobi."); // isso nunca vai acontecer...
    }

    private static int executarCena(int cena, Personagem jogador, Local[] locais) throws Exception {
        switch (cena) {

            // 0 – PRÓLOGO EM KONOHA
            case 0 -> {
                System.out.println("\n[Konoha – Gabinete da Hokage]");
                System.out.println("Konoha é a Vila Oculta da Folha, uma das vilas ninja mais fortes.");
                System.out.println(
                        "A Hokage é a líder da vila. No momento é a Tsunade, famosa por força absurda e por curar quase tudo.");
                System.out.println(
                        "Ela te chamou porque não quer que o resto do mundo saiba que Konoha está investigando.");
                System.out.println();
                System.out.println("Tsunade: “Tem chakra corrompido vindo da região da Névoa. Três alertas já.”");
                System.out.println(
                        "Tsunade: “Se isso for arma de outra vila, a gente entra em guerra. Então vamos na surdina.”");
                System.out.println("Tsunade: “Você vai sozinho. Se for pego, não diz que é de Konoha.”");
                System.out.println();
                System.out.println("Ao lado dela está Kakashi, um jonin de elite, especialista em missão secreta.");
                System.out.println(
                        "Kakashi: “Coleta informação primeiro, briga depois. Viu selo de invocação? Segue o rastro.”");
                System.out.println();
                System.out.println("Shikamaru, que cuida de estratégia, fecha o raciocínio:");
                System.out
                        .println("Shikamaru: “A Névoa parece só o ponto de entrada. A origem está mais pro interior.”");
                pressionarEnter();
                return 1;
            }

            // 1 – NÉVOA OCULTA
            case 1 -> {
                Local alvo = locais[0];
                System.out.println("\n[" + alvo.getNome() + "]");
                System.out.println("A Vila da Névoa é conhecida por missões sujas e por usar neblina como cobertura.");
                System.out.println("Aqui você sente chakra velho, como se alguém tivesse trazido um lutador de volta.");
                System.out.println(
                        "Um espadachim enorme aparece. É o Zabuza, um ninja da Névoa, famoso por assassinatos e pela espada gigante..");

                ResultadoBatalha resultado = enfrentar(jogador, alvo.getInimigo());

                if (resultado == ResultadoBatalha.FUGA) {
                    return 3;
                }

                System.out.println("\nAo revistar o corpo, você encontra um selo de invocação RECENTE.");
                System.out.println(
                        "Isso confirma o que o Shikamaru falou: alguém está pagando para trazer gente forte de volta.");
                System.out.println("Você pode seguir o rastro agora ou dar uma respirada numa rota segura.");
                System.out.println("1 - Seguir direto para a Floresta da Morte (rota mais rápida)");
                System.out.println("2 - Passar na Estrada Shinobi para recuperar (rota mais segura)");
                String op = sc.nextLine().trim();
                if (op.equals("2"))
                    return 3;
                return 2;
            }

            // 2 – FLORESTA DA MORTE
            case 2 -> {
                Local alvo = locais[1];
                System.out.println("\n[" + alvo.getNome() + "]");
                System.out.println("A Floresta da Morte é usada em exames ninjas porque é perigosa de verdade.");
                System.out.println("Aqui atuam ninjas que gostam de experimento e teste de corpo.");
                System.out.println(
                        "Quem aparece? Orochimaru, um dos ninjas mais perigosos, obcecado por ganhar poder e viver pra sempre.");
               
                ResultadoBatalha resultado = enfrentar(jogador, alvo.getInimigo());

                if (resultado == ResultadoBatalha.FUGA) {
                    return 3;
                }

                System.out.println("\nEntre os pergaminhos dele você encontra menção a 'pagamento vindo do deserto'.");
                System.out.println("Ou seja: alguém da região da Areia está abastecendo esse esquema.");
                System.out.println("Shikamaru (na tua cabeça): “Vai pra Areia. Se tem dinheiro, tem mandante.”");
                pressionarEnter();
                return 4;
            }

            // 3 – ESTRADA SHINOBI (DESCANSO)
            case 3 -> {
                Local alvo = locais[3];
                System.out.println("\n[" + alvo.getNome() + "]");
                System.out.println("A Estrada Shinobi é uma rota relativamente neutra. Mensageiros passam aqui.");
                System.out.println("Ninguém briga nesse trecho porque todo mundo precisa desse caminho.");
                if (new Random().nextBoolean()) {
                    jogador.getInventario().adicionarItem(
                        FabricaDeItens.criarPocao()
                    );
                    System.out.println("Um mercador ninja te reconhece e te entrega 1 Poção de Cura.");
                } else {
                    System.out.println("Hoje não teve nada de especial. Pelo menos você descansou.");
                }
                System.out.println("Depois do descanso, você volta para a trilha que leva à floresta.");
                pressionarEnter();
                return 2;
            }

            // 4 – VILA DA AREIA
            case 4 -> {
                Local alvo = locais[2];
                System.out.println("\n[" + alvo.getNome() + "]");
                System.out.println("A Vila da Areia é aliada de Konoha, mas não gosta de ser investigada.");
                System.out.println("Quem te recebe é o Gaara, o Kazekage. Ele virou líder jovem e quer paz.");
                System.out.println(
                        "Gaara: “Se chakra estranho está cruzando o deserto, alguém está nos usando de rota.”");
                System.out
                        .println("Gaara: “Se você veio de Konoha, é porque Tsunade achou que isso pode virar guerra.”");
                System.out.println("Perto dos depósitos você vê um baú semi-enterrado.");
                System.out.println("1 - Abrir o baú (pode ser item, pode ser armadilha)");
                System.out.println("2 - Ignorar e focar na missão");
                String op = sc.nextLine().trim();
                if (op.equals("1")) {
                    abrirBauAreia(jogador, alvo.getInimigo());
                }
                System.out.println("Assim que você avança, aparece Rasa.");
                System.out.println(
                        "Contexto rápido: Rasa é o antigo Kazekage e controla areia com metal. Ele não confia fácil.");
                System.out.println(
                        "Rasa: “Quero saber por que Konoha está rastreando fluxos de chakra na nossa região.”");
                ResultadoBatalha resultado = enfrentar(jogador, alvo.getInimigo());

                if (resultado == ResultadoBatalha.FUGA) {
                    return 3;
                }
                System.out.println(
                        "Terminada a luta, chega um mensageiro da Vila da Chuva dizendo que o ritual começou.");
                System.out.println(
                        "Vila da Chuva = lugar onde quase sempre chove e onde surgiram grupos radicais como a Akatsuki.");
                pressionarEnter();
                return 5;
            }

            // 5 – VILA DA CHUVA
            case 5 -> {
                Local alvo = locais[4];
                System.out.println("\n[" + alvo.getNome() + "]");
                System.out.println("A Vila da Chuva vive em guerra interna. Daqui surgiu a Akatsuki.");
                System.out.println("Antes de você chegar até o líder, aparece Konan.");
                System.out.println("Contexto rápido: Konan é parceira do líder da Akatsuki e age como guardiã.");
                System.out.println("Konan: “Você é de Konoha. Não deveria ter chegado tão longe.”");
                System.out.println("Konan: “Pain vai lutar. Mas sei que você está atrás de alguém acima dele.”");
                System.out.println("Logo depois disso, chega o Pain, ele acredita que dor traz paz..");
                ResultadoBatalha resultado = enfrentar(jogador, alvo.getInimigo());

                if (resultado == ResultadoBatalha.FUGA) {
                    return 3;
                }
                System.out.println("Entre os registros dele você encontra o nome do verdadeiro mandante: 'Maligno'.");
                System.out.println("Localização apontada: Oráculo do Triunfo, um lugar antigo usado pra rituais.");
                pressionarEnter();
                return 6;
            }

            // 6 – ORÁCULO (FINAL)
            case 6 -> {
                Local alvo = locais[5];
                System.out.println("\n[" + alvo.getNome() + "]");
                System.out.println("O Oráculo do Triunfo é uma ruína antiga usada para rituais de alto nível.");
                System.out.println("O chakra que você sentia desde a Névoa está mais forte aqui. É a origem.");
                System.out.println("O mandante está aqui: ‘Maligno’. O boss final.");
                System.out.println("Maligno: “A Hokage sempre manda alguém. Nunca vem ela mesma.”");
                System.out.println("Maligno: “Aqui não tem segunda chance.”");
                pressionarEnter();
                return 7;
            }

            case 7 -> {
                Local alvo = locais[5];
                enfrentar(jogador, alvo.getInimigo());
                return -1;
            }

            default -> {
                return -1;
            }
        }
    }

    private static void pressionarEnter() {
        System.out.println("\n[ENTER para continuar]");
        sc.nextLine();
        System.out.println("----------------------------------------------\n");
    }

    private static ResultadoBatalha enfrentar(Personagem jogador, Inimigo inimigo) {
        while (true) {
            ResultadoBatalha resultado = servicoBatalha.batalhar(jogador, inimigo);

            if (resultado == ResultadoBatalha.VITORIA) {
                servicoRecompensa.aplicarVitoria(jogador, inimigo);
                savePoint = jogador.getInventario().clone();
                System.out.println("Vitoria! Avancando na historia ninja...");
                return resultado;
            }

            if (resultado == ResultadoBatalha.FUGA) {
                return resultado;
            }

            aplicarRevive(jogador);
        }
    }

    private static void aplicarRevive(Personagem jogador) {
        if (revivesRestantes > 0) {
            revivesRestantes--;
            System.out.println("\nVoce foi derrotado... mas tinha chakra de retorno.");
            System.out.println("Revives restantes: " + revivesRestantes);

            jogador.setPontosVida(100);

            if (savePoint != null) {
                jogador.setInventario(savePoint.clone());
            }
        } else {
            System.out.println("\nVoce foi derrotado... GAME OVER.");
            System.exit(0);
        }
    }

    private static void abrirBauAreia(Personagem jogador, Inimigo inimigoOriginal) throws Exception {
        int tesouro = random.nextInt(1, 4);

          switch (tesouro) {

        case 1 -> {
            jogador.getInventario().adicionarItem(
                FabricaDeItens.criarPocao()
            );

            System.out.println("Você achou uma poção de cura no baú.");
        }

        case 2 -> {
            jogador.setDefesa(jogador.getDefesa() - 2);
            jogador.setPontosVida(jogador.getPontosVida() - 10);

            System.out.println("Armadilha de areia! Você perdeu 10 de HP e 2 de defesa.");
            System.out.println(jogador);
        }

        case 3 -> {
            System.out.println(
                "Você achou um talismã. Ele vai te ajudar contra quem está controlando a areia."
            );

            inimigoOriginal.setPontosVida(0);
        }
    }
    }

    private static Personagem escolherPersonagem() throws Exception {
        System.out.println("Escolha seu personagem:");
        for (OpcaoDePersonagem opcaoPersonagem : fabricaDePersonagens.listarOpcoes()) {
            System.out.println(
                opcaoPersonagem.getCodigo()
                + " - "
                + opcaoPersonagem.getNome()
            );
        }
        System.out.print("Digite o número: ");
        String opcao = sc.nextLine();
        System.out.println("----------------------------------------------\n");

        return switch (opcao) {
            case "1" -> fabricaDePersonagens.criarPorCodigo(opcao);
            case "2" -> fabricaDePersonagens.criarPorCodigo(opcao);
            case "3" -> fabricaDePersonagens.criarPorCodigo(opcao);
            default -> {
                System.out.println("Opção inválida, será escolhido o Naruto por padrão.");
                yield fabricaDePersonagens.criarPorCodigo(opcao);
            }
        };
    }

}
