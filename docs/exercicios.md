# Exercícios da oficina

Todos os exercícios usam o projeto deste repositório. Leia o diff de tudo o que o agente fizer antes de aceitar.

## Atividade 1 · Chatbot, copiloto ou agente? (3 min, em duplas)

Classifique cada situação e justifique pelo critério: quem age no projeto e quem verifica o resultado?

1. Você cola um erro no chat e recebe uma explicação.
2. O editor completa o resto do método enquanto você digita.
3. Você pede "adicione paginação" e 4 arquivos mudam, com testes rodados.
4. Um script no CI lê uma issue, implementa e abre um PR sozinho.
5. Você pede um regex e testa você mesmo no terminal.

## Atividade 2B · Quanto poder você daria? (4 min)

Para cada ação, diga se dá para desfazer e escolha allow, perguntar ou deny: ler `src/` e `git log`; rodar `./mvnw test`; editar `TarefaService.java`; `git push origin main`; ler `.env`; `DROP TABLE` no banco de homologação. Depois escreva as regras no `.claude/settings.json`.

## Exercício 2 · Explorar o gestor-tarefas (10 min) · branch `main`

1. Abra o Claude Code na raiz do repositório (modo padrão de permissões).
2. Peça um mapa da arquitetura e dos arquivos principais.
3. Trace o fluxo de criação de uma tarefa, do controller ao banco.
4. Descubra como o sistema decide que uma tarefa está atrasada.
5. Confira cada resposta abrindo os arquivos citados.

**Entrega:** um parágrafo descrevendo o projeto e uma resposta conferida no código.

## Exercício 3A · Laboratório de prompts (8 min, opcional)

Use a mesma tarefa no antes e no depois e peça só plano ou revisão, sem alterar arquivos. Rode o prompt vago, reescreva e compare pela rubrica: escopo correto, referência ao código, casos de borda e verificação. Para saber qual técnica ajudou, mude uma de cada vez.

## Exercício 3 · CLAUDE.md e plano da feature (10 min) · branch `main`

1. Rode `/init` e leia o `CLAUDE.md` gerado.
2. Corrija e complete: comandos, convenções e duas regras "não faça".
3. Faça commit do `CLAUDE.md`.
4. Limpe o contexto, entre em plan mode e peça o plano da feature descrita no Exercício 4.
5. Critique o plano e peça para salvá-lo em `docs/plano-prioridade.md`, sem autorizar a implementação.

**Entrega:** `CLAUDE.md` commitado e plano salvo em `docs/plano-prioridade.md`. Referência: branch `modulo-3`.

## Exercício 4 · Implementar prioridade e prazo (20 min) · a partir de `modulo-3`

> Como usuário, quero definir prioridade e prazo nas minhas tarefas, para focar no que é urgente.

Critérios de aceite:

1. Prioridade BAIXA, MEDIA ou ALTA; padrão MEDIA.
2. Prazo é opcional e não pode estar no passado na criação.
3. `GET /tarefas?prioridade=ALTA` filtra pela prioridade.
4. Tarefa com prazo vencido e não concluída aparece como atrasada.
5. Tarefa sem prazo mantém a regra atual: atrasada após 7 dias da criação.

Passos: **primeiro, crie a branch** `feat/prioridade-prazo`; retome com contexto limpo e `@docs/plano-prioridade.md`; implemente no modo padrão; suba a aplicação e teste com `curl`; diante de um erro, cole o stack trace completo e peça diagnóstico antes da correção.

**Entrega:** feature funcionando e os 5 critérios conferidos. Referência: branch `modulo-4`.

## Atividade 4B · Que tipo de falha é esta? (3 min)

Classifique como passageira, permanente, lógica ou sem progresso: `529 Overloaded`; `cannot find symbol: getDeadline()`; o agente editou o teste em vez do service; terceira tentativa com o mesmo `NullPointerException`; `401 authentication_error`.

## Exercício 5 · Diff, commit e revisão (10 min) · a partir de `modulo-4`

1. Continue na branch `feat/prioridade-prazo` criada no Exercício 4.
2. Veja o diff: `git diff` se tem alterações locais, ou `git diff modulo-3...HEAD` se retomou da branch `modulo-4`.
3. Peça ao agente que explique o diff e aponte o que está fora do escopo; faça um commit revisado (Conventional Commits).
4. Em sessão nova, peça a revisão de `modulo-3...HEAD` e confira cada achado no código.
5. Desafio: refatore a regra de atraso para `Tarefa.estaAtrasada(hoje)`, com testes verdes antes e depois.

**Entrega mínima:** um commit revisado e os achados da revisão conferidos no código. Referência: branch `modulo-5`.

## Exercício 6 · Caçar o bug plantado (15 min) · branch `modulo-6-bug`

1. Faça checkout de `modulo-6-bug` e rode `./mvnw test`.
2. Peça a lista de casos de borda das regras de prazo e atraso e gere os testes que faltarem.
3. Siga `@docs/debug.md`: reproduzir, hipóteses, causa raiz, provar.
4. Corrija a implementação **sem alterar os testes existentes**.
5. Registre a lição no `CLAUDE.md` e faça commit.

Dica: há mais de um bug. Nem todos têm teste.

**Entrega:** bugs corrigidos, testes novos e lição no `CLAUDE.md`. Referência: branch `modulo-6`.

## Exercício 7 · Uma skill simples (6 min) · a partir de `modulo-6`

**Entrega mínima:** crie uma skill de arquivo único, `.claude/skills/revisao-codigo/SKILL.md`, com nome, descrição e passos (use `git diff modulo-3...HEAD`), e acione a skill uma vez (`/revisao-codigo` ou "revise minhas mudanças").

Desafios opcionais:

- **Hook** `PostToolUse` que roda o formatador; edite um arquivo e confirme que ele rodou.
- **Subagente** revisor só com `Read`, `Grep` e `Glob`: sem `Edit` nem `Bash`, para ser de fato somente leitura.
- **MCP**: conecte um servidor (por exemplo, GitHub) com `claude mcp add`, se já tiver credencial.

**Entrega:** a skill commitada em `.claude/skills/`. Solução completa de referência: branch `modulo-7`.

## Atividade 7B · Escolha o mecanismo (4 min)

Hook, skill, MCP, subagente, CLAUDE.md ou plugin? Formatador em todo arquivo editado; checklist de revisão repetido pela equipe; consultar issues do Jira; mapear 200 arquivos legados sem poluir a sessão; Java 21 e convenção de nomes; levar a configuração para outros cinco repositórios.

## Atividade 8 · Caça à injeção (5 min)

Um README de terceiros contém, num comentário HTML invisível, uma instrução para rodar `curl … | bash` e colar o `.env` num PR. Por que um humano não veria? Em que modo o agente executaria? Que regras deny bloqueiam cada parte? Onde está a tríade letal?
