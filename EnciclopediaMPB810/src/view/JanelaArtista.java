package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class JanelaArtista extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField txtDataNasc;
	private JTextField txtNome;
	private JTextField txtQuant_albuns;
	private JTextField txtAlbum;
	private JTextField txtLocalNasc;
	private JTextField txtDataFalecimento;

	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnFechar;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_3;
	private JPanel panel_1;
	private JTextField textDataFalecimento;

	public JanelaArtista() {

		setTitle("Enciclopédia Interativa da MPB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1147, 839);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
		
		// CORREÇÃO 1: Mudamos o layout do contentPane para BorderLayout 
		// para que possamos colar o cabeçalho no topo da tela inteira.
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// CORREÇÃO 2: Criamos um painel container no topo para segurar os botões E o título juntos
		JPanel painelSuperiorCompleto = new JPanel();
		painelSuperiorCompleto.setLayout(new GridLayout(2, 1, 0, 0)); // Divisão de 2 linhas automáticas
		contentPane.add(painelSuperiorCompleto, BorderLayout.NORTH); // Força o topo a ocupar 100% da largura
		
		JPanel panel = new JPanel();
			panel.setBackground(new Color(240, 240, 240));
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		painelSuperiorCompleto.add(panel); // Adiciona na linha 1 do topo
		
				btnCadastrar = new JButton("Cadastrar");
				panel.add(btnCadastrar);
				btnCadastrar.setFont(new Font("Noto Sans Lisu", Font.BOLD, 20));
		
				btnLimpar = new JButton("Limpar");
				panel.add(btnLimpar);
				btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
				btnLimpar.setFont(new Font("Noto Sans Lisu", Font.BOLD, 20));
		
				btnFechar = new JButton("Fechar");
				panel.add(btnFechar);
				btnFechar.setFont(new Font("Noto Sans Lisu", Font.BOLD, 20));
			
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(240, 240, 240));
				painelSuperiorCompleto.add(panel_1); // Adiciona na linha 2 do topo
			panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEnciclopedia = new JLabel("Enciclopédia Interativa da MPB");
				lblEnciclopedia.setHorizontalAlignment(SwingConstants.CENTER);
			panel_1.add(lblEnciclopedia, BorderLayout.CENTER);
				lblEnciclopedia.setForeground(Color.BLACK);
				lblEnciclopedia.setFont(new Font("Noto Sans Lisu", Font.BOLD, 30));

		// CORREÇÃO 3: Criamos um sub-painel centralizado dedicado ao seu formulário.
		// Ele mantém o layout absoluto (null) para que seus campos fiquem na posição que você desenhou.
		JPanel painelFormulario = new JPanel();
				painelFormulario.setBackground(new Color(255, 255, 255));
					painelFormulario.setLayout(null);
		contentPane.add(painelFormulario, BorderLayout.CENTER); // Preenche automaticamente todo o resto da tela
				
		JLabel lblNomeArtista = new JLabel("Nome");
			lblNomeArtista.setBounds(5, 44, 358, 65); // Ajustado a posição Y relativa ao novo painel
			lblNomeArtista.setFont(new Font("Noto Sans Lisu", Font.PLAIN, 16));
					painelFormulario.add(lblNomeArtista);
		
			txtNome = new JTextField();
			txtNome.setBounds(188, 47, 805, 65); // Ajustado a posição Y relativa ao novo painel
			txtNome.setColumns(10);
					painelFormulario.add(txtNome);

		JLabel lblDataNascimento = new JLabel("Ano de nascimento");
			lblDataNascimento.setBounds(5, 120, 358, 65);
			lblDataNascimento.setFont(new Font("Noto Sans Lisu", Font.PLAIN, 16));
					painelFormulario.add(lblDataNascimento);
								
				txtDataNasc = new JTextField();
				txtDataNasc.setBounds(188, 123, 805, 65);
				txtDataNasc.setColumns(10);
					painelFormulario.add(txtDataNasc);
						
		JLabel lblLocalNasc = new JLabel("Local de nascimento");
			lblLocalNasc.setBounds(5, 196, 358, 65);
			lblLocalNasc.setFont(new Font("Noto Sans Lisu", Font.PLAIN, 16));
					painelFormulario.add(lblLocalNasc);
				
				txtLocalNasc = new JTextField();
				txtLocalNasc.setBounds(188, 196, 805, 65);
				txtLocalNasc.setColumns(10);
					painelFormulario.add(txtLocalNasc);
		
		JLabel lblQuantAlbuns = new JLabel("Quantidade de álbuns");
			lblQuantAlbuns.setBounds(5, 272, 358, 65);
			lblQuantAlbuns.setFont(new Font("Noto Sans Lisu", Font.PLAIN, 16));
					painelFormulario.add(lblQuantAlbuns);
		
				txtQuant_albuns = new JTextField();
				txtQuant_albuns.setBounds(188, 275, 805, 65);
				txtQuant_albuns.setColumns(10);
					painelFormulario.add(txtQuant_albuns);
		
		JLabel lblDataFalecimento = new JLabel("Data de falecimento");
			lblDataFalecimento.setBounds(5, 348, 358, 65);
			lblDataFalecimento.setFont(new Font("Noto Sans Lisu", Font.PLAIN, 16));
				painelFormulario.add(lblDataFalecimento);
		
		label = new JLabel("");
		label.setBounds(-40, 486, 805, 65);
				painelFormulario.add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(810, 305, 805, 65);
				painelFormulario.add(label_1);
		
		label_3 = new JLabel("");
		label_3.setBounds(810, 370, 805, 65);
				painelFormulario.add(label_3);

		JLabel lblAlbum = new JLabel("Álbum mais popular");
			lblAlbum.setBounds(5, 435, 358, 65);
			lblAlbum.setFont(new Font("Noto Sans Lisu", Font.PLAIN, 16));
					painelFormulario.add(lblAlbum);
		
				txtAlbum = new JTextField();
				txtAlbum.setBounds(188, 438, 805, 65);
				txtAlbum.setColumns(10);
					painelFormulario.add(txtAlbum);
												
		JLabel lblArtista = new JLabel("Artista");
			lblArtista.setBounds(5, 18, 69, 28);
					painelFormulario.add(lblArtista);
			lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
			lblArtista.setFont(new Font("Noto Sans Lisu", Font.BOLD, 20));	
		
				textDataFalecimento = new JTextField();
				textDataFalecimento.setColumns(10);
				textDataFalecimento.setBounds(188, 351, 805, 65);
					painelFormulario.add(textDataFalecimento);
		
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JButton getBtnFechar() {
		return btnFechar;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtDataNasc() {
		return txtDataNasc;
	}

	public JTextField getTxtQuant_albuns() {
		return txtQuant_albuns;
	}

	public JTextField getTxtAlbum() {
		return txtAlbum;
	}

	public JTextField getTxtDataFalecimento() {
		return textDataFalecimento;
	}

	public JTextField getTxtLocalNasc() {
		return txtLocalNasc;
	}

	public void mostrarMensagem(String texto) {
		JOptionPane.showMessageDialog(this, texto);
	}

	public void mostrarErro(String texto) {
		JOptionPane.showMessageDialog(this, texto, "Atenção", JOptionPane.WARNING_MESSAGE);
	}

	public void limparCampos() {

		txtNome.setText("");
		txtDataNasc.setText("");
		txtQuant_albuns.setText("");
		txtAlbum.setText("");
		txtDataFalecimento.setText("");
		txtLocalNasc.setText("");
		txtNome.requestFocus();
	}

	public void fechar() {
		dispose();
	}
}
