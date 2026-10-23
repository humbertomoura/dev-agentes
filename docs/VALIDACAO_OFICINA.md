# Checklist de ensaio da oficina — Antigravity Free + IntelliJ IDEA

> Versão revisada em 23/10/2026. Este documento separa verificações **locais** (que conseguimos inspecionar automaticamente) das verificações **interativas** (que exigem uma conta Google e o aplicativo Antigravity).

## 1. Antes de divulgar a oficina

- [ ] Conta Google pessoal consegue autenticar no **Antigravity Individual (US$ 0)**.
- [ ] A cota semanal disponível suporta 1 exploração + 1 planejamento + 1 implementação + 1 debugging + 1 revisão.
- [ ] Em **IntelliJ IDEA 2026.2.1+**, abrir `JetBrains AI > Settings > Agents`, instalar Antigravity e autenticar. *A licença estudantil do IntelliJ não é uma cota de IA.*
- [ ] Se a versão da IDE for anterior, executar `agy --version` no terminal integrado e utilizar o CLI autenticado.
- [ ] JDK 21 configurado em *Project SDK* e terminal (`java -version`).
- [ ] Projeto Maven carregado e dependências disponíveis antes da oficina.
- [ ] `./mvnw test` (Linux/macOS) ou `mvnw.cmd test` (Windows) conclui sem erro no estado `main`.
- [ ] Branch `modulo-6-bug` demonstra o defeito; branch `modulo-6` executa todos os testes.
- [ ] Abrir a Skill `revisao-codigo` e testá-la com `/revisao-codigo` (superfícies que suportam slash skill) ou referência em linguagem natural.
- [ ] Em uma pasta descartável, confirmar o comportamento real das aprovações (edição, comando e rede).

## 2. Comandos mínimos

```bash
java -version
agy --version
./mvnw test
./mvnw spring-boot:run
# Em outro terminal:
curl http://localhost:8080/tarefas
git status --short
git branch -a
```

No Windows use `mvnw.cmd` e adapte comandos conforme o shell. Não tente executar o terminal sandbox do agente com acesso indiscriminado à rede.

## 3. Prompts do ensaio

**Explorar** (sem edição):

> Inspecione este repositório Spring Boot. Cite os caminhos de controller, service, repository e DTO. Trace `POST /tarefas` até o banco; não modifique arquivos.

**Planejar** (`/plan` no App ou CLI):

> Planeje prioridade BAIXA/MEDIA/ALTA com padrão MEDIA, prazo opcional, filtro GET e preservação de tarefas antigas. Identifique as migrations, os testes e os riscos. Não implemente.

**Implementar** (branch descartável a partir de `modulo-3`):

> Implemente o plano aprovado em etapas pequenas, seguindo AGENTS.md. Rode testes após as mudanças. Não faça commit nem push.

**Depurar** (branch derivada de `modulo-6-bug`):

> Reproduza o problema de data, explique a causa raiz e faça teste de regressão antes de corrigir. Não altere testes existentes.

**Revisar**:

> Use a skill `revisao-codigo` para examinar o diff; priorize defeitos concretos, riscos de JPA/transação, datas e testes; não edite arquivos.

## 4. Controle de gasto de cota gratuita

- Abrir com um único agente principal em modo de aprovação supervisionada.
- Evitar subagentes simultâneos, longa varredura de arquivos e múltiplas chamadas a ferramentas externas.
- Criar novo chat após cada fase; deixar os critérios de aceitação e arquivos relevantes no prompt.
- Utilizar as branches de referência caso o tempo ou a cota termine; concluir revisão Git, testes e debugging no IntelliJ.
- Registrar no ensaio: quantidade de tarefas concluídas, erros de cota, tempo de build local e número de verificações humanas.

## 5. Plano de contingência

1. Integração JetBrains indisponível: usar `agy` no terminal do IntelliJ.
2. Sem IDE compatível: usar o aplicativo Antigravity com a pasta local aberta e IntelliJ apenas para depurar.
3. Atingiu limite Free: retomar do checkpoint da fase e executar testes/revisão manual; trabalhar em dupla se permitido pelos termos e pelo evento, **sem compartilhar credenciais**.
4. Maven sem internet: pré-aquecer cache Maven e distribuir ambiente de laboratório previamente configurado.

## 6. Referências oficiais

- [Planos](https://antigravity.google/pricing)
- [Introdução e instalação](https://antigravity.google/docs/getting-started)
- [Planejamento `/plan`](https://antigravity.google/docs/plan/)
- [Permissões](https://antigravity.google/docs/permissions)
- [Skills](https://antigravity.google/docs/skills/)
- [Subagentes](https://antigravity.google/docs/subagents/)
- [Hooks](https://antigravity.google/docs/hooks)
