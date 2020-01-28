ALTER TABLE turma
    DROP CONSTRAINT fk_id_serie;
ALTER TABLE professor
    DROP CONSTRAINT fk_id_professor_instituicao;

ALTER TABLE instituicao
    ADD PRIMARY KEY (id);
ALTER TABLE estudante
    ADD PRIMARY KEY (id);

ALTER TABLE turma
    ADD CONSTRAINT fk_id_serie FOREIGN KEY (id_serie) REFERENCES serie (id)
        ON DELETE CASCADE;

ALTER TABLE professor
    ADD CONSTRAINT fk_id_professor_instituicao FOREIGN KEY (id_instituicao) REFERENCES instituicao (id)
        ON DELETE CASCADE;