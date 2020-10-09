package com.ucs.projetotematico.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	JMenuBar menuBar;
	JMenu mnCadastros,mnRelatrios, mnPonto;	
	JButton btnRelatorio, btnUsuario, btnRegistrarPonto;
	JLabel lblFundo;
	
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
