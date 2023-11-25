package com.br.tecbacV2.controller;

import com.br.tecbacV2.entity.Produto;
import com.br.tecbacV2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        Produto produtoCreated = service.create(produto);

        return ResponseEntity.status(201).body(produtoCreated);
    }

    @GetMapping("/fornecedor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> getByFornecedorId(@PathVariable Long id) {
        return service.getByFornecedorId(id);
    }

}
