package com.br.tecbacV2.service;

import com.br.tecbacV2.repository.EmailRepository;
import com.br.tecbacV2.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    public Email salvar(Email email) {
        return repository.save(email);
    }

    public Optional<Email> buscarPorId(Long id){
        return repository.findById(id);
    }
}
