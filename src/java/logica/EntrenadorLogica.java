/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Entrenador;
import persistencia.EntrenadorFacadeLocal;

/**
 *
 * @author Kevin
 */



@Stateless
public class EntrenadorLogica implements EntrenadorLogicaLocal {

    @EJB
    public EntrenadorFacadeLocal entrenadorDAO;
    
    @Override
    public List<Entrenador> consultarEntrenadores() {
        return entrenadorDAO.findAll();
    }

    @Override
    public Entrenador consultarxCodigo(int codigo) {
        Entrenador objEntrenador = entrenadorDAO.find(codigo);
        return objEntrenador;
    }
    
}

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    