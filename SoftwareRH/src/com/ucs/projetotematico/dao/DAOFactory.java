package com.ucs.projetotematico.dao;

import java.sql.Connection;

//Fabrica de DAO 
//DAO = Data Access Object
// Responsável por abrir a conexão 
public abstract class DAOFactory {
	
	protected static DAOFactory instancia; 	
	
	
	public static DAOFactory getIntancia() {
		return null;
	}
	
	protected Connection conn; 
	public abstract void closeConnection(); 	
	
	public abstract UsuarioDAO getUsuarioDAO();
	//public abstract PessoaDAO getPessoaDAO(); // outra classe(tabela)

	

}
