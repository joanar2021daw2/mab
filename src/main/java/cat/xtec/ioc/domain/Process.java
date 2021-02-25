package cat.xtec.ioc.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "process")
public class Process implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pocessId")
    private int processId;

    @NotNull
    @Column(name = "numPassos")
    private int numPassos;

    @NotNull
    @Column(name = "created_on")
    private Timestamp createdOn;

    @OneToMany(cascade = {CascadeType.ALL})
    @OrderBy("created_on asc")
    private Set<Resultat> resultat;


    public Process() {
    }

    public int getIdProces() {
        return processId;
    }

    public void setIdProces(int idProces) {
        this.processId = idProces;
    }

    public int getNumPassos() {
        return numPassos;
    }

    public void setNumPassos(int numPassos) {
        this.numPassos = numPassos;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Set<Resultat> getResultat() {
        return resultat;
    }

    public void setResultat(Set<Resultat> resultat) {
        this.resultat = resultat;
    }
    
    

}
