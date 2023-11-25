package com.br.tecbacV2.controller;

import com.br.tecbacV2.service.CarrinhoService;
import com.br.tecbacV2.entity.Cliente;
import com.br.tecbacV2.entity.Carrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    CarrinhoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Carrinho> create(@RequestBody Carrinho carrinho) {
        Carrinho carrinhoCreated = service.create(carrinho);

        return ResponseEntity.status(201).body(carrinhoCreated);
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Carrinho> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Optional<Carrinho> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "consulta-lista-cliente/{id}")
    public List<Cliente> cusultaListaClientes(@PathVariable Long id) {

        return service.buscarListaClientes(id);
    }

}
