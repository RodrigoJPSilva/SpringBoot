package biblioteca.desafio.repositories;

import biblioteca.desafio.entities.CarteiraBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraBibliotecaRepository extends JpaRepository<CarteiraBiblioteca, Long> {
}
