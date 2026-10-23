# Ambiente gratuito — Antigravity Free + IntelliJ IDEA

**Antes do evento:** confirme que sua conta tem acesso ao plano gratuito e que a ferramenta consegue ler um arquivo e propor uma alteração em um repositório local. Disponibilidade, cota, autenticação e nomes dos menus podem mudar; siga a [documentação atual](https://antigravity.google/docs/getting-started).

## 1. Preparação

- Instale JDK 21, Git e IntelliJ IDEA. A licença educacional Ultimate é opcional. **Para integração nativa com Antigravity, o IntelliJ precisa ser 2026.2.1 ou posterior**; para versões antigas, use o CLI no terminal da IDE.
- Instale o Google Antigravity conforme a documentação e autentique-se numa conta elegível. Não é necessária assinatura individual paga no plano Free, mas há limites.
- Para a integração nativa, use `JetBrains AI > Settings > Agents`, procure Antigravity, instale e autentique-se; exige IntelliJ 2026.2.1+. Se a integração não estiver disponível, instale o CLI `agy` e use-o no terminal integrado da IDE.
- Verifique o CLI com `agy --version` e inicie-o pelo comando `agy` na pasta do projeto. No App/CLI, `/plan` inicia planejamento. Menus e recursos podem diferir entre superfícies.

## 2. Abrir projeto e conferir

```bash
git clone https://github.com/humbertomoura/dev-agentes.git
cd dev-agentes
java -version
./mvnw test
./mvnw spring-boot:run
```

Windows: `mvnw.cmd test`. No IntelliJ, abra a pasta como projeto Maven, escolha JDK 21, espere a indexação e execute os testes pelo painel JUnit. O Maven Wrapper baixa dependências na primeira execução: prepare antes do evento.

## 3. Fluxo de trabalho recomendado

1. Abrir a pasta da branch correta no ambiente do agente.
2. Solicitar **somente leitura** na exploração e planejamento; conferir arquivos citados.
3. Criar ou revisar `AGENTS.md` e consultar `GEMINI.md`.
4. Planejar com `/plan` (App/CLI); solicitar implementação incremental e **aprovar cada ação sensível**.
5. Rodar `./mvnw test` e examinar o Git diff no IntelliJ.
6. Criar commit somente depois de revisão humana.

## 4. Segurança e limites

- Plano Free possui limite de uso; prefira comandos e prompts de escopo pequeno.
- Não permita leitura de segredos, `git push`, scripts externos ou deleções em lote.
- As aprovações, a interface do agente e configurações de permissões variam conforme a versão; evite traduzir regras `.claude/settings.json` literalmente.
- A configuração de skills do laboratório está em `.agents/skills/`; para hooks, MCP e subagentes, consulte a documentação de cada versão e utilize ambientes sem credenciais reais.
- Se ficar sem cota, compare com o checkpoint da branch ou faça a revisão e os testes manualmente no IntelliJ.

## 5. Links oficiais

- [Antigravity](https://antigravity.google/)
- [Guia de início](https://antigravity.google/docs/getting-started)
- [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [JetBrains para estudantes](https://www.jetbrains.com/community/education/#students)

## Documentos complementares

- [Guia rápido do participante](GUIA_RAPIDO_ANTIGRAVITY.md)
- [Checklist de ensaio do instrutor](VALIDACAO_OFICINA.md)
