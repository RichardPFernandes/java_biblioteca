import java.sql.Connection;
import java.sql.PreparedStatement;

public class MidiaDigital extends Midia{
    private String album;

    public MidiaDigital(String titulo, String album, boolean disponivel){
        super(titulo, disponivel);
        this.album = album;
    }


    public void setAlbum(String album){
        this.album = album;
    }

    public String getAlbum(){
        return this.album;
    }

    public String toString(){
        return "Album: " + this.album + super.toString();
    }

    public static void adicionarMidiaDigital(Connection conn, MidiaDigital midiaDigital, Biblioteca biblioteca) throws Exception{
        PreparedStatement ps = conn.prepareStatement("INSERT INTO midia_digital (titulo, album, disponivel, id_biblioteca) VALUES (?, ?, ?, ?)");
        ps.setString(1, midiaDigital.getTitulo());
        ps.setString(2, midiaDigital.getAlbum());
        ps.setBoolean(3, midiaDigital.getDisponivel());
        ps.setInt(4, biblioteca.getId());
        ps.executeUpdate();
    }

    public static void listarMidiasDigitais(Connection conn) throws Exception{
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM midia_digital");
        java.sql.ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("id") + " - " + rs.getString("titulo") + " - " + rs.getString("album") + " - " + (rs.getBoolean("disponivel") == true ? "Disponivel" : "Indisponivel"));
        }
    }

    public static void emprestar(Connection conn, int id) throws Exception{
        PreparedStatement ps = conn.prepareStatement("UPDATE midia_digital SET disponivel = false WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static void devolver(Connection conn, int id) throws Exception{
        PreparedStatement ps = conn.prepareStatement("UPDATE midia_digital SET disponivel = true WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    

}
