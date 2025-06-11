package bibliotecainfnetapi.repository;

import bibliotecainfnetapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findLivroById(Long id);
}
