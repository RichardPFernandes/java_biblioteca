import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class Biblioteca {
    private String nome;
    private int id;

    public Biblioteca(String nome){
        this.nome = nome;

    }

    public Biblioteca(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String toString(){
        return "Nome: "+ this.nome;
    }

    public void adicionarBiblioteca(Biblioteca biblioteca, Connection conn) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("INSERT INTO biblioteca (nome) VALUES (?)");
        ps.setString(1, biblioteca.getNome());
        ps.executeUpdate();
    }


     public static Biblioteca findBiblioteca(Connection conn, int id) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM biblioteca WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            Biblioteca biblioteca = new Biblioteca(rs.getInt("id"), rs.getString("nome"));
            return biblioteca;
        }else{
            return null;
        }
        
     }
        
    
     public static void listarBibliotecas(Connection conn) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM biblioteca");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("id") + " - " + rs.getString("nome"));
        }
        
     }
}
