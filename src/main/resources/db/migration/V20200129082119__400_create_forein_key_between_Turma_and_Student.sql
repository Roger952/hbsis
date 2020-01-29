ALTER TABLE estudante
    ADD id_turma BIGINT NOT NULL;
ALTER TABLE estudante
    ADD CONSTRAINT fk_id_turma_estudante FOREIGN KEY (id_turma) REFERENCES turma (id);