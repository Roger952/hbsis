ALTER TABLE disciplina_professor
    DROP CONSTRAINT fk_id_dis_pro_disciplina;
ALTER TABLE disciplina_professor
    DROP CONSTRAINT fk_id_dis_pro_professor;

ALTER TABLE discipilna
    ADD PRIMARY KEY (id);

ALTER TABLE disciplina_professor
    ADD CONSTRAINT fk_id_dis_pro_professor FOREIGN KEY (id_professor) REFERENCES professor (id)
        ON DELETE CASCADE;

ALTER TABLE disciplina_professor
    ADD CONSTRAINT fk_id_dis_pro_disciplina FOREIGN KEY (id_disciplina) REFERENCES discipilna (id)
        ON DELETE CASCADE;