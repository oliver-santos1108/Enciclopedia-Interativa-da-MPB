
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

public class JanelaArtista extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtDataNasc;
    private JTextField txtNome;
    private JTextField txtQuant_albuns;
    private JTextField txtAlbum;
    private JTextField txtDataFalecimento;
    private JTextField txtLocalNasc;

    private JButton btnCadastrar;
    private JButton btnLimpar;
    private JButton btnFechar;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private JLabel label_7;
    private JLabel label_9;
    private JLabel label_10;
    private JLabel label_11;
    private JLabel label_12;
    private JLabel label_13;
    private JLabel label_16;
    private JLabel label_17;
    private JLabel label_6;

    public JanelaArtista() {

        setTitle("Enciclopédia Interativa da MPB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 533, 676);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 5, 0, 0));
        
        label = new JLabel("");
        contentPane.add(label);
        
        label_1 = new JLabel("");
        contentPane.add(label_1);
        
                JLabel lblEnciclopedia = new JLabel(
                        "Enciclopédia Interativa da MPB");
                lblEnciclopedia.setBackground(new Color(255, 255, 255));
                lblEnciclopedia.setForeground(Color.BLACK);
                lblEnciclopedia.setFont(
                        new Font("Noto Sans Lisu", Font.BOLD, 30));
                contentPane.add(lblEnciclopedia);
        
        label_2 = new JLabel("");
        contentPane.add(label_2);
        
        label_3 = new JLabel("");
        contentPane.add(label_3);
        
        label_4 = new JLabel("");
        contentPane.add(label_4);
        
        label_5 = new JLabel("");
        contentPane.add(label_5);
        
                JLabel lblDataFalecimento = new JLabel(
                        "Data de falecimento");
                lblDataFalecimento.setFont(new Font("Noto Sans Lisu", Font.BOLD, 20));
                lblDataFalecimento.setHorizontalAlignment(SwingConstants.CENTER);
                contentPane.add(lblDataFalecimento);
                        
                                JLabel lblNomeArtista = new JLabel("Nome");
                                lblNomeArtista.setHorizontalAlignment(SwingConstants.CENTER);
                                lblNomeArtista.setFont(
                                        new Font("Noto Sans Lisu", Font.BOLD, 20));
                                contentPane.add(lblNomeArtista);
        
                JLabel lblArtista = new JLabel("Artista");
                lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
                lblArtista.setFont(
                        new Font("Noto Sans Lisu", Font.BOLD, 20));
                contentPane.add(lblArtista);
        
        label_7 = new JLabel("");
        contentPane.add(label_7);
        
        label_9 = new JLabel("");
        contentPane.add(label_9);
                                                
                                                        JLabel lblQuantAlbuns = new JLabel(
                                                                "Quantidade de álbuns");
                                                        lblQuantAlbuns.setFont(new Font("Noto Sans Lisu", Font.BOLD, 20));
                                                        lblQuantAlbuns.setHorizontalAlignment(SwingConstants.CENTER);
                                                        contentPane.add(lblQuantAlbuns);
                                        
                                                JLabel lblDataNascimento = new JLabel(
                                                        "Ano de nascimento");
                                                lblDataNascimento.setHorizontalAlignment(SwingConstants.CENTER);
                                                lblDataNascimento.setFont(
                                                        new Font("Noto Sans Lisu", Font.BOLD, 20));
                                                contentPane.add(lblDataNascimento);
                                
                                        txtAlbum = new JTextField();
                                        txtAlbum.setColumns(10);
                                        contentPane.add(txtAlbum);
                        
                                txtQuant_albuns = new JTextField();
                                txtQuant_albuns.setColumns(10);
                                contentPane.add(txtQuant_albuns);
                
                        JLabel lblLocalNasc = new JLabel(
                                "Local de nascimento");
                        lblLocalNasc.setFont(new Font("Noto Sans Lisu", Font.BOLD, 20));
                        lblLocalNasc.setHorizontalAlignment(SwingConstants.CENTER);
                        contentPane.add(lblLocalNasc);
        
        label_10 = new JLabel("");
        contentPane.add(label_10);
                
                        JLabel lblAlbum = new JLabel(
                                "Álbum mais popular");
                        lblAlbum.setFont(new Font("Noto Sans Lisu", Font.BOLD, 20));
                        lblAlbum.setHorizontalAlignment(SwingConstants.CENTER);
                        contentPane.add(lblAlbum);
                
                        txtLocalNasc = new JTextField();
                        txtLocalNasc.setColumns(10);
                        contentPane.add(txtLocalNasc);
        
                txtNome = new JTextField();
                txtNome.setColumns(10);
                contentPane.add(txtNome);
        
        label_11 = new JLabel("");
        contentPane.add(label_11);
        
        label_12 = new JLabel("");
        contentPane.add(label_12);
                        
                                txtDataFalecimento = new JTextField();
                                txtDataFalecimento.setColumns(10);
                                contentPane.add(txtDataFalecimento);
        
        label_13 = new JLabel("");
        contentPane.add(label_13);
        
        label_16 = new JLabel("");
        contentPane.add(label_16);
                
                        btnCadastrar = new JButton("Cadastrar");
                        btnCadastrar.setFont(new Font("Noto Sans Lisu", Font.BOLD, 20));
                        btnCadastrar.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        	}
                        });
                        contentPane.add(btnCadastrar);
                
                        btnLimpar = new JButton("Limpar");
                        btnLimpar.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        	}
                        });
                        btnLimpar.setFont(new Font("Noto Sans Lisu", Font.BOLD, 20));
                        contentPane.add(btnLimpar);
                
                        btnFechar = new JButton("Fechar");
                        btnFechar.setFont(new Font("Noto Sans Lisu", Font.BOLD, 20));
                        btnFechar.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        	}
                        });
                        contentPane.add(btnFechar);
        
                txtDataNasc = new JTextField();
                txtDataNasc.setColumns(10);
                contentPane.add(txtDataNasc);
        
        label_17 = new JLabel("");
        contentPane.add(label_17);
        
        label_6 = new JLabel("");
        contentPane.add(label_6);
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
        return txtDataFalecimento;
    }

    public JTextField getTxtLocalNasc() {
        return txtLocalNasc;
    }


    public void mostrarMensagem(String texto) {
        JOptionPane.showMessageDialog(this, texto);
    }

    public void mostrarErro(String texto) {
        JOptionPane.showMessageDialog(
                this,
                texto,
                "Atenção",
                JOptionPane.WARNING_MESSAGE);
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