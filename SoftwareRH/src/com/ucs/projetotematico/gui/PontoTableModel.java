package com.ucs.projetotematico.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import com.ucs.projetotematico.model.Ponto;


public class PontoTableModel extends AbstractTableModel{
	private List<Ponto> ponto;
	private static final String nomes[] = {"Matricula","Data", "Entrada", "Saída", "Entrada", "Saída"};
	
	private ArrayList linhas = null;
	private String[] colunas = null;
	
	public PontoTableModel() {
		this.ponto = new ArrayList<Ponto>();
	}
	
	public PontoTableModel(List<Ponto> ponto) {
		this.ponto = ponto;
	}
	
	public List<Ponto> getPonto() {
		return ponto;
	}

	public void setPonto(List<Ponto> ponto) {
		this.ponto = ponto;
	}
	
	public String getColumnName(int number) {
		return nomes[number];
	}
	
	
	public int getRowCount() {
		if (ponto != null) {
			return ponto.size();
		} else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Ponto regponto = ponto.get(rowIndex);	

		switch (columnIndex) {
		case 0:
			return regponto.getId_usuario();
		case 1:
			return regponto.getDta_registro();
		case 2:
			return regponto.getManha_inicio();
		case 3:
			return regponto.getManha_final();
		case 4:
			return regponto.getTarde_inicio();
		case 5:
			return regponto.getTarde_final();		
			}
		return null;
	}
	
	public Ponto getUsuario(int rowIndex) {
		return ponto.get(rowIndex);
	}
	
	public void adicionaUsuario(Ponto ponto) {
		this.ponto.add(ponto);
		this.fireTableDataChanged();
	}
	
	
	

}
