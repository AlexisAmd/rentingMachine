package controller;

import model.Reservation;
import dao.util.JsfUtil;
import dao.util.JsfUtil.PersistAction;
import facade.ReservationFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("reservationController")
@SessionScoped
public class ReservationController implements Serializable {

    public static Object getReservation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @EJB
    private facade.ReservationFacade ejbFacade;
    private List<Reservation> items = null;
    private Reservation selected;

    public ReservationController() {
    }

    public Reservation getSelected() {
        return selected;
    }

    public void setSelected(Reservation selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ReservationFacade getFacade() {
        return ejbFacade;
    }

    public Reservation prepareCreate() {
        selected = new Reservation();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ReservationCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ReservationUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ReservationDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Reservation> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Reservation getReservation(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<Reservation> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Reservation> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Reservation.class)
    public static class ReservationControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ReservationController controller = (ReservationController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "reservationController");
            return controller.getReservation(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Reservation) {
                Reservation o = (Reservation) object;
                return getStringKey(o.getIdRerservation());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Reservation.class.getName()});
                return null;
            }
        }

    }

    public int getNbrAvailable() {

        //compteur a 0
        int nbDep = 0;
        //recup de la date d'ajd
        Date date = new Date();

        //itere sur la collection de resa
        for (Reservation r : this.ejbFacade.findAll()) {
            //si la date de depart est egale a la date actuelle
            if (r.getCheckOutDate().getMonth() == date.getMonth() && r.getCheckOutDate().getDate() == date.getDate()) {
                nbDep++;
            }
        }
        //return le nb de departs ajd
        return nbDep;
    }

    public List<Reservation> getCheckOutToday() {
        List<Reservation> rtd = new ArrayList<Reservation>();
        Date date = new Date();
        int d = date.getDate();
        int m = date.getMonth();
        int y = date.getYear();

        List<Reservation> rs = getFacade().findAll();
        for (Reservation r : rs) {
            Date c = r.getCheckOutDate();
            if (c.getYear() == y && c.getMonth() == m && c.getDate() == d) {
                rtd.add(r);

            }
        }
        return rtd;
    }

    public List<Reservation> getCheckInToday() {
        List<Reservation> rtd = new ArrayList<Reservation>();
        Date date = new Date();
        int d = date.getDate();
        int m = date.getMonth();
        int y = date.getYear();

        List<Reservation> rs = getFacade().findAll();
        for (Reservation r : rs) {
            Date c = r.getCheckInDate();
            if (c.getYear() == y && c.getMonth() == m && c.getDate() == d) {
                rtd.add(r);

            }
        }
        return rtd;
    }
}
