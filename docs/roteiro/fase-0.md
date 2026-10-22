# Fase 0 · Preparar o ambiente

**Módulo 1 · De chatbot a agente** · branch de partida `main` · branch de chegada `main`

**Objetivo:** Ter o projeto rodando e o agente aberto na raiz do repositório.

## Passo a passo

1. **Escolha o ambiente:** web (claude.ai/code), VS Code (extensão Claude Code) ou IntelliJ (plugin Claude Code + CLI). Veja [`../ambientes.md`](../ambientes.md).
2. **Traga o repositório:** na web, conecte o GitHub e escolha `desenvolvimento-agentes`; nas IDEs, `git clone https://github.com/humbertomoura/desenvolvimento-agentes.git`.
3. **Abra pela raiz:** nas IDEs, abra a pasta do repositório como projeto; na web, selecione a branch `main`.
4. **Rode os testes:** `./mvnw test` no terminal do IDE; na web, peça ao Claude para rodar.
5. **Abra o agente:** VS Code, ícone ✱; IntelliJ, Ctrl+Esc; web, nova sessão. Depois, `/status`.
6. **Observe o loop:** “Explique em 3 frases o que este projeto faz.” Repare nas chamadas ●.

## Como verificar

```text
$ ./mvnw test
Tests run: 13, Failures: 0, Errors: 0
BUILD SUCCESS

$ curl localhost:8080/tarefas
[{"id":1,"titulo":"Configurar ambiente",...}]  # 4 tarefas
```

## Pronto quando

- [ ] 13 testes verdes
- [ ] Ambiente escolhido e logado
- [ ] Claude Code aberto na raiz do projeto

## Arquivos tocados

- nenhum arquivo alterado

## Conceitos aplicados

- Agente = LLM + ferramentas + loop (Módulo 1)
- Terminal como interface (Módulo 1)
- ReAct: pensar, agir, observar (Módulo 1)
