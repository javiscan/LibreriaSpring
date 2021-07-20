package LibreriaSpringEntidades;


import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.Temporal;


@Entity
public class Prestamo {
    
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private Integer ID;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Temporal(TemporalType.TIMESTAMP) //no entiendo porque da error//
    private Date devolucion;
    
    @ManyToOne
    private Cliente cliente;
    
    @OneToMany
    private List<Libro> libro;

    public Prestamo(Integer ID, Date fecha, Date devolucion, Cliente cliente, List<Libro> libro) {
        this.ID = ID;
        this.fecha = fecha;
        this.devolucion = devolucion;
        this.cliente = cliente;
        this.libro = libro;
    }

    public Prestamo() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Date devolucion) {
        this.devolucion = devolucion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }

  
    
    
    
}
