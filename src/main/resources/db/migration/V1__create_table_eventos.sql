CREATE TABLE Eventos(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    inicio TIMESTAMP NOT NULL,
    fim TIMESTAMP NOT NULL,
    identificador VARCHAR(100)  NOT NULL UNIQUE,
    local_evento VARCHAR(255) NOT NULL,
    capacidade INTEGER NOT NULL,
    tipo_evento VARCHAR(50) NOT NULL,
        CHECK(tipo_evento IN ('festa', 'seminário', 'show', 'competição', 'networking', 'feira'))

)