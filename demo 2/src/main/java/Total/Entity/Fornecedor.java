package Total.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    // Outros campos, getters e setters

    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtos;

    public void setId(Long id) {
    }
}
