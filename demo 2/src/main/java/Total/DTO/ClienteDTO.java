package Total.DTO;
public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private boolean ativo;

    // Construtores, getters e setters

    // Construtor vazio
    public ClienteDTO() {
    }

    // Construtor com os campos principais
    public ClienteDTO(Long id, String nome, String email, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
    }

    // Getters e setters
}
