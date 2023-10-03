import java.util.ArrayList;

public class Biblioteca {
    public String nome;
    public ArrayList<Livro> livros;
    public static ArrayList<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();

    public Biblioteca(String nome){
        this.nome = nome;
        this.livros = new ArrayList<>();

        bibliotecas.add(this);
    }

    public String toString(){
        return "Nome: "+ this.nome;
    }

    public void adicionarLivro(Livro livro){
        this.livros.add(livro);

    }
    
    public void listarlivros(){
        for (int i = 0; i < livros.size(); i++){
            System.out.println(i + " - " + livros.get(i).toString());
        }
    }

    public static void listarBiblotecas(){
       for(int i = 0; i < bibliotecas.size(); i++){
           System.out.println(i + " - " + bibliotecas.get(i).toString());
       }
    }
}
