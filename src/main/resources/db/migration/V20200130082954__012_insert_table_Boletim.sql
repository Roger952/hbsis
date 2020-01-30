CREATE TABLE boletim
(

    id            BIGINT IDENTITY (1, 1) NOT NULL,
    media_final   DECIMAL(10, 2)         NOT NULL,
    id_aluno      BIGINT                 NOT NULL,
    id_semestre   BIGINT                 NOT NULL,
    id_disciplina BIGINT                 NOT NULL,

    CONSTRAINT pk_id_boletim PRIMARY KEY (id),
    CONSTRAINT fk_id_semestre_boletim FOREIGN KEY (id_semestre) REFERENCES semestre (id),
    CONSTRAINT fk_id_aluno_boletim FOREIGN KEY (id_aluno) REFERENCES estudante (id),
    CONSTRAINT fk_id_disciplina_boletim FOREIGN KEY (id_disciplina) REFERENCES discipilna (id)
);

CREATE UNIQUE INDEX ix_seestre_aluno_disciplina ON boletim (id_disciplina, id_aluno, id_semestre);

