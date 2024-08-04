import java.util.ArrayList;

public abstract class Livro implements Comparable<Livro> {
    protected String titulo;
    protected String isbn;
    protected ArrayList<Autor> autores;

    public Livro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autores = new ArrayList<>();
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public abstract double getPreco();

    @Override
    public int compareTo(Livro outroLivro) {
        return this.titulo.compareTo(outroLivro.titulo);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autores=" + autores +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    
}
