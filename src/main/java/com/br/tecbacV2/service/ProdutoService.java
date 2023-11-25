package com.br.tecbacV2.service;


import com.br.tecbacV2.repository.ProdutoRepository;
import com.br.tecbacV2.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public Produto create(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> getByFornecedorId(Long fornecedorId) {

        return repository.findByFornecedorId(fornecedorId);

    }
}
