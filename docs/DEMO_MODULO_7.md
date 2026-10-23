# Módulo 7 — Skill, subagente e hook Antigravity

> Material para demonstração do instrutor. **O hook está desativado por padrão** para evitar execução inesperada no computador do aluno.

## 1. Skill — entrega comum

Local: `.agents/skills/revisao-codigo/SKILL.md`.

Acione `/revisao-codigo` quando sua superfície suportar slash skills ou solicite: “Use a skill `revisao-codigo` para avaliar somente o diff da minha branch. Não edite arquivos.”

Critério: revisar um achado no código e confrontar com a saída de `git diff` do IntelliJ.

## 2. Subagente — demonstração opcional

Local: `.agents/agents/revisor.md`. A configuração de ferramentas contém apenas `view_file`, `grep_search`, `find_by_name` e impede execução de comandos (`commandExecutionPolicy: off`).

Peça ao agente principal: “Delegue ao subagente `revisor` a leitura dos arquivos da feature e obtenha um relatório de riscos. Não modifique arquivos.”

O sistema de subagentes e a seleção pela interface podem variar. Não pressupor que todas as superfícies JetBrains ofereçam todos os recursos do App/CLI.

## 3. Hook — demonstração opcional

Local: `.agents/hooks.json`. O exemplo desativado usa `PostToolUse` com matcher de edições e somente `git diff --check` (sem reformatar todo o projeto).

1. Mostre o JSON e explique o gatilho e o comando.
2. Em cópia descartável, habilite alterando `enabled` para `true`.
3. Faça uma edição pequena e verifique no painel do agente/CLI se o hook executou.
4. Desabilite novamente. Não utilize `spotless:apply` como hook global durante a oficina.

O nome `PostToolUse` existe nos dois ecossistemas, mas **o schema e nomes de ferramentas não são iguais**.

## 4. MCP — demonstração opcional

MCP conecta ferramentas externas; não equivale a memória persistente nem substitui Skills. Demonstre em servidor local sem credenciais reais. Se não houver um ambiente pronto, mostre apenas o fluxo conceitual, em vez de configurar um servidor externo ao vivo.

## Documentação oficial

- Skills: https://antigravity.google/docs/skills/
- Subagentes: https://antigravity.google/docs/subagents/
- Hooks: https://antigravity.google/docs/hooks
- MCP: https://antigravity.google/docs/mcp/
