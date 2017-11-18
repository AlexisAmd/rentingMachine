/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Chambre;

/**
 *
 * @author pc
 */
@Stateless
public class ChambreFacade extends AbstractFacade<Chambre> {

    @PersistenceContext(unitName = "rentingMachineJavaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChambreFacade() {
        super(Chambre.class);
    }
    
}
