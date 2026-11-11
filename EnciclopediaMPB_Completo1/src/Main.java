import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.ArtistaController;
import model.ArtistaRepositorio;
import view.JanelaSistema;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                ArtistaRepositorio repositorio = new ArtistaRepositorio();
                JanelaSistema view = new JanelaSistema();
                new ArtistaController(view, repositorio);
                view.setVisible(true);
            } catch (Exception erro) {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(null,
                    "Não foi possível iniciar a Enciclopédia.\n"
                    + erro.getMessage()
                    + "\n\nConfira o MySQL, o banco mpb e o Connector/J.",
                    "Erro ao iniciar", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
