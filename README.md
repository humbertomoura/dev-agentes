# Do Prompt ao Commit: programação com agentes de IA

**Oficina prática — Google Antigravity Free + IntelliJ IDEA**, Java 21, Spring Boot 3, Maven Wrapper, Flyway e H2. Projeto de referência: `gestor-tarefas`.

> O Antigravity tem um plano gratuito sujeito a limites e elegibilidade. Antes da oficina, teste o acesso no seu computador e consulte os termos oficiais. A licença educacional do IntelliJ não garante créditos de IA; a IDE é o ambiente de desenvolvimento.

## Primeiros passos

1. Instale Git, JDK 21 e IntelliJ IDEA (Community ou Ultimate educacional).
2. Instale e autentique o Antigravity seguindo a [documentação oficial](https://antigravity.google/docs/getting-started).
3. Abra este repositório no IntelliJ e verifique o JDK 21.
4. No terminal integrado, execute:

```bash
git clone https://github.com/humbertomoura/dev-agentes.git
cd dev-agentes
./mvnw test
./mvnw spring-boot:run
```

No Windows, use `mvnw.cmd`. Abra o agente Antigravity no ambiente disponível (aplicativo, integração JetBrains ou CLI, conforme a instalação); a interface pode variar por versão. Nunca cole chaves em prompts ou faça push de segredos.

## Atividades e referências

- [Configuração gratuita do ambiente](docs/ambientes.md)
- [Exercícios](docs/exercicios.md)
- [Roteiro passo a passo](docs/roteiro/README.md)
- [Guia de debugging](docs/debug.md)
- [Instruções compartilhadas do agente](AGENTS.md)
- [Skill de revisão](.agents/skills/revisao-codigo/SKILL.md)

## Branches de referência

`main` (início), `modulo-2` (exploração), `modulo-3` (contexto e plano), `modulo-4` (prioridade e prazo), `modulo-5` (refatoração), `modulo-6-bug` (bug plantado), `modulo-6` (correções), `modulo-7` (extensões) e `modulo-8` (entrega), mais tag histórica `v1.0.0`.

**Atenção:** as branches são soluções de referência, não etapas executadas automaticamente. Faça uma branch de trabalho própria para cada exercício.

## API

- `GET /tarefas?status=PENDENTE`
- `GET /tarefas/{id}`
- `POST /tarefas` com `titulo` e `descricao`
- `PATCH /tarefas/{id}/iniciar`
- `PATCH /tarefas/{id}/concluir`
- `DELETE /tarefas/{id}`

O console H2 está em `http://localhost:8080/h2-console` com URL JDBC `jdbc:h2:mem:tarefas`, usuário `sa` e senha vazia no ambiente didático.

## Licença

MIT, conforme [LICENSE](LICENSE). A ferramenta agente e os modelos são serviços externos com condições próprias.
