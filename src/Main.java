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
					3 - Adicionar novo livro - ok
					4 - Adicionar novo usuario - ok
					5 - Remover livro -
					6 - Remover usuario - ok
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
				System.out.println("- Adicionar novo livro -");
				System.out.print("Informe o titulo: ");
				String titulo = scan.nextLine();
				System.out.print("Informe o autor: ");
				String autor = scan.nextLine();
				System.out.print("informe o ISBN: ");
				String isbn = scan.nextLine();
				System.out.print("Informe o ano de publicação: ");
				int anoPub = scan.nextInt();
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
				break;

			case 4:
				System.out.println("- Adicionar novo usuario -");
				System.out.print("Informe o nome: ");
				String nome = scan.nextLine();
				System.out.print("Informe o cpf (apenas numeros): ");
				String cpf = scan.next();
				System.out.println();
				boolean y = true;
				for (Usuario u: listaUsuarios) {
				    if (u.getCpf().equals(cpf)) {
				         System.out.println("Cpf ja cadastrado");
				         y = false;
				     }
				}
				if (y) {
				    Usuario usuario = new Usuario(nome, cpf);
				    listaUsuarios.add(usuario);
				}
				break;

			case 5:
				System.out.println("- Remover um livro -");
				System.out.println("Informe o isbn do livro");
				String isbn1 = scan.next();
				for (Livro y : acervo) {
					if (y.getIsbn().equals((isbn1))) {
						acervo.removeIf(item -> item.equals(isbn1));
					}
				}
				System.out.println("Livro removido");
				break;

			case 6:
				System.out.println("- Remover usuario -");
				System.out.println("Informe o CPf do usuario");
				String cpf2 = scan.next();
				for (Usuario u : listaUsuarios) {
					if (u.getCpf().equals(cpf2)) {
						listaUsuarios.removeIf(item -> item.equals(cpf2));
					}
				}
				System.out.println("Usuario removido");
				break;

			case 9:
				System.exit(0);
				break;

			default:
				System.out.println("Opção Invalida");
				break;
			}
		}
	}
}
