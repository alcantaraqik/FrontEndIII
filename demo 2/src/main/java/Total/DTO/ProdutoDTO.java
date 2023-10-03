package Total.DTO;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private double preco;

    // Construtores, getters e setters

    // Construtor vazio
    public ProdutoDTO() {
    }

    // Construtor com os campos principais
    public ProdutoDTO(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e setters
}

