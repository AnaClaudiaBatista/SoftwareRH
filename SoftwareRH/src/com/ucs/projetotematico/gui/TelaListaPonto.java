package com.ucs.projetotematico.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private DAOFactory fabrica;
	private JTextField txtMatricula;
	private JTextField txtData;
	private JButton btnVoltaDia;
	private JButton btnAvancaDia;
	private JPanel panelPonto, panelUsuarios;
	private JScrollPane scrollPonto;
	private JTable tableListaPonto;
	

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListaPonto.class.getResource("/img/icone32.ico")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVoltaDia = new JButton("");
		btnVoltaDia.setIcon(new ImageIcon(TelaListaPonto.class.getResource("/img/voltaDia16.ico")));
		btnVoltaDia.setBackground(SystemColor.inactiveCaptionBorder);
		btnVoltaDia.setBorder(null);
		btnVoltaDia.setBounds(197, 233, 18, 18);
		contentPane.add(btnVoltaDia);
		
		JButton btnVoltaMes = new JButton("");
		btnVoltaMes.setIcon(new ImageIcon(TelaListaPonto.class.getResource("/img/voltaMes16.ico")));
		btnVoltaMes.setBorder(null);
		btnVoltaMes.setBackground(SystemColor.inactiveCaptionBorder);
		btnVoltaMes.setBounds(154, 233, 18, 18);
		contentPane.add(btnVoltaMes);
		
		btnAvancaDia = new JButton("");
		btnAvancaDia.setBorder(null);
		btnAvancaDia.setIcon(new ImageIcon(TelaListaPonto.class.getResource("/img/avancaDia16.ico")));
		btnAvancaDia.setBackground(SystemColor.inactiveCaption);
		btnAvancaDia.setBounds(349, 233, 18, 18);
		contentPane.add(btnAvancaDia);
		
		JButton btnAvancaMes = new JButton("");
		btnAvancaMes.setBorder(null);
		btnAvancaMes.setBackground(SystemColor.inactiveCaption);
		btnAvancaMes.setIcon(new ImageIcon(TelaListaPonto.class.getResource("/img/avancaMes16.ico")));
		btnAvancaMes.setBounds(392, 233, 18, 18);
		contentPane.add(btnAvancaMes);
		
		JLabel lblData = new JLabel("Data");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(257, 217, 63, 14);
		contentPane.add(lblData);
		
		JLabel lblMatricula = new JLabel("Digite Matricula");
		lblMatricula.setBounds(10, 217, 105, 14);
		contentPane.add(lblMatricula);
		
		txtData = new JTextField();
		txtData.setBounds(234, 235, 105, 18);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
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
					"Codigo", "Nome", "Admissão", "CPF", "Logradouro", "Numero", "Bairro"	
				}
				));			
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
		//panelUsuarios.add(tabelaUsuarios);
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
				/*SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");				
				Usuario usuario = new Usuario();
				usuario.setPesquisa(txtPesquisa.getText());				
				dao.buscaTodos(usuario);				
				txtCodigo.setText(String.valueOf(usuario.getId_usuario()));
				//txtCodigo.setText(new Integer(usuario.getId_usuario()).toString());
				txtNome.setText(usuario.getNome());						
				//txtAdmissao.setText(dataFormatada.format(usuario.getData_admissao()));
				txtCPF.setText(String.valueOf(usuario.getCpf()));
				txtRua.setText(usuario.getEndereco().getDes_bairro());
				txtNumero.setText(String.valueOf(usuario.getEndereco().getNumero()));
				txtBairro.setText(usuario.getEndereco().getDes_bairro());				
				*/
				//usuario.setData_admissao(dataFormatada.parse(txtAdmissao.getText()));	
				
			}
		});
		btnBuscarTodos.setFont(new Font("Arial", Font.PLAIN, 10));		
		
		
		
		lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaListaPonto.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 582, 374);
		contentPane.add(lblFundo);
		
		
		
		
		//Conectando ao Banco de dados
		fabrica = PostgresqlDAOFactory.getInstancia();
		dao = fabrica.getUsuarioDAO();
		
		
	}
}
