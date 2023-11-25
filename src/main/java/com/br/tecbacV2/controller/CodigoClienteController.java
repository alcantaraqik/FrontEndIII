package com.br.tecbacV2.controller;


import com.br.tecbacV2.entity.CodigoCliente;
import com.br.tecbacV2.service.CodigoClienteSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/codigo-cliente")
public class CodigoClienteController {

    @Autowired
    CodigoClienteSevice service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CodigoCliente> create(@RequestBody CodigoCliente codigoCliente) {
        CodigoCliente codigoClienteCreated = service.create(codigoCliente);

        return ResponseEntity.status(201).body(codigoClienteCreated);
    }

    @PatchMapping("/trancar-matricula/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void patchStatus(@PathVariable Long id) throws Exception {
        service.encerrarConta(id);
    }

    @GetMapping("/produto/valor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Double retornaMediaAlunos() {

        return service.retornaValorProduto();
    }

}
