/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Entrenador;

/**
 *
 * @author Kevin
 */
@Local
public interface EntrenadorFacadeLocal {

    void create(Entrenador entrenador);

    void edit(Entrenador entrenador);

    void remove(Entrenador entrenador);

    Entrenador find(Object id);

    List<Entrenador> findAll();

    List<Entrenador> findRange(int[] range);

    int count();
    
}
