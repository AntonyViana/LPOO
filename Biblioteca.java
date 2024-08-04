import java.util.ArrayList;
import java.util.Collections;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Livro> emprestados;

    public Biblioteca() {
        livros = new ArrayList<>();
        emprestados = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        Collections.sort(livros); 
    }

    public void emprestarLivro(Livro livro) {
        if (livros.contains(livro) && !emprestados.contains(livro)) {
            emprestados.add(livro);
            livros.remove(livro);
            Collections.sort(emprestados); 
        }
    }

    public void imprimirLivros() {
        System.out.println("Livros na biblioteca:");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public ArrayList<Livro> getLivrosEmprestados() {
        return emprestados;
    }
}
