package br.com.web2.cadastro_livros.service;

import br.com.web2.cadastro_livros.entities.Livro;
import br.com.web2.cadastro_livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroLivrosService {

    @Autowired
    LivroRepository livroRepository;

    public List<Livro> getAll() {
        return livroRepository.findAll();
    }

    public Livro insert(Livro livro) {
        livroRepository.save(livro);
        return livro;
    }

    public void remove(Long id) {
        Optional<Livro> livro = findById(id);

        if (livro.isPresent()) {
            livroRepository.delete(livro.get());
        }
    }

    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

}
