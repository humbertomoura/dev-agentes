# Fase 0 · Preparar o ambiente

**Módulo 1 · De chatbot a agente** · branch de partida `main` · branch de chegada `main`

**Objetivo:** Ter o projeto rodando e o agente aberto na raiz do repositório.

## Passo a passo

1. **Escolha o ambiente:** Web: `claude.ai/code · VS Code: extensão Claude Code · IntelliJ: plugin Claude Code + CLI`
2. **Traga o repositório:** Web: conecte o GitHub e escolha desenvolvimento-agentes · IDE: `git clone do repositório`
3. **Abra pela raiz:** IDE: abra a pasta do repositório como projeto · Web: selecione a branch main
4. **Rode os testes:** `./mvnw test no terminal do IDE`; na web, peça ao Claude para rodar
5. **Abra o agente:** VS Code: ícone ✱ · IntelliJ: Ctrl+Esc · Web: nova sessão; depois `/status`
6. **Observe o loop:** “Explique em 3 frases o que este projeto faz.” Repare nas chamadas ●

Neste projeto, `./mvnw test` roda testes unitários e de integração (`*IT`) porque o Surefire foi configurado para isso. No Windows, use `mvnw.cmd`.

## Como verificar (saída da referência)

```text
$ ./mvnw test
Tests run: 13, Failures: 0   # saída da referência
BUILD SUCCESS

$ ./mvnw spring-boot:run          # deixe rodando
$ curl localhost:8080/tarefas      # em outro terminal
[{"id":1,"titulo":"Configurar ambiente",...}]
```

## Pronto quando

- [ ] Todos os testes passam (referência: 13)
- [ ] API responde depois de iniciar o servidor
- [ ] Claude Code aberto na raiz do projeto

## Arquivos tocados

- nenhum arquivo alterado

## Conceitos aplicados

- Agente = LLM + ferramentas + loop (Módulo 1)
- Terminal como interface (Módulo 1)
- ReAct: pensar, agir, observar (Módulo 1)
