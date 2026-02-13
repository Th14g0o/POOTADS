package projetoFinal.logica.persistencia.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import projetoFinal.logica.interfaces.IDataAcessObject;
import projetoFinal.logica.modelos.Jogo;
import projetoFinal.logica.persistencia.BD;

public class JogoDAO implements IDataAcessObject<Jogo> {
    public Jogo inserir(Jogo p) {
        String sql = "INSERT INTO Jogo (nome, imagem) VALUES (?, ?)";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getNome());
            ps.setBytes(2, p.getImagem());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getLong(1));
                }
            }
            return p;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Jogo: " + e.getMessage(), e);
        }
    }

    public void atualizar(Jogo p) {
        if (p.getId() == null) throw new IllegalArgumentException("Jogo sem id");

        String sql = "UPDATE Jogo SET nome=?, imagem=? WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNome());
            ps.setBytes(2, p.getImagem());
            ps.setLong(3, p.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Jogo: " + e.getMessage(), e);
        }
    }

    public Jogo buscarPorId(Long id) {
        String sql = "SELECT id, nome, imagem FROM Jogo WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                Jogo p = new Jogo();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setImagem(rs.getBytes("imagem"));
                return p;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Jogo: " + e.getMessage(), e);
        }
    }

    public List<Jogo> listarTodos() {
        String sql = "SELECT id, nome, imagem FROM Jogo ORDER BY id DESC";
        List<Jogo> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Jogo p = new Jogo();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setImagem(rs.getBytes("imagem"));
                lista.add(p);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Jogos: " + e.getMessage(), e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM Jogo WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Jogo: " + e.getMessage(), e);
        }
    }
   
}
