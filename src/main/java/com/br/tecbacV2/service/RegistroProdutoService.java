package com.br.tecbacV2.service;

import com.br.tecbacV2.dto.HistoricoClienteDto;
import com.br.tecbacV2.dto.ProdutosClienteDTO;
import com.br.tecbacV2.repository.RegistroProdutoRepository;
import com.br.tecbacV2.entity.RegistroProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegistroProdutoService {

    @Autowired
    private RegistroProdutoRepository repository;

    static final Double gradesAvgToApprove = 7.0;

    public RegistroProduto create(RegistroProduto registroProduto) {
        return repository.save(registroProduto);
    }

    public HistoricoClienteDto getHistoricoFromAluno(Long matriculaAlunoId) {
        List<RegistroProduto> registroProduto = repository.findByMatriculaId(matriculaAlunoId);

        HistoricoClienteDto historicoClienteDto = new HistoricoClienteDto();

        List<ProdutosClienteDTO> produtosClienteDTOList = new ArrayList<>();

        if (!registroProduto.isEmpty()) {

            registroProduto.stream().forEach(d -> {

                historicoClienteDto.setCarrinho(d.getProduto().getCarrinho());
                historicoClienteDto.setNomeCliente(d.getCodigo().getCliente().getNome());

                ProdutosClienteDTO produtosClienteDTO = new ProdutosClienteDTO();

                produtosClienteDTO.setNome(d.getProduto().getNome());
                produtosClienteDTO.setValorProduto(d.getValorProduto());

            });

            historicoClienteDto.setProdutosClienteDTOS(produtosClienteDTOList);

            return historicoClienteDto;
        }

        return historicoClienteDto;
    }


}
