CREATE TABLE professor (

                           id      BIGINT IDENTITY (1, 1)      NOT NULL,
                           nome_professor    VARCHAR(100)    NOT NULL,
                           sexo VARCHAR(10) NOT NULL,
                           idade INTEGER NOT NULL,
                           telefone VARCHAR(11) ,
                           endereco VARCHAR(200) ,
                           email VARCHAR(100) NOT NULL,
                           cpf VARCHAR(14) NOT NULL,
                           id_instituicao BIGINT NOT NULL,

                           CONSTRAINT pk_id_professor             PRIMARY KEY  (id),
                           CONSTRAINT fk_id_professor_instituicao     FOREIGN KEY  (id_instituicao)  REFERENCES professor (id)
);

CREATE UNIQUE INDEX ix_professor_instituicao_cpf ON professor(id_instituicao, cpf);