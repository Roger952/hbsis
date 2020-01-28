CREATE TABLE turma
(

    id                    BIGINT IDENTITY (1, 1) NOT NULL,
    nome_turma            VARCHAR(50)            NOT NULL,
    quantidade_max_alunos INTEGER                NOT NULL,
    id_serie              BIGINT                 NOT NULL,

    CONSTRAINT pk_id_turma PRIMARY KEY (id),
    CONSTRAINT fk_id_serie FOREIGN KEY (id_serie) REFERENCES turma (id)

);

CREATE UNIQUE INDEX ix_turma_nome ON turma (nome_turma);