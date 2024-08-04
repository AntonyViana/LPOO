public class Ebook extends Livro {
    private double preco;

    public Ebook(String titulo, String isbn, double preco) {
        super(titulo, isbn);
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Ebook{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autores=" + autores +
                ", preco=" + preco +
                '}';
    }
}
