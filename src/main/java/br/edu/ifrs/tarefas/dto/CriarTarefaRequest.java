package br.edu.ifrs.tarefas.dto;

import br.edu.ifrs.tarefas.model.Prioridade;
import java.time.LocalDate;

public record CriarTarefaRequest(
    String titulo, String descricao, Prioridade prioridade, LocalDate prazo) {

  public CriarTarefaRequest(String titulo, String descricao) {
    this(titulo, descricao, null, null);
  }

  public Prioridade prioridadeOuPadrao() {
    return prioridade != null ? prioridade : Prioridade.MEDIA;
  }
}
