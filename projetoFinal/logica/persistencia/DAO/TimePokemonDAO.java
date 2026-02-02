package projetoFinal.logica.persistencia.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import projetoFinal.logica.interfaces.IDataAcessObject;
import projetoFinal.logica.modelos.TimePokemon;
import projetoFinal.logica.persistencia.BD;

public class TimePokemonDAO implements IDataAcessObject<TimePokemon> {

    public TimePokemon inserir(TimePokemon tp) {
        String sql = """
            INSERT INTO TimePokemon (idPokemon, idTime)
            VALUES (?, ?)
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, tp.getIdPokemon());
            ps.setLong(2, tp.getIdTime());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    tp.setId(rs.getLong(1));
                }
            }

            return tp;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir TimePokemon: " + e.getMessage(), e);
        }
    }

    public void atualizar(TimePokemon tp) {
        if (tp.getId() == null) throw new IllegalArgumentException("TimePokemon sem id");

        String sql = """
            UPDATE TimePokemon
            SET idPokemon=?, idTime=?
            WHERE id=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, tp.getIdPokemon());
            ps.setLong(2, tp.getIdTime());
            ps.setLong(3, tp.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar TimePokemon: " + e.getMessage(), e);
        }
    }

    public TimePokemon buscarPorId(Long id) {
        String sql = """
            SELECT id, idPokemon, idTime
            FROM TimePokemon
            WHERE id=?
        """;

        try (Connection conn = BD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) 
        {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                TimePokemon tp = new TimePokemon();
                tp.setId(rs.getLong("id"));
                tp.setIdPokemon(rs.getLong("idPokemon"));
                tp.setIdTime(rs.getLong("idTime"));

                return tp;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar TimePokemon: " + e.getMessage(), e);
        }
    }

    public List<TimePokemon> listarTodos() {
        String sql = """
            SELECT id, idPokemon, idTime
            FROM TimePokemon
            ORDER BY id DESC
        """;

        List<TimePokemon> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TimePokemon tp = new TimePokemon();
                tp.setId(rs.getLong("id"));
                tp.setIdPokemon(rs.getLong("idPokemon"));
                tp.setIdTime(rs.getLong("idTime"));
                lista.add(tp);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar TimePokemon: " + e.getMessage(), e);
        }
    }

    public List<TimePokemon> listarPokemons(Long idTime) {
       String sql = """
            SELECT id, idPokemon, idTime
            FROM TimePokemon
            WHERE idTime=?
        """;

        List<TimePokemon> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setLong(1, idTime);

            ResultSet rs = ps.executeQuery(); 

            while (rs.next()) {
                TimePokemon tp = new TimePokemon();
                tp.setId(rs.getLong("id"));
                tp.setIdPokemon(rs.getLong("idPokemon"));
                tp.setIdTime(rs.getLong("idTime"));
                lista.add(tp);
            }
            
            return lista;
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar TimePokemon: " + e.getMessage(), e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM TimePokemon WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar TimePokemon: " + e.getMessage(), e);
        }
    }
}
