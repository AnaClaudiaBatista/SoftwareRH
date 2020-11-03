package com.ucs.projetotematico.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnCadastros,mnRelatrios, mnPonto, mnSair;	
	private JMenuItem mntmSair;
	private JButton btnRelatorio, btnUsuario, btnRegistrarPonto;
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
		
		
		btnUsuario = new JButton("");		
		btnUsuario.setBorder(null);
		btnUsuario.setToolTipText("Cadastro de Funcion\u00E1rios");
		btnUsuario.setBackground(Color.WHITE);
		btnUsuario.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/adicionar-usuario.png")));
		btnUsuario.setBounds(10, 11, 64, 64);
		contentPane.add(btnUsuario);
		
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaUsuariosCad usuarios = new TelaUsuariosCad();
				usuarios.setLocationRelativeTo(null);
				usuarios.setVisible(true);
			}
		});
		
		
		btnRegistrarPonto = new JButton("");
		btnRegistrarPonto.setBorder(null);
		btnRegistrarPonto.setBackground(Color.WHITE);
		btnRegistrarPonto.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/calendario.png")));
		btnRegistrarPonto.setBounds(158, 11, 64, 64);
		contentPane.add(btnRegistrarPonto);
		
		btnRegistrarPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRegPonto ponto = new TelaRegPonto();
				ponto.setLocationRelativeTo(null);
				ponto.setVisible(true);
			}
		});
		
		
		lblFundo = new JLabel("");
		lblFundo.setBackground(Color.WHITE);
		lblFundo.setToolTipText("Cadastro de Funcion\u00E1rios");
		lblFundo.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(-15, 0, 612, 317);
		contentPane.add(lblFundo);
	}
}
