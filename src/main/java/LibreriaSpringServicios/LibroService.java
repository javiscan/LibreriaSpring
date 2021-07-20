package LibreriaSpringServicios;

import LibreriaSpringEntidades.Autor;
import LibreriaSpringEntidades.Editorial;
import LibreriaSpringEntidades.Libro;
import LibreriaSpringRepositorios.LibroRepositorio;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    @Autowired
    private LibroRepositorio libroRepositorio;

    public void crearLibro(String titulo, Integer anio, Integer ejemplares,
            Integer prestados, Integer idAutor, Integer idEditorial) {

        Libro libro = new Libro();

        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setPrestados(0);
        libro.setAlta(new Fecha());   
        libro.setActivo(true);
    }

    public void editarLibro(Integer idLibro, String titulo, Integer anio) {

        EntityManager em = Persistence.createEntityManagerFactory("LibreriaSpringPU").createEntityManager();

        em.getTransaction().begin();

        Libro libro = em.find(Libro.class, idLibro);

        if (titulo == null || titulo.isEmpty()) {
            titulo = libro.getTitulo();
            libro.setTitulo(titulo);
        } else {
            libro.setTitulo(titulo);
        }

        if (anio == 0) {
            anio = libro.getAnio();
            libro.setAnio(anio);
        } else {
            libro.setAnio(anio);
        }

        em.merge(libro);
        em.getTransaction().commit();
    }

    public void borrarLibro(Integer idLibro) {

        EntityManager em = Persistence.createEntityManagerFactory("LibreriaSpringPU").createEntityManager();

        em.getTransaction().begin();

        Libro libro = em.find(Libro.class, idLibro);

        em.remove(libro);
        em.getTransaction().commit();
    }

    public List<Libro> buscarLibroISBN(long isbn) {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaSpringPU").createEntityManager();
        List<Libro> libroEncontrado = null;

        if (isbn == 0) {
            System.out.println("Libro no encontrado o no cargado correctamente");
        } else {
            libroEncontrado = em.createQuery("SELECT c FROM Libro c WHERE c.isbn LIKE :isbn").
                    setParameter("isbn", isbn).getResultList();
            System.out.println(libroEncontrado);
        }
        return libroEncontrado;
    }

    public List<Libro> buscarLibroTitulo(String titulo) {

        EntityManager em = Persistence.createEntityManagerFactory("LibroSpringPU").createEntityManager();

        List<Libro> libroEncontrado = null;
        
        if(titulo == null || titulo.isEmpty()){
            System.out.println("Libro no encontrado o no cargado correctamente");
                    }else{
            libroEncontrado = em.createQuery("SELECT c FROM Libro c WHERE c.titulo LIKE :titulo").
                    setParameter("titulo", "%"+titulo+"%").
                    getResultList();
            
            System.out.println(libroEncontrado);
        }
        return libroEncontrado;
    }
}
