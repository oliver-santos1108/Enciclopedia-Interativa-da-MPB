package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ArtistaRepositorio {
	
	public boolean nomeExiste(String nome, Integer idIgnorado) throws SQLException {
	    String sql = "SELECT COUNT(*) FROM artista "
	               + "WHERE LOWER(TRIM(nome)) = LOWER(TRIM(?)) ";

	    if (idIgnorado != null) {
	        sql += "AND id_artista <> ?";
	    }

	    try (Connection con = Conexao.abrir();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, nome.trim());

	        if (idIgnorado != null) {
	            ps.setInt(2, idIgnorado);
	        }

	        try (ResultSet rs = ps.executeQuery()) {
	            rs.next();
	            return rs.getInt(1) > 0;
	        }
	    }
	}

	public void inserir(Artista a) throws SQLException {

	    if (nomeExiste(a.getNome(), null)) {
	        throw new SQLException(
	            "Já existe um artista cadastrado com esse nome."
	        );
	    }

	    String sql = "INSERT INTO artista "
	        + "(nome, data_nascimento, quant_albuns, albuns, "
	        + "data_falecimento, local_nascimento, foto) "
	        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

	    try (Connection con = Conexao.abrir();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        preencher(ps, a);
	        ps.executeUpdate();
	    }
	}

	public void atualizar(Artista a) throws SQLException {

	    if (nomeExiste(a.getNome(), a.getIdArtista())) {
	        throw new SQLException(
	            "Já existe outro artista cadastrado com esse nome!"
	        );
	    }

	    String sql = "UPDATE artista SET nome=?, data_nascimento=?, "
	        + "quant_albuns=?, albuns=?, data_falecimento=?, "
	        + "local_nascimento=?, foto=? WHERE id_artista=?";

	    try (Connection con = Conexao.abrir();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        preencher(ps, a);
	        ps.setInt(8, a.getIdArtista());
	        ps.executeUpdate();
	    }
	}

    private void preencher(PreparedStatement ps, Artista a) throws SQLException {
        ps.setString(1, a.getNome().trim());
        ps.setInt(2, a.getDataNascimento());
        ps.setInt(3, a.getQuantAlbuns());
        ps.setString(4, a.getAlbuns().trim());
        if (a.getDataFalecimento() == null) ps.setNull(5, Types.INTEGER);
        else ps.setInt(5, a.getDataFalecimento());
        ps.setString(6, a.getLocalNascimento().trim());
        if (a.getFoto() == null || a.getFoto().length == 0) ps.setNull(7, Types.BLOB);
        else ps.setBytes(7, a.getFoto());
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM artista WHERE id_artista=?";
        try (Connection con = Conexao.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Artista> listarTodos() throws SQLException {
        return consultar(null);
    }

    public List<Artista> pesquisar(String trecho) throws SQLException {
        return consultar(trecho);
    }

    private List<Artista> consultar(String trecho) throws SQLException {
        List<Artista> lista = new ArrayList<>();
        String sql = "SELECT id_artista, nome, data_nascimento, quant_albuns, albuns, "
            + "data_falecimento, local_nascimento FROM artista ";
        if (trecho != null && !trecho.trim().isEmpty()) sql += "WHERE nome LIKE ? ";
        sql += "ORDER BY nome";
        try (Connection con = Conexao.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {
            if (trecho != null && !trecho.trim().isEmpty())
                ps.setString(1, "%" + trecho.trim() + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Artista a = new Artista();
                    a.setIdArtista(rs.getInt("id_artista"));
                    a.setNome(rs.getString("nome"));
                    a.setDataNascimento(rs.getInt("data_nascimento"));
                    a.setQuantAlbuns(rs.getInt("quant_albuns"));
                    a.setAlbuns(rs.getString("albuns"));
                    int falecimento = rs.getInt("data_falecimento");
                    a.setDataFalecimento(rs.wasNull() ? null : falecimento);
                    a.setLocalNascimento(rs.getString("local_nascimento"));
                    lista.add(a);
                }
            }
        }
        return lista;
    }

    public byte[] buscarFoto(int id) throws SQLException {
        String sql = "SELECT foto FROM artista WHERE id_artista=?";
        try (Connection con = Conexao.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getBytes("foto");
            }
        }
        return null;
    }

    public Artista buscarPorId(int id) throws SQLException {
        String sql = "SELECT id_artista, nome, data_nascimento, quant_albuns, albuns, "
            + "data_falecimento, local_nascimento FROM artista WHERE id_artista=?";
        try (Connection con = Conexao.abrir();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                Artista a = new Artista();
                a.setIdArtista(rs.getInt("id_artista"));
                a.setNome(rs.getString("nome"));
                a.setDataNascimento(rs.getInt("data_nascimento"));
                a.setQuantAlbuns(rs.getInt("quant_albuns"));
                a.setAlbuns(rs.getString("albuns"));
                int falecimento = rs.getInt("data_falecimento");
                a.setDataFalecimento(rs.wasNull() ? null : falecimento);
                a.setLocalNascimento(rs.getString("local_nascimento"));
                a.setFoto(buscarFoto(id));
                return a;
            }
        }
    }
}
