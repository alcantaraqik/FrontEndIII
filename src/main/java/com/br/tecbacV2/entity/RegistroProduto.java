package com.br.tecbacV2.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class RegistroProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="codigo_id")
    private CodigoCliente codigo;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    private Double valorProduto;

    private Double porcentagemFornecedor = (valorProduto/10);

    private String status;
}
