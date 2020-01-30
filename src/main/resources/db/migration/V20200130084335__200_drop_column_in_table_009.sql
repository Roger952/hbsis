ALTER TABLE semestre
    DROP CK__semestre__ano__5FD33367;

DROP INDEX semestre.ix_semestre_nome_and_ano;

ALTER TABLE semestre
    DROP COLUMN ano;

ALTER TABLE semestre
    ADD id_ano BIGINT NOT NULL;
ALTER TABLE semestre
    ADD CONSTRAINT fk_id_ano_semestre FOREIGN KEY (id_ano) REFERENCES ano (id);