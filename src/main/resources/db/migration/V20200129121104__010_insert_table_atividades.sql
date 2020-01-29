CREATE TABLE atividade
(

    id                  BIGINT IDENTITY (1, 1) NOT NULL,
    descricao_atividade VARCHAR(100)           NOT NULL,
    status              VARCHAR(10)            NOT NULL,
    data_lancamento     DATE                   NOT NULL,
    data_entrega        DATE                   NOT NULL,
    id_semestre         BIGINT                 NOT NULL,
    id_turma_materia    BIGINT                 NOT NULL,
    id_estudante        BIGINT                 NOT NULL,

    CONSTRAINT pk_id_atividade PRIMARY KEY (id),
    CONSTRAINT fk_id_semestre FOREIGN KEY (id_semestre) REFERENCES semestre (id),
    CONSTRAINT fk_id_estudante FOREIGN KEY (id_estudante) REFERENCES estudante (id),
    CONSTRAINT fk_id_turma_materia FOREIGN KEY (id_turma_materia) REFERENCES turma_materias (id)

);
