package br.com.senaicimatec.agualife;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BancodeDados {
    private static final String URL = "jdbc:sqlite:atletas.db";

    public static void criarTabelas() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS atleta (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT, " +
                    "idade INTEGER, " +
                    "peso REAL, " +
                    "sexo TEXT);";
            stmt.execute(sql);
            sql = "CREATE TABLE IF NOT EXISTS consumo_agua (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "id_atleta INTEGER, " +
                    "data TEXT, " +
                    "quantidade REAL, " +
                    "FOREIGN KEY(id_atleta) REFERENCES atleta(id));";
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Atleta> getAtletasFromDatabase() {
        List<Atleta> atletas = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/meu_banco_de_dados", "usuario", "senha");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM atletas");

            while (rs.next()) {
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                double peso = rs.getDouble("peso");

                Atleta atleta = new Atleta(nome, idade, peso);
                atletas.add(atleta);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return atletas;
    }
}
