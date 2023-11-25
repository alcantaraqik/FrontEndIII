package com.br.tecbacV2.dto;

import lombok.Data;

@Data
public class ProdutosClienteDTO {

    private String nome;
    private Double valor1;
    private Double valor2 = (valor1/10);
    private Double valorProduto = valor1 + valor2;
}
