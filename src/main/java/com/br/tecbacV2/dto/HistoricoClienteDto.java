package com.br.tecbacV2.dto;

import com.br.tecbacV2.entity.Carrinho;
import lombok.Data;

import java.util.List;

@Data
public class HistoricoClienteDto {

    private String nomeCliente;
    private Carrinho carrinho;
    private List<ProdutosClienteDTO> produtosClienteDTOS;
}
