package com.ucs.projetotematico.dao.postgresql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.model.Endereco;
import com.ucs.projetotematico.model.Usuario;


	
public class PostgresqlUsuarioDAO implements UsuarioDAO {
	
	private Connection conn;
	
	PostgresqlUsuarioDAO (Connection conn) { // recebe a conexão e manipula ela por aqui
		this.conn = conn;
	}

		
	// metodo que consulta e lista os produtos do banco
		public List<Usuario> buscaTodos() { 	
			List<Usuario> usuarios = new ArrayList<Usuario>();

			
			 Statement stmt = null;
			 ResultSet rs = null;
		           
	try {		
				
	stmt = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY); // cria comando que manda informacao para o banco							
	rs = stmt.executeQuery("select baseusuario.id_usuario, baseusuario.des_nome,baseusuario.dta_admissao, "
						+ "baseusuario.num_cpf,endereco.des_rua, endereco.numero, endereco.des_bairro  "
						+ "from baseusuario "
						+ "left join endereco on endereco.id_endereco = baseusuario.id_endereco ");// rs recebe o resultado do select
					rs.first();
		
				while (rs.next()) { // laco pega as informacoes da tabela baseusuario e adiciona no array usuario
					Usuario usuario = new Usuario(); 				
					usuario.setId_usuario(rs.getInt("id_usuario"));
					usuario.setNome(rs.getString("des_nome"));
					usuario.setData_admissao(rs.getDate("dta_admissao"));
					usuario.setCpf(rs.getString("num_cpf"));
					
					Endereco endereco = new Endereco();
					endereco.setDes_rua(rs.getString("des_rua"));
					endereco.setNumero(rs.getInt("numero"));
					endereco.setDes_bairro(rs.getString("des_bairro"));
					
					usuario.setEndereco(endereco);
					usuarios.add(usuario);
													
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

	// método que insere no banco CERTO
 public void salvar(Usuario usuario) {
		
		if (usuario == null) { // condicao para seguranca, se o usuario tentar apagar algo nulo nao dar Exception
			return;
		}
		
		PreparedStatement pstmt = null; 
		
		try {
			//SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
			pstmt = conn.prepareStatement("insert into baseusuario (des_nome, dta_admissao, dta_nascimento, num_telefone, des_email, num_cpf, num_rg) values (?,?,?,?,?,?,?)");			
				        
			pstmt.setString(1, usuario.getNome());
			pstmt.setDate(2, new Date(usuario.getData_admissao().getDate()));			
			pstmt.setDate(3, new Date(usuario.getData_nascimento().getDate()));
			pstmt.setString(4, usuario.getTelefone());
			pstmt.setString(5, usuario.getEmail());
			pstmt.setString(6, usuario.getCpf());
			pstmt.setString(7, usuario.getRg());			
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
			
			
		}catch (SQLException se) {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao inserir os dados: " + se.getMessage());
			
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
