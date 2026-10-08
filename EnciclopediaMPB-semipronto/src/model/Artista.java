package model;

import java.time.Year;

public class Artista {

    private String nome;
    private int dataNascimento;
    private int quantAlbuns;
    private String albuns;
    private int dataFalecimento;
    private String localNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getQuantAlbuns() {
        return quantAlbuns;
    }

    public void setQuantAlbuns(int quantAlbuns) {
        this.quantAlbuns = quantAlbuns;
    }

    public String getAlbuns() {
        return albuns;
    }

    public void setAlbuns(String albuns) {
        this.albuns = albuns;
    }

    public int getDataFalecimento() {
        return dataFalecimento;
    }

    public void setDataFalecimento(int dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    public String getLocalNascimento() {
        return localNascimento;
    }

    public void setLocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
    }

    public String validar() {
        if (nome == null || nome.trim().isEmpty()) {
            return "Preencha o nome do artista.";
        }

        int anoAtual = Year.now().getValue();
        if (dataNascimento > anoAtual) {
            return "A data de nascimento não pode ser maior que o ano atual.";
        }
        if (quantAlbuns == 0) {
            return "A quantidade de álbuns deve ser diferente de zero.";
        }

        if (albuns == null || albuns.trim().isEmpty()) {
            return "Preencha os álbuns do artista.";
        }
        if (localNascimento == null || localNascimento.trim().isEmpty()) {
            return "Preencha o local de nascimento.";
        }
		return albuns;
    }
  }
