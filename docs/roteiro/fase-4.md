# Fase 4 · Versionar e revisar

**Módulo 5 · Claude Code + Git** · branch de partida `modulo-4` · branch de chegada `modulo-5`

**Objetivo:** Transformar o trabalho em commits limpos, refatorar com segurança e revisar.

## Passo a passo

1. **Veja o que mudou:** Com alterações locais: `git diff. Se retomou da referência: git diff modulo-3...HEAD`
2. **Leia o diff com o agente:** “Explique o diff e aponte o que está fora do escopo.”
3. **Faça o commit da feature:** feat(tarefas): adiciona prioridade e prazo
4. **Proteja o comportamento:** “Escreva TarefaTest: ontem, hoje, futuro, concluída e sem prazo.”
5. **Desafio: refatore:** “Mova a regra para Tarefa.estaAtrasada(hoje), sem mudar comportamento.”
6. **Revise em sessão nova:** “Revise modulo-3...HEAD por gravidade, com arquivo e linha.”

## Como verificar (saída da referência)

```text
$ git log --oneline -3
refactor(tarefas): move regra de atraso para Tarefa
test(tarefas): testes da regra de atraso na entidade
feat(tarefas): adiciona prioridade e prazo

$ ./mvnw test
Tests run: 27, Failures: 0
```

## Pronto quando

- [ ] Um commit revisado no padrão Conventional Commits
- [ ] Achados da revisão conferidos no código
- [ ] Desafio: refactor com testes verdes (referência: 27)

## Arquivos tocados

- `+ model/TarefaTest.java`
- `~ model/Tarefa.java (estaAtrasada)`
- `~ service/TarefaService.java`

## Conceitos aplicados

- Git como memória externa (Módulo 5)
- Refatoração com rede de testes (Módulo 5)
- LLM como avaliador (Módulo 5)
- Humano no circuito (Módulo 5)
