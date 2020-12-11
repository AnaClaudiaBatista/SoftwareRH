package com.ucs.projetotematico.gui;

import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;

import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class GerarRelatorio implements Serializable{
	
	//Conectando ao Banco de dados
			Connection conn	 = PostgresqlDAOFactory.openConnection();

	
	private static final long serialVersionUID = 1L;
	
	private static final String FOLDER_RELATORIOS = "/relatorios";
	private String caminhoArquivoRelatorio = null;
	private JRExporter exporter = null;
	private File arquivoGerado = null;
	
	public String geraRelatorio (HashMap parametrosRelatorio, 
			String nomeRelatorioJasper, String tipoExportar) throws Exception{
	
		String caminhoRelatorio = this.getClass().getResource(FOLDER_RELATORIOS).getPath();
		//String jasper = "relPontoForm.jasper";
		
	    // caminho compreto até o relatório compilado indicado
		String caminhoArquivosJasper = caminhoRelatorio + File.separator
				+ nomeRelatorioJasper + ".jasper";
		
		// Faz o carregamento do relatório
		JasperReport relatorioJasper = (JasperReport) JRLoader.loadObjectFromFile(caminhoArquivosJasper);
		
		// Carrega o arquivo
		JasperPrint impressoraJasper = JasperFillManager.fillReport(
				relatorioJasper, parametrosRelatorio, conn);
		
		if(tipoExportar.equalsIgnoreCase("pdf")) {
			exporter = new JRPdfExporter();
		}else if (tipoExportar.equalsIgnoreCase("xls")) {
			
		}
		
		//Caminho relatorio exportado
		caminhoArquivoRelatorio = caminhoRelatorio + File.separator
				+ nomeRelatorioJasper + "."+tipoExportar;
		
	    
		//Criar novos arquivos exportado
		
		arquivoGerado = new File (caminhoArquivoRelatorio);
		
		// Prepara a impressao
		
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,
				impressoraJasper);
		
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE,
				arquivoGerado);
		
		//executa a exportacao
		exporter.exportReport();
		
		return caminhoArquivoRelatorio;
	} 
	
	

}
