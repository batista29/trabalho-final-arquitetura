# Atributos de Qualidade

## 1. Manutenibilidade

### Justificativa

O sistema continuará recebendo novos personagens, inimigos e itens.

A facilidade de manutenção é fundamental para a evolução do projeto.

### Decisões Arquiteturais

- Hierarquia Personagem.
- Separação em pacotes.
- Uso de Strategy.

### Métrica

Inclusão de novo personagem alterando no máximo duas classes.

---

## 2. Confiabilidade

### Justificativa

O jogador não deve perder seu progresso durante as batalhas.

### Decisões Arquiteturais

- Save Point.
- Clone do inventário.
- Sistema de revive.

### Métrica

Restauração completa do inventário após derrota.

---

## 3. Extensibilidade

### Justificativa

Novos conteúdos devem ser adicionados com baixo impacto.

### Decisões Arquiteturais

- Factory de locais.
- Herança de personagens.
- Interface para efeitos de itens.

### Métrica

Adicionar novo local ou personagem sem modificar regras existentes.