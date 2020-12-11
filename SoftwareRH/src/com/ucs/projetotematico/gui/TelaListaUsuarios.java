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
	
	private JButton btnNovo, btnBuscarTodos;
	private JLabel lblFundo;
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
		scroll.setBounds(10, 22, 560, 315);
		contentPane.add(scroll);
		
		tabelaUsuarios = new JTable(new DefaultTableModel(
				new Object[][] {					
				},
				new String[] {
					"Matrícula", "Nome", "CPF", "Logradouro", "Numero", "Bairro", "Setor"	
				}
				));
		tabelaUsuarios.setAutoCreateRowSorter(true);
		

		tabelaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// testa se teve duplo clique
				if(tabelaUsuarios.getSelectedRow() != -1 && e.getClickCount() == 2) { 
					
					Object obj = (tabelaUsuarios.getValueAt(tabelaUsuarios.getSelectedRow(), 0));  //coluna 0
		            String cod = obj.toString();
					
		            TelaCadastroUsuarios cad;
					try {
						cad = new TelaCadastroUsuarios();
						  cad.preencheDados(this, cod.toString());		 
						  cad.setLocationRelativeTo(null);
				            cad.setVisible(true);
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
					
				
		btnBuscarTodos = new JButton("Buscar Todos");		
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
	
	



