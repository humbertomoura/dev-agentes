package br.edu.ifrs.tarefas.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import br.edu.ifrs.tarefas.dto.CriarTarefaRequest;
import br.edu.ifrs.tarefas.model.Prioridade;
import br.edu.ifrs.tarefas.model.StatusTarefa;
import br.edu.ifrs.tarefas.model.Tarefa;
import br.edu.ifrs.tarefas.repository.TarefaRepository;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TarefaServiceTest {

  static final LocalDate HOJE = LocalDate.of(2026, 10, 23);

  TarefaRepository repository;
  TarefaService service;

  @BeforeEach
  void setUp() {
    repository = mock(TarefaRepository.class);
    when(repository.save(any(Tarefa.class))).thenAnswer(inv -> inv.getArgument(0));
    Clock clock = Clock.fixed(HOJE.atStartOfDay(ZoneId.of("UTC")).toInstant(), ZoneId.of("UTC"));
    service = new TarefaService(repository, clock);
  }

  @Test
  void deveCriarTarefaPendenteComDataDeHoje() {
    Tarefa t = service.criar(new CriarTarefaRequest("  Estudar Spring  ", null));

    assertThat(t.getTitulo()).isEqualTo("Estudar Spring");
    assertThat(t.getStatus()).isEqualTo(StatusTarefa.PENDENTE);
    assertThat(t.getCriadaEm()).isEqualTo(HOJE);
  }

  @Test
  void deveRejeitarTituloVazio() {
    assertThatThrownBy(() -> service.criar(new CriarTarefaRequest("   ", null)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("título");
  }

  @Test
  void deveConcluir() {
    Tarefa t = new Tarefa("Ler artigo", null, HOJE.minusDays(2));
    when(repository.findById(1L)).thenReturn(Optional.of(t));

    service.concluir(1L);

    assertThat(t.isConcluida()).isTrue();
    assertThat(t.getConcluidaEm()).isEqualTo(HOJE);
  }

  @Test
  void naoDeveConcluirDuasVezes() {
    Tarefa t = new Tarefa("Ler artigo", null, HOJE.minusDays(2));
    t.concluir(HOJE.minusDays(1));
    when(repository.findById(1L)).thenReturn(Optional.of(t));

    assertThatThrownBy(() -> service.concluir(1L)).isInstanceOf(IllegalStateException.class);
  }

  @Test
  void tarefaDentroDoPrazoPadraoNaoTemAtraso() {
    Tarefa t = new Tarefa("Nova", null, HOJE.minusDays(7));

    assertThat(service.calcularAtraso(t)).isZero();
    assertThat(service.estaAtrasada(t)).isFalse();
  }

  @Test
  void tarefaAbertaHaDezDiasTemTresDiasDeAtraso() {
    Tarefa t = new Tarefa("Antiga", null, HOJE.minusDays(10));

    assertThat(service.calcularAtraso(t)).isEqualTo(3);
    assertThat(service.estaAtrasada(t)).isTrue();
  }

  @Test
  void tarefaConcluidaNuncaEstaAtrasada() {
    Tarefa t = new Tarefa("Antiga", null, HOJE.minusDays(30));
    t.concluir(HOJE);

    assertThat(service.calcularAtraso(t)).isZero();
  }

  @Test
  void prioridadePadraoEhMedia() {
    Tarefa t = service.criar(new CriarTarefaRequest("Sem prioridade", null));

    assertThat(t.getPrioridade()).isEqualTo(Prioridade.MEDIA);
    assertThat(t.getPrazo()).isNull();
  }

  @Test
  void deveCriarComPrioridadeEPrazo() {
    Tarefa t =
        service.criar(new CriarTarefaRequest("TCC", null, Prioridade.ALTA, HOJE.plusDays(10)));

    assertThat(t.getPrioridade()).isEqualTo(Prioridade.ALTA);
    assertThat(t.getPrazo()).isEqualTo(HOJE.plusDays(10));
  }

  @Test
  void deveRejeitarPrazoNoPassado() {
    var req = new CriarTarefaRequest("Atrasada", null, null, HOJE.minusDays(1));

    assertThatThrownBy(() -> service.criar(req))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("prazo");
  }

  @Test
  void tarefaComPrazoVencidoEstaAtrasada() {
    Tarefa t = new Tarefa("Relatório", null, Prioridade.ALTA, HOJE.minusDays(2), HOJE.minusDays(3));

    assertThat(service.estaAtrasada(t)).isTrue();
    assertThat(service.calcularAtraso(t)).isEqualTo(2);
  }

  @Test
  void prazoDaTarefaPrevaleceSobreOPrazoPadrao() {
    Tarefa t = new Tarefa("Longa", null, Prioridade.BAIXA, HOJE.plusDays(5), HOJE.minusDays(20));

    assertThat(service.estaAtrasada(t)).isFalse();
    assertThat(service.calcularAtraso(t)).isZero();
  }
}
