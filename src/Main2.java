import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    static ArrayList<Livro> acervo = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        while (true) {
            System.out.println("""
					=== Biblioteca Piriri Parara ===
					Digite para:
					1 - Emprestar um livro - ok
					2 - Devolver um livro - ok
					3 - Adicionar novo livro - ok
					4 - Adicionar novo usuario - ok
					5 - Remover livro - ok
					6 - Remover usuario - ok
					7 - Exibir acervo completo - ok
					8 - Exibir todos os usuarios - 
					9 - Exibir emprestimos de um usuario -
					10 - Sair - ok
					""");
            System.out.print("Informe a opção: ");
            int temp = scan.nextInt();
            scan.nextLine();
            switch (temp) {
                case 1:
                    System.out.println("- Emprestar um livro -");
                    System.out.println("Informe o cpf do usuario: ");
                    String cpf3 = scan.next();
                    System.out.println("Informe o ISBN do livro: ");
                    String isbn2 = scan.next();
                    emprestarLivro(cpf3, isbn2);
                    break;

                case 2:
                    System.out.println("- Devolver um livro -");
                    System.out.print("Informe o cpf do usuario: ");
                    String devolverCpf = scan.next();
                    System.out.print("Informe o ISBN do livro para devolução: ");
                    String devolverISBN = scan.next();
                    devolverLivro(devolverCpf, devolverISBN);
                    break;

                case 3:
                    System.out.println("- Adicionar novo livro -");
                    System.out.print("Informe o titulo: ");
                    String titulo = scan.nextLine();
                    System.out.print("Informe o autor: ");
                    String autor = scan.nextLine();
                    System.out.print("informe o ISBN: ");
                    String isbn = scan.nextLine();
                    System.out.print("Informe o ano de publicação: ");
                    int anoPub = scan.nextInt();
                    adicionarLivro(titulo, autor, isbn, anoPub);
                    break;

                case 4:
                    System.out.println("- Adicionar novo usuario -");
                    System.out.print("Informe o nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Informe o cpf (apenas numeros): ");
                    String cpf = scan.next();
                    System.out.println();
                    adicionarUsuario(nome, cpf);
                    break;


                case 5:
                    System.out.println("- Remover um livro -");
                    System.out.println("Informe o isbn do livro");
                    String isbn1 = scan.next();
                    removerLivro(isbn1);
                    break;

                case 6:
                    System.out.println("- Remover usuario -");
                    System.out.println("Informe o CPf do usuario");
                    String cpf2 = scan.next();
                    removerUsuario(cpf2);
                    break;

                case 10:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        }
    }
    public static void emprestarLivro(String cpf, String isbn) {
        boolean usuarioEncontrado = false;
        boolean livroEncontrado = false;
        for (Usuario u : listaUsuarios) {
            if (u.getCpf().equals(cpf)) {
                usuarioEncontrado = true;

                for (Livro l : acervo) {
                    if (l.getIsbn().equals(isbn)) {
                        livroEncontrado = true;
                        u.addEmprestimo(l);
                        break;
                    }
                }
                break;
            }
        }

        if (!usuarioEncontrado) {
            for (Livro l : acervo) {
                if (l.getIsbn().equals(isbn)) {
                    livroEncontrado = true;
                    break;
                }
            }
        }

        if (!usuarioEncontrado && !livroEncontrado) {
            System.out.println("Nem usuario nem livro foi encontrado");
        } else if (!usuarioEncontrado) {
            System.out.println("Usuario não encontrado");
        } else if (!livroEncontrado) {
            System.out.println("Livro não encontrado");
        }
    }

    public static void devolverLivro(String cpf, String isbn) {
        for (Usuario u : listaUsuarios) {
            if (u.getCpf().equals(cpf)) {
                u.devolerLivro(isbn);
            }
        }
    }

    public static void adicionarLivro(String titulo, String autor, String isbn, int anoPub) {
        boolean x = true;
        for (Livro l : acervo) {
            if (l.getIsbn().equals(isbn)) {
                System.out.println("Livro ja cadastrado");
                x = false;
            }
        }
        if (x) {
            Livro livro = new Livro(titulo, autor, isbn, anoPub);
            acervo.add(livro);
        }
    }

    public static void adicionarUsuario(String nome, String cpf) {
        boolean y = true;
        for (Usuario u : listaUsuarios) {
            if (u.getCpf().equals(cpf)) {
                System.out.println("Cpf ja cadastrado");
                y = false;
            }
        }
        if (y) {
            Usuario usuario = new Usuario(nome, cpf);
            listaUsuarios.add(usuario);
        }
    }

    public static void removerLivro(String isbn) {
        for (Livro l : acervo) {
            if (l.getIsbn().equals((isbn))) {
                acervo.removeIf(item -> item.equals(isbn));
            }
        }
        System.out.println("Livro removido");
    }

    public static void removerUsuario(String cpf) {
        for (Usuario u : listaUsuarios) {
            if (u.getCpf().equals(cpf)) {
                listaUsuarios.removeIf(item -> item.equals(cpf));
            }
        }
        System.out.println("Usuario removido");
    }
}
