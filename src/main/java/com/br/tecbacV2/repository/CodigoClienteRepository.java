package com.br.tecbacV2.repository;

import com.br.tecbacV2.entity.Cliente;
import com.br.tecbacV2.entity.CodigoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodigoClienteRepository extends JpaRepository<CodigoCliente, Long> {
    public List<CodigoCliente> findByAlunoId(Long alunoId);

    @Query(value = "SELECT (sum(e.valor1) + sum(valor2))", nativeQuery = true)
    public Double retornaValorProduto();

    public List<CodigoCliente> findByStatus(String status);
    @Query(value = "select a from CodigoCliente m, Cliente a where a.id = m.cliente.id and " +
            " m.status = :status")
    public List<Cliente> retornaStatu(String status);
}
