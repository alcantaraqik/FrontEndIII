package com.br.tecbacV2.controller;


import com.br.tecbacV2.entity.Fornecedor;
import com.br.tecbacV2.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class FornecedorController {

    @Autowired
    FornecedorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fornecedor> create(@RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorCreated = service.create(fornecedor);

        return ResponseEntity.status(201).body(fornecedorCreated);
    }
}
