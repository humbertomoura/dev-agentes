package br.edu.ifrs.tarefas.service;

import br.edu.ifrs.tarefas.dto.CriarTarefaRequest;
import br.edu.ifrs.tarefas.model.StatusTarefa;
import br.edu.ifrs.tarefas.model.Tarefa;
import br.edu.ifrs.tarefas.repository.TarefaRepository;
import java.time.Clock;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TarefaService {

  /** Toda tarefa aberta deve ser concluída em até 7 dias após a criação. */
  static final int PRAZO_PADRAO_DIAS = 7;

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
    Tarefa t = new Tarefa(req.titulo().trim(), req.descricao(), hoje());
    return repository.save(t);
  }

  @Transactional(readOnly = true)
  public List<Tarefa> listar(StatusTarefa status) {
    if (status == null) {
      return repository.findAllByOrderByIdAsc();
    }
    return repository.findByStatusOrderByIdAsc(status);
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

  /** Dias além do prazo padrão. Tarefas concluídas nunca estão atrasadas. */
  public long calcularAtraso(Tarefa t) {
    if (t.isConcluida()) {
      return 0;
    }
    long diasEmAberto = ChronoUnit.DAYS.between(t.getCriadaEm(), hoje());
    return Math.max(0, diasEmAberto - PRAZO_PADRAO_DIAS);
  }

  public boolean estaAtrasada(Tarefa t) {
    return calcularAtraso(t) > 0;
  }

  private LocalDate hoje() {
    return LocalDate.now(clock);
  }
}
