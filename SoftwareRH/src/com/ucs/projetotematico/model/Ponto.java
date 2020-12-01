package com.ucs.projetotematico.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Essa classe representa um produto
 * @author krohn
 *
 */
public class Ponto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 
	private int id_usuario;
	private Date dta_registro;
	private Double manha_inicio;	
	private Double manha_final;	
	private Double tarde_inicio;	
	private Double tarde_final;	

	
	
	
	public Ponto(){}
	
	public Ponto(int id_usuario, Date dta_registro, Double manha_inicio, Double manha_final, Double tarde_inicio, Double tarde_final) {
		super();
		
		this.id_usuario = id_usuario;
		this.dta_registro = dta_registro;
		this.manha_inicio = manha_inicio;
		this.manha_final = manha_final;
		this.tarde_inicio = tarde_inicio;
		this.tarde_final = tarde_final;
		
	}
	/**
	 * Obtém o codigo do produto
	 * @return Um <code>int</code> indicando o codigo do produto
	 */

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Date getDta_registro() {
		return dta_registro;
	}
	
	public void setDta_registro(Date dta_registro) {
		this.dta_registro = dta_registro;
	}

	public Double getManha_inicio() {
		return manha_inicio;
	}

	public void setManha_inicio(Double manha_inicio) {
		this.manha_inicio = manha_inicio;
	}

	public Double getManha_final() {
		return manha_final;
	}

	public void setManha_final(Double manha_final) {
		this.manha_final = manha_final;
	}

	public Double getTarde_inicio() {
		return tarde_inicio;
	}

	public void setTarde_inicio(Double tarde_inicio) {
		this.tarde_inicio = tarde_inicio;
	}

	public Double getTarde_final() {
		return tarde_final;
	}

	public void setTarde_final(Double tarde_final) {
		this.tarde_final = tarde_final;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_usuario;
		result = prime * result + ((dta_registro == null) ? 0 : dta_registro.hashCode());				
		result = prime * result + ((manha_inicio == null) ? 0 : manha_inicio.hashCode());
		result = prime * result + ((manha_final == null) ? 0 : manha_final.hashCode());
		result = prime * result + ((tarde_inicio == null) ? 0 : tarde_inicio.hashCode());
		result = prime * result + ((tarde_final == null) ? 0 : tarde_final.hashCode());
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
		Ponto other = (Ponto) obj;
		if (dta_registro == null) {
			if (other.dta_registro != null)
				return false;
		} else if (!dta_registro.equals(other.dta_registro))
			return false;
		if (id_usuario != other.id_usuario)
			return false;
		if (manha_final != other.manha_final)
			return false;
		if (manha_inicio == null) {
			if (other.manha_inicio != null)
				return false;
		} else if (!manha_inicio.equals(other.manha_inicio))
			return false;
		if (tarde_final != other.tarde_final)
			return false;
		if (tarde_inicio != other.tarde_inicio)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ponto [id_usuario=" + id_usuario + ", dta_registro=" + dta_registro + ", manha_inicio=" + manha_inicio
				+ ", manha_final=" + manha_final + ", tarde_inicio=" + tarde_inicio + ", tarde_final=" + tarde_final
				+ "]";
	}

	

	




	
}
