package br.edu.ifrs.tarefas.dto;

import br.edu.ifrs.tarefas.model.StatusTarefa;
import br.edu.ifrs.tarefas.model.Tarefa;
import java.time.LocalDate;

public record TarefaResponse(
    Long id,
    String titulo,
    String descricao,
    StatusTarefa status,
    LocalDate criadaEm,
    LocalDate concluidaEm,
    boolean atrasada,
    long diasDeAtraso) {

  public static TarefaResponse de(Tarefa t, long diasDeAtraso) {
    return new TarefaResponse(
        t.getId(),
        t.getTitulo(),
        t.getDescricao(),
        t.getStatus(),
        t.getCriadaEm(),
        t.getConcluidaEm(),
        diasDeAtraso > 0,
        diasDeAtraso);
  }
}
