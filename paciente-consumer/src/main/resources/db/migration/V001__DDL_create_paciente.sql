CREATE SCHEMA IF NOT EXISTS paciente;
create table paciente.t_paciente (
    id BIGSERIAL PRIMARY KEY,
    code UUID NOT NULL,
    nome VARCHAR NOT NULL,
    status VARCHAR NOT NULL,
    descricao VARCHAR,
    data_internacao TIMESTAMP NOT NULL,
    data_liberacao TIMESTAMP,
    unidade_code UUID NOT NULL
);