package com.ucs.projetotematico.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;
import com.ucs.projetotematico.dao.DAOFactory;
import com.ucs.projetotematico.dao.PontoDAO;
import com.ucs.projetotematico.dao.UsuarioDAO;
import com.ucs.projetotematico.dao.postgresql.PostgresqlDAOFactory;
import com.ucs.projetotematico.model.Ponto;
import com.ucs.projetotematico.model.Usuario;

public class TelaCadastroPonto extends JFrame {

	private JPanel contentPane, panelCadastro,panelManha, panelTarde;
    private JLabel lblFundo, lblCadastroDoPonto,lblData,lblManhaEntrada, lblManhaSaida, lblTardeEntrada,lblTardeSaida;
    private MaskFormatter mascaraData, mascaraHr;	
	private JTextField txtCodigo, txtNome;
	private JButton btnEditar, btnExcluir, btnSalvar, btnPesquisar, btnVoltaDia,btnVoltaMes, btnAvancaDia, btnAvancaMes;
	private JFormattedTextField txtManhaSaida,txtManhaEntrada, txtTardeEntrada,txtTardeSaida;
	SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");	
	//SimpleDateFormat horaformatada = new SimpleDateFormat("HH:mm");
	DecimalFormat  horaformatada = new DecimalFormat ("00,00");
	private PontoDAO pontoDAO;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
	private DAOFactory fabrica;	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPonto frame = new TelaCadastroPonto();
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
	public TelaCadastroPonto() throws ParseException {		
		//Conectando ao Banco de dados
		fabrica = PostgresqlDAOFactory.getInstancia();
		pontoDAO = fabrica.getPontoDAO();
		usuarioDAO = fabrica.getUsuarioDAO();

		
	
		
		setTitle("Cadastro do Ponto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroPonto.class.getResource("/img/icone32.ico")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 447, 401);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblCadastroDoPonto = new JLabel("Cadastro do Ponto");
		lblCadastroDoPonto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCadastroDoPonto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDoPonto.setBounds(20, 0, 400, 32);
		contentPane.add(lblCadastroDoPonto);
				
		
		panelCadastro = new JPanel();
		panelCadastro.setBackground(Color.WHITE);
		panelCadastro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCadastro.setBounds(20, 34, 400, 273);
		panelCadastro.setLayout(null);
		contentPane.add(panelCadastro);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// adicionando o click do botao para etrar apenas clicando em Enter
					btnPesquisar.doClick();
			}
		}});
		txtCodigo.setBounds(10, 11, 73, 20);
		panelCadastro.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(93, 11, 270, 20);
		panelCadastro.add(txtNome);
		txtNome.setColumns(10);
		
		btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sCodigo = txtCodigo.getText();		
				int codigo = Integer.parseInt(sCodigo);
				Usuario u = usuarioDAO.buscaPorCodigo(codigo);	
				if(u != null) {
				txtCodigo.setText(new Integer(u.getId_usuario()).toString());
				txtNome.setText(u.getNome());
				}
			}
		});
		btnPesquisar.setBackground(SystemColor.text);
		btnPesquisar.setIcon(new ImageIcon(TelaCadastroPonto.class.getResource("/img/lupa16.ico")));
		btnPesquisar.setBounds(370, 11, 20, 20);
		panelCadastro.add(btnPesquisar);
		
		lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(174, 42, 46, 14);
		panelCadastro.add(lblData);
		
		btnVoltaDia = new JButton("");
		btnVoltaDia.setBorder(null);
		btnVoltaDia.setIcon(new ImageIcon(TelaCadastroPonto.class.getResource("/img/voltaDia16.ico")));
		btnVoltaDia.setBackground(SystemColor.text);
		btnVoltaDia.setBounds(128, 66, 18, 18);
		panelCadastro.add(btnVoltaDia);
		
		btnVoltaMes = new JButton("");
		btnVoltaMes.setBorder(null);
		btnVoltaMes.setIcon(new ImageIcon(TelaCadastroPonto.class.getResource("/img/voltaMes16.ico")));
		btnVoltaMes.setBackground(SystemColor.text);
		btnVoltaMes.setBounds(105, 66, 18, 18);
		panelCadastro.add(btnVoltaMes);
		
		btnAvancaDia = new JButton("");
		btnAvancaDia.setBorder(null);
		btnAvancaDia.setIcon(new ImageIcon(TelaCadastroPonto.class.getResource("/img/avancaDia16.ico")));
		btnAvancaDia.setBackground(SystemColor.text);
		btnAvancaDia.setBounds(250, 65, 18, 18);
		panelCadastro.add(btnAvancaDia);
		
		btnAvancaMes = new JButton("");
		btnAvancaMes.setBorder(null);
		btnAvancaMes.setIcon(new ImageIcon(TelaCadastroPonto.class.getResource("/img/avancaMes16.ico")));
		btnAvancaMes.setBackground(SystemColor.text);
		btnAvancaMes.setBounds(275, 65, 18, 18);
		panelCadastro.add(btnAvancaMes);
		
		panelManha = new JPanel();
		panelManha.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panelManha.setBackground(SystemColor.text);
		panelManha.setBorder(new TitledBorder(null, "Manh\u00E3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelManha.setBounds(45, 97, 150, 159);
		panelCadastro.add(panelManha);
		panelManha.setLayout(null);
		
		lblManhaSaida = new JLabel("Sa\u00EDda:");
		lblManhaSaida.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblManhaSaida.setBounds(10, 84, 42, 14);
		panelManha.add(lblManhaSaida);
		
		lblManhaEntrada = new JLabel("Entrada:");
		lblManhaEntrada.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblManhaEntrada.setBounds(10, 32, 42, 14);
		panelManha.add(lblManhaEntrada);
		
		mascaraData = new MaskFormatter("##/##/####");
		
		mascaraHr = new MaskFormatter("##:##");
		
		txtManhaEntrada = new JFormattedTextField();
		txtManhaEntrada.setBounds(30, 53, 86, 20);
		panelManha.add(txtManhaEntrada);
		
		txtManhaSaida = new JFormattedTextField();
		txtManhaSaida.setBounds(30, 103, 86, 20);
		panelManha.add(txtManhaSaida);
		
			
		
		panelTarde = new JPanel();
		panelTarde.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panelTarde.setBorder(new TitledBorder(null, "Tarde", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelTarde.setBackground(SystemColor.text);
		panelTarde.setBounds(205, 97, 150, 159);
		panelCadastro.add(panelTarde);
		panelTarde.setLayout(null);
		
		lblTardeEntrada = new JLabel("Entrada:");
		lblTardeEntrada.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTardeEntrada.setBounds(10, 32, 42, 14);
		panelTarde.add(lblTardeEntrada);
		
		lblTardeSaida = new JLabel("Sa\u00EDda:");
		lblTardeSaida.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTardeSaida.setBounds(10, 84, 42, 14);
		panelTarde.add(lblTardeSaida);
				
		txtTardeEntrada = new JFormattedTextField();
		txtTardeEntrada.setBounds(30, 53, 86, 20);
		panelTarde.add(txtTardeEntrada);
		
		txtTardeSaida = new JFormattedTextField();
		txtTardeSaida.setBounds(30, 103, 86, 20);
		panelTarde.add(txtTardeSaida);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(147, 64, 103, 20);
		panelCadastro.add(dateChooser);
		
		
		btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "teste");
			}
		});
		
		btnEditar.setBackground(SystemColor.menu);
		btnEditar.setBorder(null);
		btnEditar.setIcon(new ImageIcon(TelaCadastroPonto.class.getResource("/img/IconBotaoEditar.ico")));
		btnEditar.setBounds(299, 318, 32, 32);
		contentPane.add(btnEditar);
		
		btnExcluir = new JButton("");
		btnExcluir.setBackground(SystemColor.menu);
		btnExcluir.setBorder(null);
		btnExcluir.setIcon(new ImageIcon(TelaCadastroPonto.class.getResource("/img/IconBotaoExcluir.ico")));
		btnExcluir.setBounds(344, 318, 32, 32);
		contentPane.add(btnExcluir);
		
		btnSalvar = new JButton("");		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ponto ponto = new Ponto();
				// para formatar a data em formato brasileiro
				
				// vai pegar o formato brasileiro  e converter para o estrangeiro
					ponto.setId_usuario(Integer.parseInt(txtCodigo.getText()));
				/*try {	
					ponto.setDta_registro(dataFormatada.parse(txtData.getText()));					
				} catch (ParseException e1) {
					JOptionPane.showConfirmDialog(null, "Data IncorretA!" + e1);
				}*/
				ponto.setDta_registro(dateChooser.getDate());			
				ponto.setManha_inicio(Double.parseDouble(txtManhaEntrada.getText()));
				ponto.setManha_final(Double.parseDouble(txtManhaSaida.getText()));
				ponto.setTarde_inicio(Double.parseDouble(txtTardeEntrada.getText()));
				ponto.setTarde_final(Double.parseDouble(txtTardeSaida.getText()));
					
				pontoDAO.inserePonto(ponto);	
				
			}
		});
		btnSalvar.setBackground(SystemColor.menu);
		btnSalvar.setBorder(null);
		btnSalvar.setIcon(new ImageIcon(TelaCadastroPonto.class.getResource("/img/IconBotaoSalvar.ico")));
		btnSalvar.setBounds(389, 318, 32, 32);
		contentPane.add(btnSalvar);
		
		lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaCadastroPonto.class.getResource("/img/fundo2.jpg")));
		lblFundo.setBounds(0, 0, 453, 362);
		contentPane.add(lblFundo);	
		
		
	}


	private void showMessage(String titulo, String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem, titulo,JOptionPane.ERROR_MESSAGE);
	}
}
	
	
	
	
		
		
		
	
	

