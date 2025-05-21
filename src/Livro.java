public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;

    public Livro(String titulo, String autor, String isbn, int anoPublicacao) {
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
        setAnoPublicacao(anoPublicacao);
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        if (anoPublicacao >= 0) {
            this.anoPublicacao = anoPublicacao;
        } else {
            System.out.println("Dado Invalido");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
