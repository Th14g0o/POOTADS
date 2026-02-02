package projetoFinal.logica.persistencia.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import projetoFinal.logica.interfaces.IDataAcessObject;
import projetoFinal.logica.modelos.Time;
import projetoFinal.logica.persistencia.BD;

public class TimeDAO implements IDataAcessObject<Time> {

    public Time inserir(Time t) {
        String sql = "INSERT INTO Time (nome) VALUES (?)";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, t.getNome());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    t.setId(rs.getLong(1));
                }
            }
            return t;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Time: " + e.getMessage(), e);
        }
    }

    public void atualizar(Time t) {
        if (t.getId() == null) throw new IllegalArgumentException("Time sem id");

        String sql = "UPDATE Time SET nome=? WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, t.getNome());
            ps.setLong(2, t.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Time: " + e.getMessage(), e);
        }
    }

    public Time buscarPorId(Long id) {
        String sql = "SELECT id, nome FROM Time WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                Time t = new Time();
                t.setId(rs.getLong("id"));
                t.setNome(rs.getString("nome"));
                return t;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Time: " + e.getMessage(), e);
        }
    }

    public List<Time> listarTodos() {
        String sql = "SELECT id, nome FROM Time ORDER BY id DESC";
        List<Time> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Time t = new Time();
                t.setId(rs.getLong("id"));
                t.setNome(rs.getString("nome"));
                lista.add(t);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Times: " + e.getMessage(), e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM Time WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Time: " + e.getMessage(), e);
        }
    }
}
