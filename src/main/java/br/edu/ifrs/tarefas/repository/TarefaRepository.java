package br.edu.ifrs.tarefas.repository;

import br.edu.ifrs.tarefas.model.Prioridade;
import br.edu.ifrs.tarefas.model.StatusTarefa;
import br.edu.ifrs.tarefas.model.Tarefa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

  List<Tarefa> findByStatusOrderByIdAsc(StatusTarefa status);

  List<Tarefa> findByPrioridadeOrderByIdAsc(Prioridade prioridade);

  List<Tarefa> findByStatusAndPrioridadeOrderByIdAsc(StatusTarefa status, Prioridade prioridade);

  List<Tarefa> findAllByOrderByIdAsc();
}
