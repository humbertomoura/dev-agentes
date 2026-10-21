package br.edu.ifrs.tarefas.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class TarefaTest {

  static final LocalDate HOJE = LocalDate.of(2026, 10, 23);

  @Test
  void tarefaVencidaOntemEstaAtrasada() {
    Tarefa t = new Tarefa("Relatório", null, Prioridade.ALTA, HOJE.minusDays(1), HOJE.minusDays(5));

    assertThat(t.estaAtrasada(HOJE)).isTrue();
    assertThat(t.diasDeAtraso(HOJE)).isEqualTo(1);
  }

  @Test
  void tarefaComPrazoFuturoNaoEstaAtrasada() {
    Tarefa t = new Tarefa("TCC", null, Prioridade.ALTA, HOJE.plusDays(3), HOJE.minusDays(5));

    assertThat(t.estaAtrasada(HOJE)).isFalse();
    assertThat(t.diasDeAtraso(HOJE)).isZero();
  }

  @Test
  void tarefaConcluidaNaoEstaAtrasada() {
    Tarefa t = new Tarefa("Antiga", null, Prioridade.MEDIA, HOJE.minusDays(10), HOJE.minusDays(20));
    t.concluir(HOJE);

    assertThat(t.estaAtrasada(HOJE)).isFalse();
  }

  @Test
  void semPrazoUsaPrazoPadraoDeSeteDias() {
    Tarefa t = new Tarefa("Sem prazo", null, HOJE.minusDays(10));

    assertThat(t.estaAtrasada(HOJE)).isTrue();
    assertThat(t.diasDeAtraso(HOJE)).isEqualTo(3);
  }

  @Test
  void prazoHojeNaoEstaAtrasada() {
    Tarefa t = new Tarefa("Entrega", null, Prioridade.ALTA, HOJE, HOJE.minusDays(5));

    assertThat(t.estaAtrasada(HOJE)).isFalse();
    assertThat(t.diasDeAtraso(HOJE)).isZero();
  }

  @Test
  void semPrazoNoSetimoDiaAindaEstaEmDia() {
    Tarefa t = new Tarefa("Sem prazo", null, HOJE.minusDays(7));

    assertThat(t.estaAtrasada(HOJE)).isFalse();
  }
}
