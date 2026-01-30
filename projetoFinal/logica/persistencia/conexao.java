package projetoFinal.logica.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public static void main(String[] args) {
        // O caminho do banco de dados (será criado automaticamente)
        String url = "jdbc:sqlite:projetoFinal/banco.db";
        
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexão com SQLite estabelecida!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
