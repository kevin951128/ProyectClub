/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Alumno;
import persistencia.AlumnoFacadeLocal;

/**
 *
 * @author Kevin
 */

  

@Stateless
public class AlumnoLogica implements AlumnoLogicaLocal {

    @EJB
    public AlumnoFacadeLocal alumnoDAO;
    
    @Override
    public List<Alumno> consultarAlumnos() {
        return alumnoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
