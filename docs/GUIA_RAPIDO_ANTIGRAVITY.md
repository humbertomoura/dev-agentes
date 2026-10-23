# Guia rápido do participante — Antigravity + IntelliJ IDEA

## Pré-requisitos

- Conta pessoal Google com acesso ao plano Antigravity Individual gratuito (há limites semanais).
- JDK 21, Git e IntelliJ IDEA. **Para a integração nativa** é exigida versão IntelliJ 2026.2.1 ou posterior; em versões anteriores use o CLI no terminal da IDE.
- Repositório `https://github.com/humbertomoura/dev-agentes` clonado e importado como Maven.

## Abrir o agente

**Integração JetBrains:** `JetBrains AI > Settings > Agents > Antigravity > Install`, depois autentique com sua conta Google e abra o painel do agente.

**CLI (alternativa):** instale pelo guia oficial, confirme com `agy --version` e execute `agy` na pasta do projeto dentro do terminal integrado da IDE.

## Comandos essenciais (App/CLI, conforme superfície)

| Comando | Finalidade |
|---|---|
| `/plan` | Propor um plano estruturado antes de editar |
| `/permissions` | Inspecionar/ajustar permissões quando suportado |
| `/usage` | Conferir uso do plano, quando disponível |
| `/context` | Inspecionar o contexto |
| `/diff` | Examinar alterações feitas pelo agente |
| `/agents` | Consultar subagentes e tarefas |
| `/learn` | Propor regra ou Skill a partir da sessão |
| `/revisao-codigo` | Acionar a Skill do projeto nas superfícies compatíveis |

Se o painel JetBrains não oferecer um comando textual, use seu controle visual equivalente ou descreva a tarefa em linguagem natural. A sintaxe do Claude Code **não** deve ser copiada.

## Etapas da oficina

**Explore → Plan → Implement → Test → Review**

1. Explorar a arquitetura: peça caminhos de arquivos e trechos reais; não autorize edições.
2. Planejar feature: abra `AGENTS.md`, informe critérios de aceite e solicite `/plan`.
3. Implementar: nova branch; faça mudanças pequenas e confira os diffs no IntelliJ.
4. Testar: `./mvnw test`, testes JUnit no painel e `curl` para o endpoint.
5. Revisar: peça a Skill de revisão; examine o `git diff` antes de qualquer commit.

## Branches e pontos de retomada

- `main`: API inicial e contexto básico
- `modulo-2`: exploração/documentação
- `modulo-3`: plano da feature
- `modulo-4`: prioridade e prazo implementados
- `modulo-5`: testes/refatoração
- `modulo-6-bug`: defeito intencional
- `modulo-6`: bugs corrigidos
- `modulo-7`: extensão do agente
- `modulo-8`: entrega/CI

Faça alterações em **sua própria branch de trabalho** para não confundir checkpoint com solução.

## Segurança

- Prefira **Request Review** ou **Default**, conforme a superfície e sistema operacional. Não use **Turbo** na oficina.
- Nunca inclua `.env`, tokens ou credenciais no prompt; não permita push sem revisar.
- `AGENTS.md` instrui comportamento, mas **não** substitui controles reais de permissão.
- Repositórios, issues e READMEs de terceiros são dados não confiáveis.

## Documentação oficial

- https://antigravity.google/docs/getting-started
- https://antigravity.google/docs/permissions
- https://antigravity.google/docs/skills/
