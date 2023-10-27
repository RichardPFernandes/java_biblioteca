import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op = 0;

        do {
            System.out.println("Sistema Biblioteca");
            System.out.println("0 - Sair");
            System.out.println("1 - Criar Autor");
            System.out.println("2 - Criar Livro");
            System.out.println("3 - Criar Biblioteca");
            System.out.println("4 - Adicionar Livro");
            System.out.println("5 - Emprestar Midia");
            System.out.println("6 - Devolver Midia");
            System.out.println("7 - Adicionar Midia Digital");
            System.out.println("8 - Listar todas as midias");
            System.out.println("9 - Listar todos autores");
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
                    new Autor(nome, nacionalidade);
                    break;
                case 2:
                    if(Autor.autores.size() == 0){
                        System.out.println("Não existe autor cadastrado");
                        break;
                    }
                    System.out.println("Digite o titulo");
                    sc.nextLine();
                    String titulo = sc.nextLine();
                    int posicaoAutor = -1;
                    do {
                        Autor.listarAutores();
                        System.out.println("Digite o numero do autor");
                        try {
                            posicaoAutor = sc.nextInt();
                            if (posicaoAutor >= Autor.autores.size()) {
                                throw new Exception("Autor Invalido");
                            }
                        } catch (Exception e) {
                            System.out.println("Autor Invalido");
                            posicaoAutor = -1;
                        }
                    } while (posicaoAutor < 0);
                    Autor autor = Autor.autores.get(posicaoAutor);
                    new Livro(titulo, autor, true);
                    break;
                case 3:
                    System.out.println("Digite o nome da biblioteca");
                    String nomeBiblioteca = sc.next();
                    new Biblioteca(nomeBiblioteca);
                    break;
                case 4:
                    if(Biblioteca.bibliotecas.size() == 0 || Livro.livros.size() == 0){
                        System.out.println("Não existe biblioteca cadastrada ou livro cadastrado");
                        break;
                    }
                    System.out.println("Digite o numero da biblioteca");
                    Biblioteca.listarBiblotecas();
                    int posicaoBiblioteca = -1;
                    do {
                        try {
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca Invalida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca Invalida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);
                    Biblioteca biblioteca = Biblioteca.bibliotecas.get(posicaoBiblioteca);
                    System.out.println("Digite o numero do livro");
                    Livro.listarLivros();
                    int posicaoLivro = -1;
                    do {
                        try {
                            posicaoLivro = sc.nextInt();
                            if (posicaoLivro >= Livro.livros.size()) {
                                throw new Exception("Livro Invalido");
                            }
                        } catch (Exception e) {
                            System.out.println("Livro Invalido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0);
                    Livro livro = Livro.livros.get(posicaoLivro);
                    if(biblioteca.midias.contains(livro)){
                        System.out.println("Livro já cadastrado na biblioteca");
                        break;
                    }
                    biblioteca.adicionarLivro(livro);
                    break;
                case 5:
                    if(Biblioteca.bibliotecas.size() == 0){
                        System.out.println("Não existe biblioteca cadastrada ou livro cadastrado");
                        break;
                    }
                    System.out.println("Digite o numero da biblioteca");
                    Biblioteca.listarBiblotecas();
                    posicaoBiblioteca = -1;
                    do {
                        try {
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca Invalida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca Invalida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);
                    biblioteca = Biblioteca.bibliotecas.get(posicaoBiblioteca);
                    System.out.println("Digite o numero da midia desejada");
                    biblioteca.listarMidias();
                    posicaoLivro = -1;
                    do {
                        try {
                            posicaoLivro = sc.nextInt();
                            if (posicaoLivro >= biblioteca.midias.size()) {
                                throw new Exception("Livro Invalido");
                            }
                        } catch (Exception e) {
                            System.out.println("Livro Invalido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0);
                    Midia midia = biblioteca.midias.get(posicaoLivro);
                    try {
                        midia.emprestar();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    if(Biblioteca.bibliotecas.size() == 0){
                        System.out.println("Não existe biblioteca cadastrada");
                        break;
                    }
                    System.out.println("Digite o numero da biblioteca");
                    Biblioteca.listarBiblotecas();
                    posicaoBiblioteca = -1;
                    do {
                        try {
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca Invalida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca Invalida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);
                    biblioteca = Biblioteca.bibliotecas.get(posicaoBiblioteca);
                    System.out.println("Digite o numero do livro");
                    biblioteca.listarMidias();
                    posicaoLivro = -1;
                    do {
                        try {
                            posicaoLivro = sc.nextInt();
                            if (posicaoLivro >= biblioteca.midias.size()) {
                                throw new Exception("Livro Invalido");
                            }
                        } catch (Exception e) {
                            System.out.println("Livro Invalido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0);
                    midia = biblioteca.midias.get(posicaoLivro);
                    try {
                        midia.devolver();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                 if(Biblioteca.bibliotecas.size() == 0){
                        System.out.println("Não existe biblioteca cadastrada ou livro cadastrado");
                        break;
                    }
                System.out.println("Digite o numero da biblioteca");
                Biblioteca.listarBiblotecas();
                posicaoBiblioteca = -1;
                do {
                        try {
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca Invalida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca Invalida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);
                biblioteca = Biblioteca.bibliotecas.get(posicaoBiblioteca);
                System.out.println("Digite o album da midia digital");
                String album = sc.nextLine();
                album = sc.nextLine();
                System.out.println("Digite o titulo");
                titulo = sc.nextLine();
                biblioteca.adiocionarMidiaDigital(new MidiaDigital(titulo, album, true));
                break;

                case 8:
                System.out.println("Digite o numero da biblioteca");
                Biblioteca.listarBiblotecas();
                posicaoBiblioteca = -1;
                do {
                        try {
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca Invalida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca Invalida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);
                biblioteca = Biblioteca.bibliotecas.get(posicaoBiblioteca);
                biblioteca.listarMidias();
                System.out.println("Digite enter para continuar");
                sc.nextLine();
                sc.nextLine();
        
                break;

                case 9:
                if(Autor.autores.size() == 0){
                    System.out.println("Não existe autores cadastrados");
                }
                Autor.listarAutores();
                System.out.println("Digite enter para continuar");
                sc.nextLine();
                sc.nextLine();

                break;

                default:
                    System.out.println("Opcão invalida");
                    break;
            }
        } while (op != 0);
    }

}
