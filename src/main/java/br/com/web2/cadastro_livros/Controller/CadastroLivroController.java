package br.com.web2.cadastro_livros.Controller;


import br.com.web2.cadastro_livros.entities.Livro;
import br.com.web2.cadastro_livros.service.CadastroLivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cadastro")
public class CadastroLivroController {

    @Autowired
    CadastroLivrosService cadastroLivrosService;

    @GetMapping
    public List<Livro> getAll() {
        return cadastroLivrosService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        Optional<Livro> livro = cadastroLivrosService.findById(id);

        if (livro.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(livro.get());
    }

    @PostMapping
    public ResponseEntity<Livro> insert(@RequestBody Livro livro) {
        cadastroLivrosService.insert(livro);

        return ResponseEntity.created(null).body(livro);
    }

    @PutMapping

    @DeleteMapping("{id}")
    public ResponseEntity<Livro> remove(@PathVariable Long id) {
        Optional<Livro> livro = cadastroLivrosService.findById(id);

        if (livro.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        cadastroLivrosService.remove(id);

        return ResponseEntity.ok().body(null);
    }

}
