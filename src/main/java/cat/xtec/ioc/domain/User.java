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
import javax.validation.constraints.Size;

/**
 *
 * @author JoseAndrade
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;

    @NotNull
    @Column(name = "numOperari")
    private Integer numOperari;

    @NotNull
    @Size(max = 30)
    @Column(name = "nom")
    private String nom;

    @NotNull
    @Size(max = 30)
    @Column(name = "cognom1")
    private String cognom1;

    @NotNull
    @Size(max = 30)
    @Column(name = "cognom2")
    private String cognom2;

    @NotNull
    @Size(max = 30, min = 2)
    @Column(name = "password")
    private String password;

    @Column(name = "active", columnDefinition="BOOLEAN DEFAULT true")
    private Boolean active;

    //Usuari conté resultats
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Resultat> resultats;

    public User() {
    }

    public User(Integer numOperari, String nom, String cognom1, String cognom2, String password, Boolean active) {
        this.numOperari = numOperari;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.password = password;
        this.active = active;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNumOperari() {
        return numOperari;
    }

    public void setNumOperari(Integer numOperari) {
        this.numOperari = numOperari;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(Set<Resultat> results) {
        this.resultats = results;
    }

}
