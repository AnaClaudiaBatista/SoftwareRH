package com.ucs.projetotematico.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaUsuariosCad extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuariosCad frame = new TelaUsuariosCad();
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
		setBounds(100, 100, 587, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "Admissão", "CPF", "Logradouro", "Número", "Bairro"},
			},
			new String[] {
			    "Nome", "Admissao", "CPF", "Logradouro", "Numero", "Bairro"
			}
		));
		table.setBounds(0, 75, 561, 289);
		contentPane.add(table);
	}
}
