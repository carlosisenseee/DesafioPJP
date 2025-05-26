import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    static ArrayList<Livro> acervo = new ArrayList<>();
    static ArrayList<Funcionario> colaboradores = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Emprestar Livro, Usuario pode pegar 3 livros iguas, e erro na mensagem ao atingir a quantidade maxima

        //Implementar Funcionario

        Livro livro1 = new Livro("Livro1", "Autor1", "1", 1980);
        Livro livro2 = new Livro("Livro2", "Autor2", "2", 2000);
        Livro livro3 = new Livro("Livro3", "Autor3", "3", 2000);
        Livro livro4 = new Livro("Livro4", "Autor4", "4", 2000);
        acervo.add(livro1);
        acervo.add(livro2);
        acervo.add(livro3);
        acervo.add(livro4);

        Usuario u1 = new Usuario("Carlos", "123");
        listaUsuarios.add(u1);

        Funcionario f1 = new Funcionario("Carlos", "1234", "Gerente dona de tudo");
        colaboradores.add(f1);

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
                    10 - Adicionar Funcionario
                    11 - Excluir Funcionario
                    12 - Mostrar Funcionarios
                    13 - Sair
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

                case 10: adicionarFuncionario(); break;

                case 11: excluirFuncionario(); break;

                case 12: mostrarFuncionarios(); break;

                case 13: System.exit(0); break;

                default: System.out.println("Opção Invalida"); break;
            }
        }
    }
    public static void emprestarLivro() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum funcionario Cadastrado\n");
        } else {
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
            }
        }
    }

    public static void devolverLivro() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum funcionario Cadastrado\n");
        } else {
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
    }

    public static void adicionarLivro() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum funcionario Cadastrado\n");
        } else {
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
    }

    public static void adicionarUsuario() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum funcionario Cadastrado\n");
        } else {
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
    }

    public static void removerLivro() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum funcionario Cadastrado\n");
        } else {
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
    }

    public static void removerUsuario() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum funcionario Cadastrado\n");
        } else {
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
    }

    public static void exibeAcervo() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum funcionario Cadastrado\n");
        } else {
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
    }

    public static void exibeUsuarios() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum funcionario Cadastrado\n");
        } else {
        System.out.println("- Exibir todos os usuarios -");
        if (listaUsuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado");
        } else
            for (Usuario usuario : listaUsuarios) {
                System.out.println(usuario);
            }
        System.out.println();
    }
        }

    public static void exibirEmprestimos() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum funcionario Cadastrado\n");
        } else {
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

    public static void adicionarFuncionario() {
        System.out.println("- Adicionar Funcionario -");
        System.out.println("Informe o nome do funcionario: ");
        String nome = (new Scanner(System.in).nextLine());
        System.out.println("Informe o cpf do funcionario: ");
        String cpf = new Scanner(System.in).nextLine();
        System.out.println("Informe o cargo do funcionario: ");
        String cargo = new Scanner(System.in).nextLine();

        boolean check = true;
        for (Usuario u : listaUsuarios) {
            if (u.getCpf().equals(cpf)) {
                System.out.println("Existem um usuario ja cadastrado com esse cpf\n");
                check = false;
                break;
            }
        }
        for (Funcionario f : colaboradores) {
            if (f.getCpf().equals(cpf)) {
                System.out.println("Funcionario ja cadastrado\n");
                check = false;
                break;
            }
        }

        if (check) {
            System.out.println("Funcionario cadastrado com sucesso\n");
            colaboradores.add(new Funcionario(nome, cpf, cargo));
        }
    }

    public static void excluirFuncionario() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum funcionario Cadastrado\n");
        } else {
            System.out.println("- Excluir Funcionario -");
            System.out.println("Informe o cpf do funcionario: ");
            String cpf = new Scanner(System.in).nextLine();

            boolean check = true;
            for (Funcionario f : colaboradores) {
                if (f.getCpf().equals(cpf)) {
                    colaboradores.remove(f);
                    check = false;
                    break;
                }
            }

            if (!check) {
                System.out.println("Funcionario removido com sucesso\n");
            } else {
                System.out.println("Funcionario não encontrado\n");
            }
        }
    }

    public static void mostrarFuncionarios() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum funcionario Cadastrado\n");
        } else {
            System.out.println("- Mostrar Funcionarios -");
            for (Funcionario f : colaboradores) {
                System.out.println(f.toString());
            }
            System.out.println();
        }
    }
}