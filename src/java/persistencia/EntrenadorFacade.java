/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Entrenador;

/**
 *
 * @author Kevin
 */
@Stateless
public class EntrenadorFacade extends AbstractFacade<Entrenador> implements EntrenadorFacadeLocal {

    @PersistenceContext(unitName = "ProyectClubPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntrenadorFacade() {
        super(Entrenador.class);
    }
    
}
