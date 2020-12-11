package com.ucs.projetotematico.gui;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;
import com.ucs.projetotematico.model.Usuario;
import java.awt.SystemColor;


public class TelaSplash extends JFrame {

	private JPanel contentPane;
	private Timer t;
	private JTextField txtLoading;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSplash frame = new TelaSplash();
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
	
	
	public TelaSplash() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/img/icone32.ico")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 271);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Fundo = new JLabel("");
		Fundo.setHorizontalAlignment(SwingConstants.CENTER);
		Fundo.setForeground(Color.LIGHT_GRAY);
		Fundo.setIcon(new ImageIcon(TelaSplash.class.getResource("/img/icone128.ico")));
		Fundo.setBounds(-2, 0, 376, 202);
		contentPane.add(Fundo);
		
		JProgressBar Carregando = new JProgressBar();
		Carregando.setBounds(10, 182, 354, 20);
		Carregando.setIndeterminate(true);
		contentPane.add(Carregando);
		
		txtLoading = new JTextField();
		txtLoading.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoading.setFocusable(false);
		txtLoading.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtLoading.setBorder(null);
		txtLoading.setBackground(SystemColor.menu);
		txtLoading.setForeground(SystemColor.activeCaptionText);
		txtLoading.setText("Carregando...");
		txtLoading.setBounds(145, 200, 86, 20);
		contentPane.add(txtLoading);
		txtLoading.setColumns(10);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaSplash.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(-2, 0, 436, 262);
		contentPane.add(lblFundo);
		setLocationRelativeTo(null);
		
		t = new Timer(4000, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// abre o formulário do jogo
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);		
				// interrope o timer
				t.stop();
				// fechando splash
				dispose();
			}
			
		});
		t.start();
		
	}
	}

	