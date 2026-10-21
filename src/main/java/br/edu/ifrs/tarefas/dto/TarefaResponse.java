package br.edu.ifrs.tarefas.dto;

import br.edu.ifrs.tarefas.model.Prioridade;
import br.edu.ifrs.tarefas.model.StatusTarefa;
import br.edu.ifrs.tarefas.model.Tarefa;
import java.time.LocalDate;

public record TarefaResponse(
    Long id,
    String titulo,
    String descricao,
    StatusTarefa status,
    Prioridade prioridade,
    LocalDate prazo,
    LocalDate criadaEm,
    LocalDate concluidaEm,
    boolean atrasada,
    long diasDeAtraso) {

  public static TarefaResponse de(Tarefa t, boolean atrasada, long diasDeAtraso) {
    return new TarefaResponse(
        t.getId(),
        t.getTitulo(),
        t.getDescricao(),
        t.getStatus(),
        t.getPrioridade(),
        t.getPrazo(),
        t.getCriadaEm(),
        t.getConcluidaEm(),
        atrasada,
        diasDeAtraso);
  }
}
