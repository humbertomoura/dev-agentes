# Exercícios da oficina

Todos os exercícios usam o projeto deste repositório. Leia o diff de tudo o que o agente fizer antes de aceitar.

## Atividade 1 · Chatbot, copiloto ou agente? (3 min, em duplas)

Classifique cada situação e justifique pelo critério: quem age no projeto e quem verifica o resultado?

1. Você cola um erro no chat e recebe uma explicação.
2. O editor completa o resto do método enquanto você digita.
3. Você pede "adicione paginação" e 4 arquivos mudam, com testes rodados.
4. Um script no CI lê uma issue, implementa e abre um PR sozinho.
5. Você pede um regex e testa você mesmo no terminal.

## Exercício 2 · Explorar o gestor-tarefas (10 min) · branch `main`

1. Abra o Claude Code na raiz do repositório (modo padrão de permissões).
2. Peça um mapa da arquitetura e dos arquivos principais.
3. Trace o fluxo de criação de uma tarefa, do controller ao banco.
4. Descubra como o sistema decide que uma tarefa está atrasada.
5. Confira cada resposta abrindo os arquivos citados.

**Entrega:** um parágrafo descrevendo o projeto e uma resposta conferida no código.

## Exercício 3 · CLAUDE.md e plano da feature (10 min) · branch `main`

1. Rode `/init` e leia o `CLAUDE.md` gerado.
2. Corrija e complete: comandos, convenções e duas regras "não faça".
3. Faça commit do `CLAUDE.md`.
4. Rode `/clear`, entre em plan mode (Shift+Tab) e peça o plano da feature descrita no Exercício 4.
5. Critique o plano pelo menos uma vez antes de aprovar. Não implemente ainda.

**Entrega:** `CLAUDE.md` commitado e plano salvo em `docs/plano-prioridade.md`. Referência: branch `modulo-3`.

## Exercício 4 · Implementar prioridade e prazo (18 min) · a partir de `modulo-3`

> Como usuário, quero definir prioridade e prazo nas minhas tarefas, para focar no que é urgente.

Critérios de aceite:

1. Prioridade BAIXA, MEDIA ou ALTA; padrão MEDIA.
2. Prazo é opcional e não pode estar no passado na criação.
3. `GET /tarefas?prioridade=ALTA` filtra pela prioridade.
4. Tarefa com prazo vencido e não concluída aparece como atrasada.
5. Tarefas antigas (sem prazo) continuam funcionando.

Passos: retome com `/clear` e `@docs/plano-prioridade.md`; implemente no modo padrão; suba a aplicação e teste com `curl`; diante de um erro, cole o stack trace completo e peça diagnóstico antes da correção.

**Entrega:** feature funcionando e os 5 critérios conferidos. Referência: branch `modulo-4`.

## Exercício 5 · Diff, commit, refatoração e revisão (12 min) · a partir de `modulo-4`

1. Crie a branch `feat/prioridade-prazo`.
2. Peça ao agente que explique o diff e aponte o que está fora do escopo.
3. Divida em commits lógicos com Conventional Commits.
4. Refatore a regra de atraso para `Tarefa.estaAtrasada(hoje)`, com testes verdes antes e depois.
5. Em sessão nova, peça uma revisão do branch com o checklist dos slides.

**Entrega:** branch com 2 a 4 commits limpos e uma lista de achados da revisão. Referência: branch `modulo-5`.

## Exercício 6 · Caçar o bug plantado (15 min) · branch `modulo-6-bug`

1. Faça checkout de `modulo-6-bug` e rode `./mvnw test`.
2. Peça a lista de casos de borda das regras de prazo e atraso e gere os testes que faltarem.
3. Siga `@docs/debug.md`: reproduzir, hipóteses, causa raiz, provar.
4. Corrija a implementação **sem alterar os testes existentes**.
5. Registre a lição no `CLAUDE.md` e faça commit.

Dica: há mais de um bug. Nem todos têm teste.

**Entrega:** bugs corrigidos, testes novos e lição no `CLAUDE.md`. Referência: branch `modulo-6`.

## Exercício 7 · Configure o seu agente (10 min) · a partir de `modulo-6`

Escolha uma opção:

- **Skill** `revisao-codigo` com checklist, acionada no seu branch.
- **Hook** `PostToolUse` que roda `./mvnw -q spotless:apply` após cada edição.
- **Subagente** `testador` que cobre o filtro por prioridade.
- **MCP**: conecte um servidor (por exemplo, GitHub) com `claude mcp add` e faça uma consulta.

**Entrega:** o arquivo de configuração commitado em `.claude/`. Referência: branch `modulo-7`.
