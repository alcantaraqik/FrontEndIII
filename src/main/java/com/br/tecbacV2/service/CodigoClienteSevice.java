package com.br.tecbacV2.service;

import com.br.tecbacV2.repository.CodigoClienteRepository;
import com.br.tecbacV2.entity.CodigoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
public class CodigoClienteSevice {

    static final Double gradesAvgToApprove = 7.0;

    @Autowired
    CodigoClienteRepository repository;

    public CodigoCliente create(CodigoCliente codigoCliente) {
        codigoCliente.setStatus("MATRICULADO");
        return repository.save(codigoCliente);
    }

    public void encerrarConta(Long CodigoClienteId) throws Exception {
        Optional<CodigoCliente> codigoClienteToUpdate = repository.findById(CodigoClienteId);

        if (codigoClienteToUpdate.isPresent()) {
            if (Objects.equals(codigoClienteToUpdate.get().getStatus(), "Cadastrado")) {
                codigoClienteToUpdate.ifPresent(codigoCliente -> codigoCliente.setStatus("Encerrado"));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só é possível encerrar a conta com status Cadastrado.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro não encontrada.");
        }
        repository.save(codigoClienteToUpdate.get());
    }

    public Double retornaValorProduto() {

        return repository.retornaValorProduto();
    }

}
