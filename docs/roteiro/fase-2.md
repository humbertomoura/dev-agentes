# Fase 2 · Contexto e plano

**Módulo 3 · Engenharia de contexto** · branch de partida `modulo-2` · branch de chegada `modulo-3`

**Objetivo:** Dar ao agente a memória do projeto e um plano revisado da feature.

## Passo a passo

1. **Gere a base:** `/init` e leia o CLAUDE.md proposto
2. **Refine o CLAUDE.md:** comandos, camadas, Clock injetado, convenções e “Não faça”
3. **Faça commit:** `git commit -m "docs: adiciona CLAUDE.md"`
4. **Peça o plano:** `/clear`, plan mode e prompt com <contexto> <tarefa> <restricoes> <pronto_quando>
5. **Critique o plano:** “O que acontece com as tarefas já cadastradas? Algo muda na listagem atual?”
6. **Salve o plano:** “Salve o plano aprovado em docs/plano-prioridade.md.” e faça commit

## Como verificar

```text
$ ls
CLAUDE.md  docs/  pom.xml  src/ …

$ grep -c "DEFAULT 'MEDIA'" docs/plano-prioridade.md
1
```

## Pronto quando

- [ ] CLAUDE.md com menos de 200 linhas
- [ ] Plano sem mudar o comportamento atual
- [ ] Default MEDIA para tarefas antigas

## Arquivos tocados

- `+ CLAUDE.md`
- `+ docs/plano-prioridade.md`

## Conceitos aplicados

- Engenharia de contexto (Módulo 3)
- Prompt com tags XML (Módulo 3)
- Plan mode (Módulo 3)
- Encadeamento: explorar → planejar (Módulo 3)
