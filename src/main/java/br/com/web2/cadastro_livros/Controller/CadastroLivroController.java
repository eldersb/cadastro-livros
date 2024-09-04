package br.com.web2.cadastro_livros.Controller;


import br.com.web2.cadastro_livros.entities.Livro;
import br.com.web2.cadastro_livros.exceptions.ResourceNotFoundException;
import br.com.web2.cadastro_livros.requests.LivroRequest;
import br.com.web2.cadastro_livros.service.CadastroLivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Livro> findById(@PathVariable Long id) throws ResourceNotFoundException {

        return ResponseEntity.ok(cadastroLivrosService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Livro> insert(@RequestBody LivroRequest livroRequest) {
        Livro livro = cadastroLivrosService.insert(livroRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(livro);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleException (ResourceNotFoundException ex){
        Map<String, String> responseMessage = new HashMap<>();
        responseMessage.put("messege", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
    }


}
