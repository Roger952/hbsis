CREATE TABLE turma_materias
(

    id                      BIGINT IDENTITY (1, 1) NOT NULL,
    id_turma                BIGINT                 NOT NULL,
    id_disciplina_professor BIGINT                 NOT NULL,

    CONSTRAINT pk_id_turma_materias PRIMARY KEY (id),
    CONSTRAINT fk_id_turma FOREIGN KEY (id_turma) REFERENCES turma (id),
    CONSTRAINT fk_id_disciplina_professor FOREIGN KEY (id_disciplina_professor) REFERENCES disciplina_professor (id)

);

CREATE UNIQUE INDEX ix_turma_materias ON turma_materias (id_turma, id_disciplina_professor);