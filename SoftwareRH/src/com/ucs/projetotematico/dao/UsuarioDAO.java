package com.ucs.projetotematico.dao;

import java.util.List;

import com.ucs.projetotematico.model.Usuario;

public interface UsuarioDAO {
	
	List<Usuario> buscaTodos();
	Usuario buscaPorCodigo(int codigo);
	void inserir(Usuario usuario);
	void deletar(Usuario usuario);
	void alterar(Usuario usuario);	

}
