package com.ucs.projetotematico.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.model.Usuario;

public class PostgresqlUsuarioDAO implements UsuarioDAO {
	
	private Connection conn;
	
	public PostgresqlUsuarioDAO (Connection conn) { // recebe a conexão e manipula ela por aqui
		this.conn = conn;
	}

	@Override
	// metodo que consulta e lista os produtos do banco
		public List<Usuario> buscaTodos() { // criar um statment e buscar um dado		
			
			
			 Statement stmt = null;
			 ResultSet rs = null;
			 List<Usuario> usuarios = new ArrayList<Usuario>();
	           
			 try {	       		
				
				stmt = conn.createStatement(); // cria comando que manda informação para o banco
				rs = stmt.executeQuery("select codigo, nome, descricao from usuario order by codigo"); // rs recebe o resultado do select

				while (rs.next()) { // laço pega as informacoes da tabela usuario e adiciona no array usuario
					Usuario u = new Usuario(); 
					u.setCodigo(rs.getInt("codigo"));
					u.setNome(rs.getString("nome"));
					u.setDescricao(rs.getString("descricao"));
					usuarios.add(u);		
					
				}		
			} 
			catch (SQLException se) {
				System.out.println("Ocorreu um erro : " + se.getMessage());			
			} 
			 finally {
				try {
					rs.close();
					stmt.close();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			 return usuarios;
		}

	//metodo que busca por determinado codigo
	public Usuario buscaPorCodigo(int codigo) {
		
		 Usuario usuario = null;

		 PreparedStatement pstmt = null;
		 ResultSet rs = null;		
         
		 try {	       		
			
			pstmt = conn.prepareStatement("select codigo, nome, descricao from usuario where codigo = ?"); // rs recebe o resultado do select
			pstmt.setInt(1, codigo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { 
				usuario = new Usuario(); 
				usuario.setCodigo(rs.getInt("codigo"));
				usuario.setNome(rs.getString("nome"));
				usuario.setDescricao(rs.getString("descricao"));
				
			}		
		} 
		catch (SQLException se) {
			System.out.println("Ocorreu um erro : " + se.getMessage());			
		} 
		 finally {
			try {
				rs.close();
				pstmt.close();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		 return usuario;		
	}

	// método que insere no banco
 public void inserir(Usuario usuario) {
		
		if (usuario == null) { // condiçãao para segurança, se o usuario tentar apagar algo nulo nao dar Exception
			return;
		}
		
		PreparedStatement pstmt = null; 
		try {
			pstmt = conn.prepareStatement("insert into usuario (codigo, nome, descricao) values (?,?,?)");
			
			pstmt.setInt(1, usuario.getCodigo());
			pstmt.setString(2, usuario.getNome());
			pstmt.setString(3, usuario.getDescricao());
			
			pstmt.executeUpdate();
			
			
		}catch (SQLException se) {
			System.out.println("Ocorreu um erro : " + se.getMessage());
			
		} 
		 finally {
			try {
				pstmt.close();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

 // método que da delete no banco
public void deletar(Usuario usuario) {
	
	if (usuario == null) { // condiçao para segurança, se o usuario tentar apagar algo nulo nao dar Exception
		return;
	}
	
	PreparedStatement pstmt = null; 
	try {
		pstmt = conn.prepareStatement("delete from usuario where codigo= ?");
		
		pstmt.setInt(1, usuario.getCodigo());			
		pstmt.executeUpdate();
					
	}catch (SQLException se) {
		System.out.println("Ocorreu um erro : " + se.getMessage());
		
	} 
	 finally {
		try {
			pstmt.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

// metodo que da update no banco
public void alterar(Usuario usuario) {
	
	if (usuario == null) { // condição para segurança, se o usuario tentar apagar algo nulo nao dar Exception
		return;
	}
	
	PreparedStatement pstmt = null; 
	try {
		pstmt = conn.prepareStatement("update usuario set nome = ?, descricao = ? where codigo = ?");
		
		
		pstmt.setString(1, usuario.getNome());
		pstmt.setString(2, usuario.getDescricao());
		pstmt.setInt(3, usuario.getCodigo());
		
		pstmt.executeUpdate();
		
		
	}catch (SQLException se) {
		System.out.println("Ocorreu um erro : " + se.getMessage());
		
	} 
	 finally {
		try {
			pstmt.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
	

}
