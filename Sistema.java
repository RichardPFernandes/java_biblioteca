import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Connection connManager = null;
        try {
            connManager = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gestao_biblioteca",
                    "root",
                    "");
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
            System.out.println(e.getMessage());
            return;
        }
        int op = 0;

        do {
            System.out.println("Sistema Biblioteca");
            System.out.println("0 - Sair");
            System.out.println("1 - Criar Autor");
            System.out.println("2 - Criar Biblioteca");
            System.out.println("3 - Criar Livro");
            System.out.println("4 - Emprestar Midia");
            System.out.println("5 - Devolver Midia");
            System.out.println("6 - Adicionar Midia Digital");
            System.out.println("7 - Listar todas as midias");
            System.out.println("8 - Listar todos autores");
            System.out.println("Digite a opção");
            try {
                op = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Opção invalida");
                op = -1;
                sc.nextLine();
            }
            switch (op) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    System.out.println("Digite o nome do autor");
                    String nome = sc.next();
                    System.out.println("Digite a nacionalidade do autor");
                    String nacionalidade = sc.next();
                    Autor autor = new Autor(nome, nacionalidade);
                    Autor.adicionarAutor(autor, connManager);

                    break;
                case 2:
                    System.out.println("Digite o nome da biblioteca");
                    String nomeBiblioteca = sc.next();
                    Biblioteca biblioteca = new Biblioteca(nomeBiblioteca);
                    try {
                        biblioteca.adicionarBiblioteca(biblioteca, connManager);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Digite o titulo do livro");
                    String titulo = sc.next();
                    Autor.listarAutores(connManager);
                    sc.nextLine();

                    System.out.println("Digite o id do autor");
                    int idAutor = sc.nextInt();
                    Autor autorLivro = Autor.findAutor(connManager, idAutor);
                    Biblioteca.listarBibliotecas(connManager);
                    System.out.println("Digite o id da biblioteca");
                    int idBiblioteca = sc.nextInt();
                    Biblioteca bibliotecaLivro = Biblioteca.findBiblioteca(connManager, idBiblioteca);
                    Livro livro = new Livro(titulo, true);
                    Livro.adicionarLivro(connManager, livro, autorLivro, bibliotecaLivro);

                    break;
                case 4:
                    System.out.println("Selecione o tipo de midia");
                    System.out.println("1 - Livro");
                    System.out.println("2 - Midia Digital");
                    int tipoMidia = sc.nextInt();
                    if (tipoMidia == 1) {
                        System.out.println("Digite o id do livro");
                        Livro.listarLivros(connManager);
                        int idLivro = sc.nextInt();
                        Livro.emprestar(connManager, idLivro);
                    }
                    if (tipoMidia == 2) {
                        System.out.println("Digite o id da midia digital");
                        MidiaDigital.listarMidiasDigitais(connManager);
                        int idMidiaDigital = sc.nextInt();
                        MidiaDigital.emprestar(connManager, idMidiaDigital);
                    }

                    break;
                case 5:
                    System.out.println("Selecione o tipo de midia");
                    System.out.println("1 - Livro");
                    System.out.println("2 - Midia Digital");
                    tipoMidia = sc.nextInt();
                    if (tipoMidia == 1) {
                        System.out.println("Digite o id do livro");
                        Livro.listarLivros(connManager);
                        int idLivro = sc.nextInt();
                        Livro.devolver(connManager, idLivro);
                    }
                    if (tipoMidia == 2) {
                        System.out.println("Digite o id da midia digital");
                        MidiaDigital.listarMidiasDigitais(connManager);
                        int idMidiaDigital = sc.nextInt();
                        MidiaDigital.devolver(connManager, idMidiaDigital);
                    }

                    break;

                case 6:
                    sc.nextLine();
                    System.out.println("Digite o titulo da midia digital");
                    String tituloMidiaDigital = sc.nextLine();
                    System.out.println("Digite o album da midia digital");
                    String album = sc.nextLine();
                    Biblioteca.listarBibliotecas(connManager);
                    System.out.println("Digite o id da biblioteca");
                    idBiblioteca = sc.nextInt();
                    Biblioteca bibliotecaMidiaDigital = Biblioteca.findBiblioteca(connManager, idBiblioteca);
                    MidiaDigital midiaDigital = new MidiaDigital(tituloMidiaDigital, album, true);
                    MidiaDigital.adicionarMidiaDigital(connManager, midiaDigital, bibliotecaMidiaDigital);

                    break;

                case 7:
                    System.out.println("Selecione o tipo de midia");
                    System.out.println("1 - Livro");
                    System.out.println("2 - Midia Digital");
                    tipoMidia = sc.nextInt();
                    if (tipoMidia == 1) {
                        Livro.listarLivros(connManager);
                    }
                    if (tipoMidia == 2) {
                        MidiaDigital.listarMidiasDigitais(connManager);
                    }
                    break;
                
                case 8:
                    Autor.listarAutores(connManager);
                    break;

             
                default:
                    System.out.println("Opcão invalida");
                    break;
            }
        } while (op != 0);
    }

}
