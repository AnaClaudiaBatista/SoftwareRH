package com.ucs.projetotematico.model;

import java.io.Serializable;

/**
 * Essa classe representa um produto
 * @author krohn
 *
 */
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private String descricao;
	
	public Usuario(){}
	
	public Usuario(int codigo, String nome, String descricao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
	}

	/**
	 * Obtém o código do produto
	 * @return Um <code>int</code> indicando o código do produto
	 */
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Codigo = ");
		sb.append(this.getCodigo());
		sb.append(" ");
		
		sb.append(",Nome = ");
		sb.append(this.getNome());
		sb.append(" ");

		sb.append(",Descricao = ");
		sb.append(this.getDescricao());
		sb.append(" ");

		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Usuario other = (Usuario) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
}
