# Fase 6 · Configurar o agente

**Módulo 7 · Indo além do básico** · branch de partida `modulo-6` · branch de chegada `modulo-7`

**Objetivo:** Transformar bons hábitos em configuração versionada da equipe.

## Passo a passo

1. **Permissões:** crie .`claude/settings.json com allow` para testes e deny para .env, rm -rf e `git push`
2. **Hook:** PostToolUse em Edit|Write rodando `./mvnw -q spotless:apply`
3. **Skill:** crie .`claude/skills/revisao-codigo com SKILL.md`, checklist.md e scripts/cobertura.sh
4. **Subagentes:** crie .`claude/agents/testador.md` e revisor.md (revisor sem Edit)
5. **Teste tudo:** edite um arquivo e veja o hook; rode /revisao-codigo; delegue ao testador
6. **Faça commit:** chore(claude): skill de revisão, subagentes, hook e permissões

## Como verificar

```text
$ .claude/skills/revisao-codigo/scripts/cobertura.sh
TarefaService                 78.1%
Tarefa                        87.5%
TOTAL                         84.4%

$ ./mvnw test
Tests run: 31, Failures: 0
```

## Pronto quando

- [ ] Hook formata após cada edição
- [ ] Skill acionada por /revisao-codigo
- [ ] Cobertura total perto de 84%

## Arquivos tocados

- `+ .claude/settings.json`
- `+ .claude/skills/revisao-codigo/`
- `+ .claude/agents/testador.md e revisor.md`
- `~ pom.xml (JaCoCo)`

## Conceitos aplicados

- Determinístico × probabilístico (Módulo 7)
- Divulgação progressiva (Módulo 7)
- Contexto isolado (Módulo 7)
- Primitivas do MCP (opcional) (Módulo 7)
