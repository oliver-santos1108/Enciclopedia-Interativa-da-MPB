package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.EmptyBorder;

import model.Artista;

public class JanelaSistema extends JFrame {
    private static final long serialVersionUID = 1L;
    public static final String CARTAO_CADASTRO = "cadastro";
    public static final String CARTAO_CONSULTA = "consulta";

    private final CardLayout cards = new CardLayout();
    private final JPanel painelCards = new JPanel(cards);

    private final JTextField txtNome = new JTextField(28);
    private final JTextField txtNascimento = new JTextField(8);
    private final JTextField txtQuantAlbuns = new JTextField(8);
    private final JTextArea txtAlbuns = new JTextArea(4, 28);
    private final JTextField txtFalecimento = new JTextField(8);
    private final JTextArea txtLocalNascimento = new JTextArea(2, 28);
    private final JLabel lblFoto = new JLabel("Nenhuma foto selecionada", SwingConstants.CENTER);
    private final JButton btnEscolherFoto = new JButton("Escolher foto...");
    private final JButton btnRemoverFoto = new JButton("Remover foto");
    private final JButton btnNovo = new JButton("Limpar / Novo");
    private final JButton btnSalvar = new JButton("Salvar");
    private final JButton btnExcluir = new JButton("Excluir");
    private final JButton btnIrCadastro = new JButton("Cadastro");
    private final JButton btnIrConsulta = new JButton("Consulta");
    private final JTextField txtPesquisa = new JTextField(22);
    private final JButton btnPesquisar = new JButton("Pesquisar");
    private final JButton btnMostrarTodos = new JButton("Mostrar todos");
    private final JTable tabela;
    private final ArtistaTableModel modelo = new ArtistaTableModel();
    private final JLabel lblStatus = new JLabel("Pronto.");
    private final JMenuItem miLimpar = new JMenuItem("Limpar campos");
    private final JMenuItem miSair = new JMenuItem("Sair");
    private final JMenuItem miManual = new JMenuItem("Manual de uso");
    private final JMenuItem miSobre = new JMenuItem("Sobre");
    

    public interface FileSelectionListener { void arquivoSelecionado(java.io.File arquivo); }

