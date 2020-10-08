package com.ucs.projetotematico.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDtNascimento;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtRG;
	private JTextField txtRua;
	private JTextField textField_1;
	private JTextField txtCEP;
	private JTextField txtCidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastro.class.getResource("/img/icone32.ico")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 358);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBackground(Color.WHITE);
		panelCadastro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCadastro.setBounds(10, 36, 517, 231);
		contentPane.add(panelCadastro);
		panelCadastro.setLayout(null);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Arial", Font.PLAIN, 9));
		lblNomeCompleto.setBounds(10, 11, 113, 14);
		panelCadastro.add(lblNomeCompleto);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 28, 341, 20);
		panelCadastro.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 9));
		lblDataDeNascimento.setBounds(379, 11, 113, 14);
		panelCadastro.add(lblDataDeNascimento);
		
		txtDtNascimento = new JTextField();
		txtDtNascimento.setBounds(379, 28, 128, 20);
		panelCadastro.add(txtDtNascimento);
		txtDtNascimento.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 9));
		lblTelefone.setBounds(10, 59, 70, 14);
		panelCadastro.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 9));
		lblEmail.setBounds(180, 59, 46, 14);
		panelCadastro.add(lblEmail);
		
		txtFone = new JTextField();
		txtFone.setBounds(10, 84, 147, 20);
		panelCadastro.add(txtFone);
		txtFone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(180, 84, 327, 20);
		panelCadastro.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel panelCPFeRG = new JPanel();
		panelCPFeRG.setBackground(Color.WHITE);
		panelCPFeRG.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelCPFeRG.setBounds(10, 116, 147, 93);
		panelCadastro.add(panelCPFeRG);
		panelCPFeRG.setLayout(null);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Arial", Font.PLAIN, 9));
		lblCPF.setBounds(5, 5, 46, 14);
		panelCPFeRG.add(lblCPF);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(5, 22, 127, 20);
		panelCPFeRG.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Arial", Font.PLAIN, 9));
		lblRg.setBounds(5, 50, 46, 14);
		panelCPFeRG.add(lblRg);
		
		txtRG = new JTextField();
		txtRG.setBounds(5, 66, 127, 20);
		panelCPFeRG.add(txtRG);
		txtRG.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(167, 116, 340, 93);
		panelCadastro.add(panel);
		panel.setLayout(null);
		
		JLabel lblEndereo = new JLabel("Logradouro:");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 9));
		lblEndereo.setBounds(5, 5, 85, 14);
		panel.add(lblEndereo);
		
		txtRua = new JTextField();
		txtRua.setBounds(5, 22, 167, 20);
		panel.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 9));
		lblBairro.setBounds(194, 11, 78, 14);
		panel.add(lblBairro);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 22, 120, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 9));
		lblCep.setBounds(5, 50, 46, 14);
		panel.add(lblCep);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 9));
		lblCidade.setBounds(122, 50, 54, 14);
		panel.add(lblCidade);
		
		JLabel lblUf = new JLabel("Estado:");
		lblUf.setFont(new Font("Arial", Font.PLAIN, 9));
		lblUf.setBounds(244, 50, 60, 14);
		panel.add(lblUf);
		
		txtCEP = new JTextField();
		txtCEP.setBounds(5, 66, 100, 20);
		panel.add(txtCEP);
		txtCEP.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(119, 66, 86, 20);
		panel.add(txtCidade);
		txtCidade.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 9));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--", "RS", "SC", "PR", "SP", "RJ", "ES", "MT"}));
		comboBox.setBounds(244, 66, 54, 20);
		panel.add(comboBox);
		
		JButton btnEditar = new JButton("");
		btnEditar.setBackground(SystemColor.menu);
		btnEditar.setBorder(null);
		btnEditar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/img/IconBotaoEditar.ico")));
		btnEditar.setBounds(411, 278, 32, 32);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setBackground(SystemColor.menu);
		btnExcluir.setBorder(null);
		btnExcluir.setIcon(new ImageIcon(TelaCadastro.class.getResource("/img/IconBotaoExcluir.ico")));
		btnExcluir.setBounds(453, 278, 32, 32);
		contentPane.add(btnExcluir);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setBackground(SystemColor.menu);
		btnSalvar.setBorder(null);
		btnSalvar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/img/IconBotaoSalvar.ico")));
		btnSalvar.setBounds(495, 278, 32, 32);
		contentPane.add(btnSalvar);
		
		JLabel lblCadastroDeUsuriaos = new JLabel("Cadastro de Usu\u00E1rios");
		lblCadastroDeUsuriaos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCadastroDeUsuriaos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeUsuriaos.setBounds(21, 11, 517, 14);
		contentPane.add(lblCadastroDeUsuriaos);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaCadastro.class.getResource("/img/fundo2.jpg")));
		label.setBounds(0, 0, 538, 340);
		contentPane.add(label);
	}
}
