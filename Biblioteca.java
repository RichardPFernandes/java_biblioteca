import java.lang.reflect.Array;
import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    public ArrayList<Midia> midias;
    public static ArrayList<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();

    public Biblioteca(String nome){
        this.nome = nome;
        this.midias = new ArrayList<>();

        bibliotecas.add(this);
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


    public void adicionarLivro(Livro livro){
        this.midias.add(livro);
    }

    public void adiocionarMidiaDigital(MidiaDigital midiaDigital){
        this.midias.add(midiaDigital);
    }
    
    public void listarMidias(){
        for (int i = 0; i < midias.size(); i++){
            System.out.println(i + " - " + midias.get(i).toString());
        }
    }

    public static void listarBiblotecas(){
       for(int i = 0; i < bibliotecas.size(); i++){
           System.out.println(i + " - " + bibliotecas.get(i).toString());
       }
    }
}
