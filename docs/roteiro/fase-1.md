# Fase 1 · Explorar e documentar

**Módulo 2 · Primeiros passos** · branch de partida `main` · branch de chegada `modulo-2`

**Objetivo:** Entender o código existente com o agente e registrar o que foi conferido.

## Passo a passo

1. **Escolha um modo seguro:** Plano para explorar: indicador do prompt (VS Code), menu de modo (web) ou Shift+Tab (IntelliJ)
2. **Peça um mapa:** “Descreva a arquitetura em camadas e liste os 5 arquivos mais importantes.”
3. **Siga um fluxo:** “Trace POST /tarefas até o banco, citando arquivo e linha.”
4. **Ache a regra de negócio:** “Como uma tarefa é marcada como atrasada?”
5. **Documente:** Volte ao modo Manual e peça: “Escreva docs/visao-geral.md com arquitetura, fluxo e regra de atraso.”
6. **Revise e faça commit:** `git add docs/visao-geral.md && git commit -m "docs: visão geral do projeto"`

## Como verificar (saída da referência)

```text
$ git log --oneline -1
docs: visão geral do projeto

$ grep -n "calcularAtraso" docs/visao-geral.md
…TarefaService.calcularAtraso(): 7 dias após a criação
```

## Pronto quando

- [ ] Cada afirmação conferida no arquivo citado
- [ ] docs/visao-geral.md commitado
- [ ] Testes continuam passando

## Arquivos tocados

- `+ docs/visao-geral.md`

## Conceitos aplicados

- Janela de contexto (Módulo 2)
- Ferramentas Read, Grep, Glob (Módulo 2)
- Modos de permissão (Módulo 2)
- Amostragem: compare com o colega (Módulo 2)
