import java.util.ArrayList;

public class Autor{
    public String nome;
    public static ArrayList<Autor> autores = new ArrayList<Autor>();
    

    public Autor(String nome){
        this.nome = nome;

        autores.add(this);
    }

    public String toString(){
        return "Nome: " + this.nome;
    }

    public static void listarAutores(){
        for(int i = 0; i < autores.size(); i++){
            System.out.println(i + " - " + autores.get(i).toString());
        }
    }

}