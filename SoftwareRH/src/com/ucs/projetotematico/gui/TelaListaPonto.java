package com.ucs.projetotematico.gui;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.PontoDAO;
import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;
import com.ucs.projetotematico.model.Ponto;
import com.ucs.projetotematico.model.Usuario;





public class TelaListaPonto extends JFrame {

	private JPanel contentPane;
	
	private JButton btnBuscarTodos;
	private JLabel lblFundo;
	protected JTable tabelaUsuarios;
	private JScrollPane scroll;
	private UsuarioDAO dao;
	private PontoDAO pontoDao;
	private DAOFactory fabrica;
	private JTextField txtMatricula;
	private JPanel panelPonto, panelUsuarios;
	private JScrollPane scrollPonto;
	private JTable tableListaPonto;
	private List<Ponto> pontos = new ArrayList<>();
	private JButton btnGerar;

	
  
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaPonto frame = new TelaListaPonto();	
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaListaPonto() {

		//Conectando ao Banco de dados
		fabrica = PostgresqlDAOFactory.getInstancia();
		dao = fabrica.getUsuarioDAO();

		
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListaPonto.class.getResource("/img/icone32.ico")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 601, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatricula = new JLabel("Digite Matricula");
		lblMatricula.setBounds(10, 217, 105, 14);
		contentPane.add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(10, 235, 105, 18);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		panelPonto = new JPanel();
		panelPonto.setBounds(10, 264, 562, 89);
		contentPane.add(panelPonto);
		panelPonto.setLayout(null);
		
		scrollPonto = new JScrollPane();
		scrollPonto.setBackground(SystemColor.inactiveCaption);
		scrollPonto.setBounds(0, 0, 562, 89);
		panelPonto.add(scrollPonto);
		
		
		tableListaPonto = new JTable(new PontoTableModel());		
		tableListaPonto.setAutoCreateRowSorter(true);
		tableListaPonto.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting()) {
			                return;
			            }
						PontoTableModel pontoTableModel = (PontoTableModel) tableListaPonto
								.getModel();
						Ponto ponto = pontoTableModel.getPonto().get(
								e.getLastIndex());
						System.out.println(ponto);
//						
					}
				});
		
		scrollPonto.setViewportView(tableListaPonto);
						
		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(SystemColor.inactiveCaptionBorder);
		panelUsuarios.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelUsuarios.setBounds(10, 22, 558, 188);
		contentPane.add(panelUsuarios);		
		panelUsuarios.setLayout(null);
		
		scroll = new JScrollPane();
		scroll.setBounds(0, 0, 557, 160);		
		panelUsuarios.add(scroll);
		
		tabelaUsuarios = new JTable(new DefaultTableModel(
				new Object[][] {					
				},
				new String[] {
					"Matricula", "Nome", "CPF", "Logradouro", "Numero", "Setor"	
				}
				));	
		tabelaUsuarios.setAutoCreateRowSorter(true);
		
		// clica em uma matricula e ela lista em baixo
	/*	tabelaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Object obj = (tabelaUsuarios.getValueAt(tabelaUsuarios.getSelectedRow(), 0));  //coluna 0
	            String cod = obj.toString();
	            int codigo = Integer.parseInt(cod);
	            
	        	PontoDAO pontoDAO = fabrica.getPontoDAO();
				List<Ponto> pontos = new ArrayList<Ponto>();
				
				
				//pontos = pontoDAO.buscaTodosPonto(codigo);
				
				PontoTableModel pontoTableModel = new PontoTableModel();
				pontoTableModel.setPonto(pontos);

				tableListaPonto.setModel(pontoTableModel);

				
				
			}
		});*/
		tabelaUsuarios.setBounds(44, 42, 432, 108);
		
		tabelaUsuarios.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting()) {
			                return;
			            }
						UsuarioTableModel usuarioTableModel = (UsuarioTableModel) tabelaUsuarios
								.getModel();
						Usuario usuario = usuarioTableModel.getUsuarios().get(
								e.getLastIndex());
						System.out.println(usuario);
//						
					}
				});
		scroll.setViewportView(tabelaUsuarios);				
		btnBuscarTodos = new JButton("Buscar Todos");
		btnBuscarTodos.setBounds(221, 163, 113, 21);
		panelUsuarios.add(btnBuscarTodos);
		btnBuscarTodos.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				UsuarioDAO usuarioDAO = fabrica.getUsuarioDAO(); 
				List<Usuario> usuarios = new ArrayList<Usuario>();
				
				usuarios = usuarioDAO.buscaTodos();
				
				UsuarioTableModel usuarioTableModel = new UsuarioTableModel();
				usuarioTableModel.setUsuarios(usuarios);
				tabelaUsuarios.setModel(usuarioTableModel);
				
			
			}
		});
		btnBuscarTodos.setFont(new Font("Arial", Font.PLAIN, 10));		
		
		
		
				
		
		
		JButton btnBuscaPonto = new JButton("Busca Ponto");
		btnBuscaPonto.setFont(new Font("Arial", Font.PLAIN, 10));
		btnBuscaPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PontoDAO pontoDAO = fabrica.getPontoDAO();
				List<Ponto> pontos = new ArrayList<Ponto>();
				
				pontos = pontoDAO.buscaTodos();
				
				PontoTableModel pontoTableModel = new PontoTableModel();
				pontoTableModel.setPonto(pontos);

				tableListaPonto.setModel(pontoTableModel);

				
			}
		});
		btnBuscaPonto.setBounds(234, 364, 108, 23);
		contentPane.add(btnBuscaPonto);
		
		/*
		 	// esse para salvar, o parse converte o campo de scrig para date, 
				// vai pegar o formato brasileiro  e converter para o estrangeiro
				try {	
					usuario.setData_admissao(dataFormatada.parse(txtAdmissao.getText()));					
				} catch (ParseException e1) {
					JOptionPane.showConfirmDialog(null, "Data Incorreta!" + e1);
				}	
		 */
		
		btnGerar = new JButton("Gerar Relat\u00F3rio");
		btnGerar.setFont(new Font("Arial", Font.PLAIN, 10));
		btnGerar.setBounds(125, 233, 108, 23);
		contentPane.add(btnGerar);
		
		
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sMatricula = txtMatricula.getText();
					int matricula = Integer.parseInt(sMatricula);	
					//BigDecimal mat = new BigDecimal(matricula); //CASO TENHA ERRO DE TIPOS DE DADOS NO IREPORT
					
					HashMap params = new HashMap<>();
				/*	params.put("data",
							new SimpleDateFormat("dd/MM/yyyy").
							parse(txtData.getText()));*/
					params.put("matricula", matricula);
						
			   		String file = new GerarRelatorio().geraRelatorio(params,
			   				"relPontoForm", "pdf");
			   					

			   		Desktop.getDesktop().open(new File(file));

				}catch (Exception es) {
					es.printStackTrace();
				}
				
			
			}});
		
		
		lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaListaPonto.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 582, 407);
		contentPane.add(lblFundo);
		
	
	
}
	

}
