package Total.DTO;

public class FornecedorDTO {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;

    // Construtores, getters e setters

    // Construtor vazio
    public FornecedorDTO() {
    }

    // Construtor com os campos principais
    public FornecedorDTO(Long id, String nome, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getters e setters
}
