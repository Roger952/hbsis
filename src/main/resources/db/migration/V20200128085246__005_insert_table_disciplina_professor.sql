CREATE TABLE disciplina_professor (

                           id      BIGINT IDENTITY (1, 1)      NOT NULL,
                           id_disciplina    BIGINT    NOT NULL,
                           id_professor BIGINT NOT NULL,

                           CONSTRAINT pk_id_disciplina_professor             PRIMARY KEY  (id),
                           CONSTRAINT fk_id_dis_pro_professor     FOREIGN KEY  (id_professor)  REFERENCES disciplina_professor (id),
                           CONSTRAINT fk_id_dis_pro_disciplina     FOREIGN KEY  (id_disciplina)  REFERENCES disciplina_professor (id)

);

CREATE UNIQUE INDEX ix_professor_disciplina ON disciplina_professor(id_disciplina, id_professor);