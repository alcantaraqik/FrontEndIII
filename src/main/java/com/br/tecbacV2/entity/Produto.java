package com.br.tecbacV2.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Long status;

    private double valor;

    @OneToMany(mappedBy = "produtos")
    Set<RegistroProduto> registroProdutos;

    @ManyToOne
    @JoinColumn(name="fornecedor_id")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name="carrinho_id")
    private Carrinho carrinho;

}

