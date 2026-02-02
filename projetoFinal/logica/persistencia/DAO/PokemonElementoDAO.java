package projetoFinal.logica.persistencia.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import projetoFinal.logica.interfaces.IDataAcessObject;
import projetoFinal.logica.modelos.PokemonElemento;
import projetoFinal.logica.persistencia.BD;

public class PokemonElementoDAO implements IDataAcessObject<PokemonElemento> {

    public PokemonElemento inserir(PokemonElemento pe) {
        String sql = """
            INSERT INTO PokemonElemento (idPokemon, idElemento, idJogo)
            VALUES (?, ?, ?)
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, pe.getIdPokemon());
            ps.setLong(2, pe.getIdElemento());
            ps.setLong(3, pe.getIdJogo());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    pe.setId(rs.getLong(1));
                }
            }

            return pe;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir PokemonElemento: " + e.getMessage(), e);
        }
    }

    public void atualizar(PokemonElemento pe) {
        if (pe.getId() == null) throw new IllegalArgumentException("PokemonElemento sem id");

        String sql = """
            UPDATE PokemonElemento
            SET idPokemon=?, idElemento=?, idJogo=?
            WHERE id=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, pe.getIdPokemon());
            ps.setLong(2, pe.getIdElemento());
            ps.setLong(3, pe.getIdJogo());
            ps.setLong(4, pe.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar PokemonElemento: " + e.getMessage(), e);
        }
    }

    public PokemonElemento buscarPorId(Long id) {
        String sql = """
            SELECT id, idPokemon, idElemento, idJogo
            FROM PokemonElemento
            WHERE id=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                PokemonElemento pe = new PokemonElemento();
                pe.setId(rs.getLong("id"));
                pe.setIdPokemon(rs.getLong("idPokemon"));
                pe.setIdElemento(rs.getLong("idElemento"));
                pe.setIdJogo(rs.getLong("idJogo"));

                return pe;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar PokemonElemento: " + e.getMessage(), e);
        }
    }

    public List<PokemonElemento> listarTodos() {
        String sql = """
            SELECT id, idPokemon, idElemento, idJogo
            FROM PokemonElemento
            ORDER BY id DESC
        """;

        List<PokemonElemento> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PokemonElemento pe = new PokemonElemento();
                pe.setId(rs.getLong("id"));
                pe.setIdPokemon(rs.getLong("idPokemon"));
                pe.setIdElemento(rs.getLong("idElemento"));
                pe.setIdJogo(rs.getLong("idJogo"));

                lista.add(pe);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar PokemonElemento: " + e.getMessage(), e);
        }
    }

    public List<PokemonElemento> listarElementosPorPokemonJogo(long idPokemon, long idJogo) {
        String sql = """
            SELECT id, idPokemon, idElemento, idJogo
            FROM PokemonElemento
            WHERE idPokemon=? AND  idJogo=?
        """;

        List<PokemonElemento> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
             
            ps.setLong(1, idPokemon);
            ps.setLong(2, idJogo);
             
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PokemonElemento pe = new PokemonElemento();
                pe.setId(rs.getLong("id"));
                pe.setIdPokemon(rs.getLong("idPokemon"));
                pe.setIdElemento(rs.getLong("idElemento"));
                pe.setIdJogo(rs.getLong("idJogo"));

                lista.add(pe);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar PokemonElemento: " + e.getMessage(), e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM PokemonElemento WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar PokemonElemento: " + e.getMessage(), e);
        }
    }
}
