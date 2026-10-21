INSERT INTO tarefa (titulo, descricao, status, criada_em) VALUES
  ('Configurar ambiente', 'Instalar Java 21, Git e Claude Code', 'PENDENTE', DATE '2026-10-20'),
  ('Ler o enunciado do TCC', NULL, 'EM_ANDAMENTO', DATE '2026-10-05'),
  ('Revisar pull request da equipe', 'PR #12 do módulo de relatórios', 'PENDENTE', DATE '2026-09-28');

INSERT INTO tarefa (titulo, descricao, status, criada_em, concluida_em) VALUES
  ('Entregar relatório parcial', NULL, 'CONCLUIDA', DATE '2026-09-15', DATE '2026-09-20');
