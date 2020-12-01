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
import javax.swing.border.EmptyBorder;

import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnCadastros,mnRelatrios, mnPonto, mnSair;	
	private JMenuItem mntmSair;
	private JButton btnRelatorio, btnCadastraUsuarios, btnRegistrarPonto;
	private JLabel lblFundo;
	private UsuarioDAO dao;
	private DAOFactory fabrica;	
	
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
		setBounds(100, 100, 598, 367);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);		
		
		mnPonto = new JMenu("Ponto");
		menuBar.add(mnPonto);
		
		mnSair = new JMenu("Sair do Sistema");	
		menuBar.add(mnSair);
		
		mntmSair = new JMenuItem("Sair");
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
		
		
		btnRelatorio = new JButton("");
		btnRelatorio.setBackground(Color.WHITE);
		btnRelatorio.setBorder(null);
		btnRelatorio.setToolTipText("Relat\u00F3rio do Ponto");
		btnRelatorio.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/lista-de-controle.png")));
		btnRelatorio.setBounds(84, 11, 64, 64);
		contentPane.add(btnRelatorio);
		
		btnCadastraUsuarios = new JButton("");	
		btnCadastraUsuarios.addActionListener(new ActionListener() {
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
			
		btnCadastraUsuarios.setBorder(null);
		btnCadastraUsuarios.setToolTipText("Cadastro de Funcion\u00E1rios");
		btnCadastraUsuarios.setBackground(Color.WHITE);
		btnCadastraUsuarios.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/adicionar-usuario.png")));
		btnCadastraUsuarios.setBounds(10, 11, 64, 64);
		contentPane.add(btnCadastraUsuarios);
		
		
		btnRegistrarPonto = new JButton("");
		btnRegistrarPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaUsuarios usuarios = new TelaListaUsuarios();
				usuarios.setLocationRelativeTo(null);
				usuarios.setVisible(true);
				
			}
		});
		btnRegistrarPonto.setBorder(null);
		btnRegistrarPonto.setBackground(Color.WHITE);
		btnRegistrarPonto.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/calendario.png")));
		btnRegistrarPonto.setBounds(158, 11, 64, 64);
		contentPane.add(btnRegistrarPonto);
		
		
		
		
		lblFundo = new JLabel("");
		lblFundo.setBackground(Color.WHITE);
		lblFundo.setToolTipText("Cadastro de Funcion\u00E1rios");
		lblFundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(-15, 0, 612, 317);
		contentPane.add(lblFundo);
	}
}
