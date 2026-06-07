# RPG Naruto: Batalha Shinobi

## Descrição

RPG de console desenvolvido em Java inspirado no universo Naruto.

O jogador escolhe um personagem, enfrenta inimigos em diferentes cenários, utiliza itens e avança pela história até o confronto final.

O projeto foi desenvolvido com foco na aplicação de conceitos de Programação Orientada a Objetos, SOLID, Clean Code e padrões de projeto.

---

## Tecnologias Utilizadas

- Java 17
- Programação Orientada a Objetos (POO)
- UML / PlantUML
- Git
- GitHub

---

## Estrutura do Projeto

```text
src/
├── itens/
├── jogo/
├── personagens/
├── servicos/
└── ui/
```

---

## Como Executar

### 1. Pré-requisitos

Certifique-se de possuir o Java 17 ou superior instalado.

Verifique a versão instalada:

```bash
java --version
```

---

### 2. Clonar o Repositório

```bash
git clone https://github.com/SEU-USUARIO/rpgNaruto.git
```

Entre na pasta do projeto:

```bash
cd rpgNaruto
```

---

### 3. Abrir na IDE

O projeto pode ser executado em qualquer IDE Java, como:

- IntelliJ IDEA
- Eclipse
- VS Code

Importe a pasta do projeto normalmente.

---

### 5. Executar pelo Terminal

Acesse a pasta `src`:

```bash
cd src
```

Compile todos os arquivos:

```bash
javac */*.java
```

Execute o jogo:

```bash
java jogo.GameLauncher
```

---

## Exemplo de Execução

```text
=== RPG Naruto: Batalha Shinobi ===

Escolha seu personagem:

1 - Naruto
2 - Sasuke
3 - Sakura

> 1

Você escolheu Naruto!

Local atual:
Névoa Oculta

Uma vila cercada por neblina e mistérios.

Inimigo encontrado:
Zabuza

O que deseja fazer?

1 - Atacar
2 - Usar Item
3 - Ver Inventário

> 1

Naruto usou Rasengan!
Naruto causou 28 de dano.
Zabuza agora tem 122 de HP.

Zabuza atacou!
Zabuza causou 12 de dano.
Naruto agora tem 188 de HP.
```

---

## Funcionalidades

- Escolha de personagem
- Sistema de batalha por turnos
- Inventário de itens
- Sistema de recompensas
- Diferentes inimigos e cenários
- Progressão ao longo da jornada
- Sistema de revive

