-- Create table


CREATE TABLE USUARIOCATEGORIA(
  des_nome   		INT,
  tip_status		BOOLEAN,
  des_permissao		VARCHAR(50)
);

CREATE TABLE BASEUSUARIO
( 
  id_empresa		INT NOT NULL,
  id_usuario        SERIAL,
  des_nome          VARCHAR(70) NOT NULL,
  tip_status        BOOLEAN NOT NULL,
  num_cpf           NUMERIC (14,0) NOT NULL,
  num_rg            NUMERIC (14,0) NOT NULL,
  dta_nascimento    DATE,
  id_endereco       INT NOT NULL,
  num_telefone      VARCHAR(20),
  des_email         VARCHAR(70),
  des_naturalidade  VARCHAR(70),
  des_nacionalidade VARCHAR(70),  
  tip_estado_civil  char(1) NOT NULL CHECK(tip_estado_civil in ('S','C', 'U')), 
  des_pai		    VARCHAR(50),
  des_mae		    VARCHAR(50),
  des_senha         VARCHAR(50) NOT NULL,
PRIMARY KEY (id_usuario)
);  
COMMENT ON TABLE BASEUSUARIO IS 'Dados dos Usuarios';
COMMENT ON COLUMN BASEUSUARIO.id_empresa IS 'ID da empresa';
COMMENT ON COLUMN BASEUSUARIO.id_usuario IS 'ID do usuario';
COMMENT ON COLUMN BASEUSUARIO.des_nome IS 'Nome do Usuario';
COMMENT ON COLUMN BASEUSUARIO.tip_status IS 'Status';
COMMENT ON COLUMN BASEUSUARIO.num_cpf IS 'Numero do CPF';
COMMENT ON COLUMN BASEUSUARIO.num_rg IS 'Numero do RG';
COMMENT ON COLUMN BASEUSUARIO.dta_nascimento IS 'Data de Nascimento';
COMMENT ON COLUMN BASEUSUARIO.id_endereco IS 'ID do endereco';
COMMENT ON COLUMN BASEUSUARIO.num_telefone IS 'Numero do Telefone';
COMMENT ON COLUMN BASEUSUARIO.des_naturalidade IS 'Naturalidade';
COMMENT ON COLUMN BASEUSUARIO.des_nacionalidade IS 'Nascionalidade';
COMMENT ON COLUMN BASEUSUARIO.tip_estado_civil IS 'Estado Civil - ''S'' - Solteiro(a); ''C''- Casado(a); ''U'' - União Estavel;';
COMMENT ON COLUMN BASEUSUARIO.des_pai IS 'Nome do Pai';
COMMENT ON COLUMN BASEUSUARIO.des_mae IS 'Nome da Mãe';
COMMENT ON COLUMN BASEUSUARIO.des_senha IS 'Senha de acesso';



CREATE TABLE ENDERECO (
id_endereco      INT  NOT NULL, 
des_rua 		 VARCHAR(80) NOT NULL,
des_bairro       VARCHAR(80) NOT NULL, 
numero           INT,
cep				 INT NOT NULL,
complemento      VARCHAR(80), 
id_cidade		 INT NOT NULL,
PRIMARY KEY (id_endereco)
);
COMMENT ON TABLE ENDERECO IS 'Endereço dos Usuários';
COMMENT ON COLUMN ENDERECO.id_endereco IS 'Id do endereço';
COMMENT ON COLUMN ENDERECO.des_rua IS 'Rua que reside';
COMMENT ON COLUMN ENDERECO.des_bairro IS 'Bairro que reside';
COMMENT ON COLUMN ENDERECO.numero IS 'Número da casa que reside';
COMMENT ON COLUMN ENDERECO.cep IS 'CEP da rua que reside';
COMMENT ON COLUMN ENDERECO.complemento IS 'Complemento do endereço';
COMMENT ON COLUMN ENDERECO.id_cidade IS 'Id da cidade,chave estrangeira';


CREATE TABLE LOCALCIDADE( 
  id_cidade			INT NOT NULL,
  des_nome			VARCHAR(20) NOT NULL, 
  id_estado  		INT NOT NULL,
PRIMARY KEY (id_cidade)  
);
COMMENT ON TABLE LOCALCIDADE IS 'Cidade';
COMMENT ON COLUMN LOCALCIDADE.id_cidade IS 'Id da cidade';
COMMENT ON COLUMN LOCALCIDADE.des_nome IS 'Descricao da cidade';
COMMENT ON COLUMN LOCALCIDADE.id_estado IS 'Id do estado, chave estrangeira';

CREATE TABLE LOCALESTADO( 
  id_estado			INT NOT NULL, 
  des_sigla			VARCHAR(2) NOT NULL UNIQUE,
  des_nome			VARCHAR(20)NOT NULL,
  PRIMARY KEY (id_estado)  
);
COMMENT ON TABLE LOCALESTADO IS 'Estado';
COMMENT ON COLUMN LOCALESTADO.id_estado IS 'Id da cidade';
COMMENT ON COLUMN LOCALESTADO.des_sigla IS 'Sigla do Estado';
COMMENT ON COLUMN LOCALESTADO.des_nome IS 'Nome do Estado';



