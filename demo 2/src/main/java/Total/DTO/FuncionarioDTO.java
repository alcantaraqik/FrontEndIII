package Total.DTO;

import java.time.LocalDate;

public class FuncionarioDTO {
    private Long id;
    private String nome;
    private LocalDate dataContratacao;
    private double salario;

    // Construtores, getters e setters

    // Construtor vazio
    public FuncionarioDTO() {
    }

    // Construtor com os campos principais
    public FuncionarioDTO(Long id, String nome, LocalDate dataContratacao, double salario) {
        this.id = id;
        this.nome = nome;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
    }

    // Getters e setters
}

