ALTER TABLE turma_materias
    DROP CONSTRAINT fk_id_disciplina_professor;
DROP INDEX turma_materias.ix_turma_materias;
ALTER TABLE turma_materias
    DROP COLUMN id_disciplina_professor;
ALTER TABLE turma_materias
    ADD id_disciplina BIGINT NOT NULL;
ALTER TABLE turma_materias
    ADD CONSTRAINT fk_id_disciplina FOREIGN KEY (id_disciplina) REFERENCES discipilna (id)
        ON DELETE CASCADE;
CREATE UNIQUE INDEX ix_turma_materias ON turma_materias (id_turma, id_disciplina);
