public class LivroFisico extends Livro {
    private double preco;

    public LivroFisico(String titulo, String isbn, double preco) {
        super(titulo, isbn);
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public int compareTo(Livro outroLivro) {
        return this.titulo.compareTo(outroLivro.titulo);
    }

    @Override
    public String toString() {
        return "LivroFisico{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autores=" + autores +
                ", preco=" + preco +
                '}';
    }
}
