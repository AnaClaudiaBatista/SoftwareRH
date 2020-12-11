package com.ucs.projetotematico.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.ucs.projetotematico.dao.PontoDAO;
import com.ucs.projetotematico.model.Ponto;
import com.ucs.projetotematico.model.Usuario;



	
public class PostgresqlPontoDAO implements PontoDAO {
	
	public static Connection conn;
	
	PostgresqlPontoDAO (Connection conn) { // recebe a conexão e manipula ela por aqui
		this.conn = conn;
	}

	public void inserePonto(Ponto ponto) {
		
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
					//pstmt.setInt(7,ponto.getSetor());	
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
	
	public List<Ponto> buscaTodos() { 	
		List<Ponto> pontos = new ArrayList<Ponto>();

		
		 Statement stmt = null;
		 ResultSet rs = null;
	           
try {		
			
stmt = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY); // cria comando que manda informacao para o banco							
rs = stmt.executeQuery("select id_usuario, dta_registro, periodo_manha_inicio, periodo_manha_final, "
		+ "periodo_tarde_inicio, periodo_tarde_final from registroponto");// rs recebe o resultado do select
			//	rs.first();
	
			while (rs.next()) { // laco pega as informacoes da tabela baseusuario e adiciona no array usuario
				Ponto ponto = new Ponto(); 	
				ponto.setId_usuario(rs.getInt("id_usuario"));
				ponto.setDta_registro(rs.getDate("dta_registro"));
				ponto.setManha_inicio(rs.getDouble("periodo_manha_inicio"));
				ponto.setManha_final(rs.getDouble("periodo_manha_final"));
				ponto.setTarde_inicio(rs.getDouble("periodo_tarde_inicio"));
				ponto.setTarde_final(rs.getDouble("periodo_tarde_final"));
				
				pontos.add(ponto);
												
			}		
		} 
		catch (SQLException se) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao listar os dados: " + se.getMessage());

		} 
		 finally {
			try {
				rs.close();
				stmt.close();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		// return usuario;
		return pontos;
	}
	
}
	

	
	






	


