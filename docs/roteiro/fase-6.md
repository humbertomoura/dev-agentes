# Fase 6 · Configurar o agente

**Módulo 7 · Indo além do básico** · partida `modulo-6` · referência `modulo-7`

## Entrega mínima (6 min)

1. Leia `.agents/skills/revisao-codigo/SKILL.md` e adapte o checklist ao seu diff.
2. Peça ao Antigravity: “Use a skill revisao-codigo e revise somente o diff atual; cite linhas e não edite.”
3. Valide a revisão no IntelliJ. Faça commit somente da Skill revisada.

## Desafios opcionais

- **Hook:** demonstre uma checagem pós-edição em arquivo sem credenciais; não dispare `spotless:apply` no projeto inteiro sem avaliar impacto.
- **Subagente:** crie revisor de acesso restrito a leitura, com ferramentas conforme sua versão do Antigravity.
- **MCP:** demonstre uma integração sem dados reais e com permissões mínimas.

Não copie `.claude/settings.json`, `.claude/agents/` ou gatilhos `PostToolUse` literalmente: a sintaxe e os controles do Antigravity são diferentes. Veja `docs/agente-antigravity.md`.

**Pronto quando:** Skill carregada/referenciada pelo agente e achados verificados contra código; desafios avançados são opcionais.
