package br.edu.ifrs.tarefas.controller;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class TarefaControllerIT {

  static final LocalDate HOJE = LocalDate.of(2026, 10, 23);

  @TestConfiguration
  static class RelogioFixo {
    @Bean
    @Primary
    Clock relogioFixo() {
      return Clock.fixed(HOJE.atStartOfDay(ZoneId.of("UTC")).toInstant(), ZoneId.of("UTC"));
    }
  }

  @Autowired MockMvc mvc;

  @Test
  void deveCriarTarefa() throws Exception {
    mvc.perform(
            post("/tarefas")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"titulo\":\"Preparar slides\"}"))
        .andExpect(status().isCreated())
        .andExpect(header().exists("Location"))
        .andExpect(jsonPath("$.titulo").value("Preparar slides"))
        .andExpect(jsonPath("$.status").value("PENDENTE"))
        .andExpect(jsonPath("$.criadaEm").value("2026-10-23"));
  }

  @Test
  void deveRejeitarTituloVazio() throws Exception {
    mvc.perform(
            post("/tarefas").contentType(MediaType.APPLICATION_JSON).content("{\"titulo\":\"\"}"))
        .andExpect(status().isBadRequest());
  }

  @Test
  void deveFiltrarPorStatus() throws Exception {
    mvc.perform(get("/tarefas").param("status", "CONCLUIDA"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[*].status", everyItem(is("CONCLUIDA"))));
  }

  @Test
  void deveMarcarTarefaAntigaComoAtrasada() throws Exception {
    // "Revisar pull request da equipe" foi criada em 2026-09-28 (dados de exemplo)
    mvc.perform(get("/tarefas/3"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.atrasada").value(true))
        .andExpect(jsonPath("$.diasDeAtraso").value(18));
  }

  @Test
  void deveConcluirTarefa() throws Exception {
    mvc.perform(patch("/tarefas/1/concluir"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.status").value("CONCLUIDA"))
        .andExpect(jsonPath("$.concluidaEm").value("2026-10-23"));
  }

  @Test
  void deveRetornar404ParaTarefaInexistente() throws Exception {
    mvc.perform(get("/tarefas/999")).andExpect(status().isNotFound());
  }
}
