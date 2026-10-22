# Fase 3 · Implementar prioridade e prazo

**Módulo 4 · Construindo uma feature** · branch de partida `modulo-3` · branch de chegada `modulo-4`

**Objetivo:** Implementar a feature em várias camadas, executando e corrigindo em ciclos.

## Passo a passo

1. **Retome o plano:** `/clear` e “Implemente @docs/plano-prioridade.md, um passo por vez.”
2. **Revise camada a camada:** Prioridade, Tarefa, V5__prioridade_prazo.sql, DTO, service, controller
3. **Peça os testes:** “Escreva testes unitários e de integração para os 5 critérios.” e `./mvnw test`
4. **Execute de verdade:** “Suba a app e verifique cada critério com curl.”
5. **Interprete erros:** cole o stack trace inteiro: “Explique a causa antes de corrigir.”
6. **Não faça commit ainda:** o diff será analisado na Fase 4

## Como verificar

```text
$ ./mvnw test
Tests run: 23, Failures: 0

$ curl -X POST localhost:8080/tarefas -H 'Content-Type: application/json' \
  -d '{"titulo":"TCC","prioridade":"ALTA"}'
{"id":5,…,"prioridade":"ALTA","prazo":null,…}
```

## Pronto quando

- [ ] 23 testes verdes
- [ ] GET /tarefas?prioridade=ALTA filtra
- [ ] Prazo no passado devolve 400

## Arquivos tocados

- `+ model/Prioridade.java`
- `~ model/Tarefa.java`
- `+ db/migration/V5__prioridade_prazo.sql`
- `~ dto, service, controller e testes`

## Conceitos aplicados

- Loop do agente (Módulo 4)
- Feedback do ambiente (Módulo 4)
- Classificar falhas (Módulo 4)
- Orquestrador-trabalhadores (Módulo 4)
