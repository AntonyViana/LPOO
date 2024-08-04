import java.util.ArrayList;
import java.util.List;

public class Orcamento implements Compra {
    private List<Livro> pedido;

    public Orcamento() {
        this.pedido = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        pedido.add(livro);
    }

    @Override
    public double calcularPreco() {
        double total = 0.0;
        for (Livro livro : pedido) {
            total += livro.getPreco();
        }
        return total;
    }

    public void listarPedidos() {
        System.out.println("Lista de Pedidos:");
        for (Livro livro : pedido) {
            System.out.println(livro);
        }
        System.out.println("Valor total do pedido: R$ " + calcularPreco());
    }
}
