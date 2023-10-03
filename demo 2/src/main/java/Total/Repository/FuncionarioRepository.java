package Total.Repository;

import Total.Entity.Funcionario;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository

public interface FuncionarioRepository {
    public List<Funcionario> findAll();
    List<Funcionario> findByDataContratacaoBetween(LocalDate dataInicio, LocalDate dataFim);

    public Optional<Funcionario> findById(Long id);

    public Funcionario save(Funcionario funcionario);

    public void deleteById(Long id);
}
