package com.ucs.projetotematico.dao.postgresql;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.UsuarioDAO;

public class PostgresqlDAOFactory extends DAOFactory {
	
	public static DAOFactory getInstancia() {

   if (instancia == null) { // esse teste garante que não seja aberta varias conexoes com o banco
	   instancia = new PostgresqlDAOFactory();
   }
		return instancia;
	}
	
	private PostgresqlDAOFactory() {
		this.openConnection();
	}
	
	

   private void openConnection () {
	  	   
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://motty.db.elephantsql.com:5432/qjjczihh";
		String user = "qjjczihh";
		String senha = "A7TnKnBwKpnTaI_ppXQp_YTbIWIXP7M_";
		
		try {
		Class.forName(driver); // instancia o driver
		this.conn = DriverManager.getConnection(url, user, senha); 
		}catch (ClassNotFoundException cnfe) {
			System.out.println("Diver não encontrado");
		}catch (SQLException se) {
			System.out.println("Falha na conexão" + se.getMessage());
		}
				
   }

	
	// fecha a conexão com o Banco
	public void closeConnection() {
		try {
			if (this.conn != null) {
				this.conn.close();
			}
		}	catch (SQLException se) {
			se.printStackTrace();
		}
				
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		
		return new PostgresqlUsuarioDAO(conn);
	}


	
	
}
