/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Entrenador;

/**
 *
 * @author Kevin
 */
@Local
public interface EntrenadorLogicaLocal {
    public List<Entrenador> consultarEntrenadores();
    public Entrenador consultarxCodigo(int codigo);
}
