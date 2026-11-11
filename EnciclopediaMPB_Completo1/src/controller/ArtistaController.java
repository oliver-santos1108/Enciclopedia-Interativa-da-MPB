package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Artista;
import model.ArtistaRepositorio;
import model.Imagens;
import view.JanelaSistema;

/** Controller: coordena eventos da View e operações do repositório. */
public class ArtistaController implements ActionListener, ListSelectionListener {
    private final JanelaSistema view;
    private final ArtistaRepositorio repositorio;
    private byte[] fotoEscolhida;
    private Integer idEmEdicao;

    public ArtistaController(JanelaSistema view, ArtistaRepositorio repositorio) {
        this.view = view;
        this.repositorio = repositorio;
        registrarEventos();
        recarregarTodos();
    }

    private void registrarEventos() {
        view.getBtnNovo().addActionListener(this);
        view.getBtnSalvar().addActionListener(this);
        view.getBtnExcluir().addActionListener(this);
        view.getBtnEscolherFoto().addActionListener(this);
        view.getBtnRemoverFoto().addActionListener(this);
        view.getBtnIrCadastro().addActionListener(this);
        view.getBtnIrConsulta().addActionListener(this);
        view.getBtnPesquisar().addActionListener(this);
        view.getBtnMostrarTodos().addActionListener(this);
        view.getMiLimpar().addActionListener(this);
        view.getMiSair().addActionListener(this);
        view.getMiManual().addActionListener(this);
        view.getMiSobre().addActionListener(this);
        view.getTxtPesquisa().addActionListener(this);
        view.getTabela().getSelectionModel().addListSelectionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object origem = e.getSource();
        try {
            if (origem == view.getBtnNovo() || origem == view.getMiLimpar()) novo();
            else if (origem == view.getBtnSalvar()) salvar();
            else if (origem == view.getBtnExcluir()) excluir();
            else if (origem == view.getBtnEscolherFoto()) escolherFoto();
            else if (origem == view.getBtnRemoverFoto()) {
                fotoEscolhida = null; view.mostrarFoto(null);
            }
            else if (origem == view.getBtnIrCadastro()) view.mostrarCartao(JanelaSistema.CARTAO_CADASTRO);
            else if (origem == view.getBtnIrConsulta()) {
                recarregarTodos(); view.mostrarCartao(JanelaSistema.CARTAO_CONSULTA);
            }
            else if (origem == view.getBtnPesquisar() || origem == view.getTxtPesquisa()) pesquisar();
            else if (origem == view.getBtnMostrarTodos()) recarregarTodos();
            else if (origem == view.getMiSair()) System.exit(0);
            else if (origem == view.getMiManual()) view.mostrarManual();
            else if (origem == view.getMiSobre()) view.mostrarSobre();
        } catch (Exception erro) {
            erro.printStackTrace();
            view.erro("Operação não concluída: " + erro.getMessage());
        }
    }

    private void novo() {
        idEmEdicao = null;
        fotoEscolhida = null;
        view.limparCampos();
        view.mostrarCartao(JanelaSistema.CARTAO_CADASTRO);
        view.mostrarStatus("Novo cadastro.");
    }

    private void salvar() throws Exception {
        Artista a;
        try { a = view.lerFormulario(); }
        catch (NumberFormatException ex) {
            view.erro("Confira os campos de ano e quantidade de álbuns. Use números inteiros.");
            return;
        }
        String problema = a.validar();
        if (problema != null) { view.erro(problema); return; }
        a.setFoto(fotoEscolhida);
        if (idEmEdicao == null) {
            repositorio.inserir(a);
            view.mensagem("Artista cadastrado com sucesso!");
        } else {
            a.setIdArtista(idEmEdicao);
            repositorio.atualizar(a);
            view.mensagem("Artista atualizado com sucesso!");
        }
        novo();
        recarregarTodos();
    }

    private void excluir() throws SQLException {
        if (idEmEdicao == null) { view.erro("Selecione um artista na consulta antes de excluir."); return; }
        if (!view.confirmar("Deseja realmente excluir este artista?")) return;
        repositorio.excluir(idEmEdicao);
        novo();
        recarregarTodos();
        view.mostrarStatus("Artista excluído.");
    }

    private void escolherFoto() throws Exception {
        File arquivo = view.escolherArquivo();
        if (arquivo == null) return;
        fotoEscolhida = Imagens.lerReduzida(arquivo);
        view.mostrarFoto(fotoEscolhida);
    }

    private void pesquisar() throws SQLException {
        List<Artista> lista = repositorio.pesquisar(view.getTxtPesquisa().getText());
        view.carregarTabela(lista);
        view.mostrarStatus(lista.size() + " artista(s) encontrado(s).");
    }

    private void recarregarTodos() {
        try {
            List<Artista> lista = repositorio.listarTodos();
            view.carregarTabela(lista);
            view.mostrarStatus(lista.size() + " artista(s) cadastrado(s).");
        } catch (SQLException e) {
            view.mostrarStatus("Falha ao consultar o banco.");
            throw new RuntimeException("Não foi possível acessar o banco mpb: " + e.getMessage(), e);
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) return;
        Artista selecionado = view.getArtistaSelecionado();
        if (selecionado == null) return;
        try {
            Artista completo = repositorio.buscarPorId(selecionado.getIdArtista());
            if (completo == null) return;
            idEmEdicao = completo.getIdArtista();
            fotoEscolhida = completo.getFoto();
            view.preencherCampos(completo);
            view.mostrarCartao(JanelaSistema.CARTAO_CADASTRO);
            view.mostrarStatus("Editando: " + completo.getNome());
        } catch (SQLException ex) {
            view.erro("Não foi possível carregar o artista: " + ex.getMessage());
        }
    }
}
