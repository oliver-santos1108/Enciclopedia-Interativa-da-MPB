package main;

import model.Artista;

public class TesteRegras {

    public static void main(String[] args) {

    
        Artista a = new Artista();

        a.setNome("Elis Regina");
        a.setDataNascimento(1945);
        a.setQuantAlbuns(20);
        a.setAlbuns("Elis & Tom; Falso Brilhante");
        a.setDataFalecimento(1982);
        a.setLocalNascimento("Porto Alegre - RS");

        System.out.println("Caso válido -> " + a.validar());

        Artista b = new Artista();

        b.setNome("");
        b.setDataNascimento(1945);
        b.setQuantAlbuns(10);
        b.setAlbuns("Álbuns");
        b.setLocalNascimento("São Paulo - SP");

        System.out.println("Nome vazio -> " + b.validar());

        Artista c = new Artista();

        c.setNome("Artista Teste");
        c.setDataNascimento(3000);
        c.setQuantAlbuns(10);
        c.setAlbuns("Álbuns");
        c.setLocalNascimento("São Paulo - SP");

        System.out.println("Data futura -> " + c.validar());

        Artista d = new Artista();

        d.setNome("Artista Teste");
        d.setDataNascimento(1980);
        d.setQuantAlbuns(0);
        d.setAlbuns("Álbuns");
        d.setLocalNascimento("São Paulo - SP");

        System.out.println("Quantidade zero -> " + d.validar());

        Artista e = new Artista();

        e.setNome("Artista Teste");
        e.setDataNascimento(1980);
        e.setQuantAlbuns(5);
        e.setAlbuns("");
        e.setLocalNascimento("São Paulo - SP");

        System.out.println("Álbuns vazio -> " + e.validar());

        Artista g = new Artista();

        g.setNome("Artista Teste");
        g.setDataNascimento(1980);
        g.setQuantAlbuns(5);
        g.setAlbuns("Álbuns");
        g.setLocalNascimento("");

        System.out.println("Local vazio -> " + g.validar());
    }
}