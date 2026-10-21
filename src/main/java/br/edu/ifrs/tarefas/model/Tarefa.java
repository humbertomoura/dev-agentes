package br.edu.ifrs.tarefas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tarefa")
public class Tarefa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 120)
  private String titulo;

  @Column(length = 500)
  private String descricao;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private StatusTarefa status;

  @Column(name = "criada_em", nullable = false)
  private LocalDate criadaEm;

  @Column(name = "concluida_em")
  private LocalDate concluidaEm;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 10)
  private Prioridade prioridade;

  private LocalDate prazo;

  protected Tarefa() {}

  public Tarefa(String titulo, String descricao, LocalDate criadaEm) {
    this(titulo, descricao, Prioridade.MEDIA, null, criadaEm);
  }

  public Tarefa(
      String titulo, String descricao, Prioridade prioridade, LocalDate prazo, LocalDate criadaEm) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.prioridade = prioridade;
    this.prazo = prazo;
    this.criadaEm = criadaEm;
    this.status = StatusTarefa.PENDENTE;
  }

  public void iniciar() {
    if (status != StatusTarefa.PENDENTE) {
      throw new IllegalStateException("Só é possível iniciar uma tarefa pendente");
    }
    status = StatusTarefa.EM_ANDAMENTO;
  }

  public void concluir(LocalDate hoje) {
    if (isConcluida()) {
      throw new IllegalStateException("A tarefa já está concluída");
    }
    status = StatusTarefa.CONCLUIDA;
    concluidaEm = hoje;
  }

  public boolean isConcluida() {
    return status == StatusTarefa.CONCLUIDA;
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public StatusTarefa getStatus() {
    return status;
  }

  public LocalDate getCriadaEm() {
    return criadaEm;
  }

  public LocalDate getConcluidaEm() {
    return concluidaEm;
  }

  public Prioridade getPrioridade() {
    return prioridade;
  }

  public LocalDate getPrazo() {
    return prazo;
  }
}
