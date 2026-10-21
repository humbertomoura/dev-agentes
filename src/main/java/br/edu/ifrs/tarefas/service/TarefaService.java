package br.edu.ifrs.tarefas.service;

import br.edu.ifrs.tarefas.dto.CriarTarefaRequest;
import br.edu.ifrs.tarefas.model.Prioridade;
import br.edu.ifrs.tarefas.model.StatusTarefa;
import br.edu.ifrs.tarefas.model.Tarefa;
import br.edu.ifrs.tarefas.repository.TarefaRepository;
import java.time.Clock;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TarefaService {

  private final TarefaRepository repository;
  private final Clock clock;

  public TarefaService(TarefaRepository repository, Clock clock) {
    this.repository = repository;
    this.clock = clock;
  }

  public Tarefa criar(CriarTarefaRequest req) {
    if (req.titulo() == null || req.titulo().isBlank()) {
      throw new IllegalArgumentException("O título é obrigatório");
    }
    validarPrazo(req.prazo());
    Tarefa t =
        new Tarefa(
            req.titulo().trim(), req.descricao(), req.prioridadeOuPadrao(), req.prazo(), hoje());
    return repository.save(t);
  }

  private void validarPrazo(LocalDate prazo) {
    if (prazo != null && prazo.isBefore(hoje())) {
      throw new IllegalArgumentException("O prazo não pode estar no passado");
    }
  }

  @Transactional(readOnly = true)
  public List<Tarefa> listar(StatusTarefa status, Prioridade prioridade) {
    if (status != null && prioridade != null) {
      return repository.findByStatusAndPrioridadeOrderByIdAsc(status, prioridade);
    }
    if (status != null) {
      return repository.findByStatusOrderByIdAsc(status);
    }
    if (prioridade != null) {
      return repository.findByPrioridadeOrderByIdAsc(prioridade);
    }
    return repository.findAllByOrderByIdAsc();
  }

  @Transactional(readOnly = true)
  public Tarefa buscar(Long id) {
    return repository.findById(id).orElseThrow(() -> new TarefaNaoEncontradaException(id));
  }

  public Tarefa iniciar(Long id) {
    Tarefa t = buscar(id);
    t.iniciar();
    return t;
  }

  public Tarefa concluir(Long id) {
    Tarefa t = buscar(id);
    t.concluir(hoje());
    return t;
  }

  public void excluir(Long id) {
    repository.delete(buscar(id));
  }

  public long calcularAtraso(Tarefa t) {
    return t.diasDeAtraso(hoje());
  }

  public boolean estaAtrasada(Tarefa t) {
    return t.estaAtrasada(hoje());
  }

  private LocalDate hoje() {
    return LocalDate.now(clock);
  }
}
