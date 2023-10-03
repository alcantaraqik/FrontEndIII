package Total.Controller;

import Total.Entity.Produto;
import Total.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Endpoint para listar todos os produtos
    @GetMapping("/")
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    // Endpoint para obter um produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para criar um novo produto
    @PostMapping("/")
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // Endpoint para atualizar um produto por ID
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto updatedProduto) {
        Optional<Produto> existingProduto = produtoRepository.findById(id);
        if (existingProduto.isPresent()) {
            updatedProduto.setId(id);
            return ResponseEntity.ok(produtoRepository.save(updatedProduto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para excluir um produto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
