---
name: revisao-codigo
description: Revisa as alterações Java e Spring Boot, com foco em bugs, testes e escopo. Use ao revisar um diff antes do commit.
---

# Revisão de código

1. Leia `AGENTS.md` e confira o objetivo da tarefa.
2. Inspecione `git diff modulo-3...HEAD` ou o diff informado pelo desenvolvedor.
3. Identifique bugs, erros de transação/JPA, problemas com datas/Clock, contratos REST quebrados, regressões e alterações fora do escopo.
4. Execute testes somente com aprovação explícita.
5. Relate achados por severidade, citando arquivos, linhas e evidências. Se não houver evidência, diga claramente.
6. Não faça commits, push nem edições durante a revisão.
