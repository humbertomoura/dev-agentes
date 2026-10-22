# Visão geral do gestor-tarefas

Documento produzido na Fase 1 (Módulo 2), com cada afirmação conferida no código.

## O que o projeto faz

API REST de tarefas em Java 21 e Spring Boot 3. Permite criar, listar, iniciar, concluir e excluir tarefas, e informa se cada tarefa está atrasada.

## Arquitetura em camadas

| Camada | Arquivo principal | Responsabilidade |
|---|---|---|
| Controller | `controller/TarefaController.java` | recebe HTTP em `/tarefas` e delega ao service |
| Tratamento de erros | `controller/ApiExceptionHandler.java` | converte exceções em respostas 400, 404 e 409 |
| Service | `service/TarefaService.java` | regras de negócio: criação, conclusão e atraso |
| Repository | `repository/TarefaRepository.java` | acesso a dados com Spring Data JPA |
| Modelo | `model/Tarefa.java` | entidade com status e transições (`iniciar`, `concluir`) |
| Banco | `db/migration/V1` a `V4` | schema e dados de exemplo (Flyway, H2 em memória) |

## Fluxo de `POST /tarefas`

1. `TarefaController.criar()` recebe um `CriarTarefaRequest` com título e descrição.
2. `TarefaService.criar()` valida o título (obrigatório) e cria a `Tarefa` com status `PENDENTE` e a data de hoje vinda do `Clock` injetado.
3. `TarefaRepository.save()` grava no banco.
4. A resposta é um `TarefaResponse` com status 201 e o cabeçalho `Location`.

## Regra de atraso

`TarefaService.calcularAtraso()`: uma tarefa não concluída tem até 7 dias após a criação (`PRAZO_PADRAO_DIAS`). Passado isso, cada dia conta como atraso. Tarefas concluídas nunca estão atrasadas.

## Testes

`./mvnw test` roda 13 testes: 7 unitários (`TarefaServiceTest`) e 6 de integração (`TarefaControllerIT`), com a data fixada em 23/10/2026.
