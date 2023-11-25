package com.br.tecbacV2.repository;

import com.br.tecbacV2.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContainsIgnoreCase(String nome);

    @Query(value = "select " +
            "    a.* " +
            "    from " +
            "    tecback3.aluno a " +
            "    inner join codigo_cliente ma on " +
            "    ma.id = a.id " +
            "    inner join produto d on " +
            "    d.id = ma.produto_id " +
            "            where " +
            "    d.id = ?1", nativeQuery = true)
    public List<Cliente> listaCLienteProduto(Long idProduto);


}
