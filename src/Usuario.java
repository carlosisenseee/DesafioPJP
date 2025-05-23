import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String cpf;
    private ArrayList<Livro> emprestimos = new ArrayList<>();

    public void addEmprestimo(Livro livro) {
        if (emprestimos.size() < 3) {
            emprestimos.add(livro);
        } else {
            System.out.println("O usuario ja esta com 3 livros emprestados");
        }
    }

    public void devolerLivro(String isbn) {
        for (Livro l : emprestimos) {
            if (l.getIsbn().equals(isbn)) {
                emprestimos.remove(l);
                System.out.println("Livro devolvido!");
            } else {
                System.out.println("Livro não encontrado em emprestimos");
            }
            break;
        }
    }

    public Usuario(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Livro> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Livro> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public String toString() {
    	return "Nome:" + getNome() +  "\nCpf:" + getCpf();
    }
}
