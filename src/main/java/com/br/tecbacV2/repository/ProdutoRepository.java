package com.br.tecbacV2.repository;

import com.br.tecbacV2.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findByFornecedorId(Long fornecedorId);
}
