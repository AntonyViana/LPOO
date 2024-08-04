import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Orcamento orcamento = new Orcamento();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarLivroFisico();
                    break;
                case 2:
                    cadastrarEbook();
                    break;
                case 3:
                    listarLivrosPorAutor();
                    break;
                case 4:
                    alugarLivro();
                    break;
                case 5:
                    fazerPedidoCompra();
                    break;
                case 6:
                    listarLivrosEmprestados();
                    break;
                case 7:
                    listarTodosLivrosBiblioteca();
                    break;
                case 8:
                    mostrarListaDeLivrosEtotalAPagar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Cadastrar livro físico");
        System.out.println("2 - Cadastrar ebook");
        System.out.println("3 - Listar livros por autor");
        System.out.println("4 - Alugar livro");
        System.out.println("5 - Fazer pedido de compra");
        System.out.println("6 - Listar todos os livros emprestados");
        System.out.println("7 - Listar todos os livros da biblioteca");
        System.out.println("8 - Mostrar a lista de livros e total a pagar");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
       }
    }

    private static void cadastrarLivroFisico() {
        System.out.print("Digite o título do livro físico: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o ISBN do livro físico: ");
        String isbn = scanner.nextLine();
        System.out.print("Digite o preço do livro físico: ");
        double preco = lerDouble();

        Autor autor = solicitarAutor();
        Livro livro = new LivroFisico(titulo, isbn, preco);
        livro.adicionarAutor(autor);
        cadastrarLivro(livro);
    }

    private static void cadastrarEbook() {
        System.out.print("Digite o título do ebook: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o ISBN do ebook: ");
        String isbn = scanner.nextLine();
        System.out.print("Digite o preço do ebook: ");
        double preco = lerDouble();
        Autor autor = solicitarAutor();
        Livro ebook = new Ebook(titulo, isbn, preco);
        ebook.adicionarAutor(autor);
        cadastrarLivro(ebook);
    }

    private static Autor solicitarAutor() {
        String nome, email, instituicao;
        boolean emailValido = false;

        do {

            System.out.print("Digite o nome do autor: ");
            nome = scanner.nextLine();
            System.out.print("Digite a instituição do autor: ");
            instituicao = scanner.nextLine();

            System.out.print("Digite o email do autor: ");
            email = scanner.nextLine();

            Autor autor = new Autor(nome, email, instituicao);
            emailValido = autor.validarEmail(email);

            if (!emailValido) {
                System.out.println("Email inválido. Digite novamente.");
            }
        } while (!emailValido);

        return new Autor(nome, email, instituicao);
    }

    private static void cadastrarLivro(Livro livro) {
        biblioteca.adicionarLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void listarLivrosPorAutor() {
        System.out.print("Digite o nome do autor: ");
        String nomeAutor = scanner.nextLine();

        boolean encontrou = false;
        for (Livro livro : biblioteca.getLivros()) {
            for (Autor autor : livro.autores) {
                if (autor.getNome().equalsIgnoreCase(nomeAutor)) {
                    System.out.println(livro);
                    encontrou = true;
                    break;
                }
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum livro encontrado para o autor " + nomeAutor);
        }
    }

    private static void alugarLivro() {
        System.out.print("Digite o título do livro para alugar: ");
        String tituloLivro = scanner.nextLine();

        Livro livro = buscarLivroPorTitulo(tituloLivro);
        if (livro != null) {
            biblioteca.emprestarLivro(livro);
            System.out.println("Livro alugado com sucesso!");
        } else {
            System.out.println("Livro não encontrado na biblioteca.");
        }
    }

    private static void fazerPedidoCompra() {
        System.out.print("Digite o título do livro para adicionar ao pedido de compra: ");
        String tituloLivro = scanner.nextLine();

        Livro livro = buscarLivroPorTitulo(tituloLivro);
        if (livro != null) {
            orcamento.adicionarLivro(livro);
            System.out.println("Livro adicionado ao pedido de compra!");
        } else {
            System.out.println("Livro não encontrado na biblioteca.");
        }
    }

    private static void listarLivrosEmprestados() {
        System.out.println("\nLivros emprestados:");
        for (Livro livro : biblioteca.getLivrosEmprestados()) {
            System.out.println(livro);
        }
    }

    private static void listarTodosLivrosBiblioteca() {
        System.out.println("\nTodos os livros da biblioteca:");
        biblioteca.imprimirLivros();
    }

    private static void mostrarListaDeLivrosEtotalAPagar() {
        orcamento.listarPedidos();
    }

    private static double lerDouble() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Digite novamente:");
            return lerDouble();
        }
    }

    private static Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : biblioteca.getLivros()) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

   
}
