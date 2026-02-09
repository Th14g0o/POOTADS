package projetoFinal.logica.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class Migracoes {

    public static void main(String[] args) {
        Migracoes.migrar();
    }

    private static void migrar() {
        Migracoes.criarTabelaJogo();
        Migracoes.criarTabelaRegiao();
        Migracoes.criarTabelaPokemon();
        Migracoes.criarTabelaElemento();
        Migracoes.criarTabelaPokemonElemento();
        Migracoes.criarTabelaFraquezaVantagem();
        Migracoes.criarTabelaEvolucao();
        Migracoes.criarTabelaPokedex();
        Migracoes.criarTabelaTime();
        Migracoes.criarTabelaTimePokemon();
        Migracoes.criarIndices();
    }

    private static void executarMigracao(String sql){
        try (Connection conn = BD.getConnection();
            Statement st = conn.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao migrar banco: " + e.getMessage(), e);
        }
    }

    private static void criarTabelaJogo(){
        String sql = """
            CREATE TABLE IF NOT EXISTS Jogo (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                imagem BLOB
            );
        """;
        Migracoes.executarMigracao(sql);
    }

    private static void criarTabelaPokemon(){
        String sql = """
            CREATE TABLE IF NOT EXISTS Pokemon (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                imagem BLOB
            );
        """;
        Migracoes.executarMigracao(sql);
    }

    private static void criarTabelaRegiao(){
        String sql = """
            CREATE TABLE IF NOT EXISTS Regiao (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL
            );
        """;
        Migracoes.executarMigracao(sql);
    }

    private static void criarTabelaElemento(){
        String sql = """
            CREATE TABLE IF NOT EXISTS Elemento (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                cor TEXT,
                imagem BLOB
            );
        """;
        Migracoes.executarMigracao(sql);
    }

    private static void criarTabelaPokemonElemento(){
        String sql = """
            CREATE TABLE IF NOT EXISTS PokemonElemento (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                idPokemon INTEGER NOT NULL,
                idElemento INTEGER NOT NULL,
                idJogo INTEGER NOT NULL,

                UNIQUE (idPokemon, idElemento, idJogo),
                FOREIGN KEY (idPokemon) REFERENCES Pokemon(id) ON DELETE CASCADE,
                FOREIGN KEY (idElemento) REFERENCES Elemento(id) ON DELETE CASCADE,
                FOREIGN KEY (idJogo) REFERENCES Jogo(id) ON DELETE CASCADE
            );
        """;
        Migracoes.executarMigracao(sql);
    }

    private static void criarTabelaTime(){
        String sql = """
            CREATE TABLE IF NOT EXISTS Time (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                idJogo INTEGER NOT NULL, 

                FOREIGN KEY (idJogo) REFERENCES Jogo(id) ON DELETE CASCADE
            );
        """;
        Migracoes.executarMigracao(sql);
    }


    private static void criarTabelaFraquezaVantagem(){
        String sql = """
            CREATE TABLE IF NOT EXISTS FraquezaVantagem (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                idJogo INTEGER NOT NULL,
                idElementoAlvo INTEGER NOT NULL,
                idElementoFraquezaVantagem INTEGER NOT NULL,
                ehFraqueza INTEGER NOT NULL,
                multiplicador REAL NOT NULL,

                UNIQUE (idElementoFraquezaVantagem, idElementoAlvo, idJogo),
                FOREIGN KEY (idElementoAlvo) REFERENCES Elemento(id) ON DELETE CASCADE,
                FOREIGN KEY (idElementoFraquezaVantagem) REFERENCES Elemento(id) ON DELETE CASCADE,
                FOREIGN KEY (idJogo) REFERENCES Jogo(id) ON DELETE CASCADE
            );
        """;
        Migracoes.executarMigracao(sql);
    }

    private static void criarTabelaEvolucao(){
        String sql = """
            CREATE TABLE IF NOT EXISTS Evolucao (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                idPokemon INTEGER NOT NULL,
                idEvolucao INTEGER NOT NULL,
                estagio INTEGER NOT NULL,
                requisitos TEXT NOT NULL,
                estagioEvolucao INTEGER NOT NULL,
                idJogo INTEGER NOT NULL,

                UNIQUE (idPokemon, idEvolucao),
                FOREIGN KEY (idPokemon) REFERENCES Pokemon(id) ON DELETE CASCADE,
                FOREIGN KEY (idEvolucao) REFERENCES Pokemon(id) ON DELETE CASCADE,
                FOREIGN KEY (idJogo) REFERENCES Jogo(id) ON DELETE CASCADE
            );
        """;
        Migracoes.executarMigracao(sql);
    }

    private static void criarTabelaPokedex(){
        String sql = """
            CREATE TABLE IF NOT EXISTS Pokedex (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                idPokemon INTEGER NOT NULL,
                idAnterior INTEGER,
                idProximo INTEGER,
                idJogo INTEGER NOT NULL,
                idRegiao INTEGER NOT NULL,
                numeroPokemon INTEGER NOT NULL,
                descricaoPokemon TEXT NOT NULL,
                cor TEXT,

                UNIQUE (idPokemon, idJogo, idRegiao, numeroPokemon),
                FOREIGN KEY (idPokemon) REFERENCES Pokemon(id) ON DELETE CASCADE,
                FOREIGN KEY (idRegiao) REFERENCES Regiao(id) ON DELETE CASCADE,
                FOREIGN KEY (idJogo) REFERENCES Jogo(id) ON DELETE CASCADE
            );
        """;
        Migracoes.executarMigracao(sql);
    }

    private static void criarTabelaTimePokemon(){
        String sql = """
            CREATE TABLE IF NOT EXISTS TimePokemon (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                idPokemon INTEGER NOT NULL,
                idTime INTEGER NOT NULL,

                UNIQUE (idPokemon, idTime),
                FOREIGN KEY (idPokemon) REFERENCES Pokemon(id) ON DELETE CASCADE,
                FOREIGN KEY (idTime) REFERENCES Time(id) ON DELETE CASCADE
            );
        """;
        Migracoes.executarMigracao(sql);
    }

    private static void criarIndices(){
        String sql = """
            CREATE INDEX IF NOT EXISTS idx_pe_pokemon   ON PokemonElemento(idPokemon);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_pe_elemento  ON PokemonElemento(idElemento);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_pe_jogo      ON PokemonElemento(idJogo);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_fv_jogo      ON FraquezaVantagem(idJogo);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_fv_alvo      ON FraquezaVantagem(idElementoAlvo);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_fv_fv        ON FraquezaVantagem(idElementoFraquezaVantagem);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_ev_pokemon   ON Evolucao(idPokemon);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_ev_evolucao  ON Evolucao(idEvolucao);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_evol_jogo  ON Evolucao(idJogo);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_px_pokemon   ON Pokedex(idPokemon);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_px_jogo      ON Pokedex(idJogo);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_px_regiao    ON Pokedex(idRegiao);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_tp_time      ON TimePokemon(idTime);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_tp_pokemon   ON TimePokemon(idPokemon);
        """;
        Migracoes.executarMigracao(sql);
        sql = """
            CREATE INDEX IF NOT EXISTS idx_time_jogo   ON Time(idJogo);
        """;
        Migracoes.executarMigracao(sql);
    }
}
