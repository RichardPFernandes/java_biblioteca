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
    

}
