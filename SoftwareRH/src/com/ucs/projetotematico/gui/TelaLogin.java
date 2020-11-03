package com.ucs.projetotematico.gui;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;
import com.ucs.projetotematico.model.Usuario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JButton btnAcessar;
	private JPasswordField txtSenha;
	private JLabel lblIdentificacaodeUsuario, img,lblFundo;	
	private UsuarioDAO dao;
	private DAOFactory fabrica;	


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	
	
	public TelaLogin() {
		
		//Conectando ao Banco de dados
		fabrica = PostgresqlDAOFactory.getInstancia();
		dao = fabrica.getUsuarioDAO();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/img/icone32.ico")));
		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setForeground(Color.GRAY);
		txtLogin.setBounds(147, 130, 137, 22);
	//	txtLogin.setColumns(10);
		contentPane.add(txtLogin);
		
		
		btnAcessar = new JButton("Acessar");
		btnAcessar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAcessar.setIcon(new ImageIcon(TelaLogin.class.getResource("/img/btnAcessar.png")));	
		btnAcessar.setBounds(162, 203, 105, 29);
		contentPane.add(btnAcessar);
		
		
		
		txtSenha = new JPasswordField();		
		txtSenha.addKeyListener(new KeyAdapter() {			
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// adicionando o click do botao para etrar apenas clicando em Enter
					 btnAcessar.doClick(); 
				 }
					 
			}
		});
		txtSenha.setBounds(147, 175, 137, 20);
		contentPane.add(txtSenha);
		
		
		
			btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					 if (txtLogin.getText().equals("usuario") && 
							 (txtSenha.getText().equals("1234"))) {
						/*caso usuario e senha estiverem corretos abre a tela inicial*/
						TelaInicial inicio = new TelaInicial ();
			               inicio.setVisible(true);
			               inicio.setLocationRelativeTo(null);

			               dispose(); /*fecha tela de login*/	
					} else {
						JOptionPane.showMessageDialog(rootPane, "Usuário/Senha Icorretos");	
					}				
				}});
				
		     
		
		
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 10));
		lblSenha.setBounds(147, 159, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Arial", Font.PLAIN, 10));
		lblUsurio.setBounds(147, 107, 46, 22);
		contentPane.add(lblUsurio);
		
		lblIdentificacaodeUsuario = new JLabel("Identifica\u00E7\u00E3o de Usu\u00E1rio");
		lblIdentificacaodeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdentificacaodeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdentificacaodeUsuario.setBounds(147, 88, 137, 14);
		contentPane.add(lblIdentificacaodeUsuario);
		
		img = new JLabel("");
		img.setIcon(new ImageIcon(TelaLogin.class.getResource("/img/LogoRH64.ico")));
		img.setBounds(176, 17, 73, 64);
		contentPane.add(img);
		
		lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaLogin.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 434, 271);
		contentPane.add(lblFundo);
		
		
		
		
		
	}
}
