package com.ucs.projetotematico.dao;

import java.util.List;

import com.ucs.projetotematico.model.Usuario;


public interface UsuarioDAO {
	
	
	List<Usuario> buscaTodos() ;	
	Usuario buscaPorCodigo(int id_usuario);
	Usuario buscaSenha(int id_usuario);
	//void apagar(Usuario usuario);
	void salvar(Usuario usuario);	
	void alterar(Usuario usuario);	
	 int removeUsuario(Integer codigo) ;
	 List<Usuario> buscaTodosNome( String des_nome);

}
