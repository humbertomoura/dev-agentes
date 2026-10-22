# Fase 4 · Versionar, refatorar e revisar

**Módulo 5 · Claude Code + Git** · branch de partida `modulo-4` · branch de chegada `modulo-5`

**Objetivo:** Transformar o trabalho em commits limpos, refatorar com segurança e revisar.

## Passo a passo

1. **Crie a branch:** `git switch -c feat/prioridade-prazo`
2. **Leia o diff com o agente:** “Explique o diff e aponte o que está fora do escopo.”
3. **Faça o commit da feature:** feat(tarefas): adiciona prioridade e prazo
4. **Proteja o comportamento:** “Escreva TarefaTest com ontem, prazo futuro, concluída e sem prazo.”
5. **Refatore:** “Mova a regra para Tarefa.estaAtrasada(hoje), sem mudar comportamento.”
6. **Revise em sessão nova:** “Revise main...HEAD por gravidade, com arquivo e linha.”

## Como verificar

```text
$ git log --oneline -3
refactor(tarefas): move regra de atraso para Tarefa
test(tarefas): testes da regra de atraso na entidade
feat(tarefas): adiciona prioridade e prazo

$ ./mvnw test
Tests run: 27, Failures: 0
```

## Pronto quando

- [ ] Commits no padrão Conventional Commits
- [ ] 27 testes verdes antes e depois do refactor
- [ ] Lista de achados da revisão

## Arquivos tocados

- `+ model/TarefaTest.java`
- `~ model/Tarefa.java (estaAtrasada)`
- `~ service/TarefaService.java`

## Conceitos aplicados

- Git como memória externa (Módulo 5)
- Refatoração com rede de testes (Módulo 5)
- LLM como avaliador (Módulo 5)
- Humano no circuito (Módulo 5)
