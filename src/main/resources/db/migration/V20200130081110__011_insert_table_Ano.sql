CREATE TABLE ano
(

    id                    BIGINT IDENTITY (1, 1) NOT NULL,
    nome_ano            VARCHAR(50)            NOT NULL,

    CONSTRAINT pk_id_ano PRIMARY KEY (id)

);

CREATE UNIQUE INDEX ix_ano_nome ON ano (nome_ano);
