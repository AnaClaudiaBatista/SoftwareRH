package com.ucs.projetotematico.dao;

import java.util.List;
import com.ucs.projetotematico.model.Ponto;
import com.ucs.projetotematico.model.Usuario;;


public interface PontoDAO {
	
	void inserePonto(Ponto ponto);
	List<Ponto> buscaTodos() ;
	//List<Ponto> buscaTodosPonto(int id_usuario); 

}
	