DROP DATABASE IF EXISTS pizzariarebot;
CREATE DATABASE pizzariarebot;
USE pizzariarebot;

CREATE TABLE Clientes (
	NumeroPedido INT PRIMARY KEY NOT NULL auto_increment,
    Nome VARCHAR(50) not null,
    Endereco VARCHAR(60) not null,
    MetodoPagamento VARCHAR(30) not null,
    Telefone BIGINT not null
);

CREATE TABLE Funcionarios (
	idfunc INT NOT NULL PRIMARY KEY auto_increment,
    Nome VARCHAR(50) NOT NULL,
    Telefone BIGINT not null,
    Endereco VARCHAR(50) not null
);

CREATE TABLE Cargo (
	idcargo INT PRIMARY KEY NOT NULL auto_increment,
    nome_cargo VARCHAR(50) not null,
    Descricao varchar(300) not null -- 3
);

CREATE TABLE Pedido (
	Ordem INT NOT NULL PRIMARY KEY auto_increment,
	QtdProduto INT not null,
    Sabor_Pizza varchar(30) not null,
    Valor_P int,
    Tamanho_Pizza VARCHAR(30) -- 7 id_Cliente id_Cardapio
);


-- Clientes
insert into clientes (nome,endereco,metodopagamento,telefone) values ('Luis','Rua A','PIX',71);
insert into clientes (nome,endereco,metodopagamento,telefone) values ('Luis I','Rua B','CARTAO',71);
insert into clientes (nome,endereco,metodopagamento,telefone) values ('Luisa II','Rua C','CARTAO',71);
insert into clientes (nome,endereco,metodopagamento,telefone) values ('Luis III','Rua D','DINHEIRO',71);
insert into clientes (nome,endereco,metodopagamento,telefone) values ('Luisa IV','Rua E','PIX',71);
insert into clientes (nome,endereco,metodopagamento,telefone) values ('Luisa V','Rua F','DINHEIRO',71);
insert into clientes (nome,endereco,metodopagamento,telefone) values ('Luis VI','Rua G','PIX',71);

-- Funcionarios
insert into funcionarios (nome,telefone,endereco) values ('Leopoldo II',71,'Avenida Piaba');
insert into funcionarios (nome,telefone,endereco) values ('Leopoldina III',71,'Rua Pacu');
insert into funcionarios (nome,telefone,endereco) values ('Leopoldo IV',71,'Avenida Atum');
insert into funcionarios (nome,telefone,endereco) values ('Leopoldina V',71,'Travessa Cavala');
insert into funcionarios (nome,telefone,endereco) values ('Leopoldo VI',71,'Rua do Peixe-espada');
insert into funcionarios (nome,telefone,endereco) values ('Leopoldina VII',71,'Rua dos golfinhos');
-- Cargo
insert into cargo (nome_cargo,descricao) values ('Atendente','Atende o telefone e as mesas');
insert into cargo (nome_cargo,descricao) values ('Atendente','Atende o telefone e as mesas');
insert into cargo (nome_cargo,descricao) values ('entregador','Faz entregas');
insert into cargo (nome_cargo,descricao) values ('entregador','Faz entregas');
insert into cargo (nome_cargo,descricao) values ('Entregador','Faz entregas');
insert into cargo (nome_cargo,descricao) values ('Chefe pizzaiolo','Faz pizzas');
-- Pedido
insert into pedido (Sabor_Pizza,QtdProduto,Tamanho_Pizza,Valor_P) values ('Portuguesa',1,'Familia','35');
insert into pedido (Sabor_Pizza,QtdProduto,Tamanho_Pizza,Valor_P) values ('Frango',2,'Grande','35');
insert into pedido (Sabor_Pizza,QtdProduto,Tamanho_Pizza,Valor_P) values ('Calabresa',2,'Grande','35');
insert into pedido (Sabor_Pizza,QtdProduto,Tamanho_Pizza,Valor_P) values ('Calabresa',3,'Grande','35');
insert into pedido (Sabor_Pizza,QtdProduto,Tamanho_Pizza,Valor_P) values ('Portuguesa',1,'Media','35');
insert into pedido (Sabor_Pizza,QtdProduto,Tamanho_Pizza,Valor_P) values ('Quatro Queijos',1,'Media','35');
insert into pedido (Sabor_Pizza,QtdProduto,Tamanho_Pizza,Valor_P) values ('Salame',2,'Familia','35');

