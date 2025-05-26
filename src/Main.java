import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    static ArrayList<Livro> acervo = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        while (true) {
            System.out.println("""
                    === Biblioteca Piriri Parara ===
                    Digite para:
                    1 - Emprestar um livro
                    2 - Devolver um livro
                    3 - Adicionar novo livro
                    4 - Adicionar novo usuario
                    5 - Remover livro
                    6 - Remover usuario
                    7 - Exibir acervo completo
                    8 - Exibir todos os usuarios
                    9 - Exibir emprestimo de um usuario
                    10 - Sair
                    """);
            System.out.print("Informe a opção: ");
            int temp = scan.nextInt();
            scan.nextLine();

            switch (temp) {
                case 1: emprestarLivro();break;

                case 2: devolverLivro();break;

                case 3: adicionarLivro();break;

                case 4: adicionarUsuario();break;

                case 5: removerLivro();break;

                case 6: removerUsuario();break;

                case 7: exibeAcervo();break;
                   
                case 8: exibeUsuarios();break;

                case 9: exibirEmprestimos();break;

                case 10: System.exit(0); break;

                default: System.out.println("Opção Invalida"); break;
            }
        }
    }
    public static void emprestarLivro() {
        System.out.println("- Emprestar um livro -");
        System.out.print("Informe o cpf do usuario: ");
        String cpf = (new Scanner(System.in).nextLine());
        System.out.print("Informe o ISBN do livro: ");
        String isbn = (new Scanner(System.in).nextLine());
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
            System.out.println("Nem usuario nem livro foi encontrado\n");
        } else if (!usuarioEncontrado) {
            System.out.println("Usuario não encontrado\n");
        } else if (!livroEncontrado) {
            System.out.println("Livro não encontrado\n");
        } else {
            System.out.println("Livro Emprestado!\n");
        }
    }

    public static void devolverLivro() {
        System.out.println("- Devolver um livro -");
        System.out.print("Informe o cpf do usuario: ");
        String cpf = (new Scanner(System.in).nextLine());
        System.out.print("Informe o ISBN do livro para devolução: ");
        String isbn = (new Scanner(System.in).nextLine());
        for (Usuario u : listaUsuarios) {
            if (u.getCpf().equals(cpf)) {
                if (u.getEmprestimos().isEmpty()) {
                    System.out.println("Nenhum livro emprestado");
                } else {
                    u.devolerLivro(isbn);
                }
            } else {
                System.out.println("Usuario não encontrado");
            }
        }
        System.out.println();
    }

    public static void adicionarLivro() {
        System.out.println("- Adicionar novo livro -");
        System.out.print("Informe o titulo: ");
        String titulo = (new Scanner(System.in).nextLine());
        System.out.print("Informe o autor: ");
        String autor = (new Scanner(System.in).nextLine());
        System.out.print("informe o ISBN: ");
        String isbn = (new Scanner(System.in).nextLine());
        System.out.print("Informe o ano de publicação: ");
        int anoPub = (new Scanner(System.in).nextInt());
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
        System.out.println();
    }

    public static void adicionarUsuario() {
        System.out.println("- Adicionar novo usuario -");
        System.out.print("Informe o nome: ");
        String nome = (new Scanner(System.in).nextLine());
        System.out.print("Informe o cpf (apenas numeros): ");
        String cpf = (new Scanner(System.in)).nextLine();
        System.out.println();
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

    public static void removerLivro() {
        System.out.println("- Remover um livro -");
        System.out.print("Informe o isbn do livro: ");
        String isbn = (new Scanner(System.in).nextLine());
        boolean control = true;
        for (Livro l : acervo) {
            if (l.getIsbn().equals((isbn))) {
                acervo.remove(l);
                System.out.println("Livro removido\n");
                control = false;
                break;
            }
        }
        if (control) {
            System.out.println("Livro não encontrado\n");
        }
    }

    public static void removerUsuario() {
        System.out.println("- Remover usuario -");
        System.out.print("Informe o CPf do usuario: ");
        String cpf = (new Scanner(System.in).nextLine());
        boolean control = true;
        for (Usuario u : listaUsuarios) {
            if (u.getCpf().equals(cpf)) {
                listaUsuarios.remove(u);
                System.out.println("Usuario removido\n");
                control = false;
                break;
            }
        }
        if (control) {
            System.out.println("Usuario não encontrado\n");
        }
    }

    public static void exibeAcervo() {
        System.out.println("- Exibir acervo completo -");
        if (acervo.isEmpty()) {
            System.out.println("Não existem livros no acervo");
        } else {
            for (Livro livro : acervo) {
                System.out.println(livro);
            }
        }
        System.out.println();
    }

    public static void exibeUsuarios() {
        System.out.println("- Exibir todos os usuarios -");
        if (listaUsuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado");
        } else
            for (Usuario usuario : listaUsuarios) {
                System.out.println(usuario);
            }
        System.out.println();
    }

    public static void exibirEmprestimos() {
        System.out.println("- Exibir emprestimos de um usuario -");
        System.out.print("Informe o cpf do usuario: ");
        String cpf = (new Scanner(System.in)).nextLine();
        for (Usuario u : listaUsuarios) {
            if (u.getCpf().equals(cpf)) {
                if (u.getEmprestimos().isEmpty()) {
                    System.out.println("O usuario não tem livros emprestados! ");
                } else {
                    System.out.println(u.getEmprestimos());
                }
            }
        }
        System.out.println();
    }
}