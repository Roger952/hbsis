CREATE TABLE semestre
(

    id              BIGINT IDENTITY (1, 1) NOT NULL,
    data_de_inicio  DATE                   NOT NULL,
    data_de_termino DATE                   NOT NULL,
    nome_semestre   VARCHAR(50)            NOT NULL,
    ano             BIGINT                NOT NULL  CHECK (ano BETWEEN 1000 AND 9999),

    CONSTRAINT pk_id_semestre PRIMARY KEY (id)

);

CREATE UNIQUE INDEX ix_semestre_nome_and_ano ON semestre (ano, nome_semestre);