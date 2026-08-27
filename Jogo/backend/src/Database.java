import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL =
            "jdbc:sqlite:backend/database/jogo.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void criarTabelas() {

        String sqlJogadores = """
            CREATE TABLE IF NOT EXISTS jogadores (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL
            );
        """;

        String sqlPartidas = """
            CREATE TABLE IF NOT EXISTS partidas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                jogador_id INTEGER NOT NULL,
                kills INTEGER NOT NULL,
                tempo_segundos INTEGER NOT NULL,
                FOREIGN KEY (jogador_id)
                REFERENCES jogadores(id)
            );
        """;

        try (Connection conexao = conectar();
             Statement stmt = conexao.createStatement()) {

            System.out.println("CONEXAO COM SQLITE OK!");

            stmt.execute(sqlJogadores);
            stmt.execute(sqlPartidas);

            System.out.println("TABELAS CRIADAS!");

        } catch (SQLException e) {
            System.out.println("ERRO NO SQLITE:");
            e.printStackTrace();
        }
    }
}