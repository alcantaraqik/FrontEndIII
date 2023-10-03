package Total.Controller;

import Total.Entity.Funcionario;
import Total.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Endpoint para listar todos os funcionários
    @GetMapping("/")
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();

    }

    // Endpoint para obter um funcionário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para criar um novo funcionário
    @PostMapping("/")
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    // Endpoint para atualizar um funcionário por ID
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario updatedFuncionario) {
        Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(id);
        if (existingFuncionario.isPresent()) {
            updatedFuncionario.setId(id);
            return ResponseEntity.ok(funcionarioRepository.save(updatedFuncionario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para excluir um funcionário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isPresent()) {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
