# Fase 3 · Implementar prioridade e prazo

**Módulo 4 · Construindo uma feature** · branch de partida `modulo-3` · branch de chegada `modulo-4`

**Objetivo:** Implementar a feature em várias camadas, executando e corrigindo em ciclos.

## Passo a passo

1. **Crie a branch de trabalho:** `git switch -c feat/prioridade-prazo`  (a partir de modulo-3 ou do seu trabalho)
2. **Retome o plano:** Contexto limpo e “Implemente @docs/plano-prioridade.md, um passo por vez.”
3. **Revise camada a camada:** Prioridade, Tarefa, V5__prioridade_prazo.sql, DTO, service, controller
4. **Teste os critérios:** “Escreva testes para os 5 critérios, inclusive tarefa sem prazo.” e `./mvnw test`
5. **Execute e interprete:** suba a app e confira com curl; diante de erro, cole o stack trace e peça a causa antes da correção
6. **Ainda sem commit:** o diff será analisado na Fase 4

## Como verificar (saída da referência)

```text
$ ./mvnw test
Tests run: 23, Failures: 0

$ curl -X POST localhost:8080/tarefas \
  -H 'Content-Type: application/json' \
  -d '{"titulo":"TCC","prioridade":"ALTA"}'
{"id":5,…,"prioridade":"ALTA","prazo":null,…}
```

## Pronto quando

- [ ] Testes passam (referência: 23)
- [ ] Os 5 critérios conferidos, inclusive tarefa sem prazo
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