CREATE TABLE SOLICITACAO(
  id_usuario		INT NOT NULL,
  tip_solicitacao   INT NOT NULL,
  model_type   		VARCHAR(50),
  model_id			INT,
  PRIMARY KEY (tip_solicitacao) 
);
COMMENT ON TABLE SOLICITACAO IS 'Solicitações';
COMMENT ON COLUMN SOLICITACAO.id_usuario IS 'Id do Usuário';
COMMENT ON COLUMN SOLICITACAO.tip_solicitacao IS 'Tipo de solicitacao';
COMMENT ON COLUMN SOLICITACAO.model_id IS 'ID solicitacao';

CREATE TABLE REGISTROPONTO(  
  id_usuario		   INT NOT NULL,
  dta_registro		   DATE NOT NULL,
  dta_alteracao		   DATE,
  periodo_manha_inicio TIMESTAMP,
  periodo_manha_final  TIMESTAMP,
  periodo_tarde_inicio TIMESTAMP,
  periodo_tarde_final  TIMESTAMP,
  tip_solicitacao      INT NOT NULL,
  PRIMARY KEY (dta_registro)
);
COMMENT ON TABLE REGISTROPONTO IS 'Tabela que guarda os registros do ponto';
COMMENT ON COLUMN REGISTROPONTO.id_usuario IS 'Id do Usuário';
COMMENT ON COLUMN REGISTROPONTO.dta_registro IS 'Data do Registro do ponto';
COMMENT ON COLUMN REGISTROPONTO.dta_registro IS 'Data de Modificação';
COMMENT ON COLUMN REGISTROPONTO.periodo_manha_inicio IS 'Hora inicial do primeiro turno';
COMMENT ON COLUMN REGISTROPONTO.periodo_manha_final IS 'Hora final do primeiro turno';
COMMENT ON COLUMN REGISTROPONTO.periodo_tarde_inicio IS 'Hora inicial do segundo turno';
COMMENT ON COLUMN REGISTROPONTO.periodo_tarde_final IS 'Hora inicial do segundo turno';
COMMENT ON COLUMN REGISTROPONTO.tip_solicitacao IS 'ID solicitacao';


CREATE TABLE DEPARTAMENTO(
 tip_status 	   BOOLEAN NOT NULL,
 des_nome		   VARCHAR(70) NOT NULL,
 des_observacao    INT,
 id_empresa		   INT,
 PRIMARY KEY (tip_status)
);

CREATE TABLE LOGS(
 des_log        INT,
 dta_log   	 	DATE,
 model			VARCHAR(50),
 action			VARCHAR(50),
 id_usuario     INT,
 PRIMARY KEY (des_log)
);


CREATE TABLE EMPRESA (
  id_empresa   INT NOT NULL,   
  des_nome     VARCHAR(50)NOT NULL,
  PRIMARY KEY (id_empresa)
);

ALTER TABLE BASEUSUARIO ADD CONSTRAINT BASEUSUARIO_ENDERECO_FK FOREIGN KEY (id_endereco) REFERENCES ENDERECO(id_endereco); 
ALTER TABLE BASEUSUARIO ADD CONSTRAINT BASEUSUARIO_DEPARTAMENTO_FK FOREIGN KEY (tip_status) REFERENCES DEPARTAMENTO (tip_status);
ALTER TABLE BASEUSUARIO ADD CONSTRAINT BASEUSUARIO_EMPRESA_FK FOREIGN KEY (id_empresa) REFERENCES EMPRESA (id_empresa);
ALTER TABLE ENDERECO ADD CONSTRAINT ENDERECO_LOCALCIDADE_FK FOREIGN KEY (id_cidade) REFERENCES LOCALCIDADE (id_cidade);
ALTER TABLE LOCALCIDADE ADD CONSTRAINT LOCALCIDADE_LOCALESTADO_FK FOREIGN KEY (id_estado) REFERENCES LOCALESTADO (id_estado);
ALTER TABLE SOLICITACAO ADD CONSTRAINT SOLICITACAO_BASEUSUARIO_FK FOREIGN KEY (id_usuario) REFERENCES BASEUSUARIO (id_usuario);
ALTER TABLE REGISTROPONTO ADD CONSTRAINT REGISTROPONTO_SOLICITACAO_FK FOREIGN KEY (tip_solicitacao) REFERENCES SOLICITACAO (tip_solicitacao);
ALTER TABLE LOGS ADD CONSTRAINT LOGS_BASEUSUARIO_FK FOREIGN KEY (id_usuario) REFERENCES BASEUSUARIO (id_usuario);




  