# ADR-005: Utilizar Strategy para Efeitos de Itens

## Status
Accepted

## Contexto

Os itens possuem comportamentos diferentes.

Era necessário permitir novos efeitos sem alterar o funcionamento do sistema.

## Decisão

Representar efeitos através da interface EfeitoDeItem.

## Consequências

### Benefícios

- Atende Open-Closed Principle.
- Facilita inclusão de novos efeitos.

### Custos

- Aumento do número de classes.

## Evidência no Código

itens/EfeitoDeItem.java
itens/EfeitoCura.java