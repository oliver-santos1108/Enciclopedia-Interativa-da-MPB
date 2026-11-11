package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import util.InfoApp;

public class JanelaSobre extends JDialog {
    private static final long serialVersionUID = 1L;
    public JanelaSobre(JFrame dono) {
        super(dono, "Sobre " + InfoApp.NOME, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(480, 390);
        setMinimumSize(getSize());
        setLocationRelativeTo(dono);
        JPanel raiz = new JPanel(new BorderLayout(0, 12));
        raiz.setBorder(new EmptyBorder(18, 18, 18, 18));
        setContentPane(raiz);
        raiz.add(new JLabel(montarTexto(), SwingConstants.CENTER), BorderLayout.CENTER);
        JButton fechar = new JButton("Fechar");
        fechar.addActionListener(e -> dispose());
        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rodape.add(fechar);
        raiz.add(rodape, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(fechar);
        getRootPane().registerKeyboardAction(e -> dispose(),
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
    private String montarTexto() {
        StringBuilder sb = new StringBuilder("<html><div style='text-align:center'>");
        sb.append("<h2>").append(InfoApp.NOME).append("</h2>");
        sb.append("Versão ").append(InfoApp.VERSAO).append("<br><br>");
        sb.append(InfoApp.DESCRICAO).append("<br><br><b>Desenvolvido por</b><br>");
        for (String autor : InfoApp.AUTORES) sb.append(autor).append("<br>");
        sb.append("<br><b>Professor</b><br>").append(InfoApp.PROFESSOR).append("<br><br>");
        sb.append(InfoApp.INSTITUICAO).append("<br>").append(InfoApp.DISCIPLINA)
          .append(" - ").append(InfoApp.ANO).append("<br><br><small>")
          .append(InfoApp.TECNOLOGIAS).append("</small></div></html>");
        return sb.toString();
    }
}
