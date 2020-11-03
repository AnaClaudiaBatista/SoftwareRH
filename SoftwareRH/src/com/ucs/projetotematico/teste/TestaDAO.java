package com.ucs.projetotematico.teste;

import java.util.List;

import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;
import com.ucs.projetotematico.model.Usuario;

public class TestaDAO {
	
	public static void main(String[] args) {
		
		// No início da aplicação
		DAOFactory fabrica = PostgresqlDAOFactory.getInstancia();
			
		// --
		UsuarioDAO usuarioDAO = fabrica.getUsuarioDAO();
		
		List<Usuario> usuarios = usuarioDAO.buscaTodos(null);
		
		
		for (Usuario u : usuarios) {
			System.out.println(u);
		}
		// --
		
		// No fechamento da Janela
		fabrica.closeConnection();
		
		
	}

}
