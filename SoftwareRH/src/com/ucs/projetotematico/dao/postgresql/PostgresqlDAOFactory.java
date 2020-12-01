package com.ucs.projetotematico.dao.postgresql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.PontoDAO;
import com.ucs.projetotematico.dao.UsuarioDAO;

public class PostgresqlDAOFactory extends DAOFactory {
	
	public static DAOFactory getInstancia() {

   if (instancia == null) { // esse teste garante que n√£o seja aberta varias conexoes com o banco
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
			System.out.println("Diver n√o encontrado");
		}catch (SQLException se) {
			System.out.println("Falha na conex„o" + se.getMessage());
		}
				
   }
   
 /*  public void executaSql(String sql){
	   //Statement stmt = null;
	   try {
	   ResultSet rs = null;	
	   Statement stmt = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY); // Difere a pesquisa de maiucula/minuscula,e rs rolavel que deixa setar tanto o primeiro quanto o ultimo registro do banco
       rs = stmt.executeQuery(sql);
	   } catch (SQLException ex) {
		   JOptionPane.showConfirmDialog(null, "Erro em executaSql!" + ex.getMessage());
	   }
   }*/

	
	// fecha a conex√£o com o Banco
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

	@Override
	public PontoDAO getPontoDAO() {
		return new PostgresqlPontoDAO(conn);

	}

	


	
	
}
