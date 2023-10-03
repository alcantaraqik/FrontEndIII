package Total.Controller;

import Total.Entity.Fornecedor;
import Total.Repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    // Endpoint para listar todos os fornecedores
    @GetMapping("/")
    public List<Fornecedor> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    // Endpoint para obter um fornecedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        if (fornecedor.isPresent()) {
            return ResponseEntity.ok(fornecedor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para criar um novo fornecedor
    @PostMapping("/")
    public Fornecedor createFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    // Endpoint para atualizar um fornecedor por ID
    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody Fornecedor updatedFornecedor) {
        Optional<Fornecedor> existingFornecedor = fornecedorRepository.findById(id);
        if (existingFornecedor.isPresent()) {
            updatedFornecedor.setId(id);
            return ResponseEntity.ok(fornecedorRepository.save(updatedFornecedor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para excluir um fornecedor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable Long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        if (fornecedor.isPresent()) {
            fornecedorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
