/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Clase;

/**
 *
 * @author Kevin
 */
@Local
public interface ClaseLogicaLocal {
    
    public List<Clase> consultarClases();
    public void RegistrarClase(Clase c) throws Exception;
    
}
