package com.ucs.projetotematico.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
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
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;
import com.ucs.projetotematico.model.Usuario;


public class TelaListaUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome, txtAdmissao, txtCPF, txtRua, txtNumero, txtBairro, txtCodigo;
	
	private JButton btnNovo, btnBuscarTodos;
	private JLabel lblCodigo, lblFundo, lblNome, lblAdmissao, lblCpf, lblLogradouro,lblNumero, lblBairro;
	protected JTable tabelaUsuarios;
	private JScrollPane scroll;
	private UsuarioDAO dao;
	private DAOFactory fabrica;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaUsuarios frame = new TelaListaUsuarios();	
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
	public TelaListaUsuarios() {
		//Conectando ao Banco de dados
		fabrica = PostgresqlDAOFactory.getInstancia();
		dao = fabrica.getUsuarioDAO();
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListaUsuarios.class.getResource("/img/icone32.ico")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scroll = new JScrollPane();
		scroll.setBounds(10, 47, 560, 290);
		contentPane.add(scroll);
		
		tabelaUsuarios = new JTable(new DefaultTableModel(
				new Object[][] {					
				},
				new String[] {
					"Codigo", "Nome", "Admiss�o", "CPF", "Logradouro", "Numero", "Bairro"	
				}
				));	
		tabelaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// testa se teve duplo clique
				if(tabelaUsuarios.getSelectedRow() != -1 && e.getClickCount() == 2) { 
					
						Usuario usuario = new Usuario();
						TelaCadastroUsuarios cadastro;
						try {
							cadastro = new TelaCadastroUsuarios();
							String sCodigo = ""+ tabelaUsuarios.getValueAt(tabelaUsuarios.getSelectedRow(),1);
							int codigo = Integer.parseInt(sCodigo);						
							Usuario u = dao.buscaPorCodigo(codigo);
							
							
							cadastro.setUsuarios(u);
							
							cadastro.setVisible(true); 
							 dispose(); 
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						
									
					
					}
				
			}
		});
		
		
		
		
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
		
		tabelaUsuarios.setBounds(10, 47, 560, 290);
		//contentPane.add(tabelaUsuarios);
		scroll.setViewportView(tabelaUsuarios);
		
		
		
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 10));
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setBounds(10, 11, 80, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBorder(null);
		txtCodigo.setBounds(10, 24, 80, 20);
		txtCodigo.setColumns(10);
		contentPane.add(txtCodigo);
		
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNome);
		lblNome.setBounds(90, 11, 80, 14);		
		
		txtNome = new JTextField();
		txtNome.setBorder(null);
		txtNome.setBounds(90, 24, 80, 20);
		txtNome.setColumns(10);
		contentPane.add(txtNome);
		
		
		lblAdmissao = new JLabel("Admiss\u00E3o");
		lblAdmissao.setFont(new Font("Arial", Font.PLAIN, 10));
		lblAdmissao.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmissao.setBounds(170, 11, 80, 14);
		contentPane.add(lblAdmissao);
		
		txtAdmissao = new JTextField();
		txtAdmissao.setBorder(null);
		txtAdmissao.setBounds(170, 24, 80, 20);
		txtAdmissao.setColumns(10);
		contentPane.add(txtAdmissao);
		
				
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 10));
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setBounds(250, 11, 80, 14);
		contentPane.add(lblCpf);

		txtCPF = new JTextField();
		txtCPF.setBorder(null);
		txtCPF.setBounds(250, 24, 80, 20);
		txtCPF.setColumns(10);
		contentPane.add(txtCPF);
		
		
		lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Arial", Font.PLAIN, 10));
		lblLogradouro.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogradouro.setBounds(330, 11, 80, 14);
		contentPane.add(lblLogradouro);
		
		txtRua = new JTextField();
		txtRua.setBorder(null);
		txtRua.setBounds(330, 24, 80, 20);
		txtRua.setColumns(10);
		contentPane.add(txtRua);		
		

		lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setBounds(410, 11, 80, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBorder(null);
		txtNumero.setBounds(410, 24, 80, 20);
		txtNumero.setColumns(10);
		contentPane.add(txtNumero);		
		

		lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 10));
		lblBairro.setHorizontalAlignment(SwingConstants.CENTER);
		lblBairro.setBounds(490, 11, 80, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBorder(null);
		txtBairro.setBounds(490, 24, 80, 20);
		txtBairro.setColumns(10);
		contentPane.add(txtBairro);
					
				
		btnBuscarTodos = new JButton("Buscar Todos");		
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
		btnBuscarTodos.setBounds(180, 339, 127, 23);
		contentPane.add(btnBuscarTodos);
			
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroUsuarios cadastro;
				try {
					cadastro = new TelaCadastroUsuarios();
					cadastro.setLocationRelativeTo(null);
					cadastro.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNovo.setBounds(317, 339, 80, 23);
		contentPane.add(btnNovo);
		
		
		
		lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaListaUsuarios.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 582, 374);
		contentPane.add(lblFundo);
		
		
		
		
	
		
	}
}
