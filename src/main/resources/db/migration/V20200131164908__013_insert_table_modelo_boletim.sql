CREATE TABLE modelo_boletim
(

    id                      BIGINT IDENTITY (1, 1) NOT NULL,
    diciplina               VARCHAR(50)            NOT NULL,
    media_primeiro_semestre VARCHAR(50)            NOT NULL,
    media_segundo_semestre  VARCHAR(50)            NOT NULL,
    media_terceiro_semestre VARCHAR(50)            NOT NULL,
    ano                     VARCHAR(50)            NOT NULL,
    id_aluno                BIGINT                 NOT NULL,


    CONSTRAINT pk_id_modelo_boletim PRIMARY KEY (id),
    CONSTRAINT fk_id_ano_modelo_boletim FOREIGN KEY (ano) REFERENCES ano (nome_ano),
    CONSTRAINT fk_id_aluno_modelo_boletim FOREIGN KEY (id_aluno) REFERENCES estudante (id)
);


