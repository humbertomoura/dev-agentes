# Fase 0 · Preparar o ambiente

**Módulo 1 · De chatbot a agente** · branch de partida `main` · branch de chegada `main`

**Objetivo:** Ter o projeto rodando e o agente aberto na raiz do repositório.

## Passo a passo

1. **Instale as ferramentas:** JDK 21, Git e Claude Code; faça login com: `claude`
2. **Clone o repositório:** `git clone https://github.com/humbertomoura/desenvolvimento-agentes.git`
3. **Rode os testes:** `cd desenvolvimento-agentes && ./mvnw test`
4. **Suba a API:** `./mvnw spring-boot:run` e, em outro terminal, `curl localhost:8080/tarefas`
5. **Abra o agente:** `claude` e depois `/status` para ver modelo e modo
6. **Observe o loop:** “Explique em 3 frases o que este projeto faz.” Repare nas chamadas ●

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
- [ ] API responde com 4 tarefas de exemplo
- [ ] Claude Code aberto na raiz do projeto

## Arquivos tocados

- nenhum arquivo alterado

## Conceitos aplicados

- Agente = LLM + ferramentas + loop (Módulo 1)
- Terminal como interface (Módulo 1)
- ReAct: pensar, agir, observar (Módulo 1)
