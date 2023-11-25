package com.br.tecbacV2.controller;

import com.br.tecbacV2.entity.Cliente;
import com.br.tecbacV2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> findAll() {
        return service.listaTodos();
    }

    @GetMapping("/listar-por-nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> buscarNome(@PathVariable String nome) {
        return service.listaPorNome(nome);
    }

    @GetMapping("/listar-cliente-produto/{idProduto}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listarClienteProduto(@PathVariable Long idProduto) {
        return service.listaClienteProduto(idProduto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente clienteCreated = service.create(cliente);

        return ResponseEntity.status(201).body(clienteCreated);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        Cliente clienteCreated = service.create(cliente);

        return ResponseEntity.status(201).body(clienteCreated);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cliente> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
