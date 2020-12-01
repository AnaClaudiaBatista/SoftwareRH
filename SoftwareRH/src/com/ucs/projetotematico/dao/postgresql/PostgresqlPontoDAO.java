package com.ucs.projetotematico.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.swing.JOptionPane;

import com.ucs.projetotematico.dao.PontoDAO;
import com.ucs.projetotematico.model.Ponto;



	
public class PostgresqlPontoDAO implements PontoDAO {
	
	private Connection conn;
	
	PostgresqlPontoDAO (Connection conn) { // recebe a conexão e manipula ela por aqui
		this.conn = conn;
	}

	public void inserePonto(Ponto ponto) {
		
        NumberFormat nf = NumberFormat.getInstance();

		 System.out.println("Inserindo ponto " + ponto);

			int inseriu;
			
			if (ponto != null) {
				inseriu = ponto.getId_usuario();

			PreparedStatement pstmt = null;

				try {

					pstmt = 
							conn.prepareStatement("insert into registroponto(id_usuario, dta_registro, periodo_manha_inicio, "
									+ "periodo_manha_final, periodo_tarde_inicio, periodo_tarde_final) values (?,?,?,?,?,?)");
					
					

					pstmt.setInt(1, ponto.getId_usuario());
					
					pstmt.setDate(2, new java.sql.Date(ponto.getDta_registro().getTime()));						
					pstmt.setDouble(3,ponto.getManha_inicio());			
					pstmt.setDouble(4,ponto.getManha_final());	
					pstmt.setDouble(5,ponto.getTarde_inicio());		
					pstmt.setDouble(6,ponto.getTarde_final());	
					//pstmt.setTime(6, new java.sql.Time(ponto.getTarde_final().getTime()));	

					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");

					
				}catch (SQLException se) {
					JOptionPane.showMessageDialog(null,"Ocorreu um erro ao inserir os dados: " + se.getMessage());
					
				} 
				 finally {
					try {
						pstmt.close();
						
					} catch (SQLException e) {
						System.out.println("TesteFinally" +e.getMessage());
					}
				 }
	//	return inseriu;
	 }
	}
}
	

	
	






	


