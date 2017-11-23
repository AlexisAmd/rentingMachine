/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
    , @NamedQuery(name = "Reservation.findByIdRerservation", query = "SELECT r FROM Reservation r WHERE r.idRerservation = :idRerservation")
    , @NamedQuery(name = "Reservation.findByCheckInDate", query = "SELECT r FROM Reservation r WHERE r.checkInDate = :checkInDate")
    , @NamedQuery(name = "Reservation.findByCheckOutDate", query = "SELECT r FROM Reservation r WHERE r.checkOutDate = :checkOutDate")
    , @NamedQuery(name = "Reservation.findByPaye", query = "SELECT r FROM Reservation r WHERE r.paye = :paye")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Short idRerservation;
    @Temporal(TemporalType.DATE)
    private Date checkInDate;
    @Temporal(TemporalType.DATE)
    private Date checkOutDate;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean paye;
    @JoinColumn(name = "idChambre", referencedColumnName = "idChambre", nullable = false)
    @ManyToOne(optional = false)
    private Chambre idChambre;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", nullable = false)
    @ManyToOne(optional = false)
    private Client idClient;
    private int nbDep;
    private Collection<Reservation> reservationCollection;
    
    public int isFreeToday(){
        //compteur a 0
        nbDep = 0;
        //recup de la date d'ajd
        Date date = new Date();
        //recup de tous les checkout des resa
        Collection<Reservation> c = this.getReservationCollection();
        //itere sur la collection de resa
        for (Reservation r : c) {
            //si la date de depart est egale a la date actuelle
            if (r.getCheckOutDate().compareTo(date) == 0) {
                nbDep++;
            }  
        }
        //return le nb de departs ajd
        return nbDep;
    }

    public Reservation() {
    }

    public Reservation(Short idRerservation) {
        this.idRerservation = idRerservation;
    }

    public Reservation(Short idRerservation, boolean paye) {
        this.idRerservation = idRerservation;
        this.paye = paye;
    }

    public Short getIdRerservation() {
        return idRerservation;
    }
    


    public void setIdRerservation(Short idRerservation) {
        this.idRerservation = idRerservation;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean getPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public Chambre getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Chambre idChambre) {
        this.idChambre = idChambre;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }
    
    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRerservation != null ? idRerservation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.idRerservation == null && other.idRerservation != null) || (this.idRerservation != null && !this.idRerservation.equals(other.idRerservation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idRerservation + " Chambre : " + this.getIdChambre() + " Client : " + this.getIdClient().toString();
    }
    
}
