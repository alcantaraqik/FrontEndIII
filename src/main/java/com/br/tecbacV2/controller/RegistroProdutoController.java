package com.br.tecbacV2.controller;


import com.br.tecbacV2.dto.HistoricoClienteDto;
import com.br.tecbacV2.entity.RegistroProduto;
import com.br.tecbacV2.service.RegistroProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro-disciplina")
public class RegistroProdutoController {

    @Autowired
    RegistroProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<RegistroProduto> create(@RequestBody RegistroProduto registroProduto) {
        RegistroProduto entidade = service.create(registroProduto);

        return ResponseEntity.status(201).body(entidade);
    }

    @GetMapping("/cliente-valores/{codigoId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public HistoricoClienteDto studentGrades(@PathVariable Long codigoID) {
        return service.getHistoricoFromAluno(codigoID);
    }
}
