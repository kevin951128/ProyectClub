/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Clase;
import persistencia.ClaseFacadeLocal;

/**
 *
 * @author Kevin
 */
@Stateless
public class ClaseLogica implements ClaseLogicaLocal {

    @EJB
    private ClaseFacadeLocal claseDAO;
    
    @Override
    public List<Clase> consultarClases() {
        return claseDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
