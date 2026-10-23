# Fase 6 · Configurar o agente

**Módulo 7 · Indo além do básico** · branch de partida `modulo-6` · branch de chegada `modulo-7`

**Objetivo:** Entrega mínima: criar e acionar uma skill de revisão. O restante é a solução completa de referência.

## Passo a passo

1. **Entrega mínima: skill:** crie `.claude/skills/revisao-codigo/SKILL.md` com nome, descrição e passos
2. **Acione e confira:** /revisao-codigo ou “revise minhas mudanças”; veja a skill ser carregada
3. **Desafio A: hook:** PostToolUse em Edit|Write com o formatador; edite um arquivo e confirme o resultado
4. **Desafio B: subagente:** revisor só com Read, Grep e Glob: leitura de fato, sem Bash
5. **Referência: permissões:** allow para testes; deny para .env, rm -rf e `git push`
6. **Faça commit:** chore(claude): configuração do agente

## Como verificar (saída da referência)

```text
$ ls .claude/skills/revisao-codigo
SKILL.md  checklist.md  scripts/

> /revisao-codigo
● Skill(revisao-codigo)
  achados por gravidade, com arquivo e linha
```

## Pronto quando

- [ ] Skill criada e acionada
- [ ] Desafio: hook ou subagente verificado na prática
- [ ] Solução completa na branch modulo-7

## Arquivos tocados

- `+ .claude/skills/revisao-codigo/`
- (desafios) .claude/settings.json
- (desafios) .claude/agents/

## Conceitos aplicados

- Determinístico × probabilístico (Módulo 7)
- Divulgação progressiva (Módulo 7)
- Contexto isolado (Módulo 7)
- Primitivas do MCP (opcional) (Módulo 7)
