/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Usuario;

/**
 *
 * @author Kevin
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "ProyectClubPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario findxCedula(BigInteger cedula) {
        String consulta = "select u from Usuario u where u.cedula= "+ cedula;
        try {
            Query query = em.createQuery(consulta);
        return (Usuario) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

   
    
}
