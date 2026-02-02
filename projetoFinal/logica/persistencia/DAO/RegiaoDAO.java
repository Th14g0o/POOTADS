package projetoFinal.logica.persistencia.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import projetoFinal.logica.interfaces.IDataAcessObject;
import projetoFinal.logica.modelos.Regiao;
import projetoFinal.logica.persistencia.BD;

public class RegiaoDAO implements IDataAcessObject<Regiao> {

    public Regiao inserir(Regiao r) {
        String sql = "INSERT INTO Regiao (nome) VALUES (?)";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, r.getNome());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    r.setId(rs.getLong(1));
                }
            }
            return r;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Regiao: " + e.getMessage(), e);
        }
    }

    public void atualizar(Regiao r) {
        if (r.getId() == null) throw new IllegalArgumentException("Regiao sem id");

        String sql = "UPDATE Regiao SET nome=? WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, r.getNome());
            ps.setLong(2, r.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Regiao: " + e.getMessage(), e);
        }
    }

    public Regiao buscarPorId(Long id) {
        String sql = "SELECT id, nome FROM Regiao WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                Regiao r = new Regiao();
                r.setId(rs.getLong("id"));
                r.setNome(rs.getString("nome"));
                return r;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Regiao: " + e.getMessage(), e);
        }
    }

    public List<Regiao> listarTodos() {
        String sql = "SELECT id, nome FROM Regiao ORDER BY id DESC";
        List<Regiao> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Regiao r = new Regiao();
                r.setId(rs.getLong("id"));
                r.setNome(rs.getString("nome"));
                lista.add(r);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Regioes: " + e.getMessage(), e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM Regiao WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Regiao: " + e.getMessage(), e);
        }
    }
}
