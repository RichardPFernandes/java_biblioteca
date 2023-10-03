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
            System.out.println("5 - Emprestar Livro");
            System.out.println("6 - Devolver Livro");
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
                    new Autor(nome);
                    break;
                case 2:
                    if(Autor.autores.size() == 0){
                        System.out.println("Não existe autor cadastrado");
                        break;
                    }
                    System.out.println("Digite o titulo");
                    String titulo = sc.next();
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
                    if(biblioteca.livros.contains(livro)){
                        System.out.println("Livro já cadastrado na biblioteca");
                        break;
                    }
                    biblioteca.adicionarLivro(livro);
                    break;
                case 5:
                    if(Biblioteca.bibliotecas.size() == 0 || Livro.livros.size() == 0){
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
                    System.out.println("Digite o numero do livro");
                    biblioteca.listarlivros();
                    posicaoLivro = -1;
                    do {
                        try {
                            posicaoLivro = sc.nextInt();
                            if (posicaoLivro >= biblioteca.livros.size()) {
                                throw new Exception("Livro Invalido");
                            }
                        } catch (Exception e) {
                            System.out.println("Livro Invalido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0);
                    livro = biblioteca.livros.get(posicaoLivro);
                    try {
                        livro.emprestar();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    if(Biblioteca.bibliotecas.size() == 0 || Livro.livros.size() == 0){
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
                    System.out.println("Digite o numero do livro");
                    biblioteca.listarlivros();
                    posicaoLivro = -1;
                    do {
                        try {
                            posicaoLivro = sc.nextInt();
                            if (posicaoLivro >= biblioteca.livros.size()) {
                                throw new Exception("Livro Invalido");
                            }
                        } catch (Exception e) {
                            System.out.println("Livro Invalido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0);
                    livro = biblioteca.livros.get(posicaoLivro);
                    try {
                        livro.devolver();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Opcão invalida");
                    break;
            }
        } while (op != 0);
    }

}
