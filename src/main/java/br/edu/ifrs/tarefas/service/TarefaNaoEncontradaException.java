package br.edu.ifrs.tarefas.service;

public class TarefaNaoEncontradaException extends RuntimeException {

  public TarefaNaoEncontradaException(Long id) {
    super("Tarefa " + id + " não encontrada");
  }
}
