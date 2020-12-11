package com.ucs.projetotematico.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;
import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;
import com.ucs.projetotematico.model.Usuario;

public class TelaCadastroUsuarios extends JFrame {

	private JPanel contentPane, panelCadastro, panelCPFeRG, panelEndereco;
	JTextField txtNome,txtEmail, txtRG, txtRua, txtBairro, txtCEP, txtCidade, txtCodigo, txtNumero;	
	
    private JLabel lblFundo, lblNumero, lblCadastroDeUsuriaos, lblNomeCompleto, lblDataDeNascimento, lblTelefone, lblEmail, lblCPF, lblRg, lblRua, lblBairro, lblCep, lblCidade, lblEstado, lblDataDeAdmissao, lblCodigo;
    private JComboBox txtEstadoCombo, txtEscalaCombo, txtSetorCombo;
    private JButton btnEditar, btnExcluir, btnSalvar, btnNovo;
	JFormattedTextField txtFone, txtCPF;
	JDateChooser txtAdmissao, txtDtNascimento;	
	private MaskFormatter mascaraAdmissao, mascaraTelefone, mascaraDtNascimento, mascaraCPF = null;
	private UsuarioDAO dao;
	private DAOFactory fabrica;	
	SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
	int flag = 0;
	private JLabel lblSetor;
	private JLabel lblEscala;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuarios frame = new TelaCadastroUsuarios();
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
	public TelaCadastroUsuarios() throws ParseException {	
		
		//Conectando ao Banco de dados
		fabrica = PostgresqlDAOFactory.getInstancia();
		dao = fabrica.getUsuarioDAO();
		
		
	
		
		setTitle("Cadastro de Usu\u00E1rios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroUsuarios.class.getResource("/img/icone32.ico")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 599, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblCadastroDeUsuriaos = new JLabel("Cadastro de Usu\u00E1rios");
		lblCadastroDeUsuriaos.setBackground(Color.WHITE);
		lblCadastroDeUsuriaos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCadastroDeUsuriaos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeUsuriaos.setBounds(0, 0, 583, 20);
		contentPane.add(lblCadastroDeUsuriaos);
				
		
		panelCadastro = new JPanel();
		panelCadastro.setBackground(Color.WHITE);
		panelCadastro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCadastro.setBounds(20, 25, 547, 351);
		panelCadastro.setLayout(null);
		contentPane.add(panelCadastro);
		
		
		lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setFont(new Font("Arial", Font.PLAIN, 9));
		lblNomeCompleto.setBounds(62, 10, 113, 14);		
		panelCadastro.add(lblNomeCompleto);	
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtNome.setBounds(62, 35, 302, 20);
		txtNome.setColumns(10);
		panelCadastro.add(txtNome);	
		
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 9));
		lblDataDeNascimento.setBounds(10, 65, 113, 14);
		panelCadastro.add(lblDataDeNascimento);
		
		// criando mascara para o campo de admissao
	    mascaraDtNascimento = new MaskFormatter("##/##/####");
		
		
		
