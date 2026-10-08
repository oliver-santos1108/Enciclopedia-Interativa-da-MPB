
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

    public JanelaArtista() {

        setTitle("Enciclopédia Interativa da MPB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 533, 676);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEnciclopedia = new JLabel(
                "Enciclopédia Interativa da MPB");
        lblEnciclopedia.setForeground(Color.BLACK);
        lblEnciclopedia.setFont(
                new Font("Yu Gothic Medium", Font.BOLD, 28));
        lblEnciclopedia.setBounds(36, 35, 458, 63);
        contentPane.add(lblEnciclopedia);

        JLabel lblArtista = new JLabel("Artista");
        lblArtista.setFont(
                new Font("Yu Gothic Medium", Font.BOLD, 16));
        lblArtista.setBounds(36, 109, 112, 27);
        contentPane.add(lblArtista);

        JLabel lblNomeArtista = new JLabel("Nome");
        lblNomeArtista.setFont(
                new Font("Tahoma", Font.PLAIN, 11));
        lblNomeArtista.setBounds(36, 140, 46, 14);
        contentPane.add(lblNomeArtista);

        txtNome = new JTextField();
        txtNome.setBounds(36, 153, 177, 20);
        txtNome.setColumns(10);
        contentPane.add(txtNome);

        JLabel lblDataNascimento = new JLabel(
                "Ano de nascimento");
        lblDataNascimento.setFont(
                new Font("Tahoma", Font.PLAIN, 11));
        lblDataNascimento.setBounds(36, 193, 112, 20);
        contentPane.add(lblDataNascimento);

        txtDataNasc = new JTextField();
        txtDataNasc.setBounds(36, 211, 177, 20);
        txtDataNasc.setColumns(10);
        contentPane.add(txtDataNasc);

        JLabel lblAlbum = new JLabel(
                "Álbum mais popular");
        lblAlbum.setBounds(37, 252, 118, 14);
        contentPane.add(lblAlbum);

        txtAlbum = new JTextField();
        txtAlbum.setBounds(37, 267, 176, 20);
        txtAlbum.setColumns(10);
        contentPane.add(txtAlbum);

        JLabel lblQuantAlbuns = new JLabel(
                "Quantidade de álbuns");
        lblQuantAlbuns.setBounds(256, 252, 136, 14);
        contentPane.add(lblQuantAlbuns);

        txtQuant_albuns = new JTextField();
        txtQuant_albuns.setBounds(256, 265, 177, 20);
        txtQuant_albuns.setColumns(10);
        contentPane.add(txtQuant_albuns);

        JLabel lblDataFalecimento = new JLabel(
                "Data de falecimento");
        lblDataFalecimento.setBounds(257, 140, 176, 14);
        contentPane.add(lblDataFalecimento);

        txtDataFalecimento = new JTextField();
        txtDataFalecimento.setBounds(257, 153, 176, 20);
        txtDataFalecimento.setColumns(10);
        contentPane.add(txtDataFalecimento);

        JLabel lblLocalNasc = new JLabel(
                "Local de nascimento");
        lblLocalNasc.setBounds(256, 193, 177, 14);
        contentPane.add(lblLocalNasc);

        txtLocalNasc = new JTextField();
        txtLocalNasc.setBounds(256, 207, 177, 20);
        txtLocalNasc.setColumns(10);
        contentPane.add(txtLocalNasc);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(36, 319, 98, 27);
        contentPane.add(btnCadastrar);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(170, 319, 98, 27);
        contentPane.add(btnLimpar);

        btnFechar = new JButton("Fechar");
        btnFechar.setBounds(307, 319, 98, 27);
        contentPane.add(btnFechar);
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