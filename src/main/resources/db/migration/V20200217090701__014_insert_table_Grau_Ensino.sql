CREATE TABLE grau_ensino
(

    id                      BIGINT IDENTITY (1, 1) NOT NULL,
    codigo_grau               VARCHAR(50)            NOT NULL,
    descricao_grau               VARCHAR(100)            NOT NULL

);

INSERT INTO dbo.grau_ensino (codigo_grau, descricao_grau)
VALUES (
    '100' , 'Ensino Fundamental'
) ,
(
    '101' , 'Ensino Médio'
),
(
    '102' , 'Ensino Superior'
),
(
    '103' , 'Cursos de Curta Duração'
),
(
    '104' , 'Curso Técnico'
),
(
    '105' , 'Pós Graduação'
),
(
    '105' , 'Mestrado'
),
(
    '106' , 'Doutorado'
)
