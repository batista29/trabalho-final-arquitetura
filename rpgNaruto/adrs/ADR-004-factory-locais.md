# ADR-004: Centralizar Criação de Locais

## Status
Accepted

## Contexto

A criação dos cenários estava concentrada dentro da classe Jogo.

Isso dificultava futuras alterações e inclusão de novos locais.

## Decisão

Criar uma fábrica responsável pela criação dos locais do jogo.

## Consequências

### Benefícios

- Menor acoplamento.
- Centralização da lógica de criação.
- Facilidade para adicionar novas fases.

### Custos

- Criação de uma classe adicional.

## Evidência no Código

jogo/FabricaDeLocais.java