package projetoFinal.logica.persistencia.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import projetoFinal.logica.interfaces.IDataAcessObject;
import projetoFinal.logica.modelos.Evolucao;
import projetoFinal.logica.persistencia.BD;

public class EvolucaoDAO implements IDataAcessObject<Evolucao>{
    public Evolucao inserir(Evolucao p) {
        String sql = """
            INSERT INTO Evolucao (idPokemon, idEvolucao, estagio, requisitos) 
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, p.getPokemonId());
            ps.setLong(2, p.getEvolucaoId());
            ps.setLong(3, p.getEstagio());
            ps.setString(4, p.getRequisitos());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getLong(1));
                }
            }
            return p;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Evolução: " + e.getMessage(), e);
        }
    }

    public void atualizar(Evolucao p) {
        if (p.getId() == null) throw new IllegalArgumentException("Evolução sem id");

        String sql = """
            UPDATE Evolucao SET idPokemon=?, idEvolucao=?, estagio=?, requisitos=? 
            WHERE id=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, p.getPokemonId());
            ps.setLong(2, p.getEvolucaoId());
            ps.setLong(3, p.getEstagio());
            ps.setString(4, p.getRequisitos());
            ps.setLong(5, p.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Evolução: " + e.getMessage(), e);
        }
    }

    public Evolucao buscarPorId(Long id) {
        String sql = """
            SELECT id, idPokemon, idEvolucao, estagio, requisitos FROM Evolucao 
            WHERE id=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                Evolucao p = new Evolucao();
                p.setId(rs.getLong("id"));
                p.setEstagio(rs.getInt("estagio"));
                p.setEvolucaoId(rs.getLong("idEvolucao"));
                p.setPokemonId(rs.getLong("idPokemon"));
                p.setRequisitos(rs.getString("requisitos"));
                return p;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Evolução: " + e.getMessage(), e);
        }
    }

    public List<Evolucao> listarTodos() {
        String sql = """
            SELECT id, idPokemon, idEvolucao, estagio, requisitos FROM Evolucao 
            ORDER BY id DESC
        """;
        List<Evolucao> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Evolucao p = new Evolucao();
                p.setId(rs.getLong("id"));
                p.setEstagio(rs.getInt("estagio"));
                p.setEvolucaoId(rs.getLong("idEvolucao"));
                p.setPokemonId(rs.getLong("idPokemon"));
                p.setRequisitos(rs.getString("requisitos"));
                lista.add(p);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Evoluções: " + e.getMessage(), e);
        }
    }

    public Evolucao listarPorPokemon(Long idPokemon) {
        String sql = """
            SELECT id, idPokemon, idEvolucao, estagio, requisitos FROM Evolucao 
            WHERE idPokemon=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, idPokemon);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                Evolucao p = new Evolucao();
                p.setId(rs.getLong("id"));
                p.setEstagio(rs.getInt("estagio"));
                p.setEvolucaoId(rs.getLong("idEvolucao"));
                p.setPokemonId(rs.getLong("idPokemon"));
                p.setRequisitos(rs.getString("requisitos"));
                return p;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Evolução: " + e.getMessage(), e);
        }
    }

    public Evolucao listarPorPokemonEvolucao(Long idEvolucao) {
        String sql = """
            SELECT id, idPokemon, idEvolucao, estagio, requisitos FROM Evolucao 
            WHERE idEvolucao=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, idEvolucao);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                Evolucao p = new Evolucao();
                p.setId(rs.getLong("id"));
                p.setEstagio(rs.getInt("estagio"));
                p.setEvolucaoId(rs.getLong("idEvolucao"));
                p.setPokemonId(rs.getLong("idPokemon"));
                p.setRequisitos(rs.getString("requisitos"));
                return p;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Evolução: " + e.getMessage(), e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM Evolucao WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Evolução: " + e.getMessage(), e);
        }
    }
}