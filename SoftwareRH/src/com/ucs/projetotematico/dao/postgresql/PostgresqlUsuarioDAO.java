package com.ucs.projetotematico.dao.postgresql;

import java.sql.Connection;
import java.sql.Date;
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
				
				stmt = conn.createStatement(); // cria comando que manda informacao para o banco
				
				/*rs = stmt.executeQuery("select  id_empresa,id_usuario, des_nome,tip_status, num_cpf, num_rg,dta_nascimento,"
						+ "id_endereco,num_telefone, des_email,des_naturalidade, des_nacionalidade,"
						+ "tip_estado_civil, des_pai, des_mae, des_senha from baseusuario order by id_usuario");*/ 
				
				rs = stmt.executeQuery("select * from baseusuario order by id_usuario");// rs recebe o resultado do select

				while (rs.next()) { // laco pega as informacoes da tabela baseusuario e adiciona no array usuario
					Usuario u = new Usuario(); 
					u.setId_empresa(rs.getInt("id_empresa"));					
					u.setId_usuario(rs.getInt("id_usuario"));
					u.setNome(rs.getString("des_nome"));
					u.setStatus(rs.getBoolean("tip_status"));
					u.setCpf(rs.getString("num_cpf"));
					u.setRg(rs.getString("num_rg"));
					u.setData_nascimento(rs.getDate("dta_nascimento"));					
					u.setEndereco(rs.getInt("id_endereco"));
					u.setTelefone(rs.getString("num_telefone"));
					u.setEmail(rs.getString("des_email"));
					u.setNatural(rs.getString("des_naturalidade"));
					u.setData_admissao(rs.getDate("data_admissao"));
					/*u.setNacionalidade(rs.getString("des_nacionalidade"));
					u.setEstCivil(rs.getCharacterStream("tip_estado_civil"));
					u.setPai(rs.getString("des_pai"));
					u.setMae(rs.getString("des_mae"));
					u.setSenha(rs.getString("des_senha"));	*/
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

	//metodo que busca por determinado UsuarioID
	public Usuario buscaPorCodigo(int usuarioID) {
		
		 Usuario usuario = null;

		 PreparedStatement pstmt = null;
		 ResultSet rs = null;		
         
		 try {	       		
			
			//pstmt = conn.prepareStatement("select id_usuario, des_nome, data_admissao, num_cpf from baseusuario where id_usuario = ?"); // rs recebe o resultado do select
			pstmt = conn.prepareStatement("select id_usuario, des_nome, num_cpf from baseusuario where id_usuario = ?"); // rs recebe o resultado do select

			pstmt.setInt(1, usuarioID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { 
				usuario = new Usuario(); 
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("des_nome"));
				//usuario.setData_admissao(rs.getDate("data_admissao"));
				usuario.setCpf(rs.getString("num_cpf"));
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
		
		if (usuario == null) { // condicao para seguranca, se o usuario tentar apagar algo nulo nao dar Exception
			return;
		}
		
		PreparedStatement pstmt = null; 
		try {
			pstmt = conn.prepareStatement("insert into baseusuario (id_usuario, des_nome, data_admissao, num_cpf) values (?,?,?,?)");
			
			pstmt.setInt(1, usuario.getId_usuario());
			pstmt.setString(2, usuario.getNome());
			pstmt.setDate(3, (Date)usuario.getData_admissao());
			pstmt.setString(4, usuario.getCpf());
			
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

 // metodo que da delete no banco
public void deletar(Usuario usuario) {
	
	if (usuario == null) { // condicao para seguranca, se o usuario tentar apagar algo nulo nao dar Exception
		return;
	}
	
	PreparedStatement pstmt = null; 
	try {
		pstmt = conn.prepareStatement("delete from baseusuario where id_usuario= ?");
		
		pstmt.setInt(1, usuario.getId_usuario());			
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
	
	if (usuario == null) { // condicao para seguranca, se o usuario tentar apagar algo nulo nao dar Exception
		return;
	}
	
	PreparedStatement pstmt = null; 
	try {
		pstmt = conn.prepareStatement("update baseusuario set des_nome = ?, data_admissao = ?, num_cpf = ? where id_usuario = ?");
	
		
		pstmt.setString(1, usuario.getNome());		
		pstmt.setDate(2, (Date) usuario.getData_admissao());
		pstmt.setString(3, usuario.getCpf());
		pstmt.setInt(4, usuario.getId_usuario());
		
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
