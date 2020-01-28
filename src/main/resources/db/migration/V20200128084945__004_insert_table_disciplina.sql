CREATE TABLE discipilna (

                           id      BIGINT IDENTITY (1, 1)      NOT NULL,
                           nome_Disciplina    VARCHAR(100)    NOT NULL
);

CREATE UNIQUE INDEX ix_disciplina_nome ON discipilna(nome_Disciplina);