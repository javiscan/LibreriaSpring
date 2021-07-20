package LibreriaSpringEntidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Editorial {    
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    
    private Integer ID;
    private String nombre;

    public Editorial(Integer ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public Editorial() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
