--baseline
CREATE TABLE IF NOT EXISTS tb_cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    idade INT,
    cpf VARCHAR(255) UNIQUE
);

CREATE TABLE IF NOT EXISTS tb_carros (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    img_carro VARCHAR(255),
    preco DOUBLE,
    chassi VARCHAR(255) UNIQUE,
    placa VARCHAR(255) UNIQUE,
    fk_cliente_id BIGINT,
    FOREIGN KEY (fk_cliente_id) REFERENCES tb_cliente(id)
);