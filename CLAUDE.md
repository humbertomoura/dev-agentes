# gestor-tarefas

API REST de tarefas (Java 21, Spring Boot 3, Spring Data JPA, Flyway, H2 em memória).

## Comandos

- Testes (unitários e de integração): `./mvnw test`
- Rodar a aplicação: `./mvnw spring-boot:run` (porta 8080)
- Formatar o código: `./mvnw spotless:apply`

## Arquitetura

- `controller/` só recebe a requisição e delega ao service; erros viram ProblemDetail em `ApiExceptionHandler`.
- `service/` concentra as regras de negócio.
- `dto/` define entrada e saída da API; nunca exponha a entidade `Tarefa` diretamente.
- A data de "hoje" vem sempre do `Clock` injetado. Nunca use `LocalDate.now()` sem o clock.

## Convenções

- Código em inglês técnico mínimo; nomes de domínio em português (Tarefa, prazo, prioridade).
- Todo endpoint novo exige teste de integração em `src/test/.../controller/*IT.java`.
- Regra de negócio nova exige teste unitário com data fixa.
- Mudança de schema: nova migration `V<n>__descricao.sql` em `src/main/resources/db/migration/`.
- Commits no padrão Conventional Commits (`feat`, `fix`, `refactor`, `test`, `docs`, `chore`).

## Não faça

- Não altere migrations que já existem; crie uma nova.
- Não adicione dependências ao `pom.xml` sem perguntar.
- Não altere testes existentes para fazê-los passar sem perguntar.
