import java.util.ArrayList;

public class Livro {
    public String titulo;
    public boolean disponivel;
    public Autor autor;

    public static ArrayList<Livro> livros = new ArrayList<>();

    public Livro(String titulo, Autor autor, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;

        livros.add(this);
    }

    public String toString() {
        return " Titulo: " + this.titulo
         + " Autor: " + this.autor 
         + " Disponivel: " + (this.disponivel ? "Sim" : "Não");
    }

    public static void listarLivros(){
        for(int i = 0; i < livros.size(); i++){
            System.out.println(i + " - " + livros.get(i).toString());
        }
    }

    public void emprestar() throws Exception{
        if(!this.disponivel){
            throw new Exception("Livro não está disponivel");
        }
        this.disponivel = false;
    }

    public void devolver() throws Exception{
        if(this.disponivel){
            throw new Exception("Não foi possivel devolver o livro");
        }
        this.disponivel = true;
    }


}
