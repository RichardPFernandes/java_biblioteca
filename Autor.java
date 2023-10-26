import java.util.ArrayList;

public class Autor extends Pessoa{
    private String nacionalidade;
    public static ArrayList<Autor> autores = new ArrayList<Autor>();
    

    public Autor(String nome, String nacionalidade){
        super(nome);
        this.nacionalidade = nacionalidade;
        autores.add(this);
    }

    public void setNacionalidade(String nacionalidade){
        this.nacionalidade = nacionalidade;
    }

    public String getNacionalidade(){
        return this.nacionalidade;
    }
    
    public ArrayList<Autor> getAutores(){
        return Autor.autores;
    }

    public static void listarAutores(){
        for(int i = 0; i < autores.size(); i++){
            System.out.println(i + " - " + autores.get(i).toString());
        }
    }

    public String toString(){
        return "Nome do Autor: " + super.getNome() + 
        " Nacionalidade do Autor: " + this.nacionalidade;
    }

}