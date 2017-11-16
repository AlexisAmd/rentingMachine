/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Chambre.findAll", query = "SELECT c FROM Chambre c")
    , @NamedQuery(name = "Chambre.findByIdChambre", query = "SELECT c FROM Chambre c WHERE c.idChambre = :idChambre")
    , @NamedQuery(name = "Chambre.findByEtage", query = "SELECT c FROM Chambre c WHERE c.etage = :etage")
    , @NamedQuery(name = "Chambre.findByNumero", query = "SELECT c FROM Chambre c WHERE c.numero = :numero")
    , @NamedQuery(name = "Chambre.findByNomChambre", query = "SELECT c FROM Chambre c WHERE c.nomChambre = :nomChambre")
    , @NamedQuery(name = "Chambre.findByVignette", query = "SELECT c FROM Chambre c WHERE c.vignette = :vignette")})
public class Chambre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short idChambre;
    private Short etage;
    private Short numero;
    @Size(max = 30)
    @Column(length = 30)
    private String nomChambre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String vignette;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChambre")
    private Collection<Reservation> reservationCollection;
    @JoinColumn(name = "idTarif", referencedColumnName = "idTarif")
    @ManyToOne
    private Tarif idTarif;

    public Chambre() {
    }

    public Chambre(Short idChambre) {
        this.idChambre = idChambre;
    }

    public Chambre(Short idChambre, String vignette) {
        this.idChambre = idChambre;
        this.vignette = vignette;
    }

    public Short getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Short idChambre) {
        this.idChambre = idChambre;
    }

    public Short getEtage() {
        return etage;
    }

    public void setEtage(Short etage) {
        this.etage = etage;
    }

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        this.numero = numero;
    }

    public String getNomChambre() {
        return nomChambre;
    }

    public void setNomChambre(String nomChambre) {
        this.nomChambre = nomChambre;
    }

    public String getVignette() {
        return vignette;
    }

    public void setVignette(String vignette) {
        this.vignette = vignette;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    public Tarif getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(Tarif idTarif) {
        this.idTarif = idTarif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChambre != null ? idChambre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chambre)) {
            return false;
        }
        Chambre other = (Chambre) object;
        if ((this.idChambre == null && other.idChambre != null) || (this.idChambre != null && !this.idChambre.equals(other.idChambre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Chambre[ idChambre=" + idChambre + " ]";
    }
    
}