    public JanelaSistema() {
        setTitle("Enciclopédia Interativa da MPB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setSize(1120, 760);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));
        setJMenuBar(criarMenu());

        ImageIcon icone = carregarIcone("/img/icone.png", 32, 32);
        if (icone != null) setIconImage(icone.getImage());

        JPanel topo = new JPanel(new BorderLayout());
        JLabel logo = new JLabel("ENCICLOPÉDIA INTERATIVA DA MPB", SwingConstants.CENTER);
        ImageIcon logoIcon = carregarIcone("/img/logo.png", 460, 95);
        if (logoIcon != null) {
            logo.setText("");
            logo.setIcon(logoIcon);
        }
        logo.setBorder(new EmptyBorder(10, 10, 10, 10));
        topo.add(logo, BorderLayout.CENTER);
        JPanel navegacao = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        navegacao.add(btnIrCadastro);
        navegacao.add(btnIrConsulta);
        topo.add(navegacao, BorderLayout.SOUTH);
        add(topo, BorderLayout.NORTH);

        tabela = new JTable(modelo);
        painelCards.add(criarCartaoCadastro(), CARTAO_CADASTRO);
        painelCards.add(criarCartaoConsulta(), CARTAO_CONSULTA);
        add(painelCards, BorderLayout.CENTER);
        lblStatus.setBorder(new EmptyBorder(5, 10, 8, 10));
        add(lblStatus, BorderLayout.SOUTH);
        mostrarCartao(CARTAO_CADASTRO);
    }

    private JMenuBar criarMenu() {
        JMenuBar barra = new JMenuBar();
        JMenu arquivo = new JMenu("Arquivo");
        arquivo.setMnemonic(KeyEvent.VK_A);
        miLimpar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
        miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        arquivo.add(miLimpar);
        arquivo.addSeparator();
        arquivo.add(miSair);
        JMenu ajuda = new JMenu("Ajuda");
        ajuda.setMnemonic(KeyEvent.VK_U);
        miManual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        ajuda.add(miManual);
        ajuda.add(miSobre);
        barra.add(arquivo);  
        barra.add(ajuda);
        return barra;
    }

    private JPanel criarCartaoCadastro() {
        JPanel raiz = new JPanel(new BorderLayout(10, 10));
        raiz.setBorder(new EmptyBorder(12, 18, 12, 18));
        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBorder(BorderFactory.createTitledBorder("Dados do artista"));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(5, 7, 5, 7);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.LINE_END;

        adicionarLinha(formulario, g, 0, "Nome:", txtNome);
        adicionarLinha(formulario, g, 1, "Ano de nascimento:", txtNascimento);
        adicionarLinha(formulario, g, 2, "Quantidade de álbuns:", txtQuantAlbuns);
        adicionarLinha(formulario, g, 3, "Álbuns (separados por vírgula):", new JScrollPane(txtAlbuns));
        adicionarLinha(formulario, g, 4, "Ano de falecimento (opcional):", txtFalecimento);
        adicionarLinha(formulario, g, 5, "Local de nascimento:", new JScrollPane(txtLocalNascimento));

        JPanel fotoPainel = new JPanel(new BorderLayout(5, 5));
        fotoPainel.setBorder(BorderFactory.createTitledBorder("Fotografia"));
        lblFoto.setPreferredSize(new Dimension(220, 190));
        lblFoto.setBorder(BorderFactory.createEtchedBorder());
        fotoPainel.add(lblFoto, BorderLayout.CENTER);
        JPanel botoesFoto = new JPanel(new FlowLayout());
        botoesFoto.add(btnEscolherFoto);
        botoesFoto.add(btnRemoverFoto);
        fotoPainel.add(botoesFoto, BorderLayout.SOUTH);

        JPanel centro = new JPanel(new BorderLayout(12, 0));
        centro.add(formulario, BorderLayout.CENTER);
        centro.add(fotoPainel, BorderLayout.EAST);
        raiz.add(centro, BorderLayout.CENTER);

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botoes.add(btnNovo);
        botoes.add(btnExcluir);
        botoes.add(btnSalvar);
        raiz.add(botoes, BorderLayout.SOUTH);
        return raiz;
    }

    private void adicionarLinha(JPanel p, GridBagConstraints g, int linha, String rotulo, java.awt.Component campo) {
        g.gridy = linha; g.gridx = 0; g.weightx = 0; g.gridwidth = 1;
        p.add(new JLabel(rotulo), g);
        g.gridx = 1; g.weightx = 1; g.anchor = GridBagConstraints.LINE_START;
        p.add(campo, g);
        g.anchor = GridBagConstraints.LINE_END;
    }

    private JPanel criarCartaoConsulta() {
        JPanel p = new JPanel(new BorderLayout(8, 8));
        p.setBorder(new EmptyBorder(12, 18, 12, 18));
        JPanel filtro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filtro.add(new JLabel("Pesquisar artista:"));
        filtro.add(txtPesquisa);
        filtro.add(btnPesquisar);
        filtro.add(btnMostrarTodos);
        p.add(filtro, BorderLayout.NORTH);
        tabela.setRowHeight(25);
        tabela.setAutoCreateRowSorter(true);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        p.add(new JScrollPane(tabela), BorderLayout.CENTER);
        JLabel dica = new JLabel("Selecione uma linha e use o botão Cadastro para editar o artista.");
        p.add(dica, BorderLayout.SOUTH);
        return p;
    }

    private ImageIcon carregarIcone(String caminho, int largura, int altura) {
        URL url = JanelaSistema.class.getResource(caminho);
        if (url == null) {
            System.err.println("Imagem não encontrada: " + caminho);
            return null;
        }
        ImageIcon original = new ImageIcon(url);
        if (original.getIconWidth() <= 0 || original.getIconHeight() <= 0) return null;
        double escala = Math.min((double) largura / original.getIconWidth(),
                                 (double) altura / original.getIconHeight());
        int w = Math.max(1, (int) (original.getIconWidth() * escala));
        int h = Math.max(1, (int) (original.getIconHeight() * escala));
        return new ImageIcon(original.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }

    public java.io.File escolherArquivo() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Escolha a fotografia do artista");
        chooser.setFileFilter(new FileNameExtensionFilter("Imagens (JPG, JPEG, PNG)", "jpg", "jpeg", "png"));
        return chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFile() : null;
    }

    public void mostrarFoto(byte[] bytes) {
        try {
            java.awt.image.BufferedImage imagem = model.Imagens.deBytes(bytes);
            if (imagem == null) {
                lblFoto.setIcon(null);
                lblFoto.setText("Nenhuma foto cadastrada");
            } else {
                ImageIcon icon = new ImageIcon(imagem.getScaledInstance(210, 165, Image.SCALE_SMOOTH));
                lblFoto.setText("");
                lblFoto.setIcon(icon);
            }
        } catch (Exception e) {
            lblFoto.setIcon(null);
            lblFoto.setText("Não foi possível exibir a foto");
        }
    }

    public void mostrarCartao(String nome) { cards.show(painelCards, nome); }
    public void carregarTabela(List<Artista> artistas) { modelo.setDados(artistas); }
    public Artista getArtistaSelecionado() {
        int linha = tabela.getSelectedRow();
        if (linha < 0) return null;
        return modelo.getArtista(tabela.convertRowIndexToModel(linha));
    }
    public void limparCampos() {
        txtNome.setText(""); txtNascimento.setText(""); txtQuantAlbuns.setText("");
        txtAlbuns.setText(""); txtFalecimento.setText(""); txtLocalNascimento.setText("");
        tabela.clearSelection();
        mostrarFoto(null);
    }
    public void preencherCampos(Artista a) {
        txtNome.setText(a.getNome());
        txtNascimento.setText(String.valueOf(a.getDataNascimento()));
        txtQuantAlbuns.setText(String.valueOf(a.getQuantAlbuns()));
        txtAlbuns.setText(a.getAlbuns());
        txtFalecimento.setText(a.getDataFalecimento() == null ? "" : a.getDataFalecimento().toString());
        txtLocalNascimento.setText(a.getLocalNascimento());
        mostrarFoto(a.getFoto());
    }
    public Artista lerFormulario() {
        String nome = txtNome.getText().trim();
        int nascimento = Integer.parseInt(txtNascimento.getText().trim());
        int quantidade = Integer.parseInt(txtQuantAlbuns.getText().trim());
        String albuns = txtAlbuns.getText().trim();
        String falecimentoTexto = txtFalecimento.getText().trim();
        Integer falecimento = falecimentoTexto.isEmpty() ? null : Integer.valueOf(falecimentoTexto);
        String local = txtLocalNascimento.getText().trim();
        return new Artista(nome, nascimento, quantidade, albuns, falecimento, local);
    }
    public void mostrarStatus(String texto) { lblStatus.setText(" " + texto); }
    public void mensagem(String texto) { JOptionPane.showMessageDialog(this, texto); }
    public boolean confirmar(String texto) {
        return JOptionPane.showConfirmDialog(this, texto, "Confirmação",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    public void erro(String texto) {
        JOptionPane.showMessageDialog(this, texto, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public JTextField getTxtPesquisa() { return txtPesquisa; }
    public JTable getTabela() { return tabela; }
    public JButton getBtnNovo() { return btnNovo; }
    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnExcluir() { return btnExcluir; }
    public JButton getBtnEscolherFoto() { return btnEscolherFoto; }
    public JButton getBtnRemoverFoto() { return btnRemoverFoto; }
    public JButton getBtnIrCadastro() { return btnIrCadastro; }
    public JButton getBtnIrConsulta() { return btnIrConsulta; }
    public JButton getBtnPesquisar() { return btnPesquisar; }
    public JButton getBtnMostrarTodos() { return btnMostrarTodos; }
    public JMenuItem getMiLimpar() { return miLimpar; }
    public JMenuItem getMiSair() { return miSair; }
    public JMenuItem getMiManual() { return miManual; }
    public JMenuItem getMiSobre() { return miSobre; }
    public void mostrarSobre() { new JanelaSobre(this).setVisible(true); }
    public void mostrarManual() { new JanelaManual(this).setVisible(true); }
}
