package com.ucs.projetotematico.gui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;
import com.ucs.projetotematico.model.Usuario;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class TelaUsuariosCad extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtNome, txtAdmissao, txtCPF, txtRua, txtNumero, txtBairro, txtCodigo;
	
	private JButton btnNovo, btnPesquisar;
	private JTextField txtPesquisa;
	private JLabel lblCodigo, lblFundo, lblNome, lblAdmissao, lblCpf, lblLogradouro,lblNumero, lblBairro;
	private UsuarioDAO dao;
	private DAOFactory fabrica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuariosCad frame = new TelaUsuariosCad();	
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
	public TelaUsuariosCad() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaUsuariosCad.class.getResource("/img/icone32.ico")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Nome", "Admissao", "CPF", "Logradouro", "Numero", "Bairro"
			}
		));
		table.setBounds(10, 85, 560, 268);
		contentPane.add(table);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 10));
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setBounds(10, 48, 80, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 63, 80, 20);
		txtCodigo.setColumns(10);
		contentPane.add(txtCodigo);
		
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNome);
		lblNome.setBounds(90, 48, 80, 14);		
		
		txtNome = new JTextField();
		txtNome.setBounds(90, 63, 80, 20);
		txtNome.setColumns(10);
		contentPane.add(txtNome);
		
		
		lblAdmissao = new JLabel("Admiss\u00E3o");
		lblAdmissao.setFont(new Font("Arial", Font.PLAIN, 10));
		lblAdmissao.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmissao.setBounds(170, 48, 80, 14);
		contentPane.add(lblAdmissao);
		
		txtAdmissao = new JTextField();
		txtAdmissao.setBounds(170, 63, 80, 20);
		txtAdmissao.setColumns(10);
		contentPane.add(txtAdmissao);
		
				
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 10));
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setBounds(250, 48, 80, 14);
		contentPane.add(lblCpf);

		txtCPF = new JTextField();
		txtCPF.setBounds(250, 63, 80, 20);
		txtCPF.setColumns(10);
		contentPane.add(txtCPF);
		
		
		lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Arial", Font.PLAIN, 10));
		lblLogradouro.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogradouro.setBounds(330, 48, 80, 14);
		contentPane.add(lblLogradouro);
		
		txtRua = new JTextField();
		txtRua.setBounds(330, 63, 80, 20);
		txtRua.setColumns(10);
		contentPane.add(txtRua);		
		

		lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setBounds(410, 48, 80, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(410, 63, 80, 20);
		txtNumero.setColumns(10);
		contentPane.add(txtNumero);		
		

		lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 10));
		lblBairro.setHorizontalAlignment(SwingConstants.CENTER);
		lblBairro.setBounds(490, 48, 80, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(490, 63, 80, 20);
		txtBairro.setColumns(10);
		contentPane.add(txtBairro);
					
				
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 10));
		btnPesquisar.setBounds(90, 3, 80, 23);
		contentPane.add(btnPesquisar);
		
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				/*String sId_usuario = txtCodigo.getText();
				try {
					int id_usuario = Integer.parseInt(sId_usuario);
					Usuario u = dao.buscaPorCodigo(id_usuario);
					
					if (u != null) {
					txtCodigo.setText(new Integer(u.getId_usuario()).toString());
					txtNome.setText(u.getNome());
										//txtAdmissao.setText(u.getData_admissao())
					txtCPF.setText(new Integer(u.getCpf()).toString());					
					}
					
				} catch (NumberFormatException nfe) {	
					System.out.println("Código Inválido");
				}*/
			}
		});
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(10, 4, 80, 23);
		txtPesquisa.setColumns(10);
		contentPane.add(txtPesquisa);
			
		
		btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNovo.setBounds(490, 10, 80, 23);
		contentPane.add(btnNovo);
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro cadastro = new TelaCadastro();
				cadastro.setLocationRelativeTo(null);
				cadastro.setVisible(true);
			}
		});
				
		
		lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaUsuariosCad.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 582, 374);
		contentPane.add(lblFundo);
		
		//Conectando ao Banco de dados
		fabrica = PostgresqlDAOFactory.getInstancia();
		dao = fabrica.getUsuarioDAO();
	}
}
