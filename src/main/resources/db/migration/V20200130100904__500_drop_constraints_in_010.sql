ALTER TABLE atividade
    DROP CONSTRAINT fk_id_disciplina
ALTER TABLE atividade
    DROP CONSTRAINT fk_id_estudante
ALTER TABLE atividade
    DROP CONSTRAINT fk_id_semestre

ALTER TABLE atividade
    DROP COLUMN id_disciplina
ALTER TABLE atividade
    DROP COLUMN id_estudante
ALTER TABLE atividade
    DROP COLUMN id_semestre
ALTER TABLE atividade
    ADD id_boletim BIGINT NOT NULL;
ALTER TABLE atividade
    ADD CONSTRAINT fk_id_boletim_atividade FOREIGN KEY (id_boletim) REFERENCES boletim (id)
        ON DELETE CASCADE;