package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class JanelaManual extends JDialog {
    private static final long serialVersionUID = 1L;
    private static final String ARQUIVO = "/manual/manual.html";

    public JanelaManual(JFrame dono) {
        super(dono, "Manual de uso", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(720, 560);
        setMinimumSize(new java.awt.Dimension(480, 360));
        setLocationRelativeTo(dono);
        JPanel raiz = new JPanel(new BorderLayout(0, 8));
        raiz.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(raiz);
        JEditorPane editor = new JEditorPane();
        editor.setEditable(false);
        carregar(editor);
        raiz.add(new JScrollPane(editor), BorderLayout.CENTER);
        JButton fechar = new JButton("Fechar");
        fechar.addActionListener(e -> dispose());
        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rodape.add(fechar);
        raiz.add(rodape, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(fechar);
        getRootPane().registerKeyboardAction(e -> dispose(),
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    private void carregar(JEditorPane editor) {
        URL url = JanelaManual.class.getResource(ARQUIVO);
        if (url == null) {
            editor.setContentType("text/plain");
            editor.setText("Manual não encontrado: " + ARQUIVO);
            return;
        }
        try { editor.setPage(url); }
        catch (IOException e) {
            editor.setContentType("text/plain");
            editor.setText("Não foi possível abrir o manual: " + e.getMessage());
        }
    }
}
