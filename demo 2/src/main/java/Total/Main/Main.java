package Total.Main;

import Total.Entity.Produto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crie uma lista de produtos
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto A", 100.0));
        produtos.add(new Produto("Produto B", 50.0));
        produtos.add(new Produto("Produto C", 75.0));
        produtos.add(new Produto("Produto D", 120.0));

        // Use a API de Stream para filtrar produtos com preço acima de 80.0
        List<Produto> produtosFiltrados = filtrarProdutosComPrecoAlto(produtos);

        // Imprima os produtos filtrados
        produtosFiltrados.forEach(System.out::println);
    }

    public static List<Produto> filtrarProdutosComPrecoAlto(List<Produto> produtos) {
        return produtos.stream()
                .filter(produto -> produto.getPreco() > 80.0)
                .toList(); // A partir do Java 16, você pode usar .toList() para converter o Stream em uma lista
    }
}
