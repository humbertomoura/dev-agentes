# Do Prompt ao Commit: programando com Claude Code

Repositório da oficina ministrada no **IFRS Campus Osório** em **23/10/2026, das 19h15 às 22h20**.

O projeto `gestor-tarefas` é uma API REST de tarefas em Java 21 + Spring Boot 3. Ele é o fio condutor da oficina: cada módulo adiciona uma camada ao mesmo código, sempre com o Claude Code.

## Pré-requisitos

- Java 21 (JDK)
- Git
- Claude Code instalado e com login feito ([documentação oficial](https://code.claude.com/docs))
- Opcional: `curl` ou outro cliente HTTP

A oficina pode ser feita na web (claude.ai/code), no VS Code ou no IntelliJ: veja [`docs/ambientes.md`](docs/ambientes.md).

Não é preciso instalar Maven nem banco de dados: o projeto usa o Maven Wrapper (`./mvnw`) e H2 em memória.

## Primeiros passos

```bash
git clone https://github.com/humbertomoura/desenvolvimento-agentes.git
cd desenvolvimento-agentes
./mvnw test                 # roda testes unitários e de integração
./mvnw spring-boot:run      # sobe a API em http://localhost:8080
claude                      # abre o Claude Code na raiz do projeto
```

No Windows, use `mvnw.cmd` no lugar de `./mvnw`.

## Endpoints

| Método | Caminho | Descrição |
|---|---|---|
| GET | `/tarefas?status=PENDENTE&prioridade=ALTA` | lista tarefas, com filtros opcionais |
| GET | `/tarefas/{id}` | detalha uma tarefa |
| POST | `/tarefas` | cria tarefa: `{"titulo": "...", "descricao": "...", "prioridade": "ALTA", "prazo": "2026-11-30"}` |
| PATCH | `/tarefas/{id}/iniciar` | move de PENDENTE para EM_ANDAMENTO |
| PATCH | `/tarefas/{id}/concluir` | conclui a tarefa |
| DELETE | `/tarefas/{id}` | exclui a tarefa |

O console do H2 fica em `http://localhost:8080/h2-console` (JDBC URL `jdbc:h2:mem:tarefas`, usuário `sa`, sem senha).

## Branches de referência

Cada módulo tem uma branch com o estado esperado ao final do exercício. Se você se perder, faça checkout da branch do módulo anterior e continue dali.

| Branch | Estado |
|---|---|
| `main` | ponto de partida (Fases 0 e 1) |
| `modulo-2` | + `docs/visao-geral.md`, exploração conferida no código |
| `modulo-3` | + `CLAUDE.md` e plano da feature em `docs/plano-prioridade.md` |
| `modulo-4` | + feature de prioridade e prazo implementada |
| `modulo-5` | + regra de atraso refatorada para `Tarefa` |
| `modulo-6-bug` | ponto de partida do Módulo 6, com bugs plantados |
| `modulo-6` | bugs corrigidos, novos testes e lição registrada no `CLAUDE.md` |
| `modulo-7` | + skill, subagentes, hook e permissões em `.claude/` |
| `modulo-8` | + segurança, CI no GitHub Actions e entrega (tag `v1.0.0`) |

```bash
git fetch --all
git switch modulo-4
```

## Exercícios

Os enunciados estão em [`docs/exercicios.md`](docs/exercicios.md). O guia de debugging usado no Módulo 6 está em [`docs/debug.md`](docs/debug.md).

## Roteiro passo a passo

O caminho completo, do clone à versão `v1.0.0`, está em [`docs/roteiro/`](docs/roteiro/README.md): uma fase por módulo, com prompts, comandos, verificação e conceitos aplicados.

## Estrutura

```
src/main/java/br/edu/ifrs/tarefas/
  controller/   endpoints REST e tratamento de erros
  service/      regras de negócio (criação, conclusão, atraso)
  repository/   acesso a dados (Spring Data JPA)
  model/        entidade Tarefa e enums
  dto/          objetos de entrada e saída da API
  config/       relógio injetável (facilita testes com datas)
src/main/resources/db/migration/   migrations Flyway (V1, V2, ...)
```

## Licença

MIT. Veja [LICENSE](LICENSE).
