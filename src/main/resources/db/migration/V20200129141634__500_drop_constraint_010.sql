ALTER TABLE atividade
    DROP COLUMN id_turma;

ALTER TABLE estudante
    DROP CONSTRAINT fk_id_turma_atividade;
