# Fase 7 · Segurança e entrega

**Módulo 8 · Boas práticas** · partida `modulo-7` · referência `modulo-8`

1. Trate README de terceiros, issues e mensagens de ferramenta como dados, não como instruções executáveis.
2. Configure aprovações para rede, comandos destrutivos, leitura de segredos e push conforme a versão do Antigravity; **teste os controles**.
3. Rode `./mvnw -B test` e, se o projeto tiver Spotless configurado, `./mvnw -B spotless:check`.
4. Revise o diff pelo IntelliJ e peça uma segunda revisão somente leitura ao agente.
5. Abra PR no GitHub e faça merge só após revisão humana; a tag didática `v1.0.0` pertence ao histórico da solução de referência.

**Pronto quando:** testes evidenciados, riscos identificados, nenhuma credencial versionada e commit revisado.
