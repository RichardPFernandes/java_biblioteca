import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Livro extends Midia{
    private Autor autor;


    public Livro(String titulo, Autor autor, boolean disponivel) {
        super(titulo,disponivel);
        this.autor = autor;

    }

    public Livro(String titulo, boolean disponivel){
        super(titulo, disponivel);
    }

    public Autor geAutor(){
        return this.autor;
    }

    public void setAutor(Autor autor){
        this.autor = autor;
    }


    public String toString(){
        return this.autor + super.toString();
    }

    public static void adicionarLivro(Connection conn, Livro livro, Autor autor, Biblioteca biblioteca) throws Exception{
        PreparedStatement ps = conn.prepareStatement("INSERT INTO livro (titulo, disponivel, id_autor, id_biblioteca) VALUES (?, ?, ?, ?)");
        ps.setString(1, livro.getTitulo());
        ps.setBoolean(2, livro.getDisponivel());
        ps.setInt(3, autor.getId());
        ps.setInt(4, biblioteca.getId());
        ps.executeUpdate();
    }

    public static void listarLivros(Connection conn) throws Exception{
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM livro");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("id") + " - " + rs.getString("titulo") + " - " + (rs.getBoolean("disponivel") == true ? "Disponivel" : "Indisponivel"));
        }
    }

    public static void emprestar(Connection conn, int id) throws Exception{
        PreparedStatement ps = conn.prepareStatement("UPDATE livro SET disponivel = false WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static void devolver(Connection conn, int id) throws Exception{
        PreparedStatement ps = conn.prepareStatement("UPDATE livro SET disponivel = true WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

 


}
