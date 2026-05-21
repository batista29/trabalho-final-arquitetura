# ADR-001: Utilizar Hierarquia de Personagens

## Status
Accepted

## Contexto

O sistema possui diversos personagens jogáveis e inimigos que compartilham características comuns como nome, vida, ataque, defesa e inventário.

Sem uma abstração adequada haveria duplicação de código e dificuldade para adicionar novos personagens.

## Decisão

Criar uma classe abstrata Personagem e utilizar herança para especializar personagens jogáveis e inimigos.

## Consequências

### Benefícios

- Reutilização de código.
- Menor duplicação.
- Facilidade para criar novos personagens.

### Custos

- Dependência da hierarquia de herança.
- Necessidade de manter a abstração consistente.

## Evidência no Código

personagens/Personagem.java
personagens/Naruto.java
personagens/Sasuke.java
personagens/Pain.java