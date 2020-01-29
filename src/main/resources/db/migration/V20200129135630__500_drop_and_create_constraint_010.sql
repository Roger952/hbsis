ALTER TABLE atividade
    DROP CONSTRAINT fk_id_turma_materia;

ALTER TABLE atividade
    DROP COLUMN id_turma_materia;
ALTER TABLE atividade
    ADD id_turma BIGINT NOT NULL;
ALTER TABLE estudante
    ADD CONSTRAINT fk_id_turma_atividade FOREIGN KEY (id_turma) REFERENCES turma (id);
ALTER TABLE atividade
    ADD id_professor BIGINT NOT NULL;
ALTER TABLE atividade
    ADD CONSTRAINT fk_id_professor_atividade FOREIGN KEY (id_professor) REFERENCES professor (id);
ALTER TABLE atividade
    ADD id_disciplina BIGINT NOT NULL;
ALTER TABLE atividade
    ADD CONSTRAINT fk_id_disciplina FOREIGN KEY (id_disciplina) REFERENCES discipilna (id);
