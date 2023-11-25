package com.br.tecbacV2.service;


import com.br.tecbacV2.repository.FornecedorRepository;
import com.br.tecbacV2.entity.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository repository;

    public Fornecedor create(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }
}
