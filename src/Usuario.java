import java.util.ArrayList;

public class Usuario extends Pessoa{

    public void addEmprestimo(Livro livro) {
        if (getEmprestimos().size() < 3) {
            getEmprestimos().add(livro);
        } else {
            System.out.println("O usuario ja esta com 3 livros emprestados\n");
        }
    }

    public void devolerLivro(String isbn) {
        for (Livro l : getEmprestimos()) {
            if (l.getIsbn().equals(isbn)) {
                getEmprestimos().remove(l);
                System.out.println("Livro devolvido!\n");
            } else {
                System.out.println("Livro não encontrado em emprestimos\n");
            }
            break;
        }
    }

    public Usuario(String nome, String cpf) {
        super(nome, cpf);
    }

    public String toString() {
    	return "Nome:" + getNome() +  "\nCpf:" + getCpf();
    }
}
