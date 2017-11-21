/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(catalog = "hotel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarif.findAll", query = "SELECT t FROM Tarif t")
    , @NamedQuery(name = "Tarif.findByIdTarif", query = "SELECT t FROM Tarif t WHERE t.idTarif = :idTarif")
    , @NamedQuery(name = "Tarif.findByPrix", query = "SELECT t FROM Tarif t WHERE t.prix = :prix")
    , @NamedQuery(name = "Tarif.findByCapacite", query = "SELECT t FROM Tarif t WHERE t.capacite = :capacite")
    , @NamedQuery(name = "Tarif.findByClasse", query = "SELECT t FROM Tarif t WHERE t.classe = :classe")})
public class Tarif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(nullable = false)
    private Short idTarif;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short prix;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Size(min = 1, max = 8)
    private Short capacite;
//    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String classe;
    @OneToMany(mappedBy = "idTarif")
    private Collection<Chambre> chambreCollection;

    public Tarif() {
    }

    public Tarif(Short idTarif) {
        this.idTarif = idTarif;
    }

    public Tarif(Short idTarif, short prix, short capacite, String classe) {
        this.idTarif = idTarif;
        this.prix = prix;
        this.capacite = capacite;
        this.classe = classe;
    }

    public Short getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(Short idTarif) {
        this.idTarif = idTarif;
    }

    public short getPrix() {
        return prix;
    }

    public void setPrix(short prix) {
        this.prix = prix;
    }

    public Short getCapacite() {
        return capacite;
    }

    public void setCapacite(Short capacite) {
        this.capacite = capacite;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @XmlTransient
    public Collection<Chambre> getChambreCollection() {
        return chambreCollection;
    }

    public void setChambreCollection(Collection<Chambre> chambreCollection) {
        this.chambreCollection = chambreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarif != null ? idTarif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarif)) {
            return false;
        }
        Tarif other = (Tarif) object;
        if ((this.idTarif == null && other.idTarif != null) || (this.idTarif != null && !this.idTarif.equals(other.idTarif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idTarif + " - " + this.getClasse() + " - " + this.getCapacite() + " personnes";
    }

    /**
     *
     * @return nombre de chambre dont le tarif est le même que le tarif (classe, capacité, prix etc..) de cette instance de la classe tarif
     */
    public short getNombreDeChambre() {
        Collection<Chambre> chambres = this.chambreCollection;
        short cpt = 0;
        for (Chambre c : chambres) {
            if (c.getIdTarif().idTarif.equals(this.idTarif)) {
                cpt++;
            }
        }
        return cpt;
    }

}
