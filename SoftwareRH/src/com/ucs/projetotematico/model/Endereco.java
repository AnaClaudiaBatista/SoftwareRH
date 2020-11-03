package com.ucs.projetotematico.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Essa classe representa um produto
 * @author krohn
 *
 */
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 
	private int id_endereco;
	private String des_rua;
	private String des_bairro;	
	private int numero;
	private int cep;
	private String complemento;
	private int id_cidade;
	private String pesquisa;
	
	
	public Endereco(){}
	
	public Endereco(int id_endereco, String des_rua, String des_bairro, int numero, int cep, String complemento, int id_cidade) {
		super();
		
		this.id_endereco = id_endereco;
		this.des_rua = des_rua;
		this.des_bairro = des_bairro;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
		this.id_cidade = id_cidade;
		
		
	}
	/**
	 * Obtém o codigo do produto
	 * @return Um <code>int</code> indicando o codigo do produto
	 */

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getDes_rua() {
		return des_rua;
	}

	public void setDes_rua(String des_rua) {
		this.des_rua = des_rua;
	}

	public String getDes_bairro() {
		return des_bairro;
	}

	public void setDes_bairro(String des_bairro) {
		this.des_bairro = des_bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(int id_cidade) {
		this.id_cidade = id_cidade;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cep;
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((des_bairro == null) ? 0 : des_bairro.hashCode());
		result = prime * result + ((des_rua == null) ? 0 : des_rua.hashCode());
		result = prime * result + id_cidade;
		result = prime * result + id_endereco;
		result = prime * result + numero;
		result = prime * result + ((pesquisa == null) ? 0 : pesquisa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cep != other.cep)
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (des_bairro == null) {
			if (other.des_bairro != null)
				return false;
		} else if (!des_bairro.equals(other.des_bairro))
			return false;
		if (des_rua == null) {
			if (other.des_rua != null)
				return false;
		} else if (!des_rua.equals(other.des_rua))
			return false;
		if (id_cidade != other.id_cidade)
			return false;
		if (id_endereco != other.id_endereco)
			return false;
		if (numero != other.numero)
			return false;
		if (pesquisa == null) {
			if (other.pesquisa != null)
				return false;
		} else if (!pesquisa.equals(other.pesquisa))
			return false;
		return true;
	}
	




	
}
