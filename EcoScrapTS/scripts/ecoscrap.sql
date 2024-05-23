create database ecoscrap;

use ecoscrap;

CREATE TABLE usuario (
id_usuario INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
nome_completo varchar(100) not null unique,
endereco varchar(255) null,
bairro varchar(50) null,
email varchar(100) not null unique,
senha varchar(100) not null,
datanascimento date null,
sexo char(1) not null,
vendedor char(1) not null,
data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null
);


CREATE TABLE ferrovelho (
id_ferrovelho int AUTO_INCREMENT PRIMARY KEY NOT NULL,
nome varchar(100) not null unique,
cnpj  varchar(18) not null unique,
endereco varchar(255) null,
bairro varchar(50) null,
email varchar(100) not null unique,
senha varchar(100) not null
);

CREATE TABLE materialreciclavel (
id_material int AUTO_INCREMENT PRIMARY KEY NOT NULL,
id_ferrovelho INT NOT NULL,
reciclavel varchar(30) null,
preco_kg float not null,
categoria varchar(30) null,
FOREIGN KEY (id_ferrovelho) REFERENCES ferrovelho(id_ferrovelho)
);

CREATE TABLE denuncia(
id_denuncia int AUTO_INCREMENT PRIMARY KEY NOT NULL,
id_usuario INT null,
endereco varchar(50) not null,
bairro varchar(30) not null,
data_ocorrido datetime not null,
descricao text not null,
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE cotacao(
id_cotacao INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
id_ferrovelho INT NOT NULL,
id_material INT not null,
peso double NULL,
data_cotacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
valor_total float not null,
FOREIGN KEY (id_material) REFERENCES materialreciclavel(id_material),
FOREIGN KEY (id_ferrovelho) REFERENCES ferrovelho(id_ferrovelho)
);

CREATE TABLE estoqueferrovelho (
id_estoque INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
id_ferrovelho INT NOT NULL,
id_material INT NOT NULL,
kg INT NOT NULL,
FOREIGN KEY (id_ferrovelho) REFERENCES ferrovelho(id_ferrovelho),
FOREIGN KEY (id_material) REFERENCES materialreciclavel(id_material)
);
