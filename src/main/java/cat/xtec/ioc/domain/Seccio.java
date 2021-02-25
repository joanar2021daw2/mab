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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "seccio")
public class Seccio implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseccio")
    private Integer idSeccio;
    
    @NotNull    
    @Column(name = "nom")
    private String nom;
    
    @NotNull
    @Column(name = "tipusProduccio")
    private String tipusProduccio;
    
    //La Secció conté instalacions
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Instalacio> instalacions;
    
    public Seccio(String nom, String tipusProduccio) {
        this.nom = nom;
        this.tipusProduccio = tipusProduccio;
    }

    public Seccio() {
    }

    public Integer getIdSeccio() {
        return idSeccio;
    }

    public void setIdSeccio(Integer idSeccio) {
        this.idSeccio = idSeccio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipusProduccio() {
        return tipusProduccio;
    }

    public void setTipusProduccio(String tipusProduccio) {
        this.tipusProduccio = tipusProduccio;
    }

    public Set<Instalacio> getInstalacions() {
        return instalacions;
    }

    public void setInstalacions(Set<Instalacio> instalacions) {
        this.instalacions = instalacions;
    }
    
    
    
    
}
