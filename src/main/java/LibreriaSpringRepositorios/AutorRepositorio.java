package LibreriaSpringRepositorios;

import LibreriaSpringEntidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor,String> {
    
    /* creo que esta mal, este es para buscar no para crear*/
    @Query("SELECT c FROM Autor c WHERE c.nombre = :nombre")
    public Autor buscarAutor ( String nombre);  //creo que falta (@Param("nombre")//
    
}
