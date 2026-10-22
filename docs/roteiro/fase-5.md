# Fase 5 · Caçar o bug plantado

**Módulo 6 · Testes e debugging** · branch de partida `modulo-6-bug` · branch de chegada `modulo-6`

**Objetivo:** Diagnosticar com método, corrigir sem trapacear e registrar a lição.

## Passo a passo

1. **Reproduza:** `git switch modulo-6-bug && ./mvnw test`  (8 falhas)
2. **Liste os casos de borda:** “Liste casos de borda de prazo e atraso. Não escreva código.”
3. **Investigue o histórico:** “Siga @docs/debug.md.” O agente usa `git log -L em estaAtrasada`
4. **Ache as duas causas:** comparação invertida e prazo igual a hoje rejeitado (sem teste)
5. **Teste primeiro:** escreva os testes de borda que faltam e veja-os falhar
6. **Corrija e registre:** corrija sem alterar testes; lição no CLAUDE.md; commits test, fix e docs

## Como verificar

```text
$ ./mvnw test   # antes
Tests run: 27, Failures: 8

$ ./mvnw test   # depois
Tests run: 31, Failures: 0

$ git log --oneline -3
docs: registra lição sobre comparação de datas…
```

## Pronto quando

- [ ] 31 testes verdes
- [ ] Nenhum teste existente alterado
- [ ] Lição registrada no CLAUDE.md

## Arquivos tocados

- `~ model/Tarefa.java`
- `~ service/TarefaService.java`
- `~ testes (+4)`
- `~ CLAUDE.md (lições)`

## Conceitos aplicados

- Alucinação × verificação (Módulo 6)
- Reward hacking (Módulo 6)
- Testes como juiz (pass@k) (Módulo 6)
- TDD (Módulo 6)
