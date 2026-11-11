package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class Conexao {
    private static final String URL =
        "jdbc:mysql://localhost:3306/mpb?useSSL=false&serverTimezone=America/Sao_Paulo&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "aluno_cd";
    private static final String SENHA = "aluno_pw";

    private Conexao() { }

    public static Connection abrir() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
