package cat.xtec.ioc.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "referencia")
public class Referencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idReferencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReferencaia;

    @NotNull
    @Column(name = "referencia")
    private String referencia;

    /*L'entitat Referencia pot tenir múltiples resultats(propietari de la relació 
    és a Resultat ManyToOne Referencia referencia. MappedBy és camp de resultat que representa*/
    @OneToMany(cascade = {CascadeType.ALL})
    @OrderBy("created_on asc")
    private Set<Resultat> resultat;

    //La entitat Refernecia pot tenir múltiples processos(a Process no referenciem Referencia)
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Process> processos;


    public Referencia() {
    }

    public Referencia(int idReferencaia, String referencia) {
        this.idReferencaia = idReferencaia;
        this.referencia = referencia;
    }

    public int getIdReferencaia() {
        return idReferencaia;
    }

    public void setIdReferencaia(int idReferencaia) {
        this.idReferencaia = idReferencaia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Set<Process> getProcessos() {
        return processos;
    }

    public void setProcessos(Set<Process> processos) {
        this.processos = processos;
    }

    public Set<Resultat> getResultat() {
        return resultat;
    }

    public void setResultat(Set<Resultat> resultat) {
        this.resultat = resultat;
    }
    
}
