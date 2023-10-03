package Total.Repository;

import Total.Entity.Produto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository {
    List<Produto> findAll();

    List<Produto> findByPrecoGreaterThan(Double valor);

    Optional<Produto> findById(Long id);

    Produto save(Produto produto);

    void deleteById(Long id);
}
