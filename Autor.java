import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Autor extends Pessoa {
    private int id;
    private String nacionalidade;

    public Autor(String nome, String nacionalidade) {
        super(nome);
        this.nacionalidade = nacionalidade;
    }

    public Autor(int id, String nome, String nacionalidade) {
        super(nome);
        this.id = id;
        this.nacionalidade = nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void adicionarAutor(Autor autor, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO autor (nome, nacionalidade) VALUES (?, ?)");
        ps.setString(1, autor.getNome());
        ps.setString(2, autor.getNacionalidade());
        ps.executeUpdate();

    }

    public static void listarAutores(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM autor");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " - " + rs.getString("nome") + " - " + rs.getString("nacionalidade"));
        }

    }

    public static Autor findAutor(Connection conn, int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM autor WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Autor autor = new Autor(rs.getInt("id"), rs.getString("nome"), rs.getString("nacionalidade"));
            return autor;
        } else {
            return null;
        }

    }

    public String toString() {
        return "Nome do Autor: " + super.getNome() +
                " Nacionalidade do Autor: " + this.nacionalidade;
    }

}