
package LibreriaSpringRepositorios;

import LibreriaSpringEntidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,String>{
    // aca es para buscar por query//
    
    List<Libro> listarActivo{
    
    }
}
