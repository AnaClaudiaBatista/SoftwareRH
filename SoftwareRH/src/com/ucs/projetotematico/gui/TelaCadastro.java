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

	private JPanel contentPane, panelCadastro, panelCPFeRG, panelEndereco;
	private JTextField txtNome, txtDtNascimento, txtFone, txtEmail, txtCPF, txtRG, txtRua, txtBairro, txtCEP, txtCidade, txtCodigo, txtAdmissao;
    private JLabel lblFundo, lblCadastroDeUsuriaos, lblNomeCompleto, lblDataDeNascimento, lblTelefone, lblEmail, lblCPF, lblRg, lblRua, lblBairro, lblCep, lblCidade, lblEstado, lblDataDeAdmissao, lblCodigo;
    private JComboBox comboEstado;
    private JButton btnEditar, btnExcluir, btnSalvar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {		
		
		setTitle("Cadastro de Usu\u00E1rios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastro.class.getResource("/img/icone32.ico")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 569, 400);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblCadastroDeUsuriaos = new JLabel("Cadastro de Usu\u00E1rios");
		lblCadastroDeUsuriaos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCadastroDeUsuriaos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeUsuriaos.setBounds(10, 0, 517, 23);
		contentPane.add(lblCadastroDeUsuriaos);
				
		
		panelCadastro = new JPanel();
		panelCadastro.setBackground(Color.WHITE);
		panelCadastro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCadastro.setBounds(20, 34, 517, 282);
		panelCadastro.setLayout(null);
		contentPane.add(panelCadastro);
		
		
		lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Arial", Font.PLAIN, 9));
		lblNomeCompleto.setBounds(10, 66, 113, 14);		
		panelCadastro.add(lblNomeCompleto);	
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 91, 341, 20);
		txtNome.setColumns(10);
		panelCadastro.add(txtNome);	
		
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 9));
		lblDataDeNascimento.setBounds(378, 66, 113, 14);
		panelCadastro.add(lblDataDeNascimento);
		
		txtDtNascimento = new JTextField();
		txtDtNascimento.setBounds(378, 91, 128, 20);
		txtDtNascimento.setColumns(10);
		panelCadastro.add(txtDtNascimento);
		
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 9));
		lblTelefone.setBounds(10, 122, 70, 14);
		panelCadastro.add(lblTelefone);
		
		txtFone = new JTextField();
		txtFone.setBounds(10, 147, 147, 20);
		txtFone.setColumns(10);
		panelCadastro.add(txtFone);	
		
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 9));
		lblEmail.setBounds(169, 122, 46, 14);
		panelCadastro.add(lblEmail);	
						
		txtEmail = new JTextField();
		txtEmail.setBounds(166, 147, 340, 20);
		txtEmail.setColumns(10);
		panelCadastro.add(txtEmail);
		
		
		panelCPFeRG = new JPanel();
		panelCPFeRG.setBackground(Color.WHITE);
		panelCPFeRG.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelCPFeRG.setBounds(10, 178, 147, 93);
		panelCPFeRG.setLayout(null);
		panelCadastro.add(panelCPFeRG);
		
		
		lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Arial", Font.PLAIN, 9));
		lblCPF.setBounds(5, 5, 46, 14);
		panelCPFeRG.add(lblCPF);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(5, 22, 127, 20);
		txtCPF.setColumns(10);
		panelCPFeRG.add(txtCPF);
		
		
		lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Arial", Font.PLAIN, 9));
		lblRg.setBounds(5, 50, 46, 14);
		panelCPFeRG.add(lblRg);
		
		txtRG = new JTextField();
		txtRG.setBounds(5, 66, 127, 20);
		txtRG.setColumns(10);
		panelCPFeRG.add(txtRG);
		
		
		panelEndereco = new JPanel();
		panelEndereco.setBackground(Color.WHITE);
		panelEndereco.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelEndereco.setBounds(167, 178, 340, 93);
		panelEndereco.setLayout(null);
		panelCadastro.add(panelEndereco);
		
		lblRua = new JLabel("Logradouro:");
		lblRua.setFont(new Font("Arial", Font.PLAIN, 9));
		lblRua.setBounds(5, 5, 85, 14);
		panelEndereco.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setBounds(5, 22, 200, 20);
		txtRua.setColumns(10);
		panelEndereco.add(txtRua);
		
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 9));
		lblBairro.setBounds(214, 5, 78, 14);
		panelEndereco.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(214, 22, 116, 20);
		txtBairro.setColumns(10);
		panelEndereco.add(txtBairro);
		
		
		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 9));
		lblCep.setBounds(5, 50, 46, 14);
		panelEndereco.add(lblCep);
		
		txtCEP = new JTextField();
		txtCEP.setBounds(5, 66, 100, 20);		
		txtCEP.setColumns(10);
		panelEndereco.add(txtCEP);
		
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 9));
		lblCidade.setBounds(113, 50, 54, 14);
		panelEndereco.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(113, 66, 90, 20);
		txtCidade.setColumns(10);
		panelEndereco.add(txtCidade);
		
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 9));
		lblEstado.setBounds(214, 50, 60, 14);
		panelEndereco.add(lblEstado);
		
		comboEstado = new JComboBox();
		comboEstado.setBackground(SystemColor.menu);
		comboEstado.setFont(new Font("Arial", Font.PLAIN, 9));
		comboEstado.setModel(new DefaultComboBoxModel(new String[] {"--", "RS", "SC", "PR", "SP", "RJ", "ES", "MT"}));
		comboEstado.setBounds(214, 66, 54, 20);
		panelEndereco.add(comboEstado);
		
		
		lblDataDeAdmissao = new JLabel("Data de Admiss\u00E3o:");
		lblDataDeAdmissao.setFont(new Font("Arial", Font.PLAIN, 9));
		lblDataDeAdmissao.setBounds(204, 10, 95, 14);
		panelCadastro.add(lblDataDeAdmissao);
		
		txtAdmissao = new JTextField();
		txtAdmissao.setBounds(204, 35, 147, 20);
		txtAdmissao.setColumns(10);
		panelCadastro.add(txtAdmissao);
		
		
		lblCodigo = new JLabel("Matricula:");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 9));
		lblCodigo.setBounds(10, 10, 46, 14);
		panelCadastro.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 35, 147, 20);
		txtCodigo.setColumns(10);
		panelCadastro.add(txtCodigo);		
		
	
		btnEditar = new JButton("");
		btnEditar.setBackground(SystemColor.menu);
		btnEditar.setBorder(null);
		btnEditar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/img/IconBotaoEditar.ico")));
		btnEditar.setBounds(411, 318, 32, 32);
		contentPane.add(btnEditar);
		
		btnExcluir = new JButton("");
		btnExcluir.setBackground(SystemColor.menu);
		btnExcluir.setBorder(null);
		btnExcluir.setIcon(new ImageIcon(TelaCadastro.class.getResource("/img/IconBotaoExcluir.ico")));
		btnExcluir.setBounds(453, 318, 32, 32);
		contentPane.add(btnExcluir);
		
		btnSalvar = new JButton("");
		btnSalvar.setBackground(SystemColor.menu);
		btnSalvar.setBorder(null);
		btnSalvar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/img/IconBotaoSalvar.ico")));
		btnSalvar.setBounds(495, 318, 32, 32);
		contentPane.add(btnSalvar);
		
		lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaCadastro.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 570, 377);
		contentPane.add(lblFundo);	
		
		
	}
}
