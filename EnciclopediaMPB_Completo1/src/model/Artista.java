package model;

public class Artista {
    private int idArtista;
    private String nome;
    private int dataNascimento;
    private int quantAlbuns;
    private String albuns;
    private Integer dataFalecimento;
    private String localNascimento;
    private byte[] foto;

    public Artista() { }

    public Artista(String nome, int dataNascimento, int quantAlbuns,
                   String albuns, Integer dataFalecimento, String localNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.quantAlbuns = quantAlbuns;
        this.albuns = albuns;
        this.dataFalecimento = dataFalecimento;
        this.localNascimento = localNascimento;
    }

    public String validar() {
        if (nome == null || nome.trim().isEmpty()) return "Informe o nome do artista.";
        if (dataNascimento < 1000 || dataNascimento > 2100) return "Informe um ano de nascimento válido.";
        if (quantAlbuns < 0) return "A quantidade de álbuns não pode ser negativa.";
        if (albuns == null || albuns.trim().isEmpty()) return "Informe os álbuns (ou escreva 'Não informado').";
        if (dataFalecimento != null &&
            (dataFalecimento < dataNascimento || dataFalecimento > 2100))
            return "O ano de falecimento deve ser posterior ao nascimento.";
        if (localNascimento == null || localNascimento.trim().isEmpty())
            return "Informe o local de nascimento (ou escreva 'Não informado').";
        return null;
    }

    public int getIdArtista() { 
    	return idArtista; 
    }
    public void setIdArtista(int idArtista) { 
    	this.idArtista = idArtista; 
    }
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
    public Integer getDataFalecimento() {
    	return dataFalecimento; 
    }
    public void setDataFalecimento(Integer dataFalecimento) { 
    	this.dataFalecimento = dataFalecimento; 
    }
    public String getLocalNascimento() { 
    	return localNascimento; 
    }
    public void setLocalNascimento(String localNascimento) {
    	this.localNascimento = localNascimento; 
    }
    public byte[] getFoto() { 
    	return foto; 
    }
    public void setFoto(byte[] foto) {
    	this.foto = foto; 
    }
    public boolean temFoto() { 
    	return foto != null && foto.length > 0;
    }
}
