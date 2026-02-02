package projetoFinal.logica.persistencia.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import projetoFinal.logica.interfaces.IDataAcessObject;
import projetoFinal.logica.modelos.Elemento;
import projetoFinal.logica.persistencia.BD;

public class ElementoDAO implements IDataAcessObject<Elemento> {
    public Elemento inserir(Elemento p) {
        String sql = "INSERT INTO Elemento (nome, cor, imagem) VALUES (?, ? , ?)";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getNome());
            ps.setString(2, p.getCor());
            ps.setBytes(3, p.getImagem());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getLong(1));
                }
            }
            return p;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Elemento: " + e.getMessage(), e);
        }
    }

    public void atualizar(Elemento p) {
        if (p.getId() == null) throw new IllegalArgumentException("Elemento sem id");

        String sql = "UPDATE Elemento SET nome=?, cor=?, imagem=? WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNome());
            ps.setString(2, p.getCor());
            ps.setBytes(3, p.getImagem());
            ps.setLong(4, p.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Elemento: " + e.getMessage(), e);
        }
    }

    public Elemento buscarPorId(Long id) {
        String sql = "SELECT id, nome, cor, imagem FROM Elemento WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                Elemento p = new Elemento();
                p.setId(rs.getLong("id"));
                 p.setNome(rs.getString("nome"));
                p.setCor(rs.getString("cor"));
                p.setImagem(rs.getBytes("imagem"));
                return p;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Elemento: " + e.getMessage(), e);
        }
    }

    public List<Elemento> listarTodos() {
        String sql = "SELECT id, nome, cor, imagem FROM Elemento ORDER BY id DESC";
        List<Elemento> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Elemento p = new Elemento();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setCor(rs.getString("cor"));
                p.setImagem(rs.getBytes("imagem"));
                lista.add(p);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Elementos: " + e.getMessage(), e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM Elemento WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar Elemento: " + e.getMessage(), e);
        }
    }
}
