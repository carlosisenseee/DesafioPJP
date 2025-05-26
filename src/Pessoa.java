import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private ArrayList<Livro> emprestimos = new ArrayList<>();

    public Pessoa(String nome, String cpf) {
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
        return "Nome: " + getNome() + " Cpf: " + getCpf();
    }
}
