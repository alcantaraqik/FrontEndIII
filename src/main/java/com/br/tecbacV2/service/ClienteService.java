package com.br.tecbacV2.service;

import com.br.tecbacV2.repository.ClienteRepository;
import com.br.tecbacV2.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listaTodos(){
        return repository.findAll();
    }

    public List<Cliente> listaPorNome(String nome){

        return repository.findByNomeContainsIgnoreCase(nome);
    }

    public List<Cliente> listaClienteProduto(Long idProduto){
        return repository.listaCLienteProduto(idProduto);
    }

    public Cliente create(Cliente cliente) {

        //Set<Curso> cursoList = Collections.singleton(new Curso().toBuilder().id(dto.getIdCurso()).build());

        //Aluno aluno = Aluno.builder()
        //.nome(dto.getNomeAluno())
        //.email(dto.getEmailAluno())
        //.cursos(cursoList)
        //.build();

        return repository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
