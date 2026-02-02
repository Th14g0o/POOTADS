package projetoFinal.logica.persistencia.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import projetoFinal.logica.interfaces.IDataAcessObject;
import projetoFinal.logica.modelos.FraquezaVantagem;
import projetoFinal.logica.persistencia.BD;

public class FraquezaVantagemDAO implements IDataAcessObject<FraquezaVantagem> {

    public FraquezaVantagem inserir(FraquezaVantagem fv) {
        String sql = """
            INSERT INTO FraquezaVantagem
                (idJogo, idElementoAlvo, idElementoFraquezaVantagem, ehFraqueza, multiplicador)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, fv.getIdJogo());
            ps.setLong(2, fv.getIdElementoAlvo());
            ps.setLong(3, fv.getIdElementoFraquezaVantagem());
            ps.setInt(4, fv.getEhFraqueza() ? 1 : 0);      // boolean -> 0/1
            ps.setDouble(5, fv.getMultiplicador());       // double -> REAL

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    fv.setId(rs.getLong(1));
                }
            }
            return fv;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir FraquezaVantagem: " + e.getMessage(), e);
        }
    }

    public void atualizar(FraquezaVantagem fv) {
        if (fv.getId() == null) throw new IllegalArgumentException("FraquezaVantagem sem id");

        String sql = """
            UPDATE FraquezaVantagem
               SET idJogo=?,
                   idElementoAlvo=?,
                   idElementoFraquezaVantagem=?,
                   ehFraqueza=?,
                   multiplicador=?
             WHERE id=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, fv.getIdJogo());
            ps.setLong(2, fv.getIdElementoAlvo());
            ps.setLong(3, fv.getIdElementoFraquezaVantagem());
            ps.setInt(4, fv.getEhFraqueza() ? 1 : 0);
            ps.setDouble(5, fv.getMultiplicador());
            ps.setLong(6, fv.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar FraquezaVantagem: " + e.getMessage(), e);
        }
    }

    public FraquezaVantagem buscarPorId(Long id) {
        String sql = """
            SELECT id, idJogo, idElementoAlvo, idElementoFraquezaVantagem, ehFraqueza, multiplicador
              FROM FraquezaVantagem
             WHERE id=?
        """;

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                FraquezaVantagem fv = new FraquezaVantagem();
                fv.setId(rs.getLong("id"));
                fv.setIdJogo(rs.getLong("idJogo"));
                fv.setIdElementoAlvo(rs.getLong("idElementoAlvo"));
                fv.setIdElementoFraquezaVantagem(rs.getLong("idElementoFraquezaVantagem"));
                fv.setEhFraqueza(rs.getInt("ehFraqueza") != 0);
                fv.setMultiplicador(rs.getDouble("multiplicador"));

                return fv;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar FraquezaVantagem: " + e.getMessage(), e);
        }
    }

    public List<FraquezaVantagem> listarTodos() {
        String sql = """
            SELECT id, idJogo, idElementoAlvo, idElementoFraquezaVantagem, ehFraqueza, multiplicador
              FROM FraquezaVantagem
             ORDER BY id DESC
        """;

        List<FraquezaVantagem> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                FraquezaVantagem fv = new FraquezaVantagem();
                fv.setId(rs.getLong("id"));
                fv.setIdJogo(rs.getLong("idJogo"));
                fv.setIdElementoAlvo(rs.getLong("idElementoAlvo"));
                fv.setIdElementoFraquezaVantagem(rs.getLong("idElementoFraquezaVantagem"));
                fv.setEhFraqueza(rs.getInt("ehFraqueza") != 0);
                fv.setMultiplicador(rs.getDouble("multiplicador"));

                lista.add(fv);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar FraquezaVantagem: " + e.getMessage(), e);
        }
    }

    public List<FraquezaVantagem> listarPorElementoJogo(long idElemento, long idJogo) {
        String sql = """
            SELECT id, idJogo, idElementoAlvo, idElementoFraquezaVantagem, ehFraqueza, multiplicador
            FROM FraquezaVantagem
            WHERE idElementoAlvo=? AND idJogo=? 
        """;

        List<FraquezaVantagem> lista = new ArrayList<>();

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
             
            ps.setLong(1, idElemento);
            ps.setLong(2, idJogo);
             
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FraquezaVantagem fv = new FraquezaVantagem();
                fv.setId(rs.getLong("id"));
                fv.setIdJogo(rs.getLong("idJogo"));
                fv.setIdElementoAlvo(rs.getLong("idElementoAlvo"));
                fv.setIdElementoFraquezaVantagem(rs.getLong("idElementoFraquezaVantagem"));
                fv.setEhFraqueza(rs.getInt("ehFraqueza") != 0);
                fv.setMultiplicador(rs.getDouble("multiplicador"));

                lista.add(fv);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar FraquezaVantagem: " + e.getMessage(), e);
        }
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM FraquezaVantagem WHERE id=?";

        try (Connection conn = BD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar FraquezaVantagem: " + e.getMessage(), e);
        }
    }
}
