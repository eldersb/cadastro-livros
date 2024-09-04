package br.com.web2.cadastro_livros.service;

import br.com.web2.cadastro_livros.entities.Livro;
import br.com.web2.cadastro_livros.exceptions.ResourceNotFoundException;
import br.com.web2.cadastro_livros.repository.LivroRepository;
import br.com.web2.cadastro_livros.requests.LivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroLivrosService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getAll() {
        return livroRepository.findAll();
    }

    public Livro insert(LivroRequest livroRequest) {

        Livro livro = new Livro();
        livro.setTitulo(livroRequest.getTitulo());
        livro.setResumo(livroRequest.getResumo());
        livro.setQuantidadeDePaginas(livroRequest.getQuantidadeDePaginas());
        livro.setAutores(livroRequest.getAutores());
        livro.setCategoria(livroRequest.getCategoria());

        return livroRepository.save(livro);

    }

    public Livro findById(Long id) throws ResourceNotFoundException {
        Optional<Livro> livroOptional = livroRepository.findById(id);

        if (livroOptional.isEmpty()) {
            throw new ResourceNotFoundException("Livro não encontrado!");
        }

        return livroOptional.get();
    }


}
