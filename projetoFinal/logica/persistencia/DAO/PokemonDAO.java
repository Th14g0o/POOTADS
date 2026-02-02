package projetoFinal.logica.persistencia.DAO;

import projetoFinal.logica.persistencia.BD;
import projetoFinal.logica.interfaces.IDataAcessObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import projetoFinal.logica.modelos.Pokemon;

public class PokemonDAO implements IDataAcessObject<Pokemon> {

    public Pokemon inserir(Pokemon p) {
        String sql = "INSERT INTO Pokemon (nome, imagem) VALUES (?, ?)";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getNome());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getLong(1));
                }
            }
            return p;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir pokemon: " + e.getMessage(), e);
        }
    }

    public void atualizar(Pokemon p) {
        if (p.getId() == null) throw new IllegalArgumentException("Pokemon sem id");

        String sql = "UPDATE Pokemon SET nome=?, imagem=? WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNome());
            ps.setBytes(2, p.getImagem());
            ps.setLong(3, p.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar pokemon: " + e.getMessage(), e);
        }
    }

    public Pokemon buscarPorId(Long id) {
        String sql = "SELECT id, nome, imagem FROM Pokemon WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                Pokemon p = new Pokemon();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setImagem(rs.getBytes("imagem"));
                return p;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar pokemon: " + e.getMessage(), e);
        }
    }

    public List<Pokemon> listarTodos() {
        String sql = "SELECT id, nome, imagem FROM Pokemon ORDER BY id DESC";
        List<Pokemon> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pokemon p = new Pokemon();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setImagem(rs.getBytes("imagem"));
                lista.add(p);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar pokemons: " + e.getMessage(), e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM Pokemon WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar pokemon: " + e.getMessage(), e);
        }
    }
}
