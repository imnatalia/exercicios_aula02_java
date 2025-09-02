package exercicios_aula02_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TesteProduto {
    public static void main(String[] args) {
        // Criando a lista de produtos
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", 3500.00, "Eletronicos"));
        produtos.add(new Produto("Livro: O Senhor dos Anéis", 80.00, "Livros"));
        produtos.add(new Produto("Smartphone", 2200.00, "Eletronicos"));
        produtos.add(new Produto("Livro: Harry Potter", 65.50, "Livros"));
        produtos.add(new Produto("Fones de Ouvido", 450.00, "Eletronicos"));
        produtos.add(new Produto("Mouse sem fio", 120.00, "Eletronicos"));
        produtos.add(new Produto("Livro: A Arte da Guerra", 45.00, "Livros"));
        produtos.add(new Produto("Teclado Mecânico", 550.00, "Periféricos"));

        // a. Imprimir produtos da categoria "Eletronicos" usando forEach e if
        // tradicional
        System.out.println("--- Produtos da categoria 'Eletronicos' (forEach e if tradicional) ---");
        for (Produto produto : produtos) {
            if (produto.getCategoria().equals("Eletronicos")) {
                System.out.println(produto.getNome());
            }
        }

        // a. Imprimir produtos da categoria "Eletronicos" usando stream() e filter()
        System.out.println("\n--- Produtos da categoria 'Eletronicos' (stream e filter) ---");
        produtos.stream()
                .filter(produto -> produto.getCategoria().equals("Eletronicos"))
                .forEach(produto -> System.out.println(produto.getNome()));

        // b. Criar e imprimir lista de preços > 500.0 usando filter() e map()
        System.out.println("--- Preços de produtos com valor > R$ 500,00 ---");
        List<Double> precosAcimaDe500 = produtos.stream()
                .filter(produto -> produto.getPreco() > 500.0)
                .map(Produto::getPreco)
                .collect(Collectors.toList());

        precosAcimaDe500.forEach(preco -> System.out.println("R$ " + preco));

        // c. Calcular o valor total do estoque de livros
        double valorTotalLivros = produtos.stream()
                .filter(produto -> produto.getCategoria().equals("Livros"))
                .mapToDouble(Produto::getPreco)
                .sum();

        System.out.println("--- Valor total do estoque de livros ---");
        System.out.printf("Valor total: R$ %.2f\n", valorTotalLivros);


        // d. Escreva um método buscarProdutoPorNome(List<Produto> produtos, String nome) que retorna um Optional<Produto>. Use a Stream API (filter e findFirst).
        // e. No seu método main, chame o buscarProdutoPorNome: Primeiro, com um nome de produto que existe. Use ifPresent() para imprimir os detalhes do produto; Depois, com um nome que não existe. Use orElseThrow() para lançar uma RuntimeException com a mensagem "Produto não encontrado!".
        String nomeParaBuscar = "Smartphone";
        Optional<Produto> produtoEncontrado = buscarProdutoPorNome(produtos, nomeParaBuscar);

        System.out.println("--- Buscando produto por nome ---");
        if (produtoEncontrado.isPresent()) {
            System.out.println("Produto encontrado: " + produtoEncontrado.get().getNome());
        } else {
            System.out.println("Produto '" + nomeParaBuscar + "' não encontrado.");
        }

        System.out.println("\n--- Buscando produto 'Monitor Curvo') ---");
        try {
            buscarProdutoPorNome(produtos, "Monitor Curvo")
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    /**
     * Busca um produto por nome na lista usando a Stream API.
     * @param produtos A lista de produtos.
     * @param nome O nome do produto a ser buscado.
     * @return Um Optional contendo o produto encontrado, ou um Optional vazio se não houver correspondência.
     */
    public static Optional<Produto> buscarProdutoPorNome(List<Produto> produtos, String nome) {
        return produtos.stream()
              .filter(produto -> produto.getNome().equals(nome))
              .findFirst();
    }

}