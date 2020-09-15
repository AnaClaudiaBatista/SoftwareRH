-- INSERTS

-- INSERE ESTADOS
insert into localestado values
(1, 'RS','Rio Grande do Sul')
(2, 'SC','Santa Catarina')
(3, 'PR','Paraná')
(4, 'SP','São Paulo')
(5, 'RJ','Rio de Janeiro');

--INSERE CIDADES
insert into localcidade values
(369, 'Caxias do Sul', 1),
(370, 'Farroupilha', 1),
(371, 'Flores da Cunha', 1),
(372, 'São Marcos', 1);

-- INSERE ENDEREÇOS
insert into endereco  values
(147,'Borges de Medeiros', 'Centro',5874,94532000,default,369),
(148, 'Alfredo Chaves', 'Centro', '874', 98740001,default,369); 

-- INSERE EMPRESA
INSERT INTO EMPRESA VALUES (1, 'Minha Empresa');

-- INSERE DEPARTAMENTO
INSERT INTO DEPARTAMENTO VALUES (true, 'Nome Teste', default, 1);

-- INSERE USUARIOS
insert into baseusuario values 
(1,1000,'Maria Isabel Mendez',true,	82978371064,339294395,	'1985-04-05' ,147,'(47)9 9857-4254','misabel123@hotmail.com','RS','Brasileira','C','Jose Mendez',	'Margarida Mendez',	'12345'),
(1,1001,'Felipe Jorge Henz',true, 33083555075,301978517,'1992-09-27' ,148,'(47)9 9684-8547','felipe_jhenz@hotmail.com','RS','Brasileiro','S','Elisvaldo Henz',	'Janete Hanz',	'54321');


--SELECT PARA TESTE
SELECT 
BASEUSUARIO.ID_USUARIO,
BASEUSUARIO.DES_NOME,
EMPRESA.DES_NOME AS NMEMPRESA,
ENDERECO.DES_RUA,
ENDERECO.NUMERO,
LOCALCIDADE.DES_NOME AS CIDADE,
LOCALESTADO.DES_NOME AS ESTADO
FROM BASEUSUARIO
JOIN EMPRESA ON EMPRESA.ID_EMPRESA = BASEUSUARIO.ID_EMPRESA
JOIN ENDERECO ON ENDERECO.ID_ENDERECO= BASEUSUARIO.ID_ENDERECO
JOIN LOCALCIDADE ON LOCALCIDADE.ID_CIDADE = ENDERECO.ID_CIDADE
JOIN LOCALESTADO ON LOCALESTADO.ID_ESTADO = LOCALCIDADE.ID_ESTADO





	





