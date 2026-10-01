package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistaRepositorioBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/mpb";

    private static final String USER =
            "aluno_cd";

    private static final String SENHA =
            "aluno_pw";

    private Connection abrir() throws SQLException {

        return DriverManager.getConnection(URL, USER, SENHA);
    }

    public void salvar(Artista artista) {

        String problema = artista.validar();

        if (problema != null) {
            throw new IllegalArgumentException(problema);
        }

        if (existe(artista.getNome(), artista.getDataNascimento())) {

            throw new IllegalArgumentException("Já existe um artista com esse nome e essa data de nascimento.");
        }

        String sql ="INSERT INTO artista "
                + "(nome, data_nascimento, conjugues, quant_albuns, "
                + "albuns, data_falecimento, idade, local_nascimento) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
        	Connection con = abrir();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, artista.getNome().trim());
            ps.setInt(2, artista.getDataNascimento());
            ps.setString(3,artista.getConjugues() == null ? "" : artista.getConjugues().trim()
            );

            ps.setInt(4, artista.getQuantAlbuns());
            ps.setString(5, artista.getAlbuns().trim());

            if (artista.getDataFalecimento() == 0) {
                ps.setNull(6, java.sql.Types.INTEGER);
            } else {
                ps.setInt(6, artista.getDataFalecimento());
            }
            ps.setInt(7, artista.getIdade());
            ps.setString(8, artista.getLocalNascimento().trim());
            ps.executeUpdate();
            
        } catch (SQLException erro) {

            throw new RuntimeException(
                    "Erro ao gravar: " + erro.getMessage(),
                    erro
            );
        }
    }

    public boolean existe(String nome, int dataNascimento) {
        String sql = "SELECT id_artista FROM artista "
                + "WHERE nome = ? AND data_nascimento = ?";
        try (
            Connection con = abrir();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, nome.trim());
            ps.setInt(2, dataNascimento);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException erro) {
            throw new RuntimeException(
                    "Erro ao consultar: " + erro.getMessage(),
                    erro
            );
        }
    }
    public List<Artista> listarTodos() {
        String sql =
                "SELECT nome, data_nascimento, conjugues, quant_albuns, "
                + "albuns, data_falecimento, idade, local_nascimento "
                + "FROM artista ORDER BY nome";

        List<Artista> lista = new ArrayList<>();
        try (
            Connection con = abrir();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Artista artista = new Artista();
                artista.setNome(rs.getString("nome"));
                artista.setDataNascimento(rs.getInt("data_nascimento")
                );

                artista.setConjugues(rs.getString("conjugues")
                );

                artista.setQuantAlbuns(rs.getInt("quant_albuns")
                );

                artista.setAlbuns(rs.getString("albuns")
                );

                int dataFalecimento =rs.getInt("data_falecimento");

                if (rs.wasNull()) {
                    dataFalecimento = 0;
                }

                artista.setDataFalecimento(dataFalecimento);

                artista.setIdade(
                        rs.getInt("idade")
                );

                artista.setLocalNascimento(
                        rs.getString("local_nascimento")
                );

                lista.add(artista);
            }

        } catch (SQLException erro) {

            throw new RuntimeException(
                    "Erro ao listar: " + erro.getMessage(),
                    erro
            );
        }

        return lista;
    }

    public int contar() {

        String sql =
                "SELECT COUNT(*) FROM artista";

        try (
            Connection con = abrir();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 0;

        } catch (SQLException erro) {

            throw new RuntimeException(
                    "Erro ao contar: " + erro.getMessage(),
                    erro
            );
        }
    }

    public static void main(String[] args) {

        ArtistaRepositorioBD bd =
                new ArtistaRepositorioBD();

        try (Connection con = bd.abrir()) {

            System.out.println(
                    "Conexao OK com " + con.getCatalog()
            );

            System.out.println(
                    "Registros: " + bd.contar()
            );

        } catch (SQLException erro) {

            System.out.println(
                    "Falha: " + erro.getMessage()
            );
        }
    }
}