# Referência de migração Claude Code → Antigravity

| Na oficina original | Na versão atual |
|---|---|
| `claude` | Antigravity (app/integração ou CLI `agy`, instalado e autenticado) |
| `CLAUDE.md` | `AGENTS.md` e ponte `GEMINI.md` |
| `/init` | criar/revisar manualmente `AGENTS.md` |
| `/clear` | iniciar conversa nova |
| `plan mode` | `/plan` no Antigravity App ou CLI; não autorizar edição antes de aprovar o plano |
| `.claude/skills/` | `.agents/skills/` |
| `.claude/settings.json` | configurações de aprovação/permissão do Antigravity; **não copiar JSON** |
| `.claude/agents/` | `.agents/agents/`, usando nomes reais das ferramentas do Antigravity |
| `PostToolUse` do Claude | `.agents/hooks.json` com schema próprio do Antigravity; não copiar o JSON original |
| `claude mcp add` | configuração MCP própria do Antigravity |
| `/revisao-codigo` | `/revisao-codigo` em superfícies com slash skills ou pedido em linguagem natural |

## Prompt reutilizável para planejamento

> Leia AGENTS.md e os arquivos relevantes. Planeje a implementação da feature de prioridade e prazo sem editar nenhum arquivo. Cite arquivos, alterações previstas, riscos de dados existentes, testes necessários e critérios de aceite. Pare após apresentar o plano.

## Prompt reutilizável para revisão

> Faça uma revisão somente leitura do diff. Priorize problemas reais, verifique arquivos/linhas e informe testes que foram ou não executados. Não edite, não commite nem envie alterações à rede.

## Observação

O arquivo `AGENTS.md` contém instruções; não é uma barreira de segurança. Permissões e isolamento precisam ser configurados e testados separadamente.

## Comandos oficiais úteis (App/CLI)

`/plan`, `/permissions`, `/usage`, `/diff`, `/context`, `/agents`, `/learn`. Confira disponibilidade na superfície usada.

## IntelliJ

A integração nativa exige **IntelliJ 2026.2.1+** e é instalada por `JetBrains AI > Settings > Agents > Antigravity`. Se indisponível, utilize `agy` pelo terminal do IntelliJ. Não confunda a assinatura educacional do IntelliJ com créditos de IA.

## Permissões

Em macOS/Linux há perfis **Request Review**, **Default**, **Auto (Preview)** e **Turbo** em versões elegíveis. Para a oficina prefira Request Review ou Default; **não** use Turbo. Windows usa controles que podem diferir; sempre teste o comportamento antes de demonstrar.
