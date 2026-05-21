# ADR-002: Utilizar Prototype para Save Point

## Status
Accepted

## Contexto

O jogo possui mecânica de revive e save point.

Era necessário restaurar o estado do inventário sem recriar manualmente cada item.

## Decisão

Utilizar clonagem do inventário através da implementação do padrão Prototype.

## Consequências

### Benefícios

- Recuperação rápida do estado.
- Menor complexidade na restauração.

### Custos

- Necessidade de garantir cópia correta dos objetos.

## Evidência no Código

itens/Inventario.java

Método:

clone()