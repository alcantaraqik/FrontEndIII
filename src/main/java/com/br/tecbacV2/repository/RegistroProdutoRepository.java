package com.br.tecbacV2.repository;


import com.br.tecbacV2.entity.RegistroProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroProdutoRepository extends JpaRepository<RegistroProduto, Long> {

    RegistroProduto findByMatriculaIdAndDisciplinaId(Long matriculaId, Long disciplinaId);

    List<RegistroProduto> findByMatriculaId(Long matriculaId);
}
