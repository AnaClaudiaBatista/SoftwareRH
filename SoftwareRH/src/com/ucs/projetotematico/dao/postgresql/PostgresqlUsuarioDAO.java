package com.ucs.projetotematico.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.model.Usuario;


public class PostgresqlUsuarioDAO implements UsuarioDAO {

	private Connection conn;

	PostgresqlUsuarioDAO(Connection conn) { // recebe a conexÃ£o e manipula ela por aqui
		this.conn = conn;
	}

	// metodo que consulta e lista os produtos do banco
	public List<Usuario> buscaTodos() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY); // cria comando que manda
																							// informacao para o banco
			rs = stmt.executeQuery("select baseusuario.id_usuario, baseusuario.des_nome, "
					+ "baseusuario.num_cpf,baseusuario.des_rua, baseusuario.numero, baseusuario.des_bairro, baseusuario.des_setor "
					+ "from baseusuario ");// rs recebe o resultado do select

			rs.first();
			while (rs.next()) { // laco pega as informacoes da tabela baseusuario e adiciona no array usuario
				Usuario usuario = new Usuario();
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("des_nome"));
				usuario.setCpf(rs.getString("num_cpf"));
				usuario.setDes_rua(rs.getString("des_rua"));
				usuario.setNumero(rs.getInt("numero"));
				usuario.setDes_bairro(rs.getString("des_bairro"));
				usuario.setDes_setor(rs.getString("des_setor"));

				usuarios.add(usuario);

			}

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao listar os dados: " + se.getMessage());

		} finally {
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
	
	public List<Usuario> buscaTodosNome(String des_nome) {
		

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			 //s.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY); // cria comando que manda
			System.out.println("Buscando usuário com o nome = " + des_nome);
																				// informacao para o banco
			pstmt = conn.prepareStatement("select baseusuario.id_usuario, baseusuario.des_nome, "
					+ "baseusuario.num_cpf,baseusuario.des_rua, baseusuario.numero, baseusuario.des_bairro, baseusuario.des_setor "
					+ "from baseusuario where baseusuario.des_nome like !");// rs recebe o resultado do select

			pstmt.setString(1, "'%"+des_nome+"%'");
			rs = pstmt.executeQuery();
			
			rs.first();
			while (rs.next()) { // laco pega as informacoes da tabela baseusuario e adiciona no array usuario
				Usuario usuario = new Usuario();
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("des_nome"));
				usuario.setCpf(rs.getString("num_cpf"));
				usuario.setDes_rua(rs.getString("des_rua"));
				usuario.setNumero(rs.getInt("numero"));
				usuario.setDes_bairro(rs.getString("des_bairro"));
				usuario.setDes_setor(rs.getString("des_setor"));

				usuarios.add(usuario);

			}

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao listar os dados: " + se.getMessage());

		} finally {
			try {
				rs.close();
				pstmt.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		// return usuario;
		return usuarios;
	}

	// metodo que busca por determinado UsuarioID
	public Usuario buscaPorCodigo(int id_usuario) {

		Usuario usuario = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			System.out.println("Buscando usuário com o codigo = " + id_usuario);
			pstmt = conn.prepareStatement(
					"select id_usuario,des_nome, dta_admissao, dta_nascimento, num_telefone, des_email, num_cpf, num_rg, "
							+ "des_rua, des_bairro, des_cidade, numero, cep, des_estado, des_setor, des_escala"
							+ " from baseusuario where id_usuario = ?"); // rs recebe o resultado do select

			pstmt.setInt(1, id_usuario);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("des_nome"));
				usuario.setData_admissao(rs.getDate("dta_admissao"));
				usuario.setData_nascimento(rs.getDate("dta_nascimento"));
				usuario.setTelefone(rs.getString("num_telefone"));
				usuario.setEmail(rs.getString("des_email"));
				usuario.setCpf(rs.getString("num_cpf"));
				usuario.setRg(rs.getString("num_rg"));
				usuario.setDes_rua(rs.getString("des_rua"));
				usuario.setDes_bairro(rs.getString("des_bairro"));
				usuario.setDes_cidade(rs.getString("des_cidade"));
				usuario.setNumero(rs.getInt("numero"));
				usuario.setCep(rs.getInt("cep"));
				usuario.setDes_estado(rs.getString("des_estado"));
				usuario.setDes_setor(rs.getString("des_setor"));
				usuario.setDes_escala(rs.getString("des_escala"));

			}
		} catch (SQLException se) {
			System.out.println("Ocorreu um erro : " + se.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return usuario;
	}

	// mÃ©todo que insere no banco CERTO
	public void salvar(Usuario usuario) {

		if (usuario == null) {
			return;
		}

		PreparedStatement pstmt = null;

		System.out.println("Inserindo usuario " + usuario);

		try {
			// SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
			pstmt = conn
					.prepareStatement("insert into baseusuario (des_nome, dta_admissao, dta_nascimento, num_telefone,"
							+ " des_email, num_cpf, num_rg, des_rua, des_bairro,des_cidade,cep,numero,des_estado, des_setor, des_escala) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, usuario.getNome());
			pstmt.setDate(2, new java.sql.Date(usuario.getData_admissao().getTime()));
			pstmt.setDate(3, new java.sql.Date(usuario.getData_nascimento().getTime()));
			pstmt.setString(4, usuario.getTelefone());
			pstmt.setString(5, usuario.getEmail());
			pstmt.setString(6, usuario.getCpf());
			pstmt.setString(7, usuario.getRg());
			pstmt.setString(8, usuario.getDes_rua());
			pstmt.setString(9, usuario.getDes_bairro());
			pstmt.setString(10, usuario.getDes_cidade());
			pstmt.setInt(11, usuario.getCep());
			pstmt.setInt(12, usuario.getNumero());
			pstmt.setString(13, usuario.getDes_estado());
			pstmt.setString(14, usuario.getDes_setor());
			pstmt.setString(15, usuario.getDes_escala());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir os dados: " + se.getMessage());

		} finally {
			try {
				pstmt.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public Usuario buscaSenha(int id_usuario) {

		Usuario usuario = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			System.out.println("Buscando o usuario com o codigo = " + id_usuario);
			pstmt = conn.prepareStatement(
					"select baseusuario.id_usuario,baseusuario.senha from baseusuario where id_usuario = ?"); 
			pstmt.setInt(1, id_usuario);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setSenha(rs.getString("senha"));

			}
		} catch (SQLException se) {
			
			JOptionPane.showMessageDialog(null, "Usuário/Senha Icorretos");
			
		} finally {
			try {
				rs.close();
				pstmt.close();

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Icorretos");	
				System.out.println(e.getMessage());
			}
		}
		return usuario;
	}

	// metodo que busca por determinado UsuarioID
	/*public void apagar(Usuario usuario) {

		if (usuario == null) {
			return;
		}

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from baseusuario where id_usuario= ?");
			pstmt.setInt(1, usuario.getId_usuario());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
		} catch (SQLException se) {
			System.out.println("Ocorreu um erro : " + se.getMessage());
		} finally {
			try {
				pstmt.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}*/
	
	public int removeUsuario(Integer codigo) {

		System.out.println("Removendo o usuario com código = " + codigo);

		int apagou = 0;

		if (codigo != null) {

			PreparedStatement pstmt = null;

			try {
				pstmt = conn
						.prepareStatement("delete from baseusuario where id_usuario =  ?");
				pstmt.setInt(1, codigo);
				pstmt.execute();
				apagou = codigo;
				JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
			} catch (SQLException se) {
				System.out.println("Ocorreu um erro : " + se.getMessage());
			} finally {
				try {
					pstmt.close();

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}else JOptionPane.showMessageDialog(null, "Código Nulo");
		return apagou;
	
	};

// metodo que da update no banco
	public void alterar(Usuario usuario) {

		if (usuario == null) { // condicao para seguranca, se o usuario tentar apagar algo nulo nao dar
								// Exception
			return;
		}

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"update baseusuario set des_nome = ?, dta_admissao = ?, dta_nascimento = ?, num_telefone = ?, "
							+ "des_email = ?, num_cpf = ?, num_rg = ?, des_rua = ?, des_bairro = ?,des_cidade = ?,cep = ? ,numero = ? , des_estado=?,"
							+ " des_setor = ?, des_escala= ? where id_usuario = ?");

			pstmt.setString(1, usuario.getNome());
			pstmt.setDate(2, new java.sql.Date(usuario.getData_admissao().getTime()));
			pstmt.setDate(3, new java.sql.Date(usuario.getData_nascimento().getTime()));
			pstmt.setString(4, usuario.getTelefone());
			pstmt.setString(5, usuario.getEmail());
			pstmt.setString(6, usuario.getCpf());
			pstmt.setString(7, usuario.getRg());
			pstmt.setString(8, usuario.getDes_rua());
			pstmt.setString(9, usuario.getDes_bairro());
			pstmt.setString(10, usuario.getDes_cidade());
			pstmt.setInt(11, usuario.getCep());
			pstmt.setInt(12, usuario.getNumero());
			pstmt.setString(13, usuario.getDes_estado());
			pstmt.setString(14, usuario.getDes_setor());
			pstmt.setString(15, usuario.getDes_escala());
			pstmt.setInt(16, usuario.getId_usuario());

			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");

		} catch (SQLException se) {
			System.out.println("Ocorreu um erro na alteração dos dados! /n Erro:" + se.getMessage());

		} finally {
			try {
				pstmt.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
