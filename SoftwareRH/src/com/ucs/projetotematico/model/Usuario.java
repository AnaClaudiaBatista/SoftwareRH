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
	
	 
	private int id_empresa;
	private int id_usuario;
	private String nome;
	private boolean status;
	private String cpf;
	private String rg;
	private Date data_nascimento;	
	private String telefone;
	private String email;
	private String natural;
	private Date data_admissao;
	private String senha;
	private String des_rua;
	private String des_bairro;
	private String des_cidade;
	private String des_estado;
	private String des_setor;
	private String des_escala;
	private int cep;
	private int numero;

	
	
	public Usuario(){}
	
	public Usuario(int id_empresa, int id_usuario, String nome, boolean status, String cpf, String rg, Date data_nascimento, int endereco, String telefone, 
			String email, String natural, Date data_admissao, String senha, String des_rua, String des_bairro, String des_cidade, String des_estado,String des_setor ,String des_escala, int cep, int numero) {
		super();
		
		this.id_empresa = id_empresa;
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.status = status;
		this.cpf = cpf;
		this.rg = rg;
		this.data_nascimento = data_nascimento;
		//this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.natural = natural;
		this.data_admissao = data_admissao;
		this.senha = senha;
		this.des_rua = des_rua;
		this.des_bairro = des_bairro;
		this.des_estado = des_estado;
		this.des_cidade = des_cidade;
		this.numero = numero;
		this.cep = cep;
		this.des_setor = des_setor;
		this.des_escala = des_escala;
		
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getDes_cidade() {
		return des_cidade;
	}

	public void setDes_cidade(String des_cidade) {
		this.des_cidade = des_cidade;
	}

	public String getDes_estado() {
		return des_estado;
	}
	
	public void setDes_estado(String des_estado) {
		this.des_estado = des_estado;
	}

	public void setDes_setor(String des_setor) {
		this.des_setor = des_setor;
	}
	
	public String getDes_setor() {
		return des_setor;
	}
	
	public String getDes_escala() {
		return des_estado;
	}

	public void setDes_escala(String des_escala) {
		this.des_escala = des_escala;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cep;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((data_admissao == null) ? 0 : data_admissao.hashCode());
		result = prime * result + ((data_nascimento == null) ? 0 : data_nascimento.hashCode());
		result = prime * result + ((des_bairro == null) ? 0 : des_bairro.hashCode());
		result = prime * result + ((des_cidade == null) ? 0 : des_cidade.hashCode());
		result = prime * result + ((des_estado == null) ? 0 : des_estado.hashCode());
		result = prime * result + ((des_escala == null) ? 0 : des_escala.hashCode());
		result = prime * result + ((des_setor == null) ? 0 : des_setor.hashCode());
		result = prime * result + ((des_rua == null) ? 0 : des_rua.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());	
		result = prime * result + id_empresa;
		result = prime * result + id_usuario;
		result = prime * result + ((natural == null) ? 0 : natural.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numero;
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		if (cep != other.cep)
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
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
		if (des_bairro == null) {
			if (other.des_bairro != null)
				return false;
		} else if (!des_bairro.equals(other.des_bairro))
			return false;
		if (des_cidade == null) {
			if (other.des_cidade != null)
				return false;
		} else if (!des_cidade.equals(other.des_cidade))
			return false;
		if (des_estado == null) {
			if (other.des_estado != null)
				return false;
		} else if (!des_estado.equals(other.des_estado))
			return false;
		if (des_escala == null) {
			if (other.des_escala != null)
				return false;
		} else if (!des_escala.equals(other.des_escala))
			return false;
		if (des_setor == null) {
			if (other.des_setor != null)
				return false;
		} else if (!des_setor.equals(other.des_setor))
			return false;
		if (des_rua == null) {
			if (other.des_rua != null)
				return false;
		} else if (!des_rua.equals(other.des_rua))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;		
		if (id_empresa != other.id_empresa)
			return false;
		if (id_usuario != other.id_usuario)
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
		if (numero != other.numero)
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (status != other.status)
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id_empresa=" + id_empresa + ", id_usuario=" + id_usuario + ", nome=" + nome + ", status="
				+ status + ", cpf=" + cpf + ", rg=" + rg + ", data_nascimento=" + data_nascimento + ",  telefone=" + telefone + ", email=" + email + ", natural=" + natural + ", data_admissao="
				+ data_admissao + ", senha=" + senha + ", des_rua=" + des_rua + ", des_bairro=" + des_bairro
				+ ", des_cidade=" + des_cidade + ", des_estado=" + des_estado + ", des_escala=" + des_escala + ", des_setor="
				+ "des_setor" + ", cep=" + cep + ", numero=" + numero
				+ "]";
	}
	

	
}
