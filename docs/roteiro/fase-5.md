# Fase 5 · Caçar o bug plantado

**Módulo 6 · Testes e debugging** · branch de partida `modulo-6-bug` · branch de chegada `modulo-6`

**Objetivo:** Diagnosticar com método, corrigir sem trapacear e registrar a lição.

## Passo a passo

1. **Reproduza:** `git switch modulo-6-bug && git switch -c fix/bug-datas && ./mvnw test` (trabalhe na sua branch)
2. **Liste os casos de borda:** “Liste casos de borda de prazo e atraso. Não escreva código.”
3. **Investigue o histórico:** “Siga @docs/debug.md.” Peça `git log` e `git blame` na regra de atraso
4. **Demonstre a causa raiz:** prove cada hipótese com um teste antes de corrigir
5. **Teste primeiro:** escreva os testes de borda que faltam e veja-os falhar
6. **Corrija e registre:** corrija sem alterar testes; lição durável no AGENTS.md; commits test, fix e docs

## Como verificar (saída da referência)

```text
$ ./mvnw test   # antes
Tests run: 27, Failures: 8

$ ./mvnw test   # depois
Tests run: 31, Failures: 0

$ git log --oneline -3
docs: registra lição sobre comparação de datas…
```

## Pronto quando

- [ ] Testes passam (referência: 31)
- [ ] Nenhum teste existente alterado
- [ ] Lição durável registrada no AGENTS.md

## Arquivos tocados

- `~ model/Tarefa.java`
- `~ service/TarefaService.java`
- `~ testes (+4)`
- `~ AGENTS.md (lições)`

## Conceitos aplicados

- Alucinação × verificação (Módulo 6)
- Reward hacking (Módulo 6)
- Testes como juiz (pass@k) (Módulo 6)
- TDD (Módulo 6)
