package com.ucs.projetotematico.gui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.ucs.projetotematico.model.Usuario;


public class UsuarioTableModel extends AbstractTableModel{
	private List<Usuario> usuarios;
	private static final String nomes[] = {"Codigo", "Nome", "Admissao", "CPF", "Logradouro", "Numero", "Bairro"};
	
	private ArrayList linhas = null;
	private String[] colunas = null;
	
	public UsuarioTableModel() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public UsuarioTableModel(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String getColumnName(int number) {
		return nomes[number];
	}
	
	
	public int getRowCount() {
		if (usuarios != null) {
			return usuarios	.size();
		} else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Usuario usuario = usuarios.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return usuario.getId_usuario();
		case 1:
			return usuario.getNome();
		case 2:
			return usuario.getData_admissao();
		case 3:
			return usuario.getCpf();
		case 4:
			return usuario.getEndereco().getDes_rua();
		case 5:
			return usuario.getEndereco().getNumero();
		case 6:
			return usuario.getEndereco().getDes_bairro();
			}
		return null;
	}
	
	public Usuario getUsuario(int rowIndex) {
		return usuarios.get(rowIndex);
	}
	
	public void adicionaUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		this.fireTableDataChanged();
	}
	
	
	

}
