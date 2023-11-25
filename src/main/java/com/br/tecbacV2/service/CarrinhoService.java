package com.br.tecbacV2.service;

import com.br.tecbacV2.repository.CarrinhoRepository;
import com.br.tecbacV2.entity.Cliente;
import com.br.tecbacV2.entity.Carrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    CarrinhoRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public Carrinho create(Carrinho carrinho) {
        return repository.save(carrinho);
    }

    public List<Carrinho> findAll() {
        return repository.findAll();
    }

    public Optional<Carrinho> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Cliente> buscarListaClientes(Long id){
        Query query = entityManager.createNativeQuery("select a.* from tecbackV2.carrinho c" +
                "  inner join tecbackV2.cliente-carrinho ac on c.id = ac.id_curso" +
                "  inner join  tecbackV2.cliente a on ac.id_cliente = a.id" +
                "  where c.id = " + id, "ClientesCarrinhosMapping");
        List<Cliente> pessoas = query.getResultList();
        return pessoas;
    }
    
}
