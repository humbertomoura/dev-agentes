# Referência de migração Claude Code → Antigravity

| Na oficina original | Na versão atual |
|---|---|
| `claude` | Antigravity (app/integração ou CLI `agy`, se disponível) |
| `CLAUDE.md` | `AGENTS.md` e ponte `GEMINI.md` |
| `/init` | criar/revisar manualmente `AGENTS.md` |
| `/clear` | iniciar conversa nova |
| `plan mode` | instrução explícita de **somente análise, sem editar**; conferir modo de planejamento na interface |
| `.claude/skills/` | `.agents/skills/` |
| `.claude/settings.json` | configurações de aprovação/permissão do Antigravity; **não copiar JSON** |
| `.claude/agents/` | agentes personalizados de acordo com a versão |
| `PostToolUse` | hooks disponíveis na instalação; não presumir evento/sintaxe idênticos |
| `claude mcp add` | configuração MCP própria do Antigravity |
| `/revisao-codigo` | solicitação em linguagem natural usando a skill de revisão |

## Prompt reutilizável para planejamento

> Leia AGENTS.md e os arquivos relevantes. Planeje a implementação da feature de prioridade e prazo sem editar nenhum arquivo. Cite arquivos, alterações previstas, riscos de dados existentes, testes necessários e critérios de aceite. Pare após apresentar o plano.

## Prompt reutilizável para revisão

> Faça uma revisão somente leitura do diff. Priorize problemas reais, verifique arquivos/linhas e informe testes que foram ou não executados. Não edite, não commite nem envie alterações à rede.

## Observação

O arquivo `AGENTS.md` contém instruções; não é uma barreira de segurança. Permissões e isolamento precisam ser configurados e testados separadamente.
