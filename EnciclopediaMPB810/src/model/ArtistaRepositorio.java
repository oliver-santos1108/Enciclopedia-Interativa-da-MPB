package model;

import java.util.ArrayList;
import java.util.List;

public class ArtistaRepositorio {

    private List<Artista> artistas = new ArrayList<>();

    public void salvar(Artista artista) {

        String problema = artista.validar();

        if (problema != null) {
            throw new IllegalArgumentException(problema);
        }

        if (existe(artista.getNome(), artista.getDataNascimento())) {
            throw new IllegalArgumentException(
                    "Já existe um artista com esse nome e essa data de nascimento.");
        }

        artistas.add(artista);
    }

    public boolean existe(String nome, int dataNascimento) {
        for (Artista artista : artistas) {
            if (artista.getNome().equals(nome)
                    && artista.getDataNascimento() == dataNascimento) {
                return true;
            }
        }

        return false;
    }

    public List<Artista> listarTodos() {
        return new ArrayList<>(artistas);
    }

    public int contar() {
        return artistas.size();
    }
}