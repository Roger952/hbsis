CREATE TABLE estudante (

                             id      BIGINT IDENTITY (1, 1)      NOT NULL,
                             name_estudante    VARCHAR(100)    NOT NULL,
                             matricula    VARCHAR(100)    NOT NULL,
                             sexo VARCHAR(10) NOT NULL,
                             idade INTEGER NOT NULL,
                             telefone VARCHAR(11) ,
                             endereco VARCHAR(200) ,
                             email VARCHAR(100) NOT NULL,
                             cpf VARCHAR(14) NOT NULL
);

CREATE UNIQUE INDEX ix_estudante_matricula ON estudante(matricula);
CREATE UNIQUE INDEX ix_estudante_cpf ON estudante(cpf);