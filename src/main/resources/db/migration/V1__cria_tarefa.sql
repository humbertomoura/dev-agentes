CREATE TABLE tarefa (
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo    VARCHAR(120) NOT NULL,
    status    VARCHAR(20)  NOT NULL,
    criada_em DATE         NOT NULL
);
