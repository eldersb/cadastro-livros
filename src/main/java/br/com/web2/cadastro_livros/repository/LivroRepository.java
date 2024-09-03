package br.com.web2.cadastro_livros.repository;
import br.com.web2.cadastro_livros.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LivroRepository extends JpaRepository<Livro, Long> {

}
