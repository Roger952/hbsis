ALTER TABLE modelo_boletim
    DROP CONSTRAINT fk_id_ano_modelo_boletim;
ALTER TABLE modelo_boletim
    ALTER COLUMN ano BIGINT NOT NULL;
ALTER TABLE modelo_boletim
    ADD CONSTRAINT fk_id_ano_modelo_boletim FOREIGN KEY (ano) REFERENCES ano (id)