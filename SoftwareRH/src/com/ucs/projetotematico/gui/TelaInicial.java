package com.ucs.projetotematico.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
 
public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnCadastros, mnPonto, mnSair;	
	private JMenuItem mntmSair;
	private JButton btnListaCad, btnCadastraUsuarios;
	private JLabel lblFundo;
	private UsuarioDAO dao;
	private DAOFactory fabrica;	
	private JMenuItem mntmCadastrarPonto;
	private JMenuItem mntmListarFuncionrios;
	private JMenuItem mntmListarPonto;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		//Conectando ao Banco de dados
		fabrica = PostgresqlDAOFactory.getInstancia();
		dao = fabrica.getUsuarioDAO();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/img/icone32.ico")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 301);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastros = new JMenu("Cadastros");
		mnCadastros.setFont(new Font("Arial", Font.PLAIN, 11));
		menuBar.add(mnCadastros);
		
		JMenuItem mntmNovoCadastro = new JMenuItem("Novo Cadastro");
		mntmNovoCadastro.setFont(new Font("Arial", Font.PLAIN, 11));
		mntmNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroUsuarios cadUsuario;
				try {
					cadUsuario = new TelaCadastroUsuarios();
					cadUsuario.setLocationRelativeTo(null);
					cadUsuario.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnCadastros.add(mntmNovoCadastro);
		
		mntmListarFuncionrios = new JMenuItem("Listar Funcion\u00E1rios");
		mntmListarFuncionrios.setFont(new Font("Arial", Font.PLAIN, 11));
		mntmListarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaUsuarios listaUsuario;				
				listaUsuario = new TelaListaUsuarios();
				listaUsuario.setLocationRelativeTo(null);
				listaUsuario.setVisible(true);
			}
		});
		mnCadastros.add(mntmListarFuncionrios);
		
		mnPonto = new JMenu("Ponto");
		mnPonto.setFont(new Font("Arial", Font.PLAIN, 11));
		menuBar.add(mnPonto);
		
		mntmCadastrarPonto = new JMenuItem("Cadastrar Ponto");
		mntmCadastrarPonto.setFont(new Font("Arial", Font.PLAIN, 11));
		mntmCadastrarPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPonto cadPonto;				
				try {
					cadPonto = new TelaCadastroPonto();
					cadPonto.setLocationRelativeTo(null);
					cadPonto.setVisible(true);
			
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnPonto.add(mntmCadastrarPonto);
		
		mntmListarPonto = new JMenuItem("Listar Ponto");
		mntmListarPonto.setFont(new Font("Arial", Font.PLAIN, 11));
		mntmListarPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaPonto listaPonto;				
				listaPonto = new TelaListaPonto();
				listaPonto.setLocationRelativeTo(null);
				listaPonto.setVisible(true);
			}
		});
		mnPonto.add(mntmListarPonto);
		
		mnSair = new JMenu("Sair do Sistema");	
		mnSair.setFont(new Font("Arial", Font.PLAIN, 11));
		menuBar.add(mnSair);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.setFont(new Font("Arial", Font.PLAIN, 11));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CAIXA DE DIALOGO CONFIRMANDO SE O USUARIO DESEJA SAIR DO SISTEMA
				int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? ", "Atenção", JOptionPane.YES_NO_OPTION);
				if (sair == JOptionPane.YES_OPTION) {
				fabrica.closeConnection();
				System.exit(0);
			}}
		});
		mnSair.add(mntmSair);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		btnListaCad = new JButton("");
		btnListaCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaUsuarios listaUsuario;				
				listaUsuario = new TelaListaUsuarios();
				listaUsuario.setLocationRelativeTo(null);
				listaUsuario.setVisible(true);
				
			}
		});
		btnListaCad.setBackground(Color.WHITE);
		btnListaCad.setBorder(null);
		btnListaCad.setToolTipText("Lista Funcion\u00E1rios");
		btnListaCad.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/ListaFunc64.ico")));
		btnListaCad.setBounds(84, 11, 64, 64);
		contentPane.add(btnListaCad);
		
		btnCadastraUsuarios = new JButton("");	
		btnCadastraUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroUsuarios cadUsuario;
				try {
					cadUsuario = new TelaCadastroUsuarios();
					cadUsuario.setLocationRelativeTo(null);
					cadUsuario.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
			
		btnCadastraUsuarios.setBorder(null);
		btnCadastraUsuarios.setToolTipText("Cadastro de Funcion\u00E1rios");
		btnCadastraUsuarios.setBackground(Color.WHITE);
		btnCadastraUsuarios.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/CadastroFunc64.ico")));
		btnCadastraUsuarios.setBounds(10, 11, 64, 64);
		contentPane.add(btnCadastraUsuarios);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 93, 389, 2);
		contentPane.add(separator);
		
		JButton btnCadPonto = new JButton("");
		btnCadPonto.setBackground(SystemColor.text);
		btnCadPonto.setBorder(null);
		btnCadPonto.setToolTipText("Cadastro Ponto");
		btnCadPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPonto cadPonto;				
					try {
						cadPonto = new TelaCadastroPonto();
						cadPonto.setLocationRelativeTo(null);
						cadPonto.setVisible(true);
				
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			
			
		}});
		btnCadPonto.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/CadastroPonto64.ico")));
		btnCadPonto.setBounds(10, 103, 64, 64);
		contentPane.add(btnCadPonto);
		
		JButton btnListaPonto = new JButton("");
		btnListaPonto.setBackground(SystemColor.text);
		btnListaPonto.setBorder(null);
		btnListaPonto.setToolTipText("Lista Ponto");
		btnListaPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaPonto listaPonto;				
				listaPonto = new TelaListaPonto();
				listaPonto.setLocationRelativeTo(null);
				listaPonto.setVisible(true);
				
			}
		});
		btnListaPonto.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/ListaPonto64.ico")));
		btnListaPonto.setBounds(82, 103, 64, 64);
		contentPane.add(btnListaPonto);
		
		
		
		
		lblFundo = new JLabel("");
		lblFundo.setBackground(Color.WHITE);
		lblFundo.setToolTipText("Cadastro de Funcion\u00E1rios");
		lblFundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(-15, 0, 412, 246);
		contentPane.add(lblFundo);
	}
}
