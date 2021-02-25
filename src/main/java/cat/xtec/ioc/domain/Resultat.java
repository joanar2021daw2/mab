package cat.xtec.ioc.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "resultat")
public class Resultat implements Serializable {

    private static final long serialVersionUID = 1L;

    /*No referenciem la classe Usuari, ja que les respostes no tenen usuaris.
    Serà l'entitat de tiups usuari la que pot tenir múltiples resultats, 
    així que definim la relació a la clase User
    De la mateixa manera no referenciem les referències*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idResultat")
    private Integer idResultat;

    @NotNull
    @Column(name = "created_on")
    private Timestamp createdOn;

    @NotNull
    @Column(name = "tempsPasos")
    private String tempsPassos;

    @NotNull
    @Column(name = "tempsTotal")
    private int tempsTotal;

    public Resultat() {
    }

    public Integer getIdResultat() {
        return idResultat;
    }

    public void setIdResultat(Integer idResultat) {
        this.idResultat = idResultat;
    }

    public int getTempsTotal() {
        return tempsTotal;
    }

    public void setTempsTotal(int tempsTotal) {
        this.tempsTotal = tempsTotal;
    }

    public String getTempsPassos() {
        return tempsPassos;
    }

    public void setTempsPassos(String tempsPassos) {
        this.tempsPassos = tempsPassos;
    }

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }


}
