import java.util.ArrayList;

public class Livro extends Midia{
    private Autor autor;

    public static ArrayList<Livro> livros = new ArrayList<>();

    public Livro(String titulo, Autor autor, boolean disponivel) {
        super(titulo,disponivel);
        this.autor = autor;

        livros.add(this);
    }

    public Autor geAutor(){
        return this.autor;
    }

    public void setAutor(Autor autor){
        this.autor = autor;
    }


    public static void listarLivros(){
        for(int i = 0; i < livros.size(); i++){
            System.out.println(i + " - " + livros.get(i).toString());
        }
    }

    public String toString(){
        return this.autor + super.toString();
    }

 


}
