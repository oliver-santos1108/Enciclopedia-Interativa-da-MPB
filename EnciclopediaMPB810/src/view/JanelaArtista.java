
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

    public JanelaArtista() {

        setTitle("Enciclopédia Interativa da MPB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 533, 676);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 4, 0, 0));
        
        label = new JLabel("");
        contentPane.add(label);
        
                JLabel lblEnciclopedia = new JLabel(
                        "Enciclopédia Interativa da MPB");
                lblEnciclopedia.setForeground(Color.BLACK);
                lblEnciclopedia.setFont(
                        new Font("Yu Gothic Medium", Font.BOLD, 28));
                contentPane.add(lblEnciclopedia);
        
        label_1 = new JLabel("");
        contentPane.add(label_1);
        
        label_2 = new JLabel("");
        contentPane.add(label_2);

        JLabel lblArtista = new JLabel("Artista");
        lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
        lblArtista.setFont(
                new Font("Yu Gothic Medium", Font.BOLD, 16));
        contentPane.add(lblArtista);
        
        label_3 = new JLabel("");
        contentPane.add(label_3);
        
        label_4 = new JLabel("");
        contentPane.add(label_4);
        
        label_5 = new JLabel("");
        contentPane.add(label_5);

        JLabel lblNomeArtista = new JLabel("Nome");
        lblNomeArtista.setFont(
                new Font("Tahoma", Font.PLAIN, 11));
        contentPane.add(lblNomeArtista);
        
                txtNome = new JTextField();
                txtNome.setColumns(10);
                contentPane.add(txtNome);
        
                JLabel lblDataFalecimento = new JLabel(
                        "Data de falecimento");
                contentPane.add(lblDataFalecimento);
        
                txtDataFalecimento = new JTextField();
                txtDataFalecimento.setColumns(10);
                contentPane.add(txtDataFalecimento);
                
                        JLabel lblDataNascimento = new JLabel(
                                "Ano de nascimento");
                        lblDataNascimento.setFont(
                                new Font("Tahoma", Font.PLAIN, 11));
                        contentPane.add(lblDataNascimento);
        
                txtDataNasc = new JTextField();
                txtDataNasc.setColumns(10);
                contentPane.add(txtDataNasc);
        
                JLabel lblLocalNasc = new JLabel(
                        "Local de nascimento");
                contentPane.add(lblLocalNasc);
        
                txtLocalNasc = new JTextField();
                txtLocalNasc.setColumns(10);
                contentPane.add(txtLocalNasc);
        
                JLabel lblAlbum = new JLabel(
                        "Álbum mais popular");
                contentPane.add(lblAlbum);
        
                txtAlbum = new JTextField();
                txtAlbum.setColumns(10);
                contentPane.add(txtAlbum);
        
                JLabel lblQuantAlbuns = new JLabel(
                        "Quantidade de álbuns");
                contentPane.add(lblQuantAlbuns);
        
                txtQuant_albuns = new JTextField();
                txtQuant_albuns.setColumns(10);
                contentPane.add(txtQuant_albuns);
        
        label_7 = new JLabel("");
        contentPane.add(label_7);
        
        label_9 = new JLabel("");
        contentPane.add(label_9);
        
        label_10 = new JLabel("");
        contentPane.add(label_10);
        
        label_11 = new JLabel("");
        contentPane.add(label_11);
        
                btnCadastrar = new JButton("Cadastrar");
                btnCadastrar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                contentPane.add(btnCadastrar);
        
                btnLimpar = new JButton("Limpar");
                contentPane.add(btnLimpar);
        
                btnFechar = new JButton("Fechar");
                contentPane.add(btnFechar);
        
        label_12 = new JLabel("");
        contentPane.add(label_12);
        
        label_13 = new JLabel("");
        contentPane.add(label_13);
        
        label_16 = new JLabel("");
        contentPane.add(label_16);
        
        label_17 = new JLabel("");
        contentPane.add(label_17);
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