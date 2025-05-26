public class Funcionario extends Pessoa{
    private String cargo;

    public Funcionario(String nome, String cpf, String cargo) {
        super(nome, cpf);
        setCargo(cargo);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return  super.toString() + " Cargo: " + getCargo();
    }
}