alter table clientes add column idPedido int;
alter table funcionarios add column idCargo int ;
alter table pedido add column id_Cliente int ;
alter table pedido add column id_Cardapio int ;

/* Chaves estrangeiras */
alter table Clientes add constraint fk_idpedido foreign key (idPedido) references Pedido(Ordem);
alter table Funcionarios add constraint fk_idCargos foreign key (idCargo) references Cargo(idcargo);
alter table Pedido add constraint fk_id_Cliente foreign key (id_Cliente) references Clientes(NumeroPedido);

UPDATE Pedido SET id_Cliente = 1 WHERE Ordem = 1;
UPDATE Pedido SET id_Cliente = 2 WHERE Ordem = 2;
UPDATE Pedido SET id_Cliente = 3 WHERE Ordem = 3;
UPDATE Pedido SET id_Cliente = 4 WHERE Ordem = 4;
UPDATE Pedido SET id_Cliente = 5 WHERE Ordem = 5;
UPDATE Pedido SET id_Cliente = 6 WHERE Ordem = 6;
UPDATE Pedido SET id_Cliente = 7 WHERE Ordem = 7;

UPDATE Funcionarios SET idCargo = 1 WHERE idfunc = 1;
UPDATE Funcionarios SET idCargo = 2 WHERE idfunc = 2;
UPDATE Funcionarios SET idCargo = 3 WHERE idfunc = 3;
UPDATE Funcionarios SET idCargo = 4 WHERE idfunc = 4;
UPDATE Funcionarios SET idCargo = 5 WHERE idfunc = 5;
UPDATE Funcionarios SET idCargo = 6 WHERE idfunc = 6;

-- Funções aritméticas

SELECT COUNT(Sabor_Pizza) FROM Pedido;
SELECT MAX(Valor_P) FROM Pedido;

-- AGRUPAMENTO e Junções

SELECT P.Sabor_Pizza, Sum(P.Valor_P) As Total
FROM Pedido P
GROUP BY Sabor_Pizza;

SELECT P.Tamanho_Pizza, COUNT(P.qtdproduto)
FROM Pedido P
GROUP BY Tamanho_Pizza;

SELECT C.Nome ,P.Ordem, P.Sabor_Pizza, P.Tamanho_Pizza, P.Valor_P
FROM Pedido AS P
INNER JOIN Clientes AS C
ON P.id_Cliente = C.NumeroPedido;

-- View

CREATE VIEW vw_FuncionariosCargo
AS SELECT F.Nome AS Funcionarios, C.nome_cargo AS Cargo
FROM Funcionarios F
INNER JOIN Cargo C
ON F.idCargo = C.idcargo;

SELECT Funcionarios, Cargo
FROM vw_FuncionariosCargo
GROUP BY Funcionarios;

CREATE VIEW vw_ClientesPedido
AS SELECT C.Nome AS Clientes, P.Sabor_Pizza, P.Tamanho_Pizza AS Pedido
FROM Clientes C
INNER JOIN Pedido P
ON C.NumeroPedido = P.id_Cliente;


 
SELECT Clientes, Pedido
FROM vw_ClientesPedido
GROUP BY Clientes;

 DELIMITER $$
 CREATE PROCEDURE pr_abaixapreco(
 in nid int,
 in nqtd decimal(10,2)
 )
 begin
	update pedido
    set pedido.valor_p = pedido.valor_p - nqtd
    where pedido.ordem = nid;
end
 $$
 call pr_abaixapreco(1,15);
 
 DELIMITER $$
 CREATE PROCEDURE pr_mudartamanho(
 in nid int,
 in nTamanhoPizza varchar(30)
 )
 begin
	update pedido
    set pedido.Tamanho_Pizza = nTamanhoPizza
    where pedido.ordem = nid;
end

 $$
call pr_mudartamanho(1,'Média');

 delimiter $$
 create trigger tr_mudapreco
 after insert on pedido
 for each row
 begin
	update pedido
	set pedido.valor_p = pedido.valor_p + 5
	where pedido.ordem = new.ordem;
 end
 $$
 
  delimiter $$
 create trigger tr_mudacargo
 after insert on funcionarios
 for each row
 begin
	update cargo
	set cargo.nome_cargo = 'estagiário'
	where cargo.idcargo = new.idcargo;
 end
 $$
 
 
 
 