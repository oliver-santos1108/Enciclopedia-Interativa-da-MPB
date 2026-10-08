
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Artista;
import model.ArtistaRepositorioBD;
import view.JanelaArtista;

public class ArtistaController implements ActionListener {

    private ArtistaRepositorioBD repositorio;
    private JanelaArtista view;

    public ArtistaController(ArtistaRepositorioBD repositorio,JanelaArtista view) {
        this.repositorio = repositorio;
        this.view = view;
        view.getBtnCadastrar().addActionListener(this);
        view.getBtnLimpar().addActionListener(this);
        view.getBtnFechar().addActionListener(this);
    }

    public void iniciarTela() {
        view.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.getBtnCadastrar()) {
            cadastrar();

        } else if (e.getSource() == view.getBtnLimpar()) {
            view.limparCampos();
        } else if (e.getSource() == view.getBtnFechar()) {
            view.fechar();
        }
    }

    private void cadastrar() {
        try {
            Artista artista = new Artista();
     
            artista.setNome(view.getTxtNome().getText());
            artista.setDataNascimento(Integer.parseInt(view.getTxtDataNasc().getText().trim()));
            artista.setQuantAlbuns(Integer.parseInt(view.getTxtQuant_albuns().getText().trim()));
            artista.setAlbuns(view.getTxtAlbum().getText());

            String dataFalecimento = view.getTxtDataFalecimento().getText().trim();
            if (dataFalecimento.isEmpty()) {
                artista.setDataFalecimento(0);
            } else {
                artista.setDataFalecimento(Integer.parseInt(dataFalecimento));
            }

            artista.setLocalNascimento(view.getTxtLocalNasc().getText());

            repositorio.salvar(artista);

            view.mostrarMensagem("Artista cadastrado com sucesso!\n"
                    + "Total de artistas cadastrados: "
                    + repositorio.contar());
            view.limparCampos();

        } catch (NumberFormatException erro) {
            view.mostrarErro("Preencha os campos numéricos (Data de Nascimento e Quantidade de Álbuns) corretamente.");
        } catch (IllegalArgumentException erro) {
            view.mostrarErro(erro.getMessage());
        } catch (Exception erro) {
            view.mostrarErro("Erro ao acessar o banco de dados: " + erro.getMessage());
        }
    }
   /* private void cadastrar() {
        try {
            Artista artista = new Artista();
            artista.setNome(view.getTxtNome().getText());
            artista.setDataNascimento(Integer.parseInt(view.getTxtDataNasc().getText().trim()));


            artista.setQuantAlbuns(Integer.parseInt(view.getTxtQuant_albuns().getText().trim()));

            artista.setAlbuns(view.getTxtAlbum().getText());

            String dataFalecimento = view.getTxtDataFalecimento().getText().trim();

            if (dataFalecimento.isEmpty()) {
            	artista.setDataFalecimento(0);
            } else {
                artista.setDataFalecimento(Integer.parseInt(dataFalecimento));
            }

            artista.setLocalNascimento(view.getTxtLocalNasc().getText());

            repositorio.salvar(artista);

            view.mostrarMensagem("Artista cadastrado com sucesso!\n"
                    + "Total de artistas cadastrados: "
                    + repositorio.contar());
            view.limparCampos();

        } catch (NumberFormatException erro) {
            view.mostrarErro("Preencha os campos numéricos corretamente.");
        } catch (IllegalArgumentException erro) {
            view.mostrarErro(erro.getMessage());

        } catch (RuntimeException erro) {

            view.mostrarErro(erro.getMessage());
        }
    }*/
}
