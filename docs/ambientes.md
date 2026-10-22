# Ambientes da oficina: web, VS Code e IntelliJ

O agente é o mesmo nos três ambientes. O que está versionado no repositório (`CLAUDE.md`, `.claude/settings.json`, `.claude/skills/`, `.claude/agents/`) vale em todos. A configuração pessoal em `~/.claude/` vale no VS Code e no IntelliJ da sua máquina, mas não vai para a nuvem.

## Claude Code na web (claude.ai/code)

1. Acesse claude.ai/code e conecte o GitHub com a Claude GitHub App.
2. Crie um ambiente: rede **Trusted** (padrão), variáveis em formato `.env` e, se quiser, um script de setup. A VM já traz OpenJDK 21 com Maven e Gradle.
3. Script de setup opcional para cachear dependências: `./mvnw -q -DskipTests package`.
4. Escolha o repositório `desenvolvimento-agentes` e a branch, defina o modo de permissão e descreva a tarefa.
5. Revise o diff (com comentários por linha) e crie o pull request.

Diferenças: comandos que abrem seletores recebem argumento (`/model sonnet`, `/effort high`); não há `/clear` (abra uma nova sessão); `/compact` e `/context` funcionam. Faça push antes de pedir algo que dependa de commits locais.

## VS Code (extensão Claude Code)

1. Instale a extensão **Claude Code** (Cmd/Ctrl+Shift+X) e faça login.
2. Abra a pasta raiz do repositório e clique no ícone ✱.
3. Configurações sugeridas (Cmd/Ctrl+, → Extensions → Claude Code): `initialPermissionMode: plan`, `preferredLocation: sidebar`, `respectGitIgnore: true`.
4. No rodapé do prompt: modo de permissão, modelo e esforço, uso do contexto. Menu `/`: MCP, skills, hooks, permissões, memória (CLAUDE.md) e plugins.
5. Contexto: a seleção vai automaticamente; Option/Alt+K insere `@arquivo#linhas`.

## IntelliJ IDEA (plugin Claude Code [Beta])

1. Instale o CLI e confira com `claude --version`.
2. Instale o plugin **Claude Code [Beta]** no JetBrains Marketplace e reinicie o IDE.
3. Abra o projeto pela raiz e use Cmd/Ctrl+Esc para abrir o Claude Code no terminal do IDE.
4. Rode `/config` e defina o diff tool como `auto` para ver diffs no visualizador do IntelliJ.
5. Se o Esc não interromper o Claude, desmarque Settings → Tools → Terminal → *Move focus to the editor with Escape*.

## Equivalências rápidas

| Ação | Web | VS Code | IntelliJ (CLI no IDE) |
|---|---|---|---|
| Modelo | `/model sonnet` | nome do modelo no rodapé | `/model` |
| Esforço | `/effort high` | linha Effort no seletor | `/effort` |
| Modo | menu de modo | indicador no rodapé | Shift+Tab |
| Limpar contexto | nova sessão; `/compact` | nova conversa; `/compact` | `/clear`; `/compact` |
| CLAUDE.md | do repositório | `/` → Instructions | `/memory` |
| MCP | conectores da sessão | `/mcp` | `/mcp`, `claude mcp add` |
| Plugins | declarados no settings do repo | `/plugins` | `/plugin` |
