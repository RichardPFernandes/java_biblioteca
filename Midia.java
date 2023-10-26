public class Midia {
    private String titulo;
    private boolean disponivel;
    
    public Midia(String titulo, boolean disponivel){
        this.titulo = titulo;
        this.disponivel = disponivel;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public boolean getDisponivel(){
        return this.disponivel;
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

    public String toString(){
        return " Titulo: " + this.titulo 
        + " Disponibilidade: " + (disponivel ? "Sim" : "Não");
    }
}
