# ADR-003: Adotar Monólito Modular

## Status
Accepted

## Contexto

O projeto é desenvolvido por uma equipe pequena e possui escopo acadêmico.

Microsserviços adicionariam complexidade sem gerar benefícios proporcionais.

## Decisão

Adotar arquitetura monolítica modular.

## Consequências

### Benefícios

- Implantação simples.
- Menor complexidade operacional.
- Facilidade para depuração.

### Custos

- Escalabilidade limitada.
- Acoplamento maior entre módulos.

## Evidência no Código

Estrutura:

jogo/
personagens/
itens/

Todos executados em uma única aplicação Java.