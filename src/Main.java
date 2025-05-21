import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Livro> acervo = new ArrayList<>();

        while (true) {
            System.out.println("""
                    === Biblioteca Piriri Parara ===
                    Digite para:
                    1 - Emprestar um livro - 
                    2 - Devolver um livro -
                    3 - Adicionar novo livro -
                    4 - Adicionar novo usuario - ok
                    5 - Remover livro - 
                    6 - Remover usuario -
                    7 - Alterar livro -
                    8 - Alterar usuario -
                    9 - Sair - ok
                    """);
            System.out.print("Informe a opção: ");
            int temp = scan.nextInt();
            scan.nextLine();
            switch (temp) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("- Adicionar novo usuario -");
                    System.out.print("Informe o nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Informe o cpf (apenas numeros): ");
                    String cpf = scan.next();
                    System.out.println();
                    Usuario usuario = new Usuario(nome, cpf);
                    listaUsuarios.add(usuario);
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Opção Invalida");
                    break;
                    
                case 6:
                	System.out.println ("- Remover usuario -");
                	System.out.println ("Informe o CPf do usuario");
                	String cpf2 = scan.next();
                	for (Usuario u: listaUsuarios) {
                		if (u.getCpf().equals(cpf2)) {
                			listaUsuarios.removeIf(item -> item.equals(cpf2)); 
           			
                		}
            }
        }
        }
    }
}