		lblTelefone = new JLabel("Telefone:");		
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 9));
		lblTelefone.setBounds(373, 121, 149, 14);
		panelCadastro.add(lblTelefone);
		
		// criando mascara para o campo de telefone	
		mascaraTelefone = new MaskFormatter("(##)#####-####");		
		
		txtFone = new JFormattedTextField(mascaraTelefone);
		txtFone.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtFone.setSelectionStart(1);
		txtFone.setSelectionEnd(1);
		txtFone.setText("(  )     -    ");
		txtFone.setBounds(373, 146, 158, 20);
		panelCadastro.add(txtFone);
		
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 9));
		lblEmail.setBounds(10, 121, 46, 14);
		panelCadastro.add(lblEmail);	
						
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtEmail.setBounds(10, 146, 354, 20);
		txtEmail.setColumns(10);
		panelCadastro.add(txtEmail);
		
		
		panelCPFeRG = new JPanel();
		panelCPFeRG.setBackground(Color.WHITE);
		panelCPFeRG.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelCPFeRG.setBounds(372, 10, 159, 100);
		panelCPFeRG.setLayout(null);
		panelCadastro.add(panelCPFeRG);
		
		
		lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Arial", Font.PLAIN, 9));
		lblCPF.setBounds(5, 5, 46, 14);
		panelCPFeRG.add(lblCPF);
		
		mascaraCPF = new MaskFormatter("###.###.###-##");
		txtCPF = new JFormattedTextField(mascaraCPF);
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtCPF.setText("      .      .       -    ");
		txtCPF.setBounds(5, 22, 144, 20);
		panelCPFeRG.add(txtCPF);
		
		
		lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Arial", Font.PLAIN, 9));
		lblRg.setBounds(5, 50, 46, 14);
		panelCPFeRG.add(lblRg);
		
		txtRG = new JTextField();
		txtRG.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtRG.setBounds(5, 66, 144, 20);
		txtRG.setColumns(10);
		panelCPFeRG.add(txtRG);
		
		
		panelEndereco = new JPanel();
		panelEndereco.setBackground(Color.WHITE);
		panelEndereco.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelEndereco.setBounds(10, 234, 521, 105);
		panelEndereco.setLayout(null);
		panelCadastro.add(panelEndereco);
		
		lblRua = new JLabel("Logradouro:");
		lblRua.setFont(new Font("Arial", Font.PLAIN, 9));
		lblRua.setBounds(5, 5, 85, 14);
		panelEndereco.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtRua.setBounds(5, 22, 349, 20);
		txtRua.setColumns(10);
		panelEndereco.add(txtRua);
		
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 9));
		lblBairro.setBounds(5, 53, 78, 14);
		panelEndereco.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtBairro.setBounds(5, 70, 256, 20);
		txtBairro.setColumns(10);
		panelEndereco.add(txtBairro);
		
		
		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 9));
		lblCep.setBounds(434, 6, 46, 14);
		panelEndereco.add(lblCep);
		
		txtCEP = new JTextField();
		txtCEP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtCEP.setBounds(434, 22, 80, 20);		
		txtCEP.setColumns(10);
		panelEndereco.add(txtCEP);
		
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 9));
		lblCidade.setBounds(271, 53, 54, 14);
		panelEndereco.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtCidade.setBounds(271, 69, 179, 20);
		txtCidade.setColumns(10);
		panelEndereco.add(txtCidade);
		
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 9));
		lblEstado.setBounds(460, 53, 54, 14);
		panelEndereco.add(lblEstado);
		
		txtEstadoCombo = new JComboBox();
		txtEstadoCombo.setBackground(Color.WHITE);
		txtEstadoCombo.setFont(new Font("Arial", Font.PLAIN, 9));
		txtEstadoCombo.setModel(new DefaultComboBoxModel(new String[] {"--", "RS", "SC", "PR", "SP", "RJ", "ES", "MT"}));
		txtEstadoCombo.setBounds(460, 69, 54, 20);
		panelEndereco.add(txtEstadoCombo);
		
		lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 9));
		lblNumero.setBounds(364, 6, 46, 14);
		panelEndereco.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtNumero.setBounds(364, 22, 60, 20);
		panelEndereco.add(txtNumero);
		txtNumero.setColumns(10);
		
		
		lblDataDeAdmissao = new JLabel("Data de Admiss\u00E3o:");
		lblDataDeAdmissao.setFont(new Font("Arial", Font.PLAIN, 9));
		lblDataDeAdmissao.setBounds(205, 66, 95, 14);
		panelCadastro.add(lblDataDeAdmissao);
		
		
		// criando mascara para o campo de admissao
		 mascaraAdmissao = new MaskFormatter("##/##/####");
		
		
		lblCodigo = new JLabel("Matricula:");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 9));
		lblCodigo.setBounds(10, 10, 46, 14);
		panelCadastro.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtCodigo.setBounds(10, 35, 46, 20);
		txtCodigo.setColumns(10);
		txtCodigo.setEnabled(false);
		panelCadastro.add(txtCodigo);		
		
		txtAdmissao = new JDateChooser();
		txtAdmissao.setBounds(205, 90, 159, 20);
		panelCadastro.add(txtAdmissao);
		
		txtDtNascimento = new JDateChooser();
		txtDtNascimento.setBounds(10, 90, 159, 20);
		panelCadastro.add(txtDtNascimento);
		
		lblSetor = new JLabel("Setor:");
		lblSetor.setFont(new Font("Arial", Font.PLAIN, 9));
		lblSetor.setBounds(10, 178, 46, 14);
		panelCadastro.add(lblSetor);
		
		lblEscala = new JLabel("Escala:");
		lblEscala.setFont(new Font("Arial", Font.PLAIN, 9));
		lblEscala.setBounds(373, 178, 155, 14);
		panelCadastro.add(lblEscala);
		
		txtSetorCombo = new JComboBox();
		txtSetorCombo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtSetorCombo.setModel(new DefaultComboBoxModel(new String[] {"--", "Comercial", "Administrativo"}));
		txtSetorCombo.setBackground(Color.WHITE);
		txtSetorCombo.setBounds(10, 203, 354, 20);
		panelCadastro.add(txtSetorCombo);
		
		txtEscalaCombo = new JComboBox();
		txtEscalaCombo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtEscalaCombo.setModel(new DefaultComboBoxModel(new String[] {"--", "8:00 -12:00 \u00E0s 13:30 - 18:18"}));
		txtEscalaCombo.setBounds(373, 203, 158, 20);
		panelCadastro.add(txtEscalaCombo);
				
	
		btnEditar = new JButton("");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 1;
				System.out.println("Entrou em editar e recebeu 1=" + flag);
								
				txtCodigo.setEnabled(false);
				txtNome.setEnabled(true);
				txtAdmissao.setEnabled(true);
				txtDtNascimento.setEnabled(true);
				txtFone.setEnabled(true);
				txtEmail.setEnabled(true);		
				txtCPF.setEnabled(true);
				txtRG.setEnabled(true);
				txtSetorCombo.setEnabled(true);
				txtEscalaCombo.setEnabled(true);
				txtEstadoCombo.setEnabled(true);
				txtRua.setEnabled(true);
				txtNumero.setEnabled(true);
				txtCEP.setEnabled(true);
				txtBairro.setEnabled(true);
				txtCidade.setEnabled(true);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnSalvar.setEnabled(true);
				 
			}
		});
		
		btnEditar.setBackground(SystemColor.menu);
		btnEditar.setBorder(null);
		btnEditar.setIcon(new ImageIcon(TelaCadastroUsuarios.class.getResource("/img/IconBotaoEditar.ico")));
		btnEditar.setBounds(451, 387, 32, 32);
		contentPane.add(btnEditar);
		
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnEditar.setEnabled(false);
				//btnExcluir.setEnabled(false);
			/*	Usuario usuario = new Usuario();							
				usuario.setId_usuario(Integer.parseInt(txtCodigo.getText()));	
				dao.apagar(usuario);*/
				int codigo = Integer.parseInt(txtCodigo.getText());
				dao.removeUsuario(codigo);
				dispose();
				
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBackground(SystemColor.menu);
		btnExcluir.setBorder(null);
		btnExcluir.setIcon(new ImageIcon(TelaCadastroUsuarios.class.getResource("/img/IconBotaoExcluir.ico")));
		btnExcluir.setBounds(493, 387, 32, 32);
		contentPane.add(btnExcluir);
		
		btnSalvar = new JButton("");		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(flag==0) {
			  System.out.println("Entrou em salvar e recebeu 0= " + flag); // teste
				Usuario usuario = new Usuario();							
				usuario.setNome(txtNome.getText());	
				usuario.setData_admissao(txtAdmissao.getDate());	
				usuario.setData_nascimento(txtDtNascimento.getDate());	
				usuario.setTelefone(txtFone.getText());
				usuario.setEmail(txtEmail.getText());
				usuario.setCpf(txtCPF.getText());
				usuario.setRg(txtRG.getText());	
				usuario.setDes_rua(txtRua.getText());
				usuario.setDes_bairro(txtBairro.getText());
				usuario.setDes_cidade(txtCidade.getText());	
				usuario.setNumero(Integer.parseInt(txtNumero.getText()));	
				usuario.setCep(Integer.parseInt(txtCEP.getText()));	
				usuario.setDes_estado((String) txtEstadoCombo.getSelectedItem());	
				usuario.setDes_setor((String) txtSetorCombo.getSelectedItem());	
				usuario.setDes_escala((String) txtEscalaCombo.getSelectedItem());	
				dao.salvar(usuario);	
				dispose();
				} 
				else{
				System.out.println("Laço =! 0 em editar e recebeu 1=" + flag); // teste

				
				//desabilita botoes
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
				
				Usuario usuario = new Usuario();
				usuario.setNome(txtNome.getText());	
				usuario.setData_admissao(txtAdmissao.getDate());	
				usuario.setData_nascimento(txtDtNascimento.getDate());	
				usuario.setTelefone(txtFone.getText());
				usuario.setEmail(txtEmail.getText());
				usuario.setCpf(txtCPF.getText());
				usuario.setRg(txtRG.getText());	
				usuario.setDes_rua(txtRua.getText());
				usuario.setDes_bairro(txtBairro.getText());
				usuario.setDes_cidade(txtCidade.getText());	
				usuario.setNumero(Integer.parseInt(txtNumero.getText()));	
				usuario.setCep(Integer.parseInt(txtCEP.getText()));	
				usuario.setDes_estado((String) txtEstadoCombo.getSelectedItem());	
				usuario.setDes_setor((String) txtSetorCombo.getSelectedItem());	
				usuario.setDes_escala((String) txtEscalaCombo.getSelectedItem());	
				usuario.setId_usuario(Integer.parseInt(txtCodigo.getText()));
				
				dao.alterar(usuario);
				dispose();
			}
			}
		});
		
		btnSalvar.setBackground(SystemColor.menu);
		btnSalvar.setBorder(null);
		btnSalvar.setIcon(new ImageIcon(TelaCadastroUsuarios.class.getResource("/img/IconBotaoSalvar.ico")));
		btnSalvar.setBounds(535, 387, 32, 32);
		contentPane.add(btnSalvar);
		
		/* btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    flag = 1;
				    System.out.println("Entrou e recebeu 1 =" + flag); // teste
					txtCodigo.setEnabled(false);
					txtNome.setEnabled(true);
					txtAdmissao.setEnabled(true);
					txtDtNascimento.setEnabled(true);
					txtFone.setEnabled(true);
					txtEmail.setEnabled(true);		
					txtCPF.setEnabled(true);
					txtRG.setEnabled(true);
					txtRua.setEnabled(true);
					txtNumero.setEnabled(true);
					txtCEP.setEnabled(true);
					txtBairro.setEnabled(true);
					txtCidade.setEnabled(true);
			}
		});
		btnNovo.setBounds(30, 327, 89, 23);
		contentPane.add(btnNovo);
		*/
		
		lblFundo = new JLabel("");
		lblFundo.setBackground(Color.WHITE);
		lblFundo.setIcon(new ImageIcon(TelaCadastroUsuarios.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(0, -46, 601, 550);
		contentPane.add(lblFundo);	
		
		
	}
	
	public void preencheDados(MouseAdapter mouseAdapter, String cod){
		
		String sCodigo = cod;
		int codigo = Integer.parseInt(sCodigo);
		Usuario u = dao.buscaPorCodigo(codigo);	
		
			//Preenche os campos com as informações das linha selecionada no "JFrameTabela"
			//String sCodigo = txtCodigo.getText();		
			//int codigo = Integer.parseInt(sCodigo);
			//Usuario u = dao.buscaPorCodigo(codigo);	
			if(u != null) {
				//Habilita os botoes
				btnEditar.setEnabled(true); 
				btnExcluir.setEnabled(true);
				btnSalvar.setEnabled(false);
				
				txtCodigo.setText(new Integer(u.getId_usuario()).toString());
				txtNome.setText(u.getNome());					
				txtAdmissao.setDate( u.getData_admissao());
				txtDtNascimento.setDate(u.getData_nascimento());
				txtFone.setText(u.getTelefone());
				txtEmail.setText(u.getEmail());			
				txtCPF.setText(u.getCpf());
				txtRG.setText(u.getRg());
				txtRua.setText(u.getDes_rua());
				txtBairro.setText(u.getDes_bairro());
				txtCidade.setText(u.getDes_cidade());
				txtNumero.setText(new Integer(u.getNumero()).toString());
				txtCEP.setText(new Integer(u.getCep()).toString());				
				txtEstadoCombo.setSelectedItem(u.getDes_estado());
				txtSetorCombo.setSelectedItem(u.getDes_setor());
				txtEscalaCombo.setSelectedItem(u.getDes_escala());
				
				//Deixa os campos da tela bloqueados
				txtCodigo.setEnabled(false);
				txtNome.setEnabled(false);
				txtAdmissao.setEnabled(false);
				txtDtNascimento.setEnabled(false);
				txtFone.setEnabled(false);
				txtEmail.setEnabled(false);		
				txtCPF.setEnabled(false);
				txtRG.setEnabled(false);
				txtRua.setEnabled(false);
				txtNumero.setEnabled(false);
				txtCEP.setEnabled(false);
				txtBairro.setEnabled(false);
				txtCidade.setEnabled(false);
				txtEstadoCombo.setEnabled(false);
				txtSetorCombo.setEnabled(false);
				txtEscalaCombo.setEnabled(false);
	    }
	
	}
}
	

	
		
		
		
	
	

