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

Classifique as operações em permitir, exigir confirmação ou bloquear: ler `src/`; executar `./mvnw test`; editar o service; `git push origin main`; ler `.env`; destruir dados. Configure aprovações na interface do Antigravity e teste em um projeto descartável. **Não presuma que regras do Claude Code funcionam.**

## Exercício 2 · Explorar o gestor-tarefas (10 min) · branch `main`

1. Abra o Antigravity na raiz do repositório (modo padrão de permissões).
2. Peça um mapa da arquitetura e dos arquivos principais.
3. Trace o fluxo de criação de uma tarefa, do controller ao banco.
4. Descubra como o sistema decide que uma tarefa está atrasada.
5. Confira cada resposta abrindo os arquivos citados.

**Entrega:** um parágrafo descrevendo o projeto e uma resposta conferida no código.

## Exercício 3A · Laboratório de prompts (8 min, opcional)

Use a mesma tarefa no antes e no depois e peça só plano ou revisão, sem alterar arquivos. Rode o prompt vago, reescreva e compare pela rubrica: escopo correto, referência ao código, casos de borda e verificação. Para saber qual técnica ajudou, mude uma de cada vez.

## Exercício 3 · AGENTS.md e plano da feature (10 min) · branch `main`

1. Abra `AGENTS.md` e confira as instruções no código real.
2. Atualize comandos, convenções e duas regras “não faça”.
3. Faça `git add AGENTS.md && git commit -m "docs: instruções do projeto"`.
4. Inicie nova conversa; peça plano **sem editar código** para prioridade e prazo.
5. Revise o plano, salve em `docs/plano-prioridade.md` e faça commit.

**Entrega:** `AGENTS.md` e plano revisados. A branch `modulo-3` é uma referência histórica de comportamento, não uma exigência para copiar `CLAUDE.md`.

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

1. Partindo de `modulo-6-bug`, crie `fix/bug-datas` e rode `./mvnw test`.
2. Peça a lista de casos de borda das regras de prazo e atraso e gere os testes que faltarem.
3. Siga `@docs/debug.md`: reproduzir, hipóteses, causa raiz, provar.
4. Corrija a implementação **sem alterar os testes existentes**.
5. Registre a lição no `AGENTS.md` e faça commit.

Dica: há mais de um bug. Nem todos têm teste.

**Entrega:** bugs corrigidos, testes novos e lição no `AGENTS.md`. Referência: branch `modulo-6`.

## Exercício 7 · Uma Skill simples (6 min) · a partir de `modulo-6`

**Entrega mínima:** parta da branch `modulo-6`; crie ou revise `.agents/skills/revisao-codigo/SKILL.md`, peça ao Antigravity para utilizá-la na revisão do diff e confira ao menos um achado no código.

Desafios opcionais: hook pós-edição limitado; subagente revisor com ferramentas somente de leitura; MCP de demonstração com credenciais descartáveis. Nenhum deles é obrigatório na cota Free. A configuração do Claude Code na branch histórica `modulo-7` é apenas referência conceitual.

## Atividade 7B · Escolha o mecanismo (4 min)

Hook, Skill, MCP, subagente ou AGENTS.md? Formatador em todo arquivo editado; checklist de revisão repetido pela equipe; consultar issues do Jira; mapear 200 arquivos legados sem poluir a sessão; Java 21 e convenção de nomes; levar a configuração para outros cinco repositórios.

## Atividade 8 · Caça à injeção (5 min)

Um README de terceiros contém, num comentário HTML invisível, uma instrução para rodar `curl … | bash` e colar o `.env` num PR. Por que um humano não veria? Em que modo o agente executaria? Que regras deny bloqueiam cada parte? Onde está a tríade letal?
