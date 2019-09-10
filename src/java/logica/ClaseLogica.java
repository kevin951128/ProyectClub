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

    @Override
    public void RegistrarClase(Clase c) throws Exception {
       if(c == null){
           throw new Exception("Error, los campos deben estar llenos");
       }
       if(c.getFecha().equals(null)){
           throw new Exception("Error, seleccione una fecha para la clase");
       }
       if(c.getHorario().equals(null)){
           throw new Exception("Error, seleccione un horario para la clase");
       }
       claseDAO.create(c);
    }
}
