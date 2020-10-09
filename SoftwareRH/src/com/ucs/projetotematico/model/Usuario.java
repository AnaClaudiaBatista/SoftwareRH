package com.ucs.projetotematico.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Essa classe representa um produto
 * @author krohn
 *
 */
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*
	 *             
					u.setStatus(rs.getBoolean("tip_status"));
					u.setCPF(rs.getInt("num_cpf"));
					u.setRG(rs.getInt("num_rg"));
					u.setData(rs.getDate("dta_nascimento"));					
					u.setEndereco(rs.getInt("id_endereco"));
					u.setTelefone(rs.getString("num_telefone"));
					u.setEmail(rs.getString("des_email"));
					u.setNatural(rs.getString("des_naturalidade"));
					u.setNacionalidade(rs.getString("des_nacionalidade"));
					u.setEstCivil(rs.getCharacterStream("tip_estado_civil"));
					u.setPai(rs.getString("des_pai"));
					u.setMae(rs.getString("des_mae"));
					u.setSenha(rs.getString("des_senha"));	
	 */
	private int id_empresa;
	private int id_usuario;
	private String nome;
	private boolean status;
	private String cpf;
	private String rg;
	private Date data_nascimento;
	private int endereco;
	private String telefone;
	private String email;
	private String natural;
	private Date data_admissao;
	//private String nacionalidade;
	//private char estCivil;
	//private String pai;
	//private String mae;
	//private String senha;	
	
	
	public Usuario(){}
	
	public Usuario(int id_empresa, int id_usuario, String nome, boolean status, String cpf, String rg, Date data_nascimento, int endereco, String telefone, 
			String email, String natural, Date data_admissao) {
		super();
		
		this.id_empresa = id_empresa;
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.status = status;
		this.cpf = cpf;
		this.rg = rg;
		this.data_nascimento = data_nascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.natural = natural;
		this.data_admissao = data_admissao;
	}
	/**
	 * Obtém o codigo do produto
	 * @return Um <code>int</code> indicando o codigo do produto
	 */
	

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getRg() {
		return rg;
	}



	public void setRg(String rg) {
		this.rg = rg;
	}



	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	
	public int getEndereco() {
		return endereco;
	}



	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNatural() {
		return natural;
	}



	public void setNatural(String natural) {
		this.natural = natural;
	}

	
	

	public Date getData_admissao() {
		return data_admissao;
	}

	public void setData_admissao(Date data_admissao) {
		this.data_admissao = data_admissao;
	}

	@Override
	public String toString() {
		return "Usuario [id_empresa=" + id_empresa + ", id_usuario=" + id_usuario + ", nome=" + nome + ", status=" + status
				+ ", cpf=" + cpf + ", rg=" + rg + ", data_nascimento=" + data_nascimento + ", endereco=" + endereco
				+ ", telefone=" + telefone + ", email=" + email + ", natural=" + natural + ", data_admissao="
				+ data_admissao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());;
		result = prime * result + ((data_admissao == null) ? 0 : data_admissao.hashCode());
		result = prime * result + ((data_nascimento == null) ? 0 : data_nascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id_empresa;
		result = prime * result + endereco;
		result = prime * result + ((natural == null) ? 0 : natural.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + id_usuario;
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
		if (cpf != other.cpf)
			return false;
		if (data_admissao == null) {
			if (other.data_admissao != null)
				return false;
		} else if (!data_admissao.equals(other.data_admissao))
			return false;
		if (data_nascimento == null) {
			if (other.data_nascimento != null)
				return false;
		} else if (!data_nascimento.equals(other.data_nascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_empresa != other.id_empresa)
			return false;
		if (endereco != other.endereco)
			return false;
		if (natural == null) {
			if (other.natural != null)
				return false;
		} else if (!natural.equals(other.natural))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg != other.rg)
			return false;
		if (status != other.status)
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (id_usuario != other.id_usuario)
			return false;
		return true;
	}





	
}
