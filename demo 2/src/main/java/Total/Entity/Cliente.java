package Total.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class Cliente {
    private String nome;
    private Long CPF;
    private Long NumTel;
    private String Email;

    @ManyToMany
    @JoinTable(
            name = "carrinho_compras",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> carrinhoCompras;
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    public Long getNumTel() {
        return NumTel;
    }

    public void setNumTel(Long numTel) {
        NumTel = numTel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setId(Long id) {
    }
}
