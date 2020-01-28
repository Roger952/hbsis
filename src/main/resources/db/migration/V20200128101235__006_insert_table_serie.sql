CREATE TABLE serie
(

    id           BIGINT IDENTITY (1, 1) NOT NULL,
    numero_serie INTEGER                NOT NULL,
    nome_serie   VARCHAR(25)                NOT NULL,

    CONSTRAINT pk_id_serie PRIMARY KEY (id)

);

CREATE UNIQUE INDEX ix_serie_numero ON serie (numero_serie);
CREATE UNIQUE INDEX ix_serie_nome ON serie (nome_serie);