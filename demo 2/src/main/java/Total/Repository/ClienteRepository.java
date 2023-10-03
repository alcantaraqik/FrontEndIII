package Total.Repository;

import Total.Entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeContrainsIgnoreCase(String nome);

    List<Cliente> findAll();

    List<Cliente> findByAtivo(boolean ativo);

    Optional<Cliente> findById(Long id);

    Cliente save(Cliente cliente);

    void deleteById(Long id);
}
