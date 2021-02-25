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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "instalacio")
public class Instalacio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInstalacio")
    private int idInstalacio;
    
    @NotNull
    @Column(name = "nom")
    private String nom;

    //La instalació conté refències
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Referencia> referencies;

    public Instalacio() {
    }

    public Instalacio(int idInstalacio, String nom) {
        this.idInstalacio = idInstalacio;
        this.nom = nom;

    }

    public int getIdInstalacio() {
        return idInstalacio;
    }

    public void setIdInstalacio(int idInstalacio) {
        this.idInstalacio = idInstalacio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Referencia> getReferencies() {
        return referencies;
    }

    public void setReferencies(Set<Referencia> referencies) {
        this.referencies = referencies;
    }

    
}
