# Plano: prioridade e prazo nas tarefas

Plano gerado em plan mode e revisado antes da implementação.

## Requisito

Como usuário, quero definir prioridade e prazo nas minhas tarefas, para focar no que é urgente.

## Passos

1. Criar o enum `Prioridade` (BAIXA, MEDIA, ALTA) em `model/`.
2. Adicionar à entidade `Tarefa` os campos `prioridade` (obrigatório, padrão MEDIA) e `prazo` (`LocalDate`, opcional).
3. Criar a migration `V5__prioridade_prazo.sql`:
   - coluna `prioridade VARCHAR(10) NOT NULL DEFAULT 'MEDIA'` (preenche as tarefas existentes);
   - coluna `prazo DATE` (nula para as tarefas existentes).
4. Aceitar `prioridade` e `prazo` em `CriarTarefaRequest`; prioridade ausente vira MEDIA.
5. Validar em `TarefaService.criar()`: prazo no passado gera `IllegalArgumentException` (HTTP 400).
6. Filtro opcional `GET /tarefas?prioridade=ALTA`, combinável com `status`.
7. Regra de atraso:
   - com prazo: atrasada se o prazo já passou e a tarefa não foi concluída;
   - sem prazo: mantém a regra atual (7 dias após a criação).
8. Expor `prioridade` e `prazo` em `TarefaResponse`.
9. Testes: unitários (prioridade padrão, prazo no passado, atraso com prazo) e de integração (criação com prazo, filtro por prioridade).

## Ajustes feitos na revisão do plano

- A primeira versão ordenava `GET /tarefas` por prioridade. Removido: mudaria o comportamento atual da listagem.
- Incluído o `DEFAULT 'MEDIA'` na migration para não quebrar as tarefas já cadastradas (critério 5).

## Riscos

- Tarefas antigas sem prazo: cobertas pela regra de 7 dias.
- Fuso horário: a data de hoje vem do `Clock` configurado para America/Sao_Paulo.
