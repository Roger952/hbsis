ALTER TABLE turma
    ADD id_instituicao BIGINT NOT NULL;
ALTER TABLE turma
    ADD CONSTRAINT fk_id_instituicao_turma FOREIGN KEY (id_instituicao) REFERENCES instituicao (id);