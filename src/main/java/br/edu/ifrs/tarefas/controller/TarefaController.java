package br.edu.ifrs.tarefas.controller;

import br.edu.ifrs.tarefas.dto.CriarTarefaRequest;
import br.edu.ifrs.tarefas.dto.TarefaResponse;
import br.edu.ifrs.tarefas.model.StatusTarefa;
import br.edu.ifrs.tarefas.model.Tarefa;
import br.edu.ifrs.tarefas.service.TarefaService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

  private final TarefaService service;

  public TarefaController(TarefaService service) {
    this.service = service;
  }

  @GetMapping
  public List<TarefaResponse> listar(@RequestParam(required = false) StatusTarefa status) {
    return service.listar(status).stream().map(this::paraResposta).toList();
  }

  @GetMapping("/{id}")
  public TarefaResponse buscar(@PathVariable Long id) {
    return paraResposta(service.buscar(id));
  }

  @PostMapping
  public ResponseEntity<TarefaResponse> criar(@RequestBody CriarTarefaRequest req) {
    Tarefa t = service.criar(req);
    return ResponseEntity.created(URI.create("/tarefas/" + t.getId())).body(paraResposta(t));
  }

  @PatchMapping("/{id}/iniciar")
  public TarefaResponse iniciar(@PathVariable Long id) {
    return paraResposta(service.iniciar(id));
  }

  @PatchMapping("/{id}/concluir")
  public TarefaResponse concluir(@PathVariable Long id) {
    return paraResposta(service.concluir(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluir(@PathVariable Long id) {
    service.excluir(id);
    return ResponseEntity.noContent().build();
  }

  private TarefaResponse paraResposta(Tarefa t) {
    return TarefaResponse.de(t, service.calcularAtraso(t));
  }
}
