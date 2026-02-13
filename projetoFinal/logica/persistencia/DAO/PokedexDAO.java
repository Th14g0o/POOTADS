package projetoFinal.logica.persistencia.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import projetoFinal.logica.interfaces.IDataAcessObject;
import projetoFinal.logica.modelos.Pokedex;
import projetoFinal.logica.persistencia.BD;

public class PokedexDAO implements IDataAcessObject<Pokedex> {

    public Pokedex inserir(Pokedex p) {
        String sql = """
            INSERT INTO Pokedex
            (
                idPokemon, idAnterior, idProximo, idJogo, idRegiao, numeroPokemon,
                descricaoPokemon, cor
             )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, p.getIdPokemon());
            if (p.getIdAnterior() != null) ps.setLong(2, p.getIdAnterior());
            else ps.setNull(2,  Types.BIGINT); 
            if (p.getIdAnterior() != null) ps.setLong(3, p.getIdProximo());
            else ps.setNull(3,  Types.BIGINT);
            ps.setLong(4, p.getIdJogo());
            ps.setLong(5, p.getIdRegiao());
            ps.setInt(6, p.getNumeroPokemon());
            ps.setString(7, p.getDescricaoPokemon());
            ps.setString(8, p.getCor());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) p.setId(rs.getLong(1));
            }

            return p;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Pokedex: " + e.getMessage(), e);
        }
    }

    public void atualizar(Pokedex p) {
        if (p.getId() == null) throw new IllegalArgumentException("Pokedex sem id");

        String sql = """
            UPDATE Pokedex
               SET idPokemon=?,
                   idAnterior=?,
                   idProximo=?,
                   idJogo=?,
                   idRegiao=?,
                   numeroPokemon=?,
                   descricaoPokemon=?,
                   cor=?
             WHERE id=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, p.getIdPokemon());
            if (p.getIdAnterior() != null) ps.setLong(2, p.getIdAnterior());
            else ps.setString(2, "NULL"); 
            if (p.getIdAnterior() != null) ps.setLong(3, p.getIdProximo());
            else ps.setString(3, "NULL");
            ps.setLong(4, p.getIdJogo());
            ps.setLong(5, p.getIdRegiao());
            ps.setInt(6, p.getNumeroPokemon());
            ps.setString(7, p.getDescricaoPokemon());
            ps.setString(8, p.getCor());
            ps.setLong(9, p.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Pokedex: " + e.getMessage(), e);
        }
    }

    public Pokedex buscarPorId(Long id) {
        String sql = """
            SELECT 
                id, idPokemon, idAnterior, idProximo, idJogo, idRegiao, numeroPokemon,
                descricaoPokemon, cor
            FROM Pokedex
             WHERE id=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                Pokedex p = new Pokedex();
                p.setId(rs.getLong("id"));
                p.setIdPokemon(rs.getLong("idPokemon"));
                p.setIdAnterior(rs.getLong("idAnterior"));
                p.setIdProximo(rs.getLong("idProximo"));
                p.setIdJogo(rs.getLong("idJogo"));
                p.setIdRegiao(rs.getLong("idRegiao"));
                p.setNumeroPokemon(rs.getInt("numeroPokemon"));
                p.setDescricaoPokemon(rs.getString("descricaoPokemon"));
                p.setCor(rs.getString("cor")); 
                return p;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Pokedex: " + e.getMessage(), e);
        }
    }

    public Pokedex buscarPorIdJogoPokemon(Long idJogo, long idPokemon) {
        String sql = """
            SELECT 
                id, idPokemon, idAnterior, idProximo, idJogo, idRegiao, numeroPokemon,
                descricaoPokemon, cor
            FROM Pokedex
             WHERE idJogo=? AND idPokemon=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, idJogo);
            ps.setLong(1, idPokemon);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                Pokedex p = new Pokedex();
                p.setId(rs.getLong("id"));
                p.setIdPokemon(rs.getLong("idPokemon"));
                p.setIdAnterior(rs.getLong("idAnterior"));
                p.setIdProximo(rs.getLong("idProximo"));
                p.setIdJogo(rs.getLong("idJogo"));
                p.setIdRegiao(rs.getLong("idRegiao"));
                p.setNumeroPokemon(rs.getInt("numeroPokemon"));
                p.setDescricaoPokemon(rs.getString("descricaoPokemon"));
                p.setCor(rs.getString("cor")); 
                return p;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Pokedex: " + e.getMessage(), e);
        }
    }


    public List<Pokedex> listarTodos() {
        String sql = """
            SELECT 
                id, idPokemon, idAnterior, idProximo, idJogo, idRegiao, numeroPokemon, 
                descricaoPokemon, cor
            FROM Pokedex
            ORDER BY id DESC
        """;

        List<Pokedex> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pokedex p = new Pokedex();
                p.setId(rs.getLong("id"));
                p.setIdPokemon(rs.getLong("idPokemon"));
                p.setIdAnterior(rs.getLong("idAnterior"));
                p.setIdProximo(rs.getLong("idProximo"));
                p.setIdJogo(rs.getLong("idJogo"));
                p.setIdRegiao(rs.getLong("idRegiao"));
                p.setNumeroPokemon(rs.getInt("numeroPokemon"));
                p.setDescricaoPokemon(rs.getString("descricaoPokemon"));
                p.setCor(rs.getString("cor"));

                lista.add(p);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Pokedex: " + e.getMessage(), e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM Pokedex WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Pokedex: " + e.getMessage(), e);
        }
    }
}
