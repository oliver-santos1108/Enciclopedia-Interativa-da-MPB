package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Artista;

public class ArtistaTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private final String[] colunas = {"ID", "Artista", "Nascimento", "Álbuns", "Falecimento", "Local de nascimento"};
    private List<Artista> dados = new ArrayList<>();

    public int getRowCount() { return dados.size(); }
    public int getColumnCount() { return colunas.length; }
    public String getColumnName(int coluna) { return colunas[coluna]; }
    public Class<?> getColumnClass(int coluna) {
        if (coluna == 0 || coluna == 2 || coluna == 3) return Integer.class;
        return String.class;
    }
    public boolean isCellEditable(int linha, int coluna) { return false; }

    public Object getValueAt(int linha, int coluna) {
        Artista a = dados.get(linha);
        switch (coluna) {
            case 0: return a.getIdArtista();
            case 1: return a.getNome();
            case 2: return a.getDataNascimento();
            case 3: return a.getQuantAlbuns();
            case 4: return a.getDataFalecimento() == null ? "—" : a.getDataFalecimento().toString();
            case 5: return a.getLocalNascimento();
            default: return "";
        }
    }
    public void setDados(List<Artista> novos) {
        dados = new ArrayList<>(novos);
        fireTableDataChanged();
    }
    public Artista getArtista(int linha) { return dados.get(linha); }
}
