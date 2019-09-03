/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Mensualidad;

/**
 *
 * @author Kevin
 */
@Stateless
public class MensualidadFacade extends AbstractFacade<Mensualidad> implements MensualidadFacadeLocal {

    @PersistenceContext(unitName = "ProyectClubPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensualidadFacade() {
        super(Mensualidad.class);
    }
    
}
