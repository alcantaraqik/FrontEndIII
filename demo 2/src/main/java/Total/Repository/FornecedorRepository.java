package Total.Repository;

import Total.Entity.Fornecedor;

import java.util.List;
import java.util.Optional;

public interface FornecedorRepository {

    List<Fornecedor> findByNome(String nome);
    List<Fornecedor> findAll();

    Optional<Fornecedor> findById(Long id);

    Fornecedor save(Fornecedor fornecedor);

    void deleteById(Long id);
}
